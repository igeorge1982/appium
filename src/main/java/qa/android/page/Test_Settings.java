package main.java.qa.android.page;

import main.java.qa.android.main.*;
import main.java.qa.android.page.Tablet_Test;
import main.java.qa.android.testng.LoggingListener;
import main.java.qa.android.testng.TestListeners;
import main.java.qa.android.testng.TestMethodListener;
import main.java.qa.android.util.AppiumTest;
import main.java.qa.android.testng.PdfListener;

import org.testng.annotations.Listeners;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_Settings extends TestBase   {
	
	public Test_Settings SettingsTest() throws Exception
	{
		HomePage.loaded();
		
		String deviceType = DriverManager.characteristics();
		String[] parts = deviceType.split(",");
		String part1 = parts[0];
		if(part1=="tablet")
		{
			Tablet_Test.selectHelpRow();
			Tablet_Test.selectSignOutRow();
			Tablet_Test.selectSettingsRow();
		}
		return new Test_Settings();
	}
}