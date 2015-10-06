package main.java.qa.android.page;

import reporter.JyperionListener;

import java.util.List;

import main.java.qa.android.main.*;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.page.Tablet_Test;
import main.java.qa.android.testng.LoggingListener;
import main.java.qa.android.testng.TestListeners;
import main.java.qa.android.testng.TestMethodListener;
import main.java.qa.android.util.AppiumTest;
import main.java.qa.android.util.Helpers;
import main.java.qa.android.util.PropertyUtils;
import main.java.qa.android.testng.PdfListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_Search extends TestBase   {
	
	@Test
	public Test_Search Test_Search()  throws Exception
	{
		HomePage.loaded();
		
		HomePage.searchPress();
		HomePage.searchFor(PropertyUtils.getProperty("searchFor"));
		HomePage.getSearchResoult();	
		HomePage.clearSearch();
		driver.hideKeyboard();
		HomePage.closeSearch();
		
		return new Test_Search();
	}
}