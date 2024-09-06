

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class RainTest 
{

	//This is test commit

	@Test
	public void test1() {
		System.out.println("hello");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saise\\chromedriver.exe");
		ChromeDriver c = new ChromeDriver();
		c.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\saise\\geckodriver.exe");
		//FirefoxDriver c = new FirefoxDriver();
		
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\saise\\msedgedriver.exe");
//		EdgeDriver c = new EdgeDriver();
		
		c.get("https://www.amazon.in/");
		System.out.println(c.getTitle());
		WebElement miniWe = c.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
		miniWe.click();
		WebElement movWe = c.findElement(By.xpath("//*[@id=\"appContainer\"]/nav/div[2]/a[3]"));
		movWe.click();
//		WebElement telWe = c.findElement(By.xpath("//*[@id=\"appContainer\"]/nav/div[2]/a[8]"));
//		telWe.click();
//		WebElement serWe = c.findElement(By.xpath("//*[@id=\"desktop_search_icon\"]/a/img"));
//		serWe.click();
//		WebElement wriWe = c.findElement(By.xpath("//*[@id=\"appContainer\"]/div/div/div[1]/div/div/input"));
//		wriWe.sendKeys("Highway Love");
		WebElement eitWe = c.findElement(By.xpath("//*[@id=\"appContainer\"]/nav/div[3]/div[2]/a/div/div[1]/img"));
		eitWe.click();
		WebElement sitWe = c.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		sitWe.sendKeys("apple iphone 15");
		WebElement setWe = c.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		setWe.submit();
		
		WebElement sutWe = c.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
		sutWe.click();
		ArrayList<String> t = new ArrayList<String> (c.getWindowHandles());
	    c.switchTo().window(t.get(1));
	    //c.close();
	    //c.switchTo().window(t.get(0));
		
		WebElement bantWe = c.findElement(By.xpath("//*[@id=\"productOverview_feature_div\"]/div/table/tbody/tr[1]/td[2]/span"));
		Assert.assertEquals(bantWe.getText(), "Apple");
		System.out.println(bantWe.getText());
		WebElement pritWe = c.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[3]/span[2]/span[2]"));
		Assert.assertEquals(pritWe.getText(), "69,999");
		System.out.println(pritWe.getText());
		WebElement seritWe = c.findElement(By.xpath("//*[@id=\"feature-bullets\"]/h1"));
		Assert.assertEquals(seritWe.getText(), "About this item");
		System.out.println(seritWe.getText());
//		WebElement baztWe = c.findElement(By.xpath("//*[@id=\"acBadge_feature_div\"]/div/span[1]"));
//		Assert.assertEquals(baztWe.getText(), "Amazon's Choice");
//		System.out.println(baztWe.getText());
		
		//WebElement dopWe = c.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
		//dopWe.click();
		//WebElement dipWe = c.findElement(By.xpath("//*[@id=\"a-autoid-16-announce\"]/div/div[1]/img"));
		//dipWe.click();
//		c.navigate().back();
//		c.navigate().forward();
//		c.get("https://mail.google.com/mail/");
//		WebElement sintWe = c.findElement(By.xpath("//*[@id=\"identifierId\"]"));
//		sintWe.sendKeys("ganesulajanakisriram@gmail.com");
//		WebElement soktWe = c.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
//		soktWe.click();
//		c.get("https://www.youtube.com/");
//		System.out.println(c.getTitle());
//		//WebElement homYou=c.findElement(By.xpath("//*[@id=\"endpoint\"]/tp-yt-paper-item/yt-formatted-string"));
//		//homYou.click();
//		WebElement shoYou=c.findElement(By.className("ytd-searchbox"));
//		shoYou.sendKeys("og teaser telugu");
		
		
		
		}
}
