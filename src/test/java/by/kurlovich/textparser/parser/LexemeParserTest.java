package by.kurlovich.textparser.parser;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.TextElements;

public class LexemeParserTest {
	ChainParser parser;
	Element element;

	@BeforeClass
	public void setUp() {
		element = new CompositeElement(TextElements.LEXEME);
		parser = new LexemeParser(null);
	}

	@AfterClass
	public void tearDown() {
		element = null;
		parser = null;
	}

	@Test
	public void paragraphTest() {
		String text = "\tFirst paragraph. First sentence.\tSecond paragraph.\tThird paragraph.";
		parser.parse(element, text);
		List<Element> list = element.getElementList();
		int actual = list.size();
		int expected = 8;

		Assert.assertEquals(actual, expected, "lexeme count mismatch.");
	}

}
