package com.Ecommerce.Firelawn.genericLIB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Connection con;
	public FileUtilies fu=new FileUtilies();
	public WebDriver driver;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public WebdriverUtilies webutilies=new WebdriverUtilies();
	
	@BeforeSuite
	public void configBs() throws SQLException {
		System.out.println("connect to database");
		con=fu.getdataDB();
		
		htmlreport=new ExtentHtmlReporter(AutoConstant.reportsPath);
		htmlreport.config().setDocumentTitle("FireflawnReport");
		htmlreport.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(htmlreport);
		
	}
	
	@BeforeMethod
	public void openApp() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getthepropertydata("url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException {
		int result=res.getStatus();
		if (result==ITestResult.FAILURE) {
			test.log(Status.FAIL,res.getName()+"Test case is failed");
			test.log(Status.FAIL,res.getThrowable()+"Testcase is failed Exception");
		}
		else if(result==ITestResult.SUCCESS) {
			test.log(Status.PASS,res.getName()+"Test case is passed");
		}
		else if (result==ITestResult.SUCCESS) {
			test.log(Status.SKIP,res.getName()+"testcase is skipped");	
		}
		String name = res.getName();
		if (result==2) {
			Screenshot a=new Screenshot();
			a.getPhoto(driver, name);
		}
		
		driver.quit();
		
	}
	
	@AfterSuite
	public void configAs() throws SQLException {
		reports.flush();
		fu.closedb();
		Reporter.log("Database is closed");
	}
	
}

