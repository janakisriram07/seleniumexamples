package webElementsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class PopupDisabledProfileFirefox {
public static void main(String[] args) {
	ProfilesIni profiles = new ProfilesIni();
	FirefoxProfile profile = profiles.getProfile("PopupDisabled");
	profile.setPreference("dom.popup_maximum", 0);
	profile.setPreference("privacy.popups.showBrowserMessage", false);
	
	WebDriver driver = new FirefoxDriver(profile);
	//WebDriver driver = new FirefoxDriver();
	driver.get("https://www.pogo.com/misc/popup-blocker-test-popup1.jsp");
}
}
