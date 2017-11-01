import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticationWindow {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ydande/Desktop/chromedriver2");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://dummyuser:dummypassword@www.surveyjunkie-testing.com/");
		Thread.sleep(5000);

//		String username = "dummyuser";
//		StringSelection user = new StringSelection(username);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(user, null);
//		try {
//
//			Robot robot = new Robot();
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(2000);
//
//			String password = "dummypassword";
//			StringSelection pass = new StringSelection(password);
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pass, null);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//		} catch (AWTException e1) {
//			e1.printStackTrace();
//		}
	}
}
