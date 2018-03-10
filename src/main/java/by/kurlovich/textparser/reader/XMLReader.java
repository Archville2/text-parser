package by.kurlovich.textparser.reader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import by.kurlovich.textparser.exception.FileProblemException;

public class XMLReader {
	private final static String SHEET_NAME = "text";
		
	public String readFile(String fileName) throws FileProblemException {
		try (XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(fileName))) {
			
			XSSFSheet myExcelSheet = myExcelBook.getSheet(SHEET_NAME);
			XSSFRow row = myExcelSheet.getRow(0);
			
			return row.getCell(0).getStringCellValue();
			
		} catch (IOException e) {
			throw new FileProblemException("problem with reading file.", e);
		}
	}
}
