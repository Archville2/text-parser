package by.kurlovich.textparser.sort;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortByLexemeLengthTest {
	SortByLexemeLength lexemeSort;
	List<String> actual;
	List<String> expected;
	
	@BeforeClass
	public void setUp() {
		lexemeSort = new SortByLexemeLength();
		actual = new ArrayList<>();
		expected = new ArrayList<>();
	}

	@AfterClass
	public void tearDown() {
		lexemeSort = null;
		actual = null;
		expected = null;
	}
	
	@Test
	public void SortSentencesByLexemeLengthTest () {
		actual.add("Sho rt sen ten ce");
		actual.add("Longest sentence");
		actual.add("Midd sent ence");
		
		expected.add("Longest sentence");
		expected.add("Midd sent ence");
		expected.add("Sho rt sen ten ce");
		
		actual.sort(lexemeSort);
		
		Assert.assertEquals(actual, expected , "sentence sorting failure");
	}
}
