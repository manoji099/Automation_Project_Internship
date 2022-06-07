package com.workpackages.Astraze_menu;

import java.io.File;
import java.io.FileInputStream;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.workpacakges.readexcel.ReadExcel;
import com.workpackages.base.BaseUI;

public class Formfill extends BaseUI {
	WebElement entername, typedrop, lifedrop, taskmanage, technology, umosize, adqualifier, responsibility, cadets,
			startDate, endDate;

	// public Object[][] readExcel() throws Exception
	// {
	// Object[][] data = ReadExcel.readexceldata("Testdata");
	// return data;
	// }

	@Test
	public void AstraForm() {
		ReadExcel obj = new ReadExcel();
		System.out.println("Test in the");
		try {

			Vector dataHolderSheet = obj.readExcelFile();
			for (int rowIndex = 1; rowIndex < dataHolderSheet.size(); rowIndex++) {
				System.out.println("Test in the for loop");
				int j = 0;
				String userName = "";
				String password = "";
				String Lifecycle = "";
				String tasks="";
				String Tech="";
				String umo="";
				String ad="";
				String respons="";
				String cadet="";
				String sdate="";
				String edate="";

				Vector cellStoreVector = (Vector) dataHolderSheet.elementAt(rowIndex);
				XSSFCell iuserName = (XSSFCell) cellStoreVector.elementAt(j++);
				userName = iuserName.toString().trim();
				
				XSSFCell ipassword = (XSSFCell) cellStoreVector.elementAt(j++);
				password = ipassword.toString().trim();
			
				XSSFCell ilyfecycle = (XSSFCell) cellStoreVector.elementAt(j++);
				Lifecycle = ilyfecycle.toString().trim();
				
				XSSFCell itasks = (XSSFCell) cellStoreVector.elementAt(j++);
				tasks = tasks.toString().trim();
				
				XSSFCell iTech = (XSSFCell) cellStoreVector.elementAt(j++);
				Tech = iTech.toString().trim();
				
				XSSFCell iumo = (XSSFCell) cellStoreVector.elementAt(j++);
				umo = iumo.toString().trim();
				
				XSSFCell iad = (XSSFCell) cellStoreVector.elementAt(j++);
				ad = iad.toString().trim();
				
				XSSFCell irespons = (XSSFCell) cellStoreVector.elementAt(j++);
				respons = irespons.toString().trim();
				
				XSSFCell icadet = (XSSFCell) cellStoreVector.elementAt(j++);
				cadet = irespons.toString().trim();
				
				XSSFCell isdate = (XSSFCell) cellStoreVector.elementAt(j++);
				sdate = isdate.toString().trim();
				
				XSSFCell iedate = (XSSFCell) cellStoreVector.elementAt(j++);
				edate = iedate.toString().trim();
				
				System.out.println(userName);
				
				

				// ---------------Entering data to Name-----------------------
				entername = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='CM_Name']")));
				entername.sendKeys((String)userName);

				// ----------select on workpackages type TextBox DropDown------
				typedrop = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("field200")));
				Select proman = new Select(typedrop);
				proman.selectByVisibleText((String)password);

				// ------------click on CheckBox is applicable-----------------
				driver.findElement(By.xpath("//input[@id='field189' and @type='checkbox']")).click();

				// -----------Select on LifeCycle Phase TextBox DropDown--------
				lifedrop = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='field191' and @name='field191']")));
				Select lifecycle = new Select(lifedrop);
				lifecycle.selectByVisibleText(Lifecycle);

				// -----------Select on LifeCycle Phase TextBox DropDown--------
				taskmanage = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("isPackageDigiteStart")));
				Select task = new Select(taskmanage);
				task.selectByVisibleText(tasks);

				// ----------------Scroll down--------------------
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//js.executeScript("window.scrollBy(0,10)");

				// --------Selecting technology TextBox DropDown--------
				technology = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field172']")));
				Select tech = new Select(technology);
				tech.selectByVisibleText(Tech);

				// --------Selecting UMO Size TextBox DropDown--------
				umosize = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field190']")));
				Select umos = new Select(umosize);
				umos.selectByVisibleText(umo);

				// --------Selecting AD Qualifier TextBox DropDown--------
				adqualifier = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field168']")));
				Select ads = new Select(adqualifier);
				ads.selectByVisibleText(ad);

				// --------Selecting AD Qualifier TextBox DropDown--------
				responsibility = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field193']")));
				Select resp = new Select(responsibility);
				resp.selectByVisibleText(respons);

				// -----------Select CADET Integration Applicability TextBox
				// DropDown----------
				cadets = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//select[@id='field120' and @name='field120']")));
				Select cad = new Select(cadets);
				cad.selectByVisibleText(cadet);

				// -----------Select Start Date Integration Applicability
				// TextBox DropDown----------
				startDate = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input[@id='field2' and @name='field2']")));
				startDate.sendKeys(sdate);

				// -----------Select End Date Integration Applicability TextBox
				// DropDown----------
				endDate = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CM_DUEDATE']")));
				endDate.sendKeys(edate);
				// -----------Select Save Button------------------
				driver.findElement(By.xpath("//*[@id='SaveBtn' or @name='SaveBtn']")).click();
				Thread.sleep(7000);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	
}

