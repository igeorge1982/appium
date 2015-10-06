package main.java.qa.android.page;

import main.java.qa.android.main.*;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.page.Tablet_Test;
import main.java.qa.android.testng.LoggingListener;
import main.java.qa.android.testng.TestListeners;
import main.java.qa.android.testng.TestMethodListener;
import main.java.qa.android.testng.PdfListener;

import org.testng.annotations.Listeners;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_Menu extends TestBase   {
	
	private static String device; 
	public Test_Menu MenuTest()	throws Exception
	{
		device = TestBase.characteristics();
		
		if ( device.contains("tablet")){
					
			HomePage.loaded();		
			Tablet_Test.selectAllMenuRow();		
		}
		
		return new Test_Menu();
	}
}
