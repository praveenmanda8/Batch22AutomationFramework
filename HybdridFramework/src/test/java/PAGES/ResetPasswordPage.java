package PAGES;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
	
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement emailTxt;
	
	@FindBy(xpath="//span[contains(text(),'Retrieve Password')]")
	WebElement RetrieveButton;
	
	
	public ResetPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail() {
		emailTxt.sendKeys("praveen.mtec@gmail.com");
	}
	
	public void clickRetrieveButton() {
		RetrieveButton.click();
	}
	

}
