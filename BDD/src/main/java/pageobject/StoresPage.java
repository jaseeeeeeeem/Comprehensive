package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StoresPage {
	
	public WebDriver driver;
	
	public StoresPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By stores = By.xpath("//a[@class='_1-vgs']");
	
	public List<WebElement> returnStores()
	{
		return driver.findElements(stores);
	}

}
