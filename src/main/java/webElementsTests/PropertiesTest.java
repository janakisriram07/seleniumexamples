package webElementsTests;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PropertiesTest {
	
	public static void main(String[] args){
		Properties props = new Properties();
		InputStream input = null;
		WebDriver wb = null;
		try {
			 
			input = new FileInputStream("src/main/resources/config.properties");
			props.load(input);
			
			String browser = props.getProperty("browser");
			
			System.out.println("Browser selected is "+browser);
			
			if(browser.equals("firefox")){
				wb = new FirefoxDriver();
			}else if(browser.equals("chrome")){
				System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
				wb = new ChromeDriver();
			}else{
				wb = new FirefoxDriver();
			}
			
			wb.get("http://www.gmail.com");

			wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
					"yagna.bitspilani@gmail.com");
			wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys("#2");
			wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();

			//wb.close();
			
		}catch(IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
	}

}
