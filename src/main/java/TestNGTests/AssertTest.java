package TestNGTests;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class AssertTest {
	private FirefoxDriver wb = null;
	
	@BeforeSuite
	public void openBrowser(){
		wb = new FirefoxDriver();
	}
	
	@Test
	public void testEmail(){
		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
				"");
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys("");
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();
		
	}
	
	@Test
	public  void testEmailError(){
		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
				"");
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys("");
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();
		
		if(!wb.findElements(By.xpath(".//*[@id='errormsg_0_Email']")).get(0).getText().equals("Enter your email address.")){
			Assert.fail("Error Message doesn't Exist");
		}
	}
	
	@AfterTest
	public  void closeBrowser(){
		//wb.close();
	}
}
