package main.java.qa.android.testng;


import main.java.qa.android.main.TestBase;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListeners extends TestBase implements ITestListener, ISuiteListener, IInvokedMethodListener {
	

	// This belongs to ISuiteListener and will execute before the Suite start

	@Override

	public void onStart(ISuite arg0) {

		System.out.println("About to begin executing Suite " + arg0.getName());


	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished

	@Override

	public void onFinish(ISuite arg0) {

		System.out.println("About to end executing Suite " + arg0.getName());

	}

	// This belongs to ITestListener and will execute before starting of Test set/batch 

	public void onStart(ITestContext arg0) {

		System.out.println("About to begin executing Test " + arg0.getName());

	}

	// This belongs to ITestListener and will execute, once the Test set/batch is finished

	public void onFinish(ITestContext arg0) {

		Reporter.log("Completed executing test " + arg0.getName(), true);
		Log.info("Completed executing test " + arg0.getName());


	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method

		printTestResults(arg0);
		Reporter.log(arg0.getName()+" test succeeded!", true);
		Log.info(arg0.getName()+" test succeeded!");

	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult arg0) {

		// This is calling the printTestResults method
		/*driver.resetApp();
		Log.info("App was reset!");
		System.out.println("App was reset!");*/
		printTestResults(arg0);
		Reporter.log(arg0.getName()+" test failed!", true);
		Log.info(arg0.getName()+" test failed!");
		


	}

	// This belongs to ITestListener and will execute before the main test start (@Test)

	public void onTestStart(ITestResult arg0) {

		System.out.println("The execution of the main test starts now");
		Log.info("The execution of "+arg0.getName()+" starts now");

	}

	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {

		printTestResults(arg0);
		Log.info(arg0.getName()+" was skipped!");


	}

	// This is just a piece of shit, ignore this

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
		Log.info("Test Method resides in " + result.getTestClass().getName());


		if (result.getParameters().length != 0) {

			String params = " ";

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + " , ";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);
			Log.info("Test Method had the following parameters : " + params);


		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);
		Log.info("Test Status: " + status);

	}

	// This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

		System.out.println(textMsg);

	}

	// This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

		System.out.println(textMsg);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}
	
	

}