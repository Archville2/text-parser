package by.kurlovich.textparser.sort;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortByCharCountTest {
	SortByCharCount charSort;
	List<String> actual;
	List<String> expected;
	
	@BeforeClass
	public void setUp() {
		charSort = new SortByCharCount('a');
	}

	@AfterClass
	public void tearDown() {
		charSort = null;
	}
	
	@Test
	public void charCountSortTest() {
		actual = new ArrayList<>();
		
		actual.add("abcde");
		actual.add("abade");
		actual.add("abada");
		actual.add("zbade");
		actual.add("zbwde");
		
		expected = new ArrayList<>();
		
		expected.add("abada");
		expected.add("abade");
		expected.add("abcde");
		expected.add("zbade");
		expected.add("zbwde");
		
		actual.sort(charSort);
		
		Assert.assertEquals(actual, expected , "list elements not sorted correctly:");
	}
}
