package TestNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestsObjects {
	
	@Test(dataProvider="giveUserNameAndPasswords")
	public void login(String emailID,String password){
		WebDriver wb = new FirefoxDriver();
		wb.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		wb.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wb.get("http://www.gmail.com");
		wb.findElement(By.xpath("//*[@type='email']")).sendKeys(emailID);
		wb.findElement(By.xpath("//*[text()='Next']")).click();
		wb.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
		wb.findElement(By.xpath("//*[text()='Next']")).click();
		wb.close();
	}
	
	@DataProvider
	public Object[][] giveUserNameAndPasswords() throws Exception{
		Object[][] testObjectArray = {{"yagna.bitspilani","1234"},
		{"yagna@elephant-tamers.com","2345"}
		};
		return testObjectArray;
	}
}
