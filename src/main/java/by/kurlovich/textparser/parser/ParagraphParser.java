package by.kurlovich.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.LeafElement;
import by.kurlovich.textparser.store.TextElements;

public class ParagraphParser extends ChainParser {
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String PARAGRAPH_PARSE_REGEX = "\\t[^\\t]+";

	public ParagraphParser(ChainParser successor) {
		super.setSuccessor(successor);
	}

	@Override
	public Element parse(Element elementText, String text) {
		Pattern pattern = Pattern.compile(PARAGRAPH_PARSE_REGEX);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			String paragraph = matcher.group();
			Element elementParagraph = new CompositeElement(TextElements.PARAGRAPH);

			LOGGER.debug("added: " + paragraph + " as paragraph");
			if (super.getSuccessor() != null) {
				elementText.addElement(super.getSuccessor().parse(elementParagraph, paragraph));
			} else {
				elementText.addElement(new LeafElement(TextElements.PARAGRAPH, paragraph));
			}
		}
		return elementText;
	}
}
