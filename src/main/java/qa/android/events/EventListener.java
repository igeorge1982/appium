package main.java.qa.android.events;


import main.java.qa.android.main.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class EventListener extends TestBase implements AbstractWebDriverEventListener {

	public EventListener(WebDriver driver){
		super(driver); 
	}
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());


	   
//////////NAVIGATION RELATED METHODS ////////////////
@Override
public void beforeNavigateTo(String url, WebDriver driver) {
System.out.println("Before Navigate To "+url);

}

@Override
public void afterNavigateTo(String url, WebDriver driver) {
// TODO Auto-generated method stub

}

@Override
public void beforeNavigateBack(WebDriver driver) {
System.out.println("Before Navigate Back. Right now I'm at "+driver.getCurrentUrl());

}

@Override
public void afterNavigateBack(WebDriver driver) {
// TODO Auto-generated method stub

}

@Override
public void beforeNavigateForward(WebDriver driver) {
// TODO Auto-generated method stub

}

@Override
public void afterNavigateForward(WebDriver driver) {
// TODO Auto-generated method stub

}

/////////////////// FINDBY RELATED METHODS ///////////////
@Override
public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	Log.info("Hello World!");

}

@Override
public void afterFindBy(By by, WebElement element, WebDriver driver) {
	Log.info("Hello World 2!");

}

////////////////////CLICKON RELATED METHODS ///////////////
@Override
public void beforeClickOn(WebElement element, WebDriver driver) {

}

@Override
public void afterClickOn(WebElement element, WebDriver driver) {
	Reporter.log("Clicked on:"+element.toString());
	Log.info("Element clicked on:"+element);
}

@Override
public void afterClickedOn(By by, WebElement element, WebDriver driver) {

}


///////////////// CHANGE OF VALUE RELATED METHODS //////////////
@Override
public void beforeChangeValueOf(WebElement element, WebDriver driver) {
// TODO Auto-generated method stub

}

@Override
public void afterChangeValueOf(WebElement element, WebDriver driver) {
// TODO Auto-generated method stub

}

/////////////// SCRIPT EXECUTION RELATED METHODS ///////////////
@Override
public void beforeScript(String script, WebDriver driver) {
// TODO Auto-generated method stub

}

@Override
public void afterScript(String script, WebDriver driver) {

}

/////////////// EXCEPTION RELATED METHODS ///////////////////////
@Override
public void onException(Throwable throwable, WebDriver driver) {
	}

}



