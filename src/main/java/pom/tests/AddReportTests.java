package pom.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.LoginPage;

public class AddReportTests {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver2");

		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws InterruptedException {
		String emailLogin = "zzzmmm@mailinator.com";
		String password = "zzzzzz";
		driver.get("http://qabidder.net/testwave/#/page/login");
		Thread.sleep(4000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeUserName(emailLogin);
		loginPage.typePassword(password);
		loginPage.clickLoginButton();
		Thread.sleep(5000);
		
	}
}
