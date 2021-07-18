package PAGES;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
	
	WebDriver driver;
	
	@FindBy(id = "email")
	WebElement email_Txt;

	@FindBy(id = "passwd")
	WebElement password_Txt;

	@FindBy(id = "SubmitLogin")
	WebElement submit_Button;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	WebElement forgotLink;
	
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUsername(String UN) {
		email_Txt.sendKeys(UN);
	}

	public void enterPassword(String PWD) {

		password_Txt.sendKeys(PWD);
	}
	
	public void clickSubmit() {
		submit_Button.click();
	}
	
	public void clickForgotLink() {
		forgotLink.click();
	}

}
