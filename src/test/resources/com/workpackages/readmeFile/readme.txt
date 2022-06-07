======================Main Project Team1================

Project Name: AstraZe-Global Reltio Support
Module Assigned: Workpackages
Application URL: "https://pratesting.cognizant.com"

======================Concepts Implemented==============

1.Data Driven Framework
2.Maven Project
3.TestNG
4.Reading data from excel
5.Invoking dynamic browser with WebDriverManager, so that we don't need the driver.exe
6.Implicit, Explicit and Fluent Waits have been implemented
7.Java OOP's concept have been implemented
8.Iteration have been done for reading excel data
9.Customized HTML report had been done
10.Extent report has implemented
11.ScreenShot concept is implemented and screenshot is attached to customized and extent HTML report

======================Paths and Object Repository=================

1.Customized report = \INTQAE21QE007_Team1_WorkPackages\test-output\customReport
2.properties file = \INTQAE21QE007_Team1_WorkPackages\src\test\resources\com\workpackages\properties
3.screenshot = \INTQAE21QE007_Team1_WorkPackages\src\test\resources\com\workpackages\screenShot
4.Extent report= \INTQAE21QE007_Team1_WorkPackages\Report
5.Exceldata = \INTQAE21QE007_Team1_WorkPackages\src\test\resources\com\workpackages\excel\MAIN_PROJECT_TEAM1_DATA.xlsx

=========================================================

*****To Iterate the excel data as required*******

Go to workpages.base package:
Go to Loginpage: 
'startIteration' is to give the input from which row it should start iterate
'endIteration' is to give the input from which row it should end iterate
'allData' is to read whole size of the excel data

=========================================================

*****This project consist of 3 package folder********

src/test/java- consist all the packages related to Automation scripting

BaseUI java class- holds all the global declaration, browser handling and screenshot method.
ReadExcel java class- holds the excel data driven using list concept
customizeReport- holds all the data screenShot, Pass, Detail
extentReport- holds all the reporting part status and also its implemented using dependency
Login.java -Its the main script we need run the program in Login class only

===========================================================
 ## To Run the project 
 
 1.Need to go to Login.java
 2.Need to enter Email and password to login at the method mainspring.
 				# Email- line-56
 				# password- line-65
 3.To Iterate
 				# startIteration- line-162
				# endIteration- line-163
				
 4. We need to add the Webdrivermanager jar 
 		
 		->Download the jar files
 		
 	->	https://download.jar-download.com/cache_jars/io.github.bonigarcia/webdrivermanager/4.4.2/jar_files.zip
 				

===========================================================

*****************Login.java***********************

All the testNG annotation are holds in 'Login class'.

      In invokeBrowser method we need to pass the browser name and urlKey
      The custom report file path is declared in beforesuite and File object value has been assigned
      The main Microsoft login page is inside the method 'mainspring'
      The AstrZe main page in the method 'AstraZe'
	  The method AstraForm consist the Workpackages filling module
	  In the AstraForm method the Iteration part is available
	  			# startIteration
	  			# endIteration
	  			# allData
	  
===========================================================

*****************customize report********************

	  The report generate the following features
	  		
	  		-Pass/Fail Status
	  		-Detail of the status
	  		-ScreenShot for every status
	  		-Screenshot is Hyperlinked
	  		-Date and Time of report generated
	  		
=========================================================== 




