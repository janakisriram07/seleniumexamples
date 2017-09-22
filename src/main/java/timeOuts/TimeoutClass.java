package timeOuts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeoutClass {
	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://qabidder.net/testwave/#/page/login");
		// TextBox
		WebElement loginField = driver.findElement(By.xpath("//*[@id='exampleInputEmail1']"));
		loginField.sendKeys("qauber.sa1@mailinator.com");
		WebElement passwordField = driver.findElement(By.xpath("//*[@id='exampleInputPassword1']"));
		passwordField.sendKeys("123456");

		WebDriverWait wait = new WebDriverWait(driver, 30); // Time in Seconds
		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button"))).click();

	}
}
