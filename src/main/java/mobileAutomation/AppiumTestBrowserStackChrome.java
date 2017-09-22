package mobileAutomation;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppiumTestBrowserStackChrome {
	
	public static final String USERNAME = "yagna1";
	public static final String AUTOMATE_KEY = "zWxpMruSrmFDag4ZDyPC";
	public static final String remoteAddress = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Samsung Galaxy S8");
		capabilities.setCapability("realMobile", "true");
		capabilities.setCapability("os_version", "7.0");
		
		capabilities.setCapability("browserName", "Chrome");
		WebDriver driver = new RemoteWebDriver(new URL(remoteAddress), capabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.get("http://www.google.com");
		 WebElement element = driver.findElement(By.name("q"));
		
		 element.sendKeys("BrowserStack");
		 element.submit();
		
		 System.out.println(driver.getTitle());
		
		driver.quit();

	

	}

}
