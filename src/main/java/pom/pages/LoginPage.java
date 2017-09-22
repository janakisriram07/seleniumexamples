package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver wb;
	
	@FindBy(xpath="//*[@id='exampleInputEmail1']")
	WebElement usernameTextBox;
	@FindBy(xpath="//*[@id='exampleInputPassword1']")
	WebElement passwordTextBox;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	public LoginPage(WebDriver wb){
		this.wb = wb;
		PageFactory.initElements(wb, this);
	}
	
	public void typeUserName(String userName){
		usernameTextBox.sendKeys(userName);
	}
	
	public void typePassword(String password){
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginButton(){
		loginButton.click();
	}

}
