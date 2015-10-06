package main.java.qa.android.page;

import static main.java.qa.android.util.Helpers.find;
import android.widget.RadioGroup;

import java.util.List;
import java.util.concurrent.TimeUnit;

import main.java.qa.android.main.DriverManager;
import main.java.qa.android.main.TestBase;
import main.java.qa.android.util.Helpers;
import main.java.qa.android.util.WaitTool;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

/** Page object for the home page **/

public abstract class HomePage extends TestBase {
	
    /** Verify the home page has loaded.
     *  Click the accessibility button.
     *  Verify the accessibility page has loaded. **/ 
	public static void accessibilityClick() {
        
		loaded();
        WaitTool.waitForElementPresent(driver, MobileBy.AccessibilityId("Accessibility"), 3);        
        find("Accessibility").click();
        AccessibilityPage.loaded();
    }
	public static List<WebElement> menuList()
	{
		openMenu();
		List<WebElement> menuList = driver.findElements(By.className("android.widget.TableRow"));
		return menuList;
	}
	public abstract void onCheckedChanged (RadioGroup group, int checkedId);	  
	
	public static void radioButtonCheck()
	{
		int selected=0;
		List<WebElement> rg = driver.findElementsByClassName("android.widget.RadioButton");
		for(int i=0;i<7;i++)
		{
			String radioBchecked =  rg.get(i).getAttribute("checked");
			if(radioBchecked.equals("true"))
			{
				selected=i+1;
				System.out.println("You are at the "+selected+". slide");
			}
		}
	}
	
	public static void swipeOfferstCategory()
	{
		Tablet_Test.selectMenu2();
		if(Tablet_Test.selectedRow!=0)
		{
			Tablet_Test.selectMenu1();
		}
		HomePage.swipeDown();
	}
	
	public static void signIn() 
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_SignIn"), 2);
		Helpers.elementByUISelector("btn_Header_SignIn").click();
		System.out.println("SignIn is selected");
	}
	
	public static void signinOpenOperatorsList()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("spinCountry"), 2);
		Helpers.elementByUISelector("spinCountry").click();
		System.out.println("Country List Open");
	}
	
	public static void signinSelectOperator()
	{
		//Helpers.elementByUISelector("select_dialog_listview");
		List<WebElement> countries = driver.findElementsByClassName("android.widget.TextView");
		countries.get(2).click();
		System.out.println("Country is selected");
	}
	
	public static void signinSelectAnotherProvider()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("txtSelectAnotherProvider"), 2);
		Helpers.elementByUISelector("txtSelectAnotherProvider").click();
		System.out.println("Another providers");
	}

	public static void signinLoginWebSelector()
	{
		Tablet_Test.signIn();
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Login_Selector_Web"), 1);
		Helpers.elementByUISelector("btn_Login_Selector_Web").click();
		driver.navigate().back();
	}
	
	public static void signinExistUserLogin()
	{
		Tablet_Test.signIn();
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Login_Selector_Login"), 1);
		Helpers.elementByUISelector("btn_Login_Selector_Login").click();
		WebElement email = Helpers.elementByUISelector("etEmailAddress");
		email.sendKeys("test@te.st");
		System.out.println("E-mail added");
		
		WebElement password = Helpers.elementByUISelector("etPassword");
		password.sendKeys("Tester");
		System.out.println("Password added");
		
		Helpers.elementByUISelector("txtSignIn").click();
		System.out.println("Login pressed");
		
		Helpers.elementByUISelector("vgGoBack").click();
		System.out.println("Navigate back");
		
		Tablet_Test.closeSignIn();
	}
	
	public static void openMenu()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Menu"), 2);
		Helpers.elementByUISelector("btn_Header_Menu").click();
		System.out.println("OpenMenu");
		HomePage.swipeDown();
	}
	
	public static void openDetailPage()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Offers_OpenContentPage"), 2);
		Helpers.elementByUISelector("btn_Offers_OpenContentPage").click();
		System.out.println("Open Detail Page");
	}

	public static void addToFavorit() 
	{
		Helpers.elementByUISelector("btn_AddToWatchlist").click();
		System.out.println("Add to Favorit");
	}

	public static void removeFavorit() 
	{
		Helpers.elementByUISelector("btn_RemoveFromWatchlist").click();
		System.out.println("Remove from Favorit");
	}
	
	public static void searchPress()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Search"), 1);
		Helpers.elementByUISelector("btn_Header_Search").click();
		System.out.println("Open Search");
	}
	
	public static void searchFor(String searchFor)
	{
		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		WebElement search = textFieldsList.get(0);       
		search.sendKeys(searchFor);
		System.out.println("Searched for : " + searchFor);
	}
	
	public static void getSearchResoult()
	{
		List<WebElement> searchResoult = driver.findElementsByClassName("android.widget.TextView");
		String resoult=searchResoult.get(0).getText();
		System.out.println("Founded contents : "+resoult);
		System.out.println();
	}

	public static void clearSearch()
	{
		Helpers.elementByUISelector("btn_Search_Clear").click();
		System.out.println("Clear Search field");		
	}
	
	public static void closeDetailPage()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Header_Back"), 1);
    	Helpers.elementByUISelector("btn_Header_Back").click();
		System.out.println("Close Detail Page");
		loaded();
	}

	public static void close()
	{	
		Helpers.wait(By.className("android.widget.ImageView"));
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btnClose"), 1);
    	Helpers.elementByUISelector("btnClose").click();
		System.out.println("CloseMenu");
	}

	public static void closePopup()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_negative"), 1);
		Helpers.elementByUISelector("btn_negative").click();
		System.out.println("Close Popup");
	}
	
	public static void closeSearch()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Search_Close"), 1);
		Helpers.elementByUISelector("btn_Search_Close").click();
		System.out.println("Close Search page");
	}

	public static void closeSettings()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Settings_Close"), 1);
		Helpers.elementByUISelector("btn_Settings_Close").click();
		System.out.println("Close Settings page");
	}
	
	public static void closeSignIn()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_Settings_Close"), 1);
		Helpers.elementByUISelector("btn_Settings_Close").click();
		System.out.println("SignIn page closed");
		Helpers.elementByUISelector("btn_Header_Menu");
	}
	
	public static void closeAnotherProvider()
	{
		Helpers.elementByUISelector("vgGoBack").click();
		System.out.println("Another provider page closed");
	}
	
	public static void registrateVoucher(String voucher)
	{
		Tablet_Test.signIn();
		HomePage.swipeUp();
		Helpers.elementByUISelector("btn_Login_Selector_Voucher").click();
		WebElement registrate = Helpers.elementByUISelector("etVoucher");
		registrate.sendKeys(voucher);
		driver.tap(1, 200, 200, 1);
		Helpers.elementByUISelector("vgGoBack").click();
		System.out.println("");
	}
	
	public static void sharePress()
	{
		Helpers.elementByUISelector("btn_Share").click();
		System.out.println("Share Content");
	}

	public static void playContent()
	{
		Helpers.elementByUISelector("btn_PlayNow").click();
		System.out.println("Play Content");
	}

	public static void playTrailer()
	{
		WaitTool.waitForElementDriverWebElementSecond(driver, Helpers.elementByUISelector("btn_PlayTrailer"), 4);
		Helpers.elementByUISelector("btn_PlayTrailer").click();
		System.out.println("Play Trailer");	
	}
	
	public static void swipeLeft()
	{
		  Dimension size = driver.manage().window().getSize();
		  Log.info("Dimension of screen is : "+size.toString());
		  int startx = (int) (size.width * 0.8);
		  Log.info("Start of X: "+Integer.toString(startx));
		  int endx = (int) (size.width * 0.2);
		  Log.info("End of X: "+Integer.toString(endx));
		  int starty = size.height / 2;
		  Log.info("Position of Y: "+Integer.toString(starty));
		  driver.swipe(startx, starty, endx, starty, 1000);
			System.out.println("Swipe Left");
	}
	public static void swipeRight()
	{
		  Dimension size = driver.manage().window().getSize();
		  Log.info("Dimension of screen is : "+size.toString());
		  int startx = (int) (size.width * 0.2);
		  Log.info("Start of X: "+Integer.toString(startx));
		  int endx = (int) (size.width * 0.8);
		  Log.info("End of X: "+Integer.toString(endx));
		  int starty = size.height / 2;
		  Log.info("Position of Y: "+Integer.toString(starty));
		  driver.swipe(startx, starty, endx, starty, 1000);
			System.out.println("Swipe Right");
	}
	public static void swipeUp()
	{
		driver.swipe(200, 900, 200, 400, 0);
	}
	public static void swipeDown()
	{
		driver.swipe(250, 400, 250, 900, 0);
	}

    /** Verify the home page has loaded **/
    public static void loaded()
    {
    	//Helpers.elementByUISelector("ivXfinityLogo");
    	//find("CINE");
    	Helpers.elementByUISelector("header");
        System.out.println("Screen Loaded");
        
    }
    public static void settingsLoaded()
    {
    	Helpers.wait(By.className("android.widget.HorizontalScrollView"));
		System.out.println("Settings Loaded");  	
    }
    public static void menuLoaded()
    {
    	Helpers.elementByUISelector("menuList");
		List<WebElement> menuList= null;
    	do
    	{
    		menuList = driver.findElements(By.className("android.widget.TableRow"));
    	}while(menuList.size()<4);
		System.out.println("Menu Loaded");
    	
    }
    
	public static void animationClick() {
        loaded();
        find("Animation").click();
        AnimationPage.loaded();
    }
	
	public static void swipeUpMenu(AppiumDriver driver, MobileElement element, int duration){
    int topY = element.getLocation().getY();
    int bottomY = topY + element.getSize().getHeight();
    int centerX = element.getLocation().getX() + (element.getSize().getWidth()/2);
    driver.swipe(centerX, bottomY, centerX, topY, duration);
}


}