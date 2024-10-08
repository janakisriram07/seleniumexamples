package TestNGTests;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadCSVFile {

	
	@Test(dataProvider="readFromCSVFile")
	public void test1(String product, String brand) {
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
		sitWe.sendKeys(product);
		WebElement setWe = c.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		setWe.submit();
		
		WebElement sutWe = c.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
		sutWe.click();
		ArrayList<String> t = new ArrayList<String> (c.getWindowHandles());
	    c.switchTo().window(t.get(1));
	    //c.close();
	    //c.switchTo().window(t.get(0));
		
		WebElement bantWe = c.findElement(By.xpath("//*[@id=\"productOverview_feature_div\"]/div/table/tbody/tr[1]/td[2]/span"));
		Assert.assertEquals(bantWe.getText(), brand);
		System.out.println(bantWe.getText());
		WebElement pritWe = c.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[3]/span[2]/span[2]"));
		Assert.assertEquals(pritWe.getText(), "69,999");
		System.out.println(pritWe.getText());
		WebElement seritWe = c.findElement(By.xpath("//*[@id=\"feature-bullets\"]/h1"));
		Assert.assertEquals(seritWe.getText(), "About this item");
		System.out.println(seritWe.getText());
	}
	
	@DataProvider
	public static Object[][] readFromCSVFile() {
		String[][] array = new String[3][2];
		BufferedReader br = null;
		String line = null;
		int count = 0;
		try {
			br = new BufferedReader(new FileReader("src/main/resources/TestData.csv"));
			while ( (line =br.readLine()) != null){
				String[] columns = line.split(",");
				array[count][0] =  columns[0];
				array[count][1] = columns[1];
				count++;
				System.out.println(columns[0]+"\t"+columns[1]);
			}
			
		} catch (Exception e) {

		} finally{
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		return (array);
	}
}
