package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePage {
	public WebDriver driver;
	public TablePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[@class='name']")
	WebElement firstProduct;
	
	@FindBy (xpath="//*[@id='authentication_popup']/div[1]/div/div[2]/a[1]")
	WebElement popup;
	
	public WebElement returnPopup()
	{
		return popup;
	}
	
	public WebElement returnProduct()
	{
		return firstProduct;
	}
	
}
