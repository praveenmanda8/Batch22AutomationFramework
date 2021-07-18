package BASECLASS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;

	public static void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\E005764\\eclipse-workspace\\HybdridFramework\\DRIVERS\\chromedriver.exe");

		driver = new ChromeDriver();

	}

	public static void Quit() {

		driver.close();
	}

}
