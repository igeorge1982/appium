package main.java.qa.android.page;

import java.util.List;

import main.java.qa.android.main.*;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.testng.LoggingListener;
import main.java.qa.android.testng.TestListeners;
import main.java.qa.android.testng.TestMethodListener;
import main.java.qa.android.util.Helpers;
import main.java.qa.android.util.WaitTool;
import main.java.qa.android.testng.PdfListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })

public class Test_Player extends TestBase {
	private static String device; 

	@Test
	public Test_Player test_Player()  throws Exception
	{
		
		device = TestBase.characteristics();
		
		if ( device.contains("tablet")){
			HomePage.loaded();

			List<WebElement> rows = HomePage.menuList();
			rows.get(1).click();
			WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("ll_Offers_Category_Main"), 3);
			Helpers.elementByUISelector("ll_Offers_Category_Main").click();
			HomePage.playTrailer();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("btn_Player_Pause").click();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("btn_Player_Play").click();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("btn_Player_Restart").click();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("sb_Player").click();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("btn_Player_Volume").click();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("btn_Player_Subtitles").click();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("btn_Player_AudioTracks").click();
			driver.tap(1, 400, 400, 2);
			Helpers.elementByUISelector("btn_Player_Close").click();
		}
		else{}
		return new Test_Player();
	}
}
