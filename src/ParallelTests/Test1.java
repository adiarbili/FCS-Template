package ParallelTests;

import java.io.File;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Tests.BaseTest;
import WebDriver.Driver;

public class Test1 extends BaseTest
{
	public static Driver driver;
	
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
	
	@Test (priority = 1)
	public void search()
	{		
		logger = extentReport.startTest("Search Adi Arbili");
		
		String searchID = "lst-ib"; 
		String searchBtnXpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]1"; 
		
		getElementByIdent(searchType.ID, searchID, "Input search").sendKeys("Adi Arbili");
		getElementByIdent(searchType.XPATH, searchBtnXpath, "Search button").submit();	
		
		logger.log(LogStatus.PASS, "Test Case (search) Status is passed");
	}
}
