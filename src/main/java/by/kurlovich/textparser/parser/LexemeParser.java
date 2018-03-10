package by.kurlovich.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kurlovich.textparser.calculator.CalculateLexeme;
import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.LeafElement;
import by.kurlovich.textparser.store.TextElements;

public class LexemeParser extends ChainParser {
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String LEXEME_PARSE_REGEX = "\\s*[^\\s]+\\b(.)";
	private final static String MATH_EXPRESSION_REGEX = "[\\d\\+\\(\\)\\/\\-\\*\\.]{3,}";

	public LexemeParser(ChainParser successor) {
		this.setSuccessor(successor);
	}

	@Override
	public Element parse(Element elementSentence, String text) {
		CalculateLexeme calculator = new CalculateLexeme();
		Pattern pattern = Pattern.compile(LEXEME_PARSE_REGEX);
		Pattern mathPattern = Pattern.compile(MATH_EXPRESSION_REGEX);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {

			Element elementLexeme = new CompositeElement(TextElements.LEXEME);

			String lexeme = matcher.group();

			Matcher mathMatcher = mathPattern.matcher(lexeme);
			if (mathMatcher.find()) {
				lexeme = calculator.calculate(lexeme) + " ";
			}
			LOGGER.debug("added: " + lexeme + " as lexeme");

			if (super.getSuccessor() != null) {
				elementSentence.addElement(this.getSuccessor().parse(elementLexeme, lexeme));
			} else {
				elementSentence.addElement(new LeafElement(TextElements.LEXEME, lexeme));
			}
		}
		return elementSentence;
	}
}
