package TESTCASES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BASECLASS.BaseClass;
import PAGES.AuthenticationPage;
import PAGES.HomePage;

public class VerifyLogin extends BaseClass {

	public static ExtentReports report;
	public static ExtentTest test;

	public static void main(String[] args) throws IOException {

		report = new ExtentReports(
				"C:\\Users\\E005764\\eclipse-workspace\\HybdridFramework\\RESULTS\\loginResults.html", true);
		test = report.startTest("VerifyLogin");

		BaseClass.setup();

		File path = new File("C:\\Users\\E005764\\eclipse-workspace\\HybdridFramework\\config.properties");
		FileInputStream input = new FileInputStream(path);
		Properties prop = new Properties();

		prop.load(input);

		driver.get(prop.getProperty("QAURL"));
		test.log(LogStatus.INFO, "Browser Luanched and URL Entered");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		if (driver.getTitle().equals("My Store")) {
			test.log(LogStatus.PASS, "User Successfully Landed on My Store Page");
		} else {
			test.log(LogStatus.FAIL, "User Successfully Not Landed on My Store Page");
		}

		HomePage objHome = new HomePage(driver);
		AuthenticationPage objAuth = new AuthenticationPage(driver);

		objHome.clickSigninLink();
		objAuth.enterUsername(prop.getProperty("USERNAME"));
		objAuth.enterPassword(prop.getProperty("PASSWORD"));
		objAuth.clickSubmit();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		String text = driver.findElement(By.xpath("//a[@title='View my customer account']//span")).getText();

		if (text.equals("yn trilochaniqa")) {
			System.out.println("User Profile is correct ");
		} else {
			System.out.println("User is not valid");
		}

		BaseClass.Quit();

		report.endTest(test);
		report.flush();

	}

}
