package ipl.generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverUtility {
	
	WebDriver driver;
	
	public DriverUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow() {
		driver.manage().window().minimize();
	}
	
	public void implicitwaitseconds(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void implicitwaitseconds() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitTillAlert(long waitseconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void fluentWaitPolling(WebElement element ) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(10));
		fluentWait.pollingEvery(Duration.ofSeconds(10));
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
		fluentWait.ignoring(NoSuchElementException.class);
	}
	
	public void customWait(WebElement element, int waitSeconds, int pollingSeconds) {
		
	}
	
	public void checkIfAlertText(String text) {
		waitTillAlert(10);
		Alert alert = driver.switchTo().alert();
		boolean check = alert.getText().strip().contains(text.strip());
		if(check) {
			System.out.println("Alert messege is correct");
			alert.accept();
		}
		else {
			System.out.println("Alert messege is not correct");
			alert.dismiss();
		}
		
	}
	
	public void clickOkOnAlert() {
		waitTillAlert(10);
		driver.switchTo().alert().accept();
	}
	
	public void clickCancelOnAlert() {
		waitTillAlert(10);
		driver.switchTo().alert().dismiss();;
	}
	
	public void waitTillTitle(String title) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(title));
		
		}
	
	public void waitTillVisibleElement(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		}
	
	public void waitExceptionIgnore() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public void mouseHoverOnElement(WebElement element) {
		Actions cursor = new Actions(driver);
		cursor.moveToElement(element).perform();
	}
	
	public void doubleClickOnElement(WebElement element) {
		Actions cursor = new Actions(driver);
		cursor.doubleClick(element).perform();
	}
	
	public void takeScreenShotpng(String filename) throws IOException {
		
		String cdate = new JavaUtility().getCurrentSystemDate();
		cdate = cdate.replace(' ', '_');
		RemoteWebDriver reDriver = (RemoteWebDriver)driver;
		File src = reDriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./pageshots/"+cdate+"-"+filename+".png");
		FileUtils.copyFile(src, dst);
		
	}
	
	public void listboxSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void listboxSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void listboxSelectByVisibleText(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
	
	public void getTableData(String sheetName) throws Exception {
		try {
			List<WebElement> tableHead = driver.findElements(By.xpath("//th"));
			int tableWidth = tableHead.size();
			int tableHeight = driver.findElements(By.tagName("tr")).size();
			ExtractData data = new ExtractData();
			
			for (int i=1; i<=tableHeight; i++) {
				for(int j=1; j<=tableWidth; j++) {
					String tableText = driver.findElement(By.xpath("//tr["+j+"]/td["+i+"]")).getText();
					data.setExcelData(sheetName, i, j, tableText);
				}
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("No table found");
		}
	}
	
	public String getLastRowValueFromWebtable(int column) {
		String tableData = driver.findElement(By.xpath("//tr[last()]/td["+column+"]")).getText();
		return tableData;
	}
	
	public void datePicker(String date) {
		String monthyear = date.substring(3);
		int day = Integer.parseInt(date.substring(0, 2));
		while(true) {
			try {
				driver.findElement(By.xpath("//th[text()='"+monthyear+"']"));
				driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
				break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//th[text()='»']")).click();
			}
		}
	}
}
