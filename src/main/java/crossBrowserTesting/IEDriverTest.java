package crossBrowserTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver",
				"src/main/resources/IEDriver/IEDriverServer_Win32/IEDriverServer.exe");
		InternetExplorerDriver wb = new InternetExplorerDriver();

		wb.get("http://www.gmail.com");

		wb.findElements(By.xpath("//*[@id=\"Email\"]")).get(0)
				.sendKeys("yagna.bitspilani@gmail.com");
		wb.findElements(By.xpath("//*[@id=\"Passwd\"]")).get(0).sendKeys("#2");
		wb.findElements(By.xpath("//*[@id=\"signIn\"]")).get(0).click();

		wb.close();
	}
}
