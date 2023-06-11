package ipl_stat;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import ipl.generic.BaseClass;
import ipl.generic.DriverUtility;
import ipl.generic.ExtractData;
import ipl.generic.JavaScriptUtility;
import ipl.generic.JavaUtility;

import ipl.pages.IplStatPageObjects;

@Listeners(ipl.generic.ListenerImplementation.class)
public class IplStatPageTest extends BaseClass {
	
	@Test
	public void stattableOfSelectedSeasonTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
		
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		getting a list of runs scored by players in the table
		List<WebElement> playerRunWEList = driver.findElements(By.xpath("//tr/td[6]"));
		List<String> playerListSt = playerRunWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<Integer> playerListInt = playerListSt.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
//		checking if the list is sorted or not
		JavaUtility ju = new JavaUtility();
		Boolean sortedOrNot = ju.isSorted(playerListInt);
		
//		Asserting
		Assert.assertTrue(sortedOrNot, "Runs are sorted in descending order");
	}
	
	@Test
	public void highestScorestInSeasonTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
		
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		checking if highest scorer is displayed at the top of the page
		String topPage = iplStat.getBattingTopper().getText().strip();
		String topTable = iplStat.getFirstPlayerName().getText().strip();
		Assert.assertTrue(topPage.equalsIgnoreCase(topTable), "First player displayed on the top of the page");
	}
	
	@Test(enabled=false)
	public void battersCategoryStattableTest() throws Exception{
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		String categoryofBatters = ed.getExcelData("ipl test data", 1, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBatters+"']")).click();
		
//		getting a list of required details of players in the table
		String columnNo = ed.getExcelData("ipl test data", 1, 5);
		List<WebElement> playerRunWEList = driver.findElements(By.xpath("//tr/td["+columnNo+"]"));
		List<String> playerRunListSt = playerRunWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<Integer> playerRunListInt = playerRunListSt.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
//		checking if the list is sorted or not
		JavaUtility ju = new JavaUtility();
		Boolean sortedOrNot = ju.isSorted(playerRunListInt);
		
//		Asserting
		Assert.assertTrue(sortedOrNot, "Runs are sorted in descending order");
		
		
	}
	
	@Test
	public void battersCategoryHighestScorerTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		String categoryofBatters = ed.getExcelData("ipl test data", 1, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBatters+"']")).click();
		
//		checking if highest 4s is displayed at the top of the page
		String topPage = iplStat.getBattingTopper().getText().strip();
		String topTable = iplStat.getFirstPlayerName().getText().strip();
		Assert.assertTrue(topPage.equalsIgnoreCase(topTable), "First player displayed on the top of the page");
	}
	
	@Test
	public void bowlersCategoryStattableTest() throws Exception{
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		getting a list of required details of players in the table
		String columnNo = ed.getExcelData("ipl test data", 2, 4);
		List<WebElement> playerWEList = driver.findElements(By.xpath("//tr/td["+columnNo+"]"));
		List<String> playerListSt = playerWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<Integer> playerListInt = playerListSt.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
//		checking if the list is sorted or not
		JavaUtility ju = new JavaUtility();
		Boolean sortedOrNot = ju.isSorted(playerListInt);
		
//		Asserting
		Assert.assertTrue(sortedOrNot, "players are sorted in descending order");
	}
	
	@Test
	public void bowlersCategoryHighestScorerTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		checking if best bowling average is displayed at the top of the page
		String topPage = iplStat.getBowlingTopper().getText().strip();
		String topTable = iplStat.getFirstPlayerName().getText().strip();
		Assert.assertTrue(topPage.equalsIgnoreCase(topTable), "First player displayed on the top of the page");
	}
	
	
	@Test
	public void battersTesmsStattableTest() throws Exception{
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		Thread.sleep(5000);
		String categoryofBatters = ed.getExcelData("ipl test data", 1, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBatters+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		getting a list of required details of players in the table
		String columnNo = ed.getExcelData("ipl test data", 1, 4);
		List<WebElement> playerRunWEList = driver.findElements(By.xpath("//tr/td["+columnNo+"]"));
		List<String> playerRunListSt = playerRunWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<Integer> playerRunListInt = playerRunListSt.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
//		checking if the list is sorted or not
		JavaUtility ju = new JavaUtility();
		Boolean sortedOrNot = ju.isSorted(playerRunListInt);
		
//		Asserting
		Assert.assertTrue(sortedOrNot, "players are sorted in descending order");
		
	}
	
	@Test
	public void battersTeamsHighestScorerTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		String categoryofBatters = ed.getExcelData("ipl test data", 1, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBatters+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		checking if highest 4s is displayed at the top of the page
		String topPage = iplStat.getBattingTopper().getText().strip();
		String topTable = iplStat.getFirstPlayerName().getText().strip();
		Assert.assertTrue(topPage.equalsIgnoreCase(topTable), "First player displayed on the top of the page");
	}
	
	@Test
	public void bowlersTeamsStattableTest() throws Exception{
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		getting a list of required details of players in the table
		String columnNo = ed.getExcelData("ipl test data", 2, 4);
		List<WebElement> playerWEList = driver.findElements(By.xpath("//tr/td["+columnNo+"]"));
		List<String> playerListSt = playerWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<Integer> playerListInt = playerListSt.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
//		checking if the list is sorted or not
		JavaUtility ju = new JavaUtility();
		Boolean sortedOrNot = ju.isSorted(playerListInt);
		
//		Asserting
		Assert.assertTrue(sortedOrNot, "Average are sorted in descending order");
	}
	
	@Test
	public void bowlersTeamHighestScorerTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		clicking on a season
		String season = ed.getExcelData("ipl test data", 1, 0);
		driver.findElement(By.xpath("//div[@class='cSBListItems seasonFilterItems ng-binding ng-scope' and text()='"+season+"']")).click();
		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		checking if best bowling average is displayed at the top of the page
		String topPage = iplStat.getBowlingTopper().getText().strip();
		String topTable = iplStat.getFirstPlayerName().getText().strip();
		Assert.assertTrue(topPage.equalsIgnoreCase(topTable), "First player displayed on the top of the page");
	}
	
	
	@Test
	public void battersPlayersTypeStattableTest() throws Exception{
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
		
		
//		selecting a category
		iplStat.getCategoryListbox().click();
		String categoryofBatters = ed.getExcelData("ipl test data", 1, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBatters+"']")).click();
		
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		selecting players type
		iplStat.getPlayerTypeListbox().click();
		String playerType = ed.getExcelData("ipl test data", 1, 8);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[text() = '"+playerType+"']")).click();
		
//		getting a list of required details of players in the table
		String columnNo = ed.getExcelData("ipl test data", 1, 5);
		List<WebElement> playerRunWEList = driver.findElements(By.xpath("//tr/td["+columnNo+"]"));
		List<String> playerRunListSt = playerRunWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<Integer> playerRunListInt = playerRunListSt.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
//		checking if the list is sorted or not
		JavaUtility ju = new JavaUtility();
		Boolean sortedOrNot = ju.isSorted(playerRunListInt);
		
//		Asserting
		Assert.assertTrue(sortedOrNot, "players are sorted in descending order");
		
	}
	
	@Test
	public void battersPlayersTypeHighestScorerTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}

		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		String categoryofBatters = ed.getExcelData("ipl test data", 1, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBatters+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 7);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		selecting players type
		iplStat.getPlayerTypeListbox().click();
		String playerType = ed.getExcelData("ipl test data", 1, 9);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[text() = '"+playerType+"']")).click();
		
//		checking if highest 4s is displayed at the top of the page
		String topPage = iplStat.getBattingTopper().getText().strip();
		String topTable = iplStat.getFirstPlayerName().getText().strip();
		Assert.assertTrue(topPage.equalsIgnoreCase(topTable), "First player displayed on the top of the page");
	}
	
	@Test
	public void bowlersPlayersTypeStattableTest() throws Exception{
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}
//		clicking season listbox
		iplStat.getSeasonListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		selecting players type
		iplStat.getPlayerTypeListbox().click();
		String playerType = ed.getExcelData("ipl test data", 1, 8);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[text() = '"+playerType+"']")).click();
		
//		getting a list of required details of players in the table
		String columnNo = ed.getExcelData("ipl test data", 2, 4);
		List<WebElement> playerWEList = driver.findElements(By.xpath("//tr/td["+columnNo+"]"));
		List<String> playerListSt = playerWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<Integer> playerListInt = playerListSt.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
//		checking if the list is sorted or not
		JavaUtility ju = new JavaUtility();
		Boolean sortedOrNot = ju.isSorted(playerListInt);
		
//		Asserting
		Assert.assertTrue(sortedOrNot, "Average are sorted in descending order");
	}
	
	@Test
	public void bowlersPlayersTypeHighestScorerTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}

		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		selecting players type
		iplStat.getPlayerTypeListbox().click();
		String playerType = ed.getExcelData("ipl test data", 1, 8);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[text() = '"+playerType+"']")).click();
		
//		checking if best bowling average player is displayed at the top of the page
		String topPage = iplStat.getBowlingTopper().getText().strip();
		String topTable = iplStat.getFirstPlayerName().getText().strip();
		Assert.assertTrue(topPage.equalsIgnoreCase(topTable), "First player displayed on the top of the page");
	}
	
	@Test
	public void bowlersSearchTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}

		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		selecting players type
		iplStat.getPlayerTypeListbox().click();
		String playerType = ed.getExcelData("ipl test data", 1, 8);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[text() = '"+playerType+"']")).click();
		
//		Searching a player
		String playerName = ed.getExcelData("ipl test data", 1, 10);
		iplStat.getPlayerNameSearchbox().sendKeys(playerName);
		
//		checking if searched player appeared or not
		List<WebElement> playerWEList = driver.findElements(By.xpath("//tr/td[2]/div/a/div[@class = 'st-ply-name ng-binding']"));
		List<String> playerListSt = playerWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		
		Boolean r = false;
		for (String name:playerListSt) {
			if(name.contains(playerName)) {
				r = true;
			}
			else {
				r = false;
				break;
			}
		}
		
		Assert.assertTrue(r, "searched player appered");
	}
	
	
	@Test
	public void battersSearchTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}

		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 7);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		selecting players type
		iplStat.getPlayerTypeListbox().click();
		String playerType = ed.getExcelData("ipl test data", 1, 9);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[text() = '"+playerType+"']")).click();
		
//		Searching a player
		String playerName = ed.getExcelData("ipl test data", 1, 12);
		iplStat.getPlayerNameSearchbox().sendKeys(playerName);
		
//		checking if searched player appeared or not
		List<WebElement> playerWEList = driver.findElements(By.xpath("//tr/td[2]/div/a/div[@class = 'st-ply-name ng-binding']"));
		List<String> playerListSt = playerWEList.stream().map(x -> x.getText()).collect(Collectors.toList());
		
		Boolean r = false;
		for (String name:playerListSt) {
			if(name.contains(playerName)) {
				r = true;
			}
			else {
				r = false;
				break;
			}
		}
		
		Assert.assertTrue(r, "searched player appered");
	
	}
	
	
	@Test
	public void InvalidSearchTest() throws Exception {
		
//		opening url
		ExtractData ed = new ExtractData();
		String url = ed.getCommonData("url");
		driver.get(url);
		
//		maximize
		DriverUtility du = new DriverUtility(driver);
		du.maximizeWindow();
		
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		accept cookies
		IplStatPageObjects iplStat = new IplStatPageObjects(driver);
		try {
			iplStat.getAcceptCookiesBtn().click();
		}
		catch(Exception e) {
			
		}

		
//		clicking on category listbox
		iplStat.getCategoryListbox().click();
		
//		selecting a category
		iplStat.getBowlersCategoryBtn().click();
		String categoryofBowlers = ed.getExcelData("ipl test data", 2, 3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/div[contains(@ng-repeat, 'list in') and text() = '"+categoryofBowlers+"']")).click();
		
//		selecting team
		iplStat.getTeamsListbox().click();
		String iplTeam = ed.getExcelData("ipl test data", 1, 6);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[contains(., '"+iplTeam+"')]")).click();
		
//		selecting players type
		iplStat.getPlayerTypeListbox().click();
		String playerType = ed.getExcelData("ipl test data", 1, 8);
		driver.findElement(By.xpath("//div[@class = 'cSBList active']/div[text() = '"+playerType+"']")).click();
		
//		Searching a player
		String playerName = ed.getExcelData("ipl test data", 1, 14);
		iplStat.getPlayerNameSearchbox().sendKeys(playerName);
		
//		checking if searched player appeared or not
		List<WebElement> playerWEList = driver.findElements(By.xpath("//tr/td[2]/div/a/div[@class = 'st-ply-name ng-binding']"));
		Boolean r = playerWEList.isEmpty();
		
		Assert.assertTrue(r, "No player appeared");
		
	}
	
}
