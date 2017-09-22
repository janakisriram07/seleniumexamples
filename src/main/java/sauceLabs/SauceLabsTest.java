package sauceLabs;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//https://wiki.saucelabs.com/display/DOCS/Java+Test+Setup+Example#JavaTestSetupExample-CodeExample
public class SauceLabsTest {
	public static final String USERNAME = "yagna1";
	  public static final String AUTOMATE_KEY = "zWxpMruSrmFDag4ZDyPC";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  public static void main(String[] args) throws Exception {

		  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		    caps.setCapability("platform", "Windows 7");
		    caps.setCapability("version", "11.0");
		    caps.setCapability("name", "Sauce Sample Test");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	  }
}
