package webElementsTests;

import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationTest {
	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();


		driver.get("http://www.gmail.com");

		driver.get("http://www.google.com");
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.navigate().forward(); 

		// driver.close();
	}
}
