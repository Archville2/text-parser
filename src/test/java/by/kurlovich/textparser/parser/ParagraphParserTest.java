package by.kurlovich.textparser.parser;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.TextElements;

public class ParagraphParserTest {
	ChainParser parser;
	Element element;
	
	@BeforeClass
	public void setUp() {
		element = new CompositeElement(TextElements.PARAGRAPH);
		parser = new ParagraphParser(null);
	}
	
	@AfterClass
	public void tearDown() {
		element = null;
		parser = null;
	}
	
	@Test
	public void paragraphTest () {
		String text = "\tFirst paragraph. First sentence.\n\tSecond paragraph.\n\tThird paragraph.";
		parser.parse(element, text);
		List<Element> list = element.getElementList();
		int actual = list.size();
		int expected = 3;
		
		Assert.assertEquals(actual, expected, "paragraph count mismatch.");
	}
}
