package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver 
{	
	private WebDriver chromeDriver;
	private WebDriverWait wait;
	public final String URL = "https://www.google.com";
	
	public Driver()
	{
		try 
		{
			System.setProperty("webdriver.chrome.driver", "resources/ChromeDriver_V2.37.exe");
			
			chromeDriver = new ChromeDriver();
			chromeDriver.manage().window().maximize();
			
			wait = new WebDriverWait(chromeDriver, 10);

			chromeDriver.get(URL);			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	public void quit()
	{
		try 
		{
			Thread.sleep(3000);
			chromeDriver.quit();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public WebDriver getChromeDriver()
	{
		return chromeDriver;
	}
	
	public WebDriverWait getWait()
	{
		return wait;
	}		
}
