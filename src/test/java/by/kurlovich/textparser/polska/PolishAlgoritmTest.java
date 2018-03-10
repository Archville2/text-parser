package by.kurlovich.textparser.polska;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PolishAlgoritmTest {
	PolishAlgoritm algoritm;

	@BeforeClass
	public void setUp () {
		algoritm = new PolishAlgoritm();
	}
	
	@AfterClass
	public void tearDown() {
		algoritm = null;
	}
	
	@Test
	public void algoritmTest() {
		String text = "2 + 2 / 4";
		String actual = algoritm.convertInfixToRPN(text.split("\\s"));
		String expected = "2 2 4 / + ";
		
		Assert.assertEquals(actual, expected , "Incorrect polish conversion:");
	}
}
