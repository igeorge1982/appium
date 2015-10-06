package main.java.qa.android.page;

import java.util.List;

import main.java.qa.android.main.DriverManager;
import main.java.qa.android.util.Helpers;
import main.java.qa.android.util.PropertyUtils;
import main.java.qa.android.util.WaitTool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xmlpull.v1.sax2.Driver;

public abstract class Tablet_Test extends HomePage{


	public static void selectMenu1()	//Offers
	{
		String one = Tablet_Test.menuList().get(0).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		HomePage.swipeDown();
		HomePage.close();
		Tablet_Test.menuList().get(0).click();
		Tablet_Test.setSelectedMenuRow(1);
		System.out.println(one + " has been selected");
	}
	
	public static void selectMenu2()	//WithoutRegistration
	{
		String two = menuList().get(1).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		HomePage.close();
		menuList().get(1).click();
		setSelectedMenuRow(2);
		System.out.println(two + " has been selected");
	}
	
	public static void selectMenu3()	//Series
	{
		String two = menuList().get(2).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		HomePage.close();
		menuList().get(2).click();
		setSelectedMenuRow(3);
		System.out.println(two + " has been selected");
	}
	
	public static void selectMenu4()	//Movies
	{
		String four = menuList().get(3).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		HomePage.close();
		menuList().get(3).click();
		setSelectedMenuRow(4);
		closePopup();
		System.out.println(four + "M has been selected");
	}
	public static void selectMenu5()	//RecentlyAdded
	{
		String five = menuList().get(4).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		menuList().get(4).click();
		setSelectedMenuRow(5);
		System.out.println(five + " has been selected");
	}
	public static void selectMenu6()	//WeeklyTop
	{
		String six = menuList().get(5).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		menuList().get(5).click();
		setSelectedMenuRow(6);
		System.out.println(six + " has been selected");
	}
	public static void selectMenu7()	//LastChance
	{
		String seven =menuList().get(6).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		menuList().get(6).click();
		setSelectedMenuRow(7);
		System.out.println(seven + " has been selected");
	}
	
	public static void selectMenu8()	//RecentlyPlayed
	{
		String eight = menuList().get(7).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		menuList().get(7).click();
		setSelectedMenuRow(8);
		System.out.println(eight + " has been selected");
	}
	
	public static void selectMenu9()	//IMDb
	{
		String nine = menuList().get(8).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		menuList().get(8).click();
		setSelectedMenuRow(9);
		System.out.println(nine + " has been selected");
	}

	public static void selectMenu10()	//Upcoming
	{
		String ten;
		ten= menuList().get(9).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		menuList().get(9).click();
		setSelectedMenuRow(10);
		System.out.println(ten + " has been selected");
	}

	public static void selectMenu(int value)
	{
		String text = menuList().get(value-1).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		HomePage.close();
		menuList().get(value-1).click();
		setSelectedMenuRow(value);
		System.out.println(text + " has been selected");
	}
	
	public static int selectedRow=0;

	public static void setSelectedMenuRow(int value)
	{
		selectedRow = value;
	}

	public static void sortFeatured(int value)
	{
		if(Tablet_Test.selectedRow==value)
		{
			Tablet_Test.selectMenu1();
			}
		else
		{
			}
		Tablet_Test.selectMenu(value);
		List<WebElement> sort = driver.findElements(By.className("android.widget.HorizontalScrollView"));
		System.out.println(sort.get(0).isSelected());
		if(sort.get(0).isSelected()==false)
		{
			sort.get(0).click();
			}
		System.out.println("Featured sort selected");
	}

	public static void sortAToZ(int value)
	{
		int i=0;
		if(Tablet_Test.selectedRow==value)
		{
			Tablet_Test.selectMenu1();
		}
		else
		{
		}
		Tablet_Test.selectMenu(value);
		WebElement holder = Helpers.elementByUISelector("llAlphabetHolder");
		List<WebElement> sort = holder.findElements(By.className("android.widget.TextView"));
		String allowed;
		do
		{
			allowed = sort.get(i).getAttribute("clickable");
			if(allowed.equals("true"))
			{
				sort.get(i).click();
				System.out.println(sort.get(i).getText() + " contains Contents");
			}
			i++;
		}while(i!=sort.size());
	}

	
	public static void selectAllMenuRow() 
	{
		HomePage.openMenu();
		HomePage.close();
		int i, j;
		HomePage.close();
		WebElement actualRow;
		String rowText;
		for(i=0;i!=9;i++)
		{
			j=i+1;
			actualRow = HomePage.menuList().get(i);
			rowText = actualRow.findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
			actualRow.click();
			System.out.println("MenuRow " + j + " : " + rowText + " has been selected");
			if(i==3)
			{
				HomePage.closePopup();
			}
			Tablet_Test.setSelectedMenuRow(i);
		}
	}

	public static void navigateOnDetailPage()
	{
		Tablet_Test.selectMenu1();
		
		HomePage.openDetailPage();
		
		HomePage.playContent();
		//Tablet_Test.playTrailer();
		HomePage.addToFavorit();
		Tablet_Test.sharePress();
		HomePage.removeFavorit();
		Helpers.getContentDetails();
		HomePage.closeDetailPage();
	}
	
	public static void selectHelpRow()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Menu"), 2);
		Helpers.elementByUISelector("btn_Header_Menu").click();
		HomePage.swipeUp();
		List<WebElement> rows = driver.findElements(By.className("android.widget.TableRow"));
		WebElement help = rows.get(rows.size()-2);
		help.click();
		System.out.println("Help is selected");
		HomePage.close();
	}
	
	public static void selectSettingsRow()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Menu"), 2);
		Helpers.elementByUISelector("btn_Header_Menu").click();
		HomePage.swipeUp();
		List<WebElement> rows = driver.findElements(By.className("android.widget.TableRow"));
		WebElement settings = rows.get(rows.size()-2);
		settings.click();
		Tablet_Test.settingsLoaded();
		Tablet_Test.close();
	}
	
	public static void navigateSettingsParental()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Menu"), 2);
		Helpers.elementByUISelector("btn_Header_Menu").click();
		HomePage.swipeUp();
		List<WebElement> rows = driver.findElements(By.className("android.widget.TableRow"));
		WebElement settings = rows.get(rows.size()-2);
		WaitTool.waitForElementDriverWebElementSecond(driver, settings, 2);
		settings.click();
		
		WebElement pageIndicator = Helpers.elementByUISelector("tpi_Pager_Indicator");
		List<WebElement> subGroup = pageIndicator.findElements(By.className("android.widget.TextView"));
		subGroup.get(1).click();
		System.out.println(subGroup.get(0).getText() + " selected");
		
		WebElement email = Helpers.elementByUISelector("et_ParentalControl_email");
		email.sendKeys("test@te.st");
		driver.tap(1, 200, 200, 1);
		System.out.println("Email address added");
		
		WebElement emailConfirm = Helpers.elementByUISelector("et_ParentalControl_email_confirmation");
		emailConfirm.sendKeys("test@te.st");
		driver.tap(1, 200, 200, 1);
		System.out.println("Confirm Email address added");
		
		WebElement password = Helpers.elementByUISelector("et_ParentalControl_pin");
		password.sendKeys("Tester");
		driver.tap(1, 200, 200, 1);
		
		System.out.println("Password added");
		WebElement passwordConfirm = Helpers.elementByUISelector("et_ParentalControl_pin_confirmation");
		passwordConfirm.sendKeys("Tester");
		driver.tap(1, 200, 200, 1);
		System.out.println("Confirm Password added");
		
		
		Helpers.elementByUISelector("btn_ParentalControl_Save").click();
		System.out.println("Parental control Save pressed");

		
		Tablet_Test.close();

	}
	
	public static void navigateSettingsDevices()
	{
		// Open Settings
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Menu"), 2);
		Helpers.elementByUISelector("btn_Header_Menu").click();
		HomePage.swipeUp();
		List<WebElement> rowsS = driver.findElements(By.className("android.widget.TableRow"));
		WebElement settings = rowsS.get(rowsS.size()-2);
		WaitTool.waitForElementDriverWebElementSecond(driver, settings, 1);
		settings.click();
		Tablet_Test.settingsLoaded();
		
		// Select Device Manager Page
		WebElement pageIndicator = driver.findElementByClassName("android.widget.HorizontalScrollView");
		List<WebElement> subGroup = pageIndicator.findElements(By.className("android.widget.TextView"));
		subGroup.get(2).click();
		System.out.println(subGroup.get(1).getText() + " selected");
		
		// Press Device Edit
		WebElement edit = Helpers.elementByUISelector("btn_Settings_DeviceManagement_Edit");
		edit.click();
		
		// Set new Device Name
		WebElement device1 = Helpers.elementByUISelector("et_Settings_DeviceManagement_Name");
		String deviceName = device1.getText();		// Get Current DeviceName
		device1.sendKeys("");						// Delete current name
		
		System.out.println("Selected device name = " + deviceName);
		device1.sendKeys("Edited name");			// Set new DeviceName
		driver.tap(1, 200, 200, 1);
		/*
		WebElement statusChange = Helpers.elementByUISelector("sw_Settings_DeviceManagement_Status");
		statusChange.click();
		System.out.println("Device status changed to : " + statusChange.getAttribute("checked"));
		statusChange.click();
		System.out.println("Device status changed to : " + statusChange.getAttribute("checked"));
		*/
		
		Helpers.elementByUISelector("btn_Settings_DeviceManagement_Confirm").click();
		System.out.println("Done pressed");
		
		Tablet_Test.close();
	}
	
	public static void navigateSettingsFAQ()
	{
		// Open Settings from menu
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Menu"), 2);
		WebElement menu = Helpers.elementByUISelector("btn_Header_Menu");
		menu.click();
		driver.scrollTo("Sign out");
		List<WebElement> rowsS = driver.findElements(By.className("android.widget.TableRow"));
		WebElement settings = rowsS.get(rowsS.size()-2);
		settings.click();
		Tablet_Test.settingsLoaded();

		// Select FAQ from settings Layout
		WebElement pageIndicator = driver.findElementByClassName("android.widget.HorizontalScrollView");
		List<WebElement> subGroup = pageIndicator.findElements(By.className("android.widget.TextView"));
		subGroup.get(3).click();
		System.out.println(subGroup.get(2).getText() + " selected");

		// Open FAQQuestions
		WebElement expendableGroup = Helpers.elementByUISelector("elv_Settings_FAQ_Questions");
		List<WebElement> expendableFAQ = expendableGroup.findElements(By.className("android.widget.TextView"));
		expendableFAQ.get(0).click();
		System.out.println(expendableFAQ.get(1).getText() + " is selected");
		expendableFAQ.get(0).click();
		System.out.println(expendableFAQ.get(1).getText() + " is closed");
		expendableFAQ.get(1).click();
		System.out.println(expendableFAQ.get(1).getText() + " is selected");
		expendableFAQ.get(1).click();
		System.out.println(expendableFAQ.get(1).getText() + " is closed");
		
		// Search in FAQ
		WebElement searchFAQ = Helpers.elementByUISelector("et_Settings_FAQ_Search");
		searchFAQ.click();
		HomePage.searchFor(PropertyUtils.getProperty("searchFor"));
		driver.tap(1, 250, 250, 1);
		HomePage.close();
	}
	
	public static void selectSignOutRow()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Menu"), 2);
		Helpers.elementByUISelector("btn_Header_Menu").click();
		HomePage.swipeUp();
		List<WebElement> rowsSO = driver.findElements(By.className("android.widget.TableRow"));
		WebElement signOut = rowsSO.get(rowsSO.size()-1);
		signOut.click();
		System.out.println("SignOut is selected");
	}
	
	public static void selectSerie()
	{
		WebElement serieContainer = driver.findElement(By.className("android.support.v7.widget.RecyclerView"));
		List<WebElement> series = serieContainer.findElements(By.className("android.widget.LinearLayout"));
		series.get(1).click();
	}
	
	public static void selectSeasonLine(int value)
	{
		Helpers.elementByUISelector("vg_Spinner_Placeholder").click();
		List<WebElement> seasons = driver.findElements(By.className("android.widget.LinearLayout"));
		seasons.get(value).click();
		Tablet_Test.closePopup();
	}
		

/*	public static void splashScreenFirstSwipe()
	{
		
		driver.swipe(150, 1330, 150, 0, 0);
	}
	
	public static void splashScreenSwipeDown()
	{
		driver.swipe(starty, endx, endy, duration);
	}
	
	public static void splashScreenSwipeDown()
	{
		driver.swipe(startx, starty, endx, endy, duration);
	}
	
	public static void splashScreenSwipeUp()
	{
		driver.swipe(startx, starty, endx, endy, duration);
	}
	
	public static void splashScreenSwipeUp()
	{
		driver.swipe(startx, starty, endx, endy, duration);
	}
*/
	
}
