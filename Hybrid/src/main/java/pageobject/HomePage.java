package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[contains(@data-gaaction,'popup.auth.close')]")
	WebElement closePopup;
	
	@FindBy (xpath="//*[@id='search']")
	WebElement searchbar;
	
	@FindBy (xpath="/html/body/div[1]/div[2]/div[2]/div[3]/div/div[3]/a[2]")
	WebElement storage;
	
	@FindBy (xpath="/html/body/div[1]/header/section/div/ul[1]/li[2]/a")
	WebElement track;
	
	By loginicon = By.cssSelector("span.header-icon-link > svg:nth-child(1)");
	
	By login = By.cssSelector(".dropdown > li:nth-child(1) > a:nth-child(1)");
	
	By loftbed = By.cssSelector(".\\31 4427 > a:nth-child(1) > span:nth-child(1)");
	
	By kids =By.cssSelector("li.topnav_item:nth-child(7) > span:nth-child(1)");
	
	By email= By.xpath("//input[@id='spree_user_email']");
	
	@FindBy (xpath="//a[@href='/help']")
	WebElement help; 
	
	@FindBy (xpath="/html/body/div[1]/header/section/div/ul[2]/li[1]/a")
	WebElement stores;
	
	@FindBy (xpath="/html/body/div[1]/header/section/div/ul[2]/li[3]/a")
	WebElement gift;
	
	By password = By.xpath("//input[@id='spree_user_password']");
	
	By Loginbtn = By.xpath("//input[@type='submit']");
	
	public WebElement returnGift()
	{
		return gift;
	}
	
	public WebElement returnTrack()
	{
		return track;
	}
	
	public WebElement returnStores()
	{
		return stores;
	}
	
	public WebElement returnLoginbtn()
	{
		List<WebElement> l3=driver.findElements(Loginbtn);
		return l3.get(2);
	}
	
	public WebElement returnPassword()
	{
		List<WebElement> l1=driver.findElements(password);
		return l1.get(2);
	}
	
	public WebElement returnEmail()
	{
		List<WebElement> l2=driver.findElements(email);
		return l2.get(1);
	}
	
	public WebElement returnStorage()
	{
		return storage;
	}
	
	public WebElement returnSearchBar()
	{
		return searchbar;
	}
	
	public WebElement returnLoftBed()
	{
		return driver.findElement(loftbed);
	}
	
	public WebElement returnHelp()
	{
		return help;
	}
	
	public WebElement returnLoginIcon()
	{
		return driver.findElement(loginicon);
	}
	
	public WebElement returnKids()
	{
		return driver.findElement(kids);
	}
	
	public WebElement returnLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement returnClosePopup()
	{
		return closePopup;
	}
}
