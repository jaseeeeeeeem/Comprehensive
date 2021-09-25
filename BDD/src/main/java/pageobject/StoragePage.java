package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoragePage {

	public WebDriver driver;
	public StoragePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/a[2]/div")
	WebElement firstHeading;
	
	By types=By.xpath("//div[contains(@class,'taxon-card text-center')]");
	
	public WebElement returnFirstHeading()
	{
		return firstHeading;
	}
	
	public List<WebElement> returnTypes()
	{
		List<WebElement> l=driver.findElements(types);
		return l;
	}
	
}
