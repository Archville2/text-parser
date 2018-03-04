package by.kurlovich.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.TextElements;

public class ParagraphParser extends ChainParser {
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String PARAGRAPH_PARSE_REGEX = "\\t[^\\t]+";
	
	public ParagraphParser(ChainParser successor) {
		this.setSuccessor(successor);
	}
	
	@Override
	public Element parse(Element elementText, String text) {
		Pattern pattern = Pattern.compile(PARAGRAPH_PARSE_REGEX);
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			CompositeElement elementParagraph = new CompositeElement(TextElements.PARAGRAPH);
			
			String paragraph = matcher.group();
			LOGGER.debug("added: " + paragraph);
			elementText.addElement(this.getSuccessor().parse(elementParagraph, paragraph));
		}
		return elementText;
	}
}
