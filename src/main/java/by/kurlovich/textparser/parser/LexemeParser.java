package by.kurlovich.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.TextElements;

public class LexemeParser extends ChainParser {
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String LEXEME_PARSE_REGEX = "\\s*[^\\s]+\\b(.)";

	public LexemeParser(ChainParser successor) {
		this.setSuccessor(successor);
	}

	@Override
	public Element parse(Element elementSentence, String text) {
		Pattern pattern = Pattern.compile(LEXEME_PARSE_REGEX);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {

			Element elementLexeme = new CompositeElement(TextElements.LEXEME);

			String lexeme = matcher.group();
			LOGGER.debug("added: " + lexeme);
			elementSentence.addElement(this.getSuccessor().parse(elementLexeme, lexeme));
		}
		return elementSentence;
	}
}
