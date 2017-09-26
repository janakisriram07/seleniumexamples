package TestNGTests;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadCSVFile {

	
	@Test(dataProvider="readFromCSVFile")
	public static void login(String emailID, String password){
		FirefoxDriver wb = new FirefoxDriver();

		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
				emailID);
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys(password);
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();
		

		wb.close();
	}
	
	@DataProvider
	public static Object[][] readFromCSVFile() {
		String[][] array = new String[3][2];
		BufferedReader br = null;
		String line = null;
		int count = 0;
		try {
			br = new BufferedReader(new FileReader("src/main/resources/TestData.csv"));
			while ( (line =br.readLine()) != null){
				String[] columns = line.split(",");
				array[count][0] =  columns[0];
				array[count][1] = columns[1];
				count++;
				System.out.println(columns[0]+"\t"+columns[1]);
			}
			
		} catch (Exception e) {

		} finally{
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		return (array);
	}
}
