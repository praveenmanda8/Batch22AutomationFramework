package UTILITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

public class ReadFromDatabase {

	public static void main(String[] args) throws SQLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\E005764\\eclipse-workspace\\HybdridFramework\\DRIVERS\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		
	    //Required necessary credentials for database
		String serverURL ="mssql:.localhost:4040/";
		String userName  = "pmanda";
		String password  = "test@123";
	
		//connection object creation for database
		Connection con = DriverManager.getConnection(serverURL,userName,password);
		
		Statement  stmt  =  con.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from Employee ");
		
		driver.get("URL");
		
		driver.manage().window().maximize();
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		

	}

}
