package ipl.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptUtility {
	RemoteWebDriver rdriver;
	
	public JavaScriptUtility(WebDriver driver) {
		rdriver = (RemoteWebDriver)driver;
	}
	
	public void clickElement(WebElement element) {
		rdriver.executeScript("arguments[0].click()", element);
	}
	
	public void clickElementById(String elementId) {
		rdriver.executeScript("documet.getElementById('"+elementId+"').click()");
	}
	
	public String getTheText(WebElement element) {
		 String text = (String)rdriver.executeScript("return argument[0].value");
		 return text;
	}
	
	public String getUrlOfCurrntPage() {
		String url = (String)rdriver.executeScript("return window.location.href");
		return url;
	}
	
	public void launchApplication(String url) {
		rdriver.executeScript("window.location=argunmets[1]");
	}
	
	public void maxSrollUp() {
		rdriver.executeScript("window.scrollBy(0,-document.body.scrollHeight");
	}
	
	public void maxSrollDown() {
		rdriver.executeScript("window.scrollBy(0, document.body.scrollHeight");
	}
	
	public void scrollElement(WebElement element) {
		rdriver.executeScript("argument[0].scrollIntoView", element);
	}
	
	public String getTitleOfCurrentPage() {
		String title = (String)rdriver.executeScript("return document.title");
		return title;
	}
	
	public void enterText(WebElement element, String data) {
		rdriver.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	
	public void srollDown(int pixel) {
		rdriver.executeScript("window.scrollBy(0, "+pixel+")");
	}
}
