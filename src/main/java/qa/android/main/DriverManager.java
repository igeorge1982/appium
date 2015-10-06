package main.java.qa.android.main;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import main.java.qa.android.page.PageAnnotations;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

public class DriverManager extends TestBase implements Constants {

	public static AndroidDriver driver = null;
	private static String app = null;
	private static String device = null;
	public static PageAnnotations uiElements = new PageAnnotations();
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	public DriverManager() {
		
	}
	
	public static AndroidDriver startDriver(String app, String device, int timeout) throws Exception
	
	{
		//get devices per a parameter from deviceConf
		List<String> deviceList = new ArrayList<String>(devices.values());
		
		for (String device_ : deviceList) {
			Log.info(device_);
		}
		
		Log.info("Nr 1 attached device: "+devices.get("deviceName"+deviceCount) +", "+ characteristics());
		Log.info("Nr of attached devices: "+deviceCount);
		
		DriverManager.device = device;
		DriverManager.app = app;
		DOMConfigurator.configure(log4jxml);
		Log.info(Platform.getCurrent());

		if (device.equalsIgnoreCase("device")) {
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", devices.get("deviceName"+1));
		capabilities.setCapability("platformVersion", devices.get("osVersion"+1));
	    capabilities.setCapability(MobileCapabilityType.SUPPORTS_NETWORK_CONNECTION, "true");
	    capabilities.setCapability(MobileCapabilityType.APP, app);

		String userDir = System.getProperty("user.dir");

		URL serverAddress;
		String localApp = app;

		String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
		
		capabilities.setCapability("app", appPath);
		serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver(serverAddress, capabilities);

		//driver = driverEventListener();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		TestBase.init(driver, serverAddress);
		PageFactory.initElements(new AppiumFieldDecorator(driver), uiElements);
		 
		    
		} 
		return driver;
	}
	/*
	private static WebDriver driverEventListener() {

		EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(
				driver);
		EventListener eventListener = new EventListener(driver);
		eventFiringDriver.register(eventListener);

		return driver = new EventFiringWebDriver(eventFiringDriver);
	}
	*/
	
	public static void stopDriver() {
		if (driver != null)
		{
			driver.closeApp();
			driver.quit();
		}
	}
	
	public static WebDriver getDriverInstance() {
		return driver;
	}
	
	public static String getApp() {
		return app;
	}
	
	public static String getDevice() {
		return device;
	}
	
}
	
