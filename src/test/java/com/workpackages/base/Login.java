package com.workpackages.base;

import java.io.File;
import java.util.List;
import java.util.Vector;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.workpacakges.readexcel.ReadExcel;
import com.workpackages.utils.*;

public class Login extends BaseUI {

	@BeforeSuite
	public void Openmainspring() {
		InvokeBrowser("Chrome", "url");
		resultFile = userDirector + "\\test-output\\customReport\\"+dateUtils.getTimeStamp()+".html";
		customFile = new File(resultFile);
	}
	
	@BeforeTest
	public void reportGenerate(){
		report = extentReportManager.getReport();
	}
	
	/*
	 * To login we need to enter email and password
	 * Email (Line- 56)
	 * Password(Line- 65)
	 * 
	 */
	@Test(priority = 1)
	public void mainspring() {

		try {
			

			logger=report.createTest("Microsoft Login");
			logger.log(Status.INFO, "Opening the WebSite");
			takeScreenshot();
			custamizeReport.updateResult(SI, "AstraZe-Workpackages", "Pass","AstraZe",customFile);

			// ---------------Enter UserName for Login-------------------
			WebElement username = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("username_xpath"))));
			username.sendKeys("9065530@cognizant.com");

			WebElement next = driver.findElement(By.id("idSIButton9"));
			next.click();
			logger.log(Status.INFO, "Opening the WebSite");
			
			// --------------Enter password for Login--------------------
			WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(prop.getProperty("psd_xpath"))));
			password.sendKeys("Rajamani@4446");
			password.click();

			WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
			submit.click();
			
			takeScreenshot();
			logger.log(Status.PASS, "Browser Opened");
			custamizeReport.updateResult(SI++, "mainspring page is successfully opened", "Pass","mainSpring",customFile);
			// -----------------This Wait for OTP Verification-------------
			Thread.sleep(50000);

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			takeScreenshot();
			custamizeReport.updateResult(SI++, "mainspring page is not successfully opened", "Fail","mainSpring",customFile);

		}
	}
	
	/*
	 * Moving to AstraZe-Supported
	 * 
	 */

	@Test(priority=2)
	public void menu() {

		try {
			
			logger=report.createTest("AstraZemenu to Workpackages");
			logger.log(Status.INFO, "Opening the AstraZemenu");
			takeScreenshot();
			// -----------------Click on Menu on left-side-----------------
			WebElement leftmenu = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("menu_xpath"))));
			leftmenu.click();

			// -----------------Click on AstraZe in Menu--------------------
			WebElement astra = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("astra_xpath"))));
			astra.click();
			logger.log(Status.PASS, "Opened the AstraZemenu");
			takeScreenshot();
			// ------------------Getting Title of the WebPage--------------
			String title = driver.getTitle();
			System.out.println("The title of the page is : " + title);
			
			

			// -----------------Moving to Execute menu---------------------

			wait.until(ExpectedConditions.elementToBeClickable
					(driver.findElement(By.xpath(prop.getProperty("execute_xpath")))));
			
			// --------------------Select Workpackages in the Dropdown-------

		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",driver.findElement
					(By.xpath(prop.getProperty("workpackages_xpath"))));
			
			
			takeScreenshot();
			custamizeReport.updateResult(SI++, "Entered in to AstraZe main page", "Pass","Workpackages",customFile);
			logger.log(Status.INFO, "Opening the Workpackages");
			logger.log(Status.PASS, "Workpackages had been opened");
		
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			takeScreenshot();
			custamizeReport.updateResult(SI++, "Doesn't Entered in to AstraZe main page", "Fail","Workpackages Failed",customFile);
		}
	}

	/*
	 * AstraForm to iterate 
	 * 
	 * startIteration - (Line-162)
	 * endIteration - (Line-163)
	 * 
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unused", "deprecation" })
	@Test(priority = 3)
	public void AstraForm() {
		
		logger=report.createTest(" Workpackages");
		logger.log(Status.INFO, "Getting into Workpackages data");

		try {
			ReadExcel obj = new ReadExcel();
			Vector dataHolderSheet = obj.readExcelFile();
			
			int allData = dataHolderSheet.size();
			startIteration =4;
			endIteration = 4;

			
			for (int rowIndex = startIteration; rowIndex <= endIteration; rowIndex++) {

				
				int j = 0;
				String userName = "";
				String password = "";
				String Lifecycle = "";
				String Tech = "";
				String umo = "";
				String ad = "";
				String respons = "";
				String sdate = "";
				String edate = "";

				Vector cellStoreVector = (Vector) dataHolderSheet.elementAt(rowIndex);
				
				XSSFCell iuserName = (XSSFCell) cellStoreVector.elementAt(j++);
				userName = iuserName.toString().trim();

				XSSFCell ipassword = (XSSFCell) cellStoreVector.elementAt(j++);
				password = ipassword.toString().trim();

				XSSFCell ilyfecycle = (XSSFCell) cellStoreVector.elementAt(j++);
				Lifecycle = ilyfecycle.toString().trim();

				XSSFCell iTech = (XSSFCell) cellStoreVector.elementAt(j++);
				Tech = iTech.toString().trim();

				XSSFCell iumo = (XSSFCell) cellStoreVector.elementAt(j++);
				umo = iumo.toString().trim();

				XSSFCell iad = (XSSFCell) cellStoreVector.elementAt(j++);
				ad = iad.toString().trim();

				XSSFCell irespons = (XSSFCell) cellStoreVector.elementAt(j++);
				respons = irespons.toString().trim();

				XSSFCell isdate = (XSSFCell) cellStoreVector.elementAt(j++);
				sdate = isdate.toString().trim();

				XSSFCell iedate = (XSSFCell) cellStoreVector.elementAt(j++);
				edate = iedate.toString().trim();

				/****************** Using Object Repository ***********************/
				
				
				// -----------------Click on New icon--------------------------
				
					while(true){
			
			            if (1 == driver.findElements((By.xpath(prop.getProperty("new_btn")))).size()){
			            	wait.until(ExpectedConditions.elementToBeClickable
			            			(By.xpath(prop.getProperty("new_btn")))).click();                    
			                break;
			            }else
			            	
			          //------------Refreshing the page----------------------
			            	
			            	driver.navigate().refresh();
			            
			         // -----------------Moving to Execute menu---------------------

						wait.until(ExpectedConditions.elementToBeClickable
								(driver.findElement(By.xpath(prop.getProperty("execute_xpath")))));
						takeScreenshot();
						custamizeReport.updateResult(SI++, "Page refreshing", "INFO","Page Refresh",customFile);
						// --------------------Select Workpackages in the Dropdown-------

					
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();",driver.findElement
								(By.xpath(prop.getProperty("workpackages_xpath"))));
						wait.until(ExpectedConditions.elementToBeClickable(
								By.xpath(prop.getProperty("new_btn")))).click();

						break;
			           
				}

				
				
				
				// ---------------------Switch to Frame--------------------
				int a=startIteration;
				Thread.sleep(2000);
				if (a == startIteration) {
					iframe = wait.until(
							ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iframe_xpath"))));
					driver.switchTo().frame(iframe);
				}

				custamizeReport.updateResult(SI++, "Workpackages data started to fill", "INFO","Workpackages data",customFile);

				// ---------------Entering data to Name-----------------------
				entername = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iname_xpath"))));
				entername.sendKeys((String) userName);

				// ----------select on workpackages type TextBox DropDown------
				
				typedrop = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("wtyre_xpath"))));
				Select proman = new Select(typedrop);
				proman.selectByVisibleText((String) password);


				// -----------Select on LifeCycle Phase TextBox DropDown--------
				lifedrop = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("lifetype_xpath"))));
				Select lifecycle = new Select(lifedrop);
				lifecycle.selectByVisibleText((String) Lifecycle);

				// --------Selecting technology TextBox DropDown--------
				
				technology = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("tech_xpath"))));
				Select tech = new Select(technology);
				tech.selectByVisibleText((String) Tech);
				
				takeScreenshot();
				logger.log(Status.INFO, "Workpackages data");
				custamizeReport.updateResult(SI++, "Workpackages data fill", "Pass","Workpackages data fill",customFile);
				// --------Selecting UMO Size TextBox DropDown--------
				umosize = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("umosize_xpath"))));
				Select umos = new Select(umosize);
				umos.selectByVisibleText((String) umo);
				
				logger.log(Status.INFO, "Workpackages data");
				
				// --------Selecting AD Qualifier TextBox DropDown--------
				adqualifier = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("adqualifier_xpath"))));
				Select ads = new Select(adqualifier);
				ads.selectByVisibleText(ad);
				
				// --------Selecting AD Qualifier TextBox DropDown--------
				responsibility = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("response_xpath"))));
				Select resp = new Select(responsibility);
				resp.selectByVisibleText((String) respons);

				// -----------Select Start Date Integration Applicability TextBox DropDown----------
				startDate = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("sdate_xpath"))));
				startDate.click();
				startDate.sendKeys((String) sdate);
				
				logger.log(Status.INFO, "Workpackages data");
				// -----------Select End Date Integration Applicability TextBox DropDown----------

				endDate = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("edate_xpath"))));
				endDate.click();
				endDate.sendKeys((String) edate);

				// -----------Select CADET Integration Applicability TextBox DropDown----------

				WebElement cadet1 = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cadet_xpath"))));
				Select cad = new Select(cadet1);
				cad.selectByValue("Yes");
				
				takeScreenshot();
				logger.log(Status.PASS, "Workpackages data");
				custamizeReport.updateResult(SI++, "Workpackages data filled successfully", "Pass","dataFilled",customFile);
				// -----------Select Save Button------------------
				driver.findElement(By.xpath(prop.getProperty("save_xpath"))).click();
				//Fluent wait
				
				driver.switchTo().alert().accept();

				wait.until(ExpectedConditions.elementToBeClickable(By.id(prop.getProperty("return_id")))).click();
				takeScreenshot();
				custamizeReport.updateResult(SI++, "Testing Completed", "Pass","Completed",customFile);

				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			takeScreenshot();
			custamizeReport.updateResult(SI++, "Workpackages data filled successfully", "Fail","dataFilled fail",customFile);

		}

	}
	
	@AfterTest
	public void reportFlush(){
		report.flush();
	}
	

	@AfterSuite
	public void quitBrowser() {
		
		driver.quit();
	}

}
