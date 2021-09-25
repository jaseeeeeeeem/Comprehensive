package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoftBed {
	
	public WebDriver driver;
	
	public LoftBed(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="/html/body/div[2]/div[2]/div[3]/div[1]/div/h1")
	WebElement heading;
	
	public WebElement returnHeading()
	{
		return heading;
	}

}
