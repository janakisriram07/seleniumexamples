package webElementsTests;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CookiesTest {
	
	@Test
	public void testCookies(){
		FirefoxDriver wb = new FirefoxDriver();

		wb.get("http://www.gmail.com");

		Cookie newcookie = new Cookie("test", "123");

		wb.manage().addCookie(newcookie);

		Set<Cookie> allCookies = wb.manage().getCookies();
		for (Cookie cookie : allCookies) {
			System.out.println(
					cookie.getName()+" : "+cookie.getValue());
		}

		System.out.println("Deleting Cookie Named test...");
		
		wb.manage().deleteCookieNamed("test");
		
		allCookies = wb.manage().getCookies();
		for (Cookie cookie : allCookies) {
			System.out.println(
					cookie.getName()+" : "+cookie.getValue());
		}
		
		System.out.println("Deleting All Cookies...");
		wb.manage().deleteAllCookies();
		
		allCookies = wb.manage().getCookies();
		for (Cookie cookie : allCookies) {
			System.out.println(
					cookie.getName()+" : "+cookie.getValue());
		}
		
		wb.close();

	}
}
