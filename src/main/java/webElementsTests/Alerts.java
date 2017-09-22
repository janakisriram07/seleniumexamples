package webElementsTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/V4");
	driver.findElement(By.name("udid")).sendKeys("mngr90984");
	driver.findElement(By.name("password")).sendKeys("UrAhEbe");
	driver.findElement(By.name("btnLogin")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("cusid")).sendKeys("99415");
	driver.findElement(By.name("AccSubmit")).click();
	
	Alert alert = driver.switchTo().alert();
	alert.accept();
	alert.dismiss();
	String text = alert.getText();
	System.out.println(text);
	
  }
}
