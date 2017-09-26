package TestNGTests;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	@Test
	public static void test1() {
		FirefoxDriver wb = new FirefoxDriver();

		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
				"yagna.bitspilani@gmail.com");
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys("#2");
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();

		//wb.close();
	}
	
	@Test
	public static void test2() {
		FirefoxDriver wb = new FirefoxDriver();

		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
				"hello");
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys("#2");
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();

		//wb.close();
	}
	
	@Test
	public static void test3() {
		FirefoxDriver wb = new FirefoxDriver();

		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0).sendKeys(
				"");
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys("");
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();

		//wb.close();
	}
}
