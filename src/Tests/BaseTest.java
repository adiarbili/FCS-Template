package Tests;

import java.io.File;

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

import WebDriver.Driver;

public abstract class BaseTest 
{
	public static Driver driver;
	
	protected static ExtentReports extentReport;
	protected ExtentTest logger;
		
	protected enum searchType {ID, XPATH};
	
	@BeforeSuite
	public void initReport()
	{
		driver = new Driver();
		
		extentReport = new ExtentReports (System.getProperty("user.dir") +"/Reports/Report.html", true);
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
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName() +" - " + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		
		driver.getChromeDriver().navigate().to(driver.URL);
		
		extentReport.endTest(logger);
		extentReport.flush();	
	}	
		
	//@AfterTest
	@AfterSuite
	public void endReport()
	{
		extentReport.close();
        driver.quit();
    }	
	
/*	public WebElement getElementByIdent(searchType type, String componeteIdentifier)
	{
		WebElement res = null;
		
		try 
		{
			switch(type)
			{
				case ID:
					res =  driver.getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(componeteIdentifier)));
					break;
				
				case XPATH:
					res =  driver.getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(componeteIdentifier)));
					break;					
			}
			
			logger.log(LogStatus.PASS, "Search for " + componeteIdentifier);
			
		} 
		catch (Exception e) 
		{
			System.out.println(componeteIdentifier + " object was not foud.");
			//logger.log(LogStatus.FAIL, "Search for " + componeteIdentifier);
			driver.quit();
			//alert()
		}
		
		return res;
	}	*/
	
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
			
			logger.log(LogStatus.PASS, "Search for " + componentDes);

		return res;
	}		
}
