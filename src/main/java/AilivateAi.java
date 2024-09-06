import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class AilivateAi 
{
	@Test(dataProvider="dataProviderMethod")
	public void test1(String Username,String Email,String Password,String RepeatPassword) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saise\\chromedriver.exe");
		ChromeDriver c = new ChromeDriver();
		c.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		c.get("https://ailivate.ai/");
		WebElement regWe = c.findElement(By.xpath("//*[@id=\"text-4\"]/div/div/section/div/div[2]/div/div/div/div/a[1]"));
		regWe.click();
		WebElement namWe = c.findElement(By.xpath("//*[@id=\"thim-popup-login\"]/div/div/div[1]/div[2]/form/p[1]/input"));
		namWe.sendKeys("Janaki Sriram");
		WebElement emaiWe = c.findElement(By.xpath("//*[@id=\"thim-popup-login\"]/div/div/div[1]/div[2]/form/p[2]/input"));
		emaiWe.sendKeys("ganesulajanakisriram@gmail.com");
		WebElement passiWe = c.findElement(By.xpath("//*[@id=\"thim-popup-login\"]/div/div/div[1]/div[2]/form/p[3]/input"));
		passiWe.sendKeys("Sriram@123");
		WebElement repasiWe = c.findElement(By.xpath("//*[@id=\"thim-popup-login\"]/div/div/div[1]/div[2]/form/p[4]/input"));
		repasiWe.sendKeys("Sriram@123");
		WebElement submWe = c.findElement(By.xpath("//*[@id=\"thim-popup-login\"]/div/div/div[1]/div[2]/form/p[5]/input"));
		submWe.click();
	}
//		@DataProvider
//		public static Object[][] readFromCSVFile() {
//			String[][] array = new String[3][4];
//			BufferedReader br = null;
//			String line = null;
//			int count = 0;
//			try {
//				br = new BufferedReader(new FileReader("src/main/resources/TestData.csv"));
//				while ( (line =br.readLine()) != null){
//					String[] columns = line.split(",");
//					array[count][0] =  columns[0];
//					array[count][1] = columns[1];
//					array[count][2] = columns[2];
//					array[count][3] = columns[3];
//					count++;
//					System.out.println(columns[0]+"\t"+columns[3]);
//				}
//				
//			} catch (Exception e) {
//
//			} finally{
//				if (null != br) {
//					try {
//						br.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		
//			return (array);
//		}
//	}
	
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
			int totalRows = 4;
			int totalCols = 4;
			//totalRows = sheet.getRows();
			//totalCols = sheet.getColumns();
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
//		for(int i = 0; i<tabArray.length;i++) {
//			String[] temp = tabArray[i];
//			for(int j=0;j<temp.length;j++) {
//				System.out.println(temp[j]);
//			}
//		}
		return (tabArray);
	}
	
	
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
	

