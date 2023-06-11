package ipl.generic;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot tsdriver = (TakesScreenshot)BaseClass.driver;
		LocalDateTime localdt = LocalDateTime.now();
		String cDT = localdt.toString().replace(" ", "_").replace(":", "_");
		File src = tsdriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("Screenshots/"+testName+"-"+cDT+".png");
		try {
			FileUtils.copyFile(src, dst);
		}
		catch (Exception e) {
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	
	
}
