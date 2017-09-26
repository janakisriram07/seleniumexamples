package TestNGTests;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataDrivenTestExcel {
	
	public DataDrivenTestExcel(String abc){
		System.out.println("Hello "+abc);
	}

	@Test(dataProvider="dataProviderMethod")
	public void login(String emailID, String password){
		FirefoxDriver wb = new FirefoxDriver();

		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
				emailID);
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys(password);
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();

		wb.close();
	}
	
	@DataProvider
	public  Object[][] dataProviderMethod() throws Exception{
		
    	Object[][] testObjArray = readExcel(
				"src/main/resources/TestData.xls", "TestingNew");
		return testObjArray;
	}
	
	public static Object[][] readExcel(String xlFilePath, String sheetName) throws Exception {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = 0;
			int totalCols = 0;
			totalRows = sheet.getRows();
			totalCols = sheet.getColumns();
			System.out.println("total cols = " + totalCols);
			System.out.println("total rows = " + totalRows);
			tabArray = new String[totalRows - 1][totalCols];
			ci = 0;
			for (int i = startRow; i < totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}
	
	
	
}
