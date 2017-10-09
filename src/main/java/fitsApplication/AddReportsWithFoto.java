package fitsApplication;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AddReportsWithFoto {
	
	public static String downloadPath = "C:\\Users\\vsleh\\Pictures";

	
	public static FirefoxProfile getFirefoxDriverProfile() throws Exception{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		//Set downloadPath
		profile.setPreference("browser.download.dir", downloadPath);
		//Set File Open &amp; Save preferences
		profile.setPreference("browser.helperApps.neverAsk.openFile","text/csv,application/x-msexcel,application/pdf,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/pdf,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		profile.setPreference("pdfjs.disabled", true);

		// Use this to disable Acrobat plugin for previewing PDFs in Firefox (if you have Adobe reader installed on your computer)
		profile.setPreference("plugin.scan.Acrobat", "99.0");
		profile.setPreference("plugin.scan.plid.all", false);
		return profile;
	}
	
	public static void main(String[] args) throws Exception {
		//System.setProperty("webdriver.gecko.driver", "C:\\QA\\Eclipse\\Drivers\\geckodriver4selenium3\\geckodriver");
		WebDriver fox = new FirefoxDriver(getFirefoxDriverProfile());
		fox.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		fox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fox.get("http://fits.qauber.com");
		fox.manage().window().maximize();
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "dryrun4@mailinator.com");
		map.put("password", "password");
		map.put("caseID", "123456789");
		map.put("firstname", "Krokodil");
		map.put("lastname", "Gena");
		map.put("location", "1234 Mockingbird Lane");
		
		fox.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys(map.get("email"));
		fox.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys(map.get("password"));
		fox.findElement(By.xpath(".//*[@type='submit']")).sendKeys(Keys.RETURN);
		fox.findElement(By.xpath(".//*[text() = 'Add Report']")).click();
		fox.findElement(By.xpath("//div[@class='fa fa-user size']")).click();
		fox.findElement(By.xpath("//input[@ng-model='wizard.report.caseNumber']")).sendKeys(map.get("caseID"));
		fox.findElement(By.xpath("//input[@name='lastName']")).sendKeys(map.get("lastname"));
		fox.findElement(By.xpath("//input[@name='firstName']")).sendKeys(map.get("firstname"));
		fox.findElement(By.xpath("//h4/div[@title='Gang Membership']")).click();
		fox.findElement(By.xpath("//input[@ng-model='wizard.report.locationOfStop']")).sendKeys(map.get("location"));
		fox.findElement(By.xpath("//div[@title='Photos']")).click();
		WebElement e = fox.findElement(By.xpath(".//button[@class='upload btn btn-primary btn-labeled']/span[@class='btn-label btn-label-right']"));
		
		/*
		 * Uploading file using selenium Webdriver is nothing but to send a file path to that locator.

			Here is the logic

			HTML tag to upload a file 
			<input type="file" name="theFile" tabindex="1" size="35">

			WebDriver code to upload a file
			driver.findElement(By.name("theFile")).sendKeys("/home/test/Desktop/uploadImg.png");
			
			But in our application, button is not of type "file", so sendKeys is not working
		 */
		System.out.println(e.isDisplayed());
		e.click();
		try { Thread.sleep(3000);}

		catch (InterruptedException e1){ e1.printStackTrace();}

		String fileLocation = "/tmp/Eforelephant.png";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		try {

		Robot robot = new Robot();

		// Uncomment here for Windows
//		robot.keyPress(KeyEvent.VK_CONTROL);
//
//		robot.keyPress(KeyEvent.VK_V);
//
//		robot.keyRelease(KeyEvent.VK_V);
//
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//
//		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//Uncomment here for Mac
		// Cmd + Tab is needed since it launches a Java app and the browser looses focus

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_TAB);

		robot.delay(500);

		//Open Goto window

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_SHIFT);

		robot.keyPress(KeyEvent.VK_G);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_SHIFT);

		robot.keyRelease(KeyEvent.VK_G);

		//Paste the clipboard value

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_V);

		//Press Enter key to close the Goto window and Upload window
		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e1) {e1.printStackTrace();}
		Thread.sleep(5000);
		fox.findElement(By.xpath("//h4/div[@title='Preview']")).click();
		fox.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']")).click();
		
	//this is where we download the list
		fox.findElement(By.xpath("html/body/div[2]/section/div/div[3]/button")).click();
		Thread.sleep(5000);
		fox.quit();
	}
	
	//and here we create the object for the firefox profile to use at the end to download

}
