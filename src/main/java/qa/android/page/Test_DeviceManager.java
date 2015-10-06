package main.java.qa.android.page;

import reporter.JyperionListener;

import java.util.List;

import main.java.qa.android.main.*;
import main.java.qa.android.page.*;
import main.java.qa.android.testng.*;
import main.java.qa.android.util.*;

import org.testng.annotations.*;
import org.junit.runner.notification.*;
import org.openqa.selenium.*;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_DeviceManager extends TestBase   {
	
	@Test
	public Test_DeviceManager Test_DeviceManager()  throws Exception
	{
		HomePage.loaded();
		
		String deviceType = DriverManager.characteristics();
		String[] parts = deviceType.split(",");
		String part1 = parts[0];
		if(part1=="tablet")
		{
			Tablet_Test.navigateSettingsDevices();
		}
		
		return new Test_DeviceManager();
	}
}