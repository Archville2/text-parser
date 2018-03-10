package by.kurlovich.textparser.parser;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.TextElements;

public class EntityParserTest {
	ChainParser parser;
	Element element;

	@BeforeClass
	public void setUp() {
		element = new CompositeElement(TextElements.TEXT);
		parser = new EntityParser(null);
	}

	@AfterClass
	public void tearDown() {
		element = null;
		parser = null;
	}

	@Test
	public void paragraphTest() {
		String text = "abcd";
		parser.parse(element, text);
		List<Element> list = element.getElementList();
		int actual = list.size();
		int expected = 4;

		Assert.assertEquals(actual, expected, "entity count mismatch.");
	}

}
