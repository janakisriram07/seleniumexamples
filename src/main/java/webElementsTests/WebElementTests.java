package webElementsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementTests {
public static void main(String[] args) throws InterruptedException {
	FirefoxDriver driver =  new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	driver.get("http://qabidder.net/testwave/#/page/login");
	Thread.sleep(10000);
	
	//TextBox
	WebElement loginField = driver.findElement(By.xpath("//*[@id='exampleInputEmail1']"));
	loginField.sendKeys("qauber.sa1@mailinator.com");
	WebElement passwordField = driver.findElement(By.xpath("//*[@id='exampleInputPassword1']"));
	passwordField.sendKeys("123456");
	
	//Button
	WebElement loginButton = driver.findElement(By.tagName("button"));
	loginButton.click();
	
	Thread.sleep(4000);
	
	//Hyperlink
//	WebElement forgotPasswordLink = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div[2]/form/div[3]/div/a"));
//	forgotPasswordLink.click();
	
	WebElement addReport = driver.findElement(By.linkText("Add Report"));
	addReport.click();
	Thread.sleep(4000);
	
	//Radio Button
	WebElement depRadioButton = driver.findElement(By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[2]/fieldset/div[3]/div/div/label/span"));
	depRadioButton.click();
	
	WebElement nextButton1 = driver.findElement(By.xpath("//div[@ng-show='wizard.active(1)']/ul/li/a/span"));
	nextButton1.click();
	
	//Dropdown
	WebElement selectBuild = driver.findElement(By.xpath("//select[@ng-model='wizard.report.build']"));
	selectBuild.findElement(By.xpath("option[@value='A']")).click();
	
	//RadioButton
	WebElement drvr = driver.findElement(By.xpath("//label/input[@value='passenger']"));
	drvr.click();
	Thread.sleep(10000);
	
	WebElement next1 = driver.findElement(By.xpath("//li/a[@ng-click='wizard.go(3)'][text()='Next']/span"));
	next1.click();
	Thread.sleep(2000);
	
	//Checkbox
	Thread.sleep(10000);
	WebElement tatoos = driver.findElement(By.xpath("//label/input[@ng-model='wizard.report.tattoos']"));
	tatoos.click();
	Thread.sleep(10000);
	WebElement tatoosText = driver.findElement(By.xpath("//input[@name='Tattoos']"));
	tatoosText.sendKeys("Tatoo on Shoulder");
	WebElement next2 = driver.findElement(By.xpath("//li/a[@ng-click='wizard.go(4)'][text()='Next']"));
	next2.click();
	
}
}
