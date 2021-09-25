package Assessment.Hybrid;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.TablePage;
import resources.base;

public class ValidatingTableResults extends base {
	
private Logger log=LogManager.getLogger(ValidatingTableResults.class.getName());
	
	@BeforeTest
	public void btest() throws IOException
	{
		initialiseDriver();
		log.info("initialised driver");
	}
	
	@AfterTest
	public void atest()
	{
		driver.close();
		log.info("driver is closed.");
		driver=null;
	}
	
	@Test
	public void validatingtablesearchresults()
	{
		driver.get(prop.getProperty("url"));
		log.info("Page Entered");
		driver.manage().window().maximize();
		HomePage hp= new HomePage(driver);
		String k= Keys.chord("table",Keys.ENTER);
		hp.returnSearchBar().sendKeys(k);
		TablePage tp=new TablePage(driver);
		if(tp.returnPopup().isDisplayed())
		{
			tp.returnPopup().click();
		}
		String res= tp.returnProduct().getText();
		if(res.contains("Table"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
}