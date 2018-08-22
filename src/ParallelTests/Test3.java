package ParallelTests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Tests.BaseTest;
import WebDriver.Driver;

public class Test3 extends BaseTest
{
	private static Driver driver;
	
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
	
	@Test (priority = 3)
	public void search()
	{		
		
		logger = extentReport.startTest("Search for Adi Arbili","Search Adi Arbili on google");
		
		String inputSearchID = "lst-ib"; 
		String searchBtnXpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]";
						
		WebElement inputSearch = getElementByIdent(searchType.ID, inputSearchID, "Input search");
		
		inputSearch.sendKeys("Adi Arbili");
		
		assertEquals(inputSearch.getAttribute("value"), "Adi Arbili");		
				
		logger.log(LogStatus.PASS, "Insert ''Adi Arbili'' to search input");
		
		getElementByIdent(searchType.XPATH, searchBtnXpath, "Search button").submit();	
		
		logger.log(LogStatus.PASS, "Click on search button");
	}
}
