package Tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Test2 extends BaseTest
{	
	/*
	@Test (priority = 2)
	public void clickSearchBtn()
	{		
		
		logger = extentReport.startTest("Press on search button"); //Dont write logger in a logger causes to :
		// "com.relevantcodes.extentreports.ExtentTestInterruptedException: Close was called before test could end safely using EndTest."		

		
		String searchBtnXpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]";
		getElementByIdent(searchType.XPATH, searchBtnXpath, "Search button").submit();	
		
		
		logger.log(LogStatus.PASS, "Test Case (search) Status is passed");
	}	
	
	@Test (priority = 1)
	public void insertText()
	{		
		logger = extentReport.startTest("Insert text to input search","Insert text: WHY????");
		
		String inputSearchID = "lst-ib"; 
		WebElement inputSearch = getElementByIdent(searchType.ID, inputSearchID, "Input search");
		
		inputSearch.sendKeys("WHY????");
		
		assertEquals(inputSearch.getAttribute("value"), "WHY????");
				
		logger.log(LogStatus.PASS, "Text was inserted properly");
	}	
	*/
	
	@Test //(priority = 1)
	public void MclickButton()
	{			
		childTest = extentReport.startTest("Click on search button");
		childTest.log(LogStatus.PASS, "Test2");
	}
	
	@Test //(priority = 2)
	public void insertText()
	{	
		childTest = extentReport.startTest("Insert text to input text");
		assertEquals(true, false, "Enter.disable()");
		childTest.log(LogStatus.PASS, "Insert \" Adi Arbili \" to input text");
	}
	
	@Test //(priority = 2)
	public void insertText3()
	{	
		childTest = extentReport.startTest("Insert text to input text");
		assertEquals(true, false, "Enter.disable()");
		childTest.log(LogStatus.PASS, "Insert \" Adi Arbili \" to input text");
	}	
	
	@BeforeClass(alwaysRun = true)
	public void search()
	{			
		mainTest = extentReport.startTest("Test2");
	}

}
