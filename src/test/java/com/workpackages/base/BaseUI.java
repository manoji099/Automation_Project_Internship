package com.workpackages.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.workpackages.utils.custamizeReport;
import com.workpackages.utils.dateUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUI {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;
	public ExtentReports report;
	public ExtentTest logger;
	public WebElement entername, typedrop, lifedrop, taskmanage, 
	technology, umosize, adqualifier, responsibility, cadets,
	startDate,iframe, endDate;
	public custamizeReport creport;
	public static int SI=1;
	public Wait<WebDriver> waits ; 
	public static String resultFile;
	public String userDirector = System.getProperty("user.dir");
	int startIteration;
	int endIteration;
	File customFile;
	
	/****************** Dynamic Browser invoking ***********************/
	@SuppressWarnings("deprecation")
	public void InvokeBrowser(String browserName, String urlKey){
		try {
			if(browserName.equalsIgnoreCase("Chrome")){
				
				//-----------------WebDriverManager had been used---------
				WebDriverManager.chromedriver().driverVersion("89.0.4389.23").setup();
				
				driver =new ChromeDriver();
				if(prop==null){
					prop = new Properties();
				
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\workpackages\\properties\\storage.properties");
				prop.load(file);
				}
			
			}else if(browserName.equalsIgnoreCase("Firefox")){
				WebDriverManager.firefoxdriver().driverVersion("0.29.1").setup();
				driver =new FirefoxDriver();
				if(prop==null){
					prop = new Properties();
				
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\workpackages\\properties\\storage.properties");
				prop.load(file);
				}
				
			}
			
				driver.manage().window().maximize();
				//implicit wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//Explicit wait
				wait = new WebDriverWait(driver, 30); 
				//FluentWait
				waits = new FluentWait<WebDriver>(driver)
					       .withTimeout(30, TimeUnit.SECONDS).ignoring(NullPointerException.class);
				
				driver.get(prop.getProperty(urlKey));
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/****************** Capture Screen Shot ***********************/
	public void takeScreenshot(){
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File pic = takescreenshot.getScreenshotAs(OutputType.FILE);
		
		try {
			
			FileUtils.copyFile(pic, new File(System.getProperty("user.dir")+
					"\\src\\test\\resources\\com\\workpackages\\screenShot\\"+ dateUtils.getTimeStamp()+".png"));
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+
					"\\src\\test\\resources\\com\\workpackages\\screenShot\\"+ dateUtils.getTimeStamp()+".png");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

	
}
