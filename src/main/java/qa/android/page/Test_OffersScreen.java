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

//@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_OffersScreen extends TestBase   {
	
	public Test_OffersScreen OffersTest() throws Exception
	{
		HomePage.loaded();

		HomePage.signIn();
		HomePage.closeSignIn();
		
		HomePage.searchPress();
		driver.hideKeyboard();
		HomePage.close();
		
		HomePage.swipeLeft();
		HomePage.radioButtonCheck();
		
		HomePage.addToFavorit();
		HomePage.playContent();
		HomePage.removeFavorit();

		HomePage.openDetailPage();
		HomePage.close();
		
		String deviceType = DriverManager.characteristics();
		String[] parts = deviceType.split(",");
		String part1 = parts[0];
		if(part1=="tablet")
		{
			HomePage.loaded();

			HomePage.signIn();
			HomePage.closeSignIn();
			
			HomePage.searchPress();
			driver.hideKeyboard();
			HomePage.close();
			
			HomePage.swipeLeft();
			HomePage.radioButtonCheck();
			
			HomePage.addToFavorit();
			HomePage.playContent();
			HomePage.removeFavorit();

			HomePage.openDetailPage();
			HomePage.close();
		}
		else
		{}
		return new Test_OffersScreen();
	}
}
	
