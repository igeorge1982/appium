package main.java.qa.android.page;

import main.java.qa.android.main.*;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.page.Tablet_Test;
import main.java.qa.android.testng.LoggingListener;
import main.java.qa.android.testng.TestListeners;
import main.java.qa.android.testng.TestMethodListener;
import main.java.qa.android.util.AppiumTest;
import main.java.qa.android.testng.PdfListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_Sort extends TestBase   {
	
	@Test
	public Test_Sort Test_Sort()  throws Exception
	{
		HomePage.loaded();
		
		String text = DriverManager.characteristics();
		if(text.contains("tablet"))
		{
			System.out.println(text);
			
			Tablet_Test.sortFeatured(2);
			Tablet_Test.sortAToZ(6);
		}
		
		return new Test_Sort();
	}
}