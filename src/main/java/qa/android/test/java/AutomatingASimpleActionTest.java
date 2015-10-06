package main.java.qa.android.test.java;

import reporter.JyperionListener;

import java.util.List;

import main.java.qa.android.main.*;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.page.Tablet_Test;
import main.java.qa.android.page.Test_Parental;
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

public class AutomatingASimpleActionTest extends AppiumTest   {
	
	@Test
	public void TabletNavigationTest()  throws Exception
	{
		//										----------		HomePage		----------
		
		HomePage.loaded();

/*
		//HomePage.swipeOfferstCategory();

		//							Sign in test
		HomePage.signIn();
		HomePage.signinOpenOperatorsList();
		HomePage.signinSelectOperator();
		HomePage.signinSelectAnotherProvider();
		HomePage.closeAnotherProvider();
		HomePage.closeSignIn();
		//HomePage.registrateVoucher("VOUCHER_CODE");

		Tablet_Test.signIn();
		Helpers.elementByUISelector("txtEnterVoucher").click();
		WebElement registrate = Helpers.elementByUISelector("etVoucher");
		registrate.sendKeys("VOUCHER_CODE");
		Helpers.elementByUISelector("vgGoBack").click();
		System.out.println("");
		HomePage.closeSignIn();
		
		Tablet_Test.selectMenu3();
		Tablet_Test.selectSerie();
		Tablet_Test.selectSeasonLine(0);
		
		HomePage.closeDetailPage();
		Tablet_Test.selectMenu1();
		

		//driver.lockScreen(3);
		//driver.runAppInBackground(3);
	
		//							Settings selection

		//Tablet_Test.selectHelpRow();

		HomePage.openMenu();
		List<WebElement> rows = driver.findElements(By.className("android.widget.TableRow"));
		WebElement help = rows.get(rows.size()-3);
		help.click();
		System.out.println("Help is selected");
		//HomePage.closeSettings();
		Tablet_Test.selectMenu1();
		
		Tablet_Test.selectSignOutRow();
		//Tablet_Test.selectSettingsRow();
		

		HomePage.openMenu();
		HomePage.swipeUp();
		List<WebElement> rowsS = driver.findElements(By.className("android.widget.TableRow"));
		WebElement settings = rowsS.get(rowsS.size()-2);
		settings.click();
		Tablet_Test.settingsLoaded();
		Tablet_Test.closeSettings();
		Tablet_Test.selectMenu1();

		Tablet_Test.navigateSettingsDevices();
		Tablet_Test.navigateSettingsFAQ();
		



		//							Search test
		HomePage.searchPress();
		HomePage.searchFor(PropertyUtils.getProperty("searchFor"));
		HomePage.getSearchResoult();	
		HomePage.clearSearch();
		HomePage.closeSearch();
		
		// https://mediaux.atlassian.net/browse/HBOGOLATAM-545
		//DriverManager.driver.navigate().back();
		

	

		
		//										----------		TABLET		----------

		//							Splashscreen test
		
		HomePage.swipeLeft();
		HomePage.radioButtonCheck();
		

		
		
		//Press all button
		HomePage.addToFavorit();
		HomePage.playContent();
		HomePage.removeFavorit();
		System.out.println(driver.manage().window().getSize());

		//							Menu row selecting Test
		Tablet_Test.selectAllMenuRow();
		


		
		
		//							DetailPage test
		HomePage.openDetailPage();
		//
		HomePage.playContent();
		//Tablet_Test.playTrailer();
		HomePage.addToFavorit();
		Tablet_Test.sharePress();
		HomePage.removeFavorit();
		
		//							Get Content Title, Category, Age Rating
		Helpers.getContentDetails();
		HomePage.closeDetailPage();
		
		
		//							Sort selecting
		Tablet_Test.sortFeatured(2);
		Tablet_Test.sortAToZ(6);	
			
		//-----------------------             Tablet Categories Selection from Menu

		
		/*
		Tablet_Test.selectMenu2();//Without
		Tablet_Test.selectMenu1();//Offers
		Tablet_Test.selectMenu3();//Series
		Tablet_Test.selectMenu4();//Movies
		Tablet_Test.selectMenu5();//Recently Added
		Tablet_Test.selectMenu6();//WeeklyTop
		Tablet_Test.selectMenu7();//Last Chance
		Tablet_Test.selectMenu8();//Recently Played
		Tablet_Test.selectMenu9();//IMDb || Upcoming
		//Tablet_Test.selectMenu10();//Upcoming
		*/
		 

		//										----------		MOBILE		----------
		
		//
		//Phone_Test.menuListElements();
		//Phone_Test.selectAllPhone();		//Mobile Categories Selection

	}
}