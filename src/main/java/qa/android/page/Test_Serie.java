package main.java.qa.android.page;

import java.util.List;

import main.java.qa.android.main.*;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.page.Tablet_Test;
import main.java.qa.android.testng.LoggingListener;
import main.java.qa.android.testng.TestListeners;
import main.java.qa.android.testng.TestMethodListener;
import main.java.qa.android.util.AppiumTest;
import main.java.qa.android.util.Helpers;
import main.java.qa.android.testng.PdfListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_Serie extends TestBase   {
	
	@Test
	public Test_Serie Test_Serie()  throws Exception
	{
		HomePage.loaded();
		
		String deviceType = DriverManager.characteristics();
		String[] parts = deviceType.split(",");
		String part1 = parts[0];
		if(part1=="tablet")
		{
			Tablet_Test.selectMenu3();
			Tablet_Test.selectSerie();
			//Tablet_Test.selectSeasonLine(0);
			Helpers.elementByUISelector("vg_Spinner_Placeholder").click();
			List<WebElement> seasons = driver.findElements(By.className("android.widget.LinearLayout"));
			seasons.get(0).click();
			//Tablet_Test.closePopup();
			HomePage.closeDetailPage();
		}

		return new Test_Serie();
	}
}