package by.kurlovich.textparser.reader;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.kurlovich.textparser.exception.FileProblemException;

public class XMLReaderTest {
	String fileName="./files/test.xlsx";
	XMLReader reader;
	
	@BeforeClass
	public void setUp() {
		reader = new XMLReader();
	}
	
	@AfterClass
	public void tearDown() {
		reader = null;
	}
	
	@Test
	public void readerTest() throws FileProblemException {
		String actual = reader.readFile(fileName);
		String expected = "message text";
		
		Assert.assertEquals(actual, expected, "Files content mismatch:");
	}

}
