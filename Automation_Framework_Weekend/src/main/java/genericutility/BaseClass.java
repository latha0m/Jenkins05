package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectutility.HomePage;
import objectutility.LoginPage;
import objectutility.WelcomePage;

public class BaseClass {
	public static ExtentReports eReport ;
	public static WebDriver driver;
	public static  ExtentTest test;
	
	public JavaUtility jutil=new JavaUtility();
	public FileUtility futil=new FileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public ExcelUtility eutil=new ExcelUtility();
	
	@BeforeSuite
	public void reportConfiguration() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/"+jutil.getSystemTime()+".html");
		eReport = new ExtentReports();
		eReport.attachReporter(spark);
		
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		wutil.maxmize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(futil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wpage=new WelcomePage(driver);
		wpage.getLoginLink().click();
		
		LoginPage lPage=new LoginPage(driver);
		lPage.getEmailTextFeild().sendKeys(futil.getDataFromProperty("email"));
		lPage.getPasswordTextFeild().sendKeys(futil.getDataFromProperty("password"));
		lPage.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		HomePage hpage=new HomePage(driver);
		hpage.getLogoutLink().click();
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		eReport.flush();
	}
	
}
