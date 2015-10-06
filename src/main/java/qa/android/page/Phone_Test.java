package main.java.qa.android.page;

import java.util.List;

import main.java.qa.android.main.TestBase;
import main.java.qa.android.page.HomePage;
import main.java.qa.android.util.Helpers;
import main.java.qa.android.util.PropertyUtils;
import main.java.qa.android.util.WaitTool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Phone_Test extends TestBase{

	public static void selectMenu(int value)
	{
		String text = HomePage.menuList().get(value-1).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.LinearLayout")).findElement(By.className("android.widget.TextView")).getText();
		HomePage.close();
		HomePage.menuList().get(value-1).click();
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
	
}
