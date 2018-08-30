package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import java.io.File;

import org.apache.tools.ant.taskdefs.condition.Not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import WebDriver.Driver;

public abstract class BaseTest 
{
	public static Driver driver;
	
	protected static ExtentReports extentReport;
	protected ExtentTest mainTest;
	protected ExtentTest childTest;
		
	protected enum searchType {ID, XPATH};
	
	@BeforeSuite
	public void initReport()
	{
		driver = new Driver();
		
		extentReport = new ExtentReports (System.getProperty("user.dir") +"/Reports/Report.html", true, NetworkMode.OFFLINE);
		extentReport
                .addSystemInfo("Chrome driver", "2.37")
                .addSystemInfo("Selenium", "3.11")
                .addSystemInfo("Extent report", "2.41.2")
                .addSystemInfo("TestNG", "6.14.2");
                
		//loading the external xml file.
		extentReport.loadConfig(new File("resources/ReportConfig.xml"));
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			childTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getName() +" - " + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			childTest.log(LogStatus.SKIP, "Test Case Skipped is "+ result.getName());
		}
		
		driver.getChromeDriver().navigate().to(driver.URL);
		mainTest.appendChild(childTest);
		extentReport.endTest(childTest);

	}	
	
	@AfterClass
	public void endTestClass()
	{
		extentReport.endTest(mainTest);
		extentReport.flush();
	}

	@AfterSuite
	public void endReport()
	{			
		extentReport.close();
        driver.quit();
    }	
	
	public WebElement getElementByIdent(searchType type, String componeteIdentifier, String componentDes)
	{
		WebElement res = null;

		switch(type)
		{
			case ID:
				res =  driver.getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(componeteIdentifier)));
				break;
			
			case XPATH:
				res =  driver.getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(componeteIdentifier)));
				break;					
		}
		
		//assertNotNull(res, "Object is null");
	
		childTest.log(LogStatus.PASS, "Search for " + componentDes);
		
		return res;
	}		
}
