package by.kurlovich.textparser.sort;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortBySentenceCountTest {
	SortBySentenceCount sentenceSort;
	List<String> actual;
	List<String> expected;
	
	@BeforeClass
	public void setUp() {
		sentenceSort = new SortBySentenceCount();
		actual = new ArrayList<>();
		expected = new ArrayList<>();
	}

	@AfterClass
	public void tearDown() {
		sentenceSort = null;
		actual = null;
		expected = null;
	}
	
	@Test
	public void SortParagraphBySentenceCountTest () {
		actual.add("First paragraph. Sentence. Another sentence.");
		actual.add("Second paragraph.");
		actual.add("Third paragraph. Last sentence.");
		
		expected.add("First paragraph. Sentence. Another sentence.");
		expected.add("Third paragraph. Last sentence.");
		expected.add("Second paragraph.");
		
		actual.sort(sentenceSort);
		
		Assert.assertEquals(actual, expected , "sentence sorting failure");
	}
}
