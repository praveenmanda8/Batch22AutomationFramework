package TESTCASES;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PAGES.AuthenticationPage;
import PAGES.HomePage;
import PAGES.ResetPasswordPage;

public class TC_02_verifyresetPassword {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\E005764\\Downloads\\chromedriver_91\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		HomePage  objHome = new HomePage(driver);
		ResetPasswordPage  objReset = new ResetPasswordPage(driver);
		AuthenticationPage objAuthentication  = new AuthenticationPage(driver);
		
		objHome.clickSigninLink();
		objAuthentication.clickForgotLink();
		objReset.enterEmail();
		objReset.clickRetrieveButton();
		
		String textmsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
		
		if(textmsg.contains("A confirmation email")) {
			System.out.println("Forgot Message succssfully sent to email");
		} else {
			System.out.println("Error in reading / sending mail");
		}
	
		

	}

}
