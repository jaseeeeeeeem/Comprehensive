package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GiftPage {
	
	public WebDriver driver;
	
	public GiftPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By occasions= By.xpath("//li[@class='_11b4v']");
	
	public List<WebElement> returnOccasion()
	{
		return driver.findElements(occasions);
	}

}
