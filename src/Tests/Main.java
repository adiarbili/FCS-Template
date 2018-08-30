package Tests;





import java.util.ArrayList;

import org.testng.TestListenerAdapter;


import com.beust.testng.TestNG;

public class Main 
{
	public static void main(String[] args) 
	{
		//TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		ArrayList<String> suites = new ArrayList<String>();
		suites.add("D:\\Work-Elbit\\Eclipse Workspace\\FCS\\src\\tests3.xml");//path to xml..

		testng.setTestSuites(suites);
		testng.run();

	}
}
