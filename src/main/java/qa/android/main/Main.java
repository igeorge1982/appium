package main.java.qa.android.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;


public class Main extends TestBase {

	public static void main(String[] args) throws FileNotFoundException  {
		
        ClassLoader test_cl = Main.class.getClassLoader();
        System.out.println(test_cl+"\n");

		List<String> suites = new ArrayList<String>();

		suites.add(testngXml);

		TestNG tng = new TestNG();
		tng.setTestSuites(suites);
		tng.run();
		System.out.println("TestNG has been initialized");


	}

}
