package ipl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * page object class for stat page
 * @author SUBHAJIT
 *
 */
public class IplStatPageObjects {

//	webelements
	
	@FindBy(xpath = "//button[text()='Accept cookies']")
	private WebElement acceptCookiesBtn;
	
	@FindBy(xpath = "//div[@class = 'sm-lb-hd__inner sm-flex statsTopHeader battingTopper']//div[@class = 'sm-lb-ply-name ng-binding']")
	private WebElement battingTopper;
	
	@FindBy(xpath = "//div[@class = 'sm-lb-hd__inner sm-flex statsTopHeader bowlingTopper']//div[@class = 'sm-lb-ply-name ng-binding']")
	private WebElement bowlingTopper;
	
	@FindBy(xpath = "//a[text()='Season']")
	private WebElement SeasonBtn;
	
	@FindBy(xpath = "//a[text()='Awards']")
	private WebElement AwardsBtn;
	
	@FindBy(xpath = "//a[text()='Records']")
	private WebElement RecordsBtn;
	
	@FindBy(xpath = "//div[@ng-click='cSBShowList($event)' and contains(text(), 'SEASON')]")
	private WebElement seasonListbox;
	
	@FindBy(xpath = "//div[contains(@class, 'customSelecBox statsTypeFilter')]")
	private WebElement categoryListbox;
	
	@FindBy(xpath = "//div/span[contains(@class, 'cSBListFItems bowFItem')]")
	private WebElement bowlersCategoryBtn;
	
	@FindBy(xpath = "//div/span[contains(@class, 'cSBListFItems batFItem')]")
	private WebElement battersCategoryBtn;
	
	@FindBy(xpath = "(//div[@class = 'customSelecBox']/div[@ng-click = 'cSBShowList($event)'])[2]")
	private WebElement teamsListbox;
	
	@FindBy(xpath = "//div[@class = 'customSelecBox']/div[text() = 'All Players']")
	private WebElement playerTypeListbox;
	
	@FindBy(xpath = "//input[@ng-model = 'playerNameSearch']")
	private WebElement playerNameSearchbox;

	@FindBy(linkText = "View All")
	private WebElement viewAllBtn;
	
	@FindBy(xpath = "//tr[2]/td[2]/div/a/div[@class = 'st-ply-name ng-binding']")
	private WebElement firstPlayerName;
	
//	constructor
	public IplStatPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	getter methods
	public WebElement getSeasonBtn() {
		return SeasonBtn;
	}

	public WebElement getAwardsBtn() {
		return AwardsBtn;
	}

	public WebElement getRecordsBtn() {
		return RecordsBtn;
	}

	public WebElement getSeasonListbox() {
		return seasonListbox;
	}

	public WebElement getCategoryListbox() {
		return categoryListbox;
	}

	public WebElement getTeamsListbox() {
		return teamsListbox;
	}

	public WebElement getPlayerTypeListbox() {
		return playerTypeListbox;
	}

	public WebElement getPlayerNameSearchbox() {
		return playerNameSearchbox;
	}

	public WebElement getViewAllBtn() {
		return viewAllBtn;
	}

	public WebElement getBattingTopper() {
		return battingTopper;
	}

	public WebElement getBowlingTopper() {
		return bowlingTopper;
	}

	public WebElement getAcceptCookiesBtn() {
		return acceptCookiesBtn;
	}

	public WebElement getBowlersCategoryBtn() {
		return bowlersCategoryBtn;
	}

	public WebElement getBattersCategoryBtn() {
		return battersCategoryBtn;
	}

	public WebElement getFirstPlayerName() {
		return firstPlayerName;
	}
	
	
}
