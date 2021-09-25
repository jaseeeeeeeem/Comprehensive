package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HelpPage {

	public WebDriver driver;
	public HelpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By questions= By.xpath("//div[@class='question row']");
	
	By topics= By.xpath("//li[@class='topic']");
	
	public List<WebElement> returnTopics()
	{
		List<WebElement> l1=driver.findElements(topics);
		return l1;
	}
	
	public List<WebElement> returnQuestions()
	{
		List<WebElement> l=driver.findElements(questions);
		return l;
	}
}
