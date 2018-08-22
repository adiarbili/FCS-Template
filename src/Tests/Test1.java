package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Test1 extends BaseTest
{
	
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
