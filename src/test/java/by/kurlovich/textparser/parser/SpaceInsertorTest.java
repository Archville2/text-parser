package by.kurlovich.textparser.parser;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpaceInsertorTest {
	SpaceInsertor insertor;
	
	@BeforeClass
	public void setUp()  {
		insertor = new SpaceInsertor();
	}
	
	@AfterClass
	public void tearDown() {
		insertor = null;
	}
	
	@Test
	public void insertorTest () {
		String text = "2+3*5+(2+2)";
		String actual = insertor.insert(text);
		String expected = "2 + 3 * 5 + ( 2 + 2 ) ";
		
		Assert.assertEquals(actual, expected , "Insufficient spaces.");
		
	}

}
