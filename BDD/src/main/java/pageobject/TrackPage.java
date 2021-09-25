package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackPage {
	
	public WebDriver driver;
	public TrackPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//*[@id='ip_379403698']")
	WebElement OrderNum;
	
	@FindBy (xpath="//*[@id='ip_394711104']")
	WebElement phone;
	
	@FindBy (xpath="/html/body/div[1]/div/main/section/form[1]/button")
	WebElement submit;
	
	@FindBy (xpath="//p[@class='_33bg3']")
	WebElement error;
	
	public WebElement returnError()
	{
		return error;
	}
	
	public WebElement returnSubmit()
	{
		return submit;
	}
	
	public WebElement returnPhone()
	{
		return phone;
	}
	
	public WebElement returnOrderNum()
	{
		return OrderNum;
	}
	
}
