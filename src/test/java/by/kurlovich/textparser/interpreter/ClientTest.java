package by.kurlovich.textparser.interpreter;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClientTest {
	String expression = "2 4 2 / +";
	Client client;
	
	@BeforeClass
	public void setUp() {
		client = new Client (expression);
	}
	
	@AfterClass
	public void tearDown() {
		client = null;
	}
	
	@Test
	public void interpreterTest() {
		Integer actual = client.calculate().intValue();
		Integer expected = 4;
		
		Assert.assertEquals(actual, expected, "Incorrect interpreter calculations:");
	}
}
