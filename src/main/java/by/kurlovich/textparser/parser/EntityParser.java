package by.kurlovich.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.LeafElement;
import by.kurlovich.textparser.store.LeafElements;

public class EntityParser extends ChainParser {
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String ENTITY_PARSE_REGEX = ".{1}";
	private final static String ANY_CHARACTER_REGEX = "[a-zA-Zа-яА-Я]";
	private final static String ANY_DIGIT_REGEX = "\\d";
	private final static String ANY_SPACE_REGEX = "\\s";

	public EntityParser(ChainParser successor) {
		this.setSuccessor(successor);
	}

	@Override
	public Element parse(Element elementLexeme, String text) {
		Pattern pattern = Pattern.compile(ENTITY_PARSE_REGEX);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			Element elementLeaf;
			String entity = matcher.group();
			String entityType = checkEntityType(entity);

			switch (entityType) {
			case "character":
				elementLeaf = new LeafElement(LeafElements.CHARACTER, entity.charAt(0));
				break;
			case "digit":
				elementLeaf = new LeafElement(LeafElements.DIGIT, entity.charAt(0));
				break;
			case "divider":
				elementLeaf = new LeafElement(LeafElements.DIVIDER, entity.charAt(0));
				break;
			default:
				elementLeaf = new LeafElement(LeafElements.SYMBOL, entity.charAt(0));
			}

			LOGGER.debug("added: " + entity + " as " + entityType);
			elementLexeme.addElement(elementLeaf);
		}
		return elementLexeme;
	}

	private String checkEntityType(String entity) {
		String type = "symbol";

		if (entity.matches(ANY_CHARACTER_REGEX)) {
			type = "character";
		}
		if (entity.matches(ANY_DIGIT_REGEX)) {
			type = "digit";
		}
		if (entity.matches(ANY_SPACE_REGEX)) {
			type = "divider";
		}
		return type;
	}
}
