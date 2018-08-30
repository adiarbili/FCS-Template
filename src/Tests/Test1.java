package Tests;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Test1 extends BaseTest
{
	//assertEquals(actual, expected);
	@BeforeClass
	public void searchText()
	{			
		mainTest = extentReport.startTest("Search for Adi Arbili", "Insert Adi Arbili to a search input and click on search button");
	}
	
	@Test (priority = 1)
	public void insertText()
	{	
		childTest = extentReport.startTest("Insert text to input text");
		
		String input = "Adi Arbili";
		
		String inputSearchID = "lst-ib"; 
		WebElement inputText =  getElementByIdent(searchType.ID, inputSearchID, "Input search");
		inputText.sendKeys(input);
		
		Assert.assertEquals(inputText.getAttribute("value"), input, "Input to search");
		childTest.log(LogStatus.PASS, "Insert \"" + input + "\" to input text");
	}
	
	@Test (priority = 2)
	public void clickButton()
	{			
		childTest = extentReport.startTest("Click on search button");
		
		String searchBtnXpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]1"; 		
		WebElement searchBtn = getElementByIdent(searchType.XPATH, searchBtnXpath, "Search button");
		childTest.log(LogStatus.PASS, "Search for a \"Search\" button.");
		
		Assert.assertEquals(searchBtn.isEnabled(), true, "Enter.disable()");
		searchBtn.submit();
					
		childTest.log(LogStatus.PASS, "\"Search\" button was clicked.");
	}
	///*
	@Test (priority = 3)
	public void someAfterTest()
	{			
		childTest = extentReport.startTest("Some test");					
		childTest.log(LogStatus.PASS, "Some test passed.");
	}//*/	
}
