package main.java.qa.android.test.java;

import java.util.List;

import main.java.qa.android.main.CaptureScreenshotOnFailureListener;
import main.java.qa.android.main.DriverManager;
import main.java.qa.android.main.TestBase;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.page.Tablet_Test;
import main.java.qa.android.page.Test_OffersScreen;
import main.java.qa.android.page.Test_DetailPage;
import main.java.qa.android.page.Test_Settings;
import main.java.qa.android.page.Test_Registration;
import main.java.qa.android.page.Test_SignIn;
import main.java.qa.android.page.Test_Login;
import main.java.qa.android.page.Test_Menu;
import main.java.qa.android.page.Test_Search;
import main.java.qa.android.page.Test_Sort;
import main.java.qa.android.page.Test_Serie;
import main.java.qa.android.page.Test_Parental;
import main.java.qa.android.page.Test_DeviceManager;
import main.java.qa.android.page.Test_FAQ;
import main.java.qa.android.page.Test_Player;
import main.java.qa.android.testng.LoggingListener;
import main.java.qa.android.testng.PdfListener;
import main.java.qa.android.testng.TestListeners;
import main.java.qa.android.testng.TestMethodListener;
import main.java.qa.android.util.Helpers;
import main.java.qa.android.util.PropertyUtils;
import main.java.qa.android.util.WaitTool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import reporter.JyperionListener;

@Listeners ({ PdfListener.class,TestListeners.class,CaptureScreenshotOnFailureListener.class,	TestMethodListener.class, LoggingListener.class,  })
public class Test_BasicNavigation extends TestBase {

	@Test
	public static void Test_OffersScreen() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Offers Screen test");
		System.out.println();
		System.out.println();
		
		Test_OffersScreen offers = new Test_OffersScreen();
		offers.OffersTest();

		System.out.println();
		System.out.println("//////////////////////////// Offers Screen Test finished");
		System.out.println();
		
		
	}
	
	@Test
	public static void Test_Settings() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Settings test");
		System.out.println();
		System.out.println();
	
		Test_Settings settingS = new Test_Settings();
		settingS.SettingsTest();

		System.out.println();
		System.out.println("//////////////////////////// Settings Test finished");
		System.out.println();
		System.out.println();
	}

	@Test
	public static void Test_DetailPage() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Detail page test");
		System.out.println();
		System.out.println();
		
		Test_DetailPage detail = new Test_DetailPage();
		detail.DetailTest();

		System.out.println();
		System.out.println("//////////////////////////// Detail Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_Menu() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Menu test");
		System.out.println();
		System.out.println();
		
		Test_Menu menu = new Test_Menu();
		menu.MenuTest();

		System.out.println();
		System.out.println("//////////////////////////// Menu Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_Registration() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Registration test");
		System.out.println();
		System.out.println();
	
		Test_Registration regist = new Test_Registration();
		regist.Test_Registration();

		System.out.println();
		System.out.println("//////////////////////////// Registration Test finished");
		System.out.println();
		System.out.println();
	}

	@Test
	public static void Test_SignIn() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// SingIn test");
		System.out.println();
		System.out.println();
	
		Test_SignIn signin = new Test_SignIn();
		signin.Test_SignIn();

		System.out.println();
		System.out.println("//////////////////////////// SignIn Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_Login() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// LogIn test");
		System.out.println();
		System.out.println();
	
		System.out.println("Exist user login test");
		Test_Login login = new Test_Login();
		login.Test_Login();

		System.out.println();
		System.out.println("//////////////////////////// Login Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_Search() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Search test");
		System.out.println();
		System.out.println();

		HomePage.loaded();
		
		String deviceType = DriverManager.characteristics();
		String[] parts = deviceType.split(",");
		String part1 = parts[0];
		if(part1=="tablet")
		{
			try
			{
				Tablet_Test.close();
				Tablet_Test.selectMenu1();
			}
			catch(Exception e){}
		
			System.out.println("Search test");
			Test_Search search = new Test_Search();
			search.Test_Search();
			
		}
		
		System.out.println();
		System.out.println("//////////////////////////// Search Test finished");
		System.out.println();
		System.out.println();
	}

	@Test
	public static void Test_Sort() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Sort test");
		System.out.println();
		System.out.println();

		Test_Sort sort = new Test_Sort();
		sort.Test_Sort();
		
		System.out.println();
		System.out.println("//////////////////////////// Sort Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_Serie() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Serie test");
		System.out.println();
		System.out.println();
		
		Test_Serie serie = new Test_Serie();
		serie.Test_Serie();
		
		System.out.println();
		System.out.println("//////////////////////////// Serie Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test              
	public static void Test_Parental() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Parental Control test");
		System.out.println();
		System.out.println();
		
		Test_Parental parental = new Test_Parental();
		parental.Test_Parental();
				
		System.out.println();
		System.out.println("//////////////////////////// Parental Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_DeviceManager() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Device Manager test");
		System.out.println();
		System.out.println();
	
		Test_DeviceManager deviceManager = new Test_DeviceManager();
		deviceManager.Test_DeviceManager();
		
		System.out.println();
		System.out.println("//////////////////////////// Device Manager Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_FAQ() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Frequently Asked Questions test");
		System.out.println();
		System.out.println();
		
		Test_FAQ faq = new Test_FAQ();
		faq.Test_FAQ();
		
		System.out.println();
		System.out.println("//////////////////////////// FAQ Test finished");
		System.out.println();
		System.out.println();
	}
	
	@Test
	public static void Test_Player() throws Exception
	{
		System.out.println();
		System.out.println("//////////////////////////// Player test");
		System.out.println();
		System.out.println();
		
		Test_Player player = new Test_Player();
		player.test_Player();
		
		System.out.println();
		System.out.println("//////////////////////////// Player test finished");
		System.out.println();
		System.out.println();
	}
}
