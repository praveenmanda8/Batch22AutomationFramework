package PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInLink;

	@FindBy(id = "search_query_top")
	WebElement search_Txt;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSigninLink() {
		signInLink.click();
	}

	public void searchAnyProduct() {

		search_Txt.sendKeys("Samsung");
	}

}
