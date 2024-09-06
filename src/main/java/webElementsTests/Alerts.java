package webElementsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\saise\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/V4");
	driver.findElement(By.name("uid")).sendKeys("mnji588364");
	driver.findElement(By.name("password")).sendKeys("pUsevyb");
	driver.findElement(By.name("btnLogin")).click();
	Thread.sleep(5000);
//	driver.findElement(By.name("cusid")).sendKeys("99415");
//	driver.findElement(By.name("AccSubmit")).click();
	
	Alert alert = driver.switchTo().alert();
//	alert.accept();
//	alert.dismiss();
	String text = alert.getText();
	System.out.println(text);
	alert.accept();
	driver.manage().window().maximize();
	
  }
}
