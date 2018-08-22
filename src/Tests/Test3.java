package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Test3 extends BaseTest
{
	
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
