package by.kurlovich.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.TextElements;

public class SentenceParser extends ChainParser {
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String SENTENCE_PARSE_REGEX = "[^\\.\\!\\?]*[\\.\\!\\?]";
	
	public SentenceParser(ChainParser successor) {
		this.setSuccessor(successor);
	}
	
	@Override
	public Element parse(Element elementParagraph, String text) {
		Pattern pattern = Pattern.compile(SENTENCE_PARSE_REGEX);
		Matcher matcher = pattern.matcher(text);
		
		
		while (matcher.find()) {
			Element elementSentence = new CompositeElement(TextElements.SENTENCE);
			
			String sentence = matcher.group();
			LOGGER.debug("added: " + sentence + " as sentence");
			elementParagraph.addElement(this.getSuccessor().parse(elementSentence, sentence));
		}
		return elementParagraph;
	}
}
