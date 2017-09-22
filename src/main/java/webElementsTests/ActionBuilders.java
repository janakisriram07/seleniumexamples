package webElementsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionBuilders {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));

		Actions builder = new Actions(driver);
		Action typeInCAPS = builder.keyDown(element, Keys.SHIFT)
				.sendKeys(element, "hello")
				.keyUp(element, Keys.SHIFT)
				.build();
		
		typeInCAPS.perform();
		
		element.submit();
		
		System.out.println(driver.getTitle());
		
	}
}
