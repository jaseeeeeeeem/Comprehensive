package Assessment.Hybrid;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.TablePage;
import resources.ExcelDriven;
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
	public void validatingtablesearchresults() throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Page Entered");
		driver.manage().window().maximize();
		HomePage hp= new HomePage(driver);
		ExcelDriven ed= new ExcelDriven();
		ed.initialiseWorkbook("Sheet1");
		List<String> l=ed.getData("tosearch");
		String k= Keys.chord(l.get(1),Keys.ENTER);
		hp.returnSearchBar().sendKeys(k);
		TablePage tp=new TablePage(driver);
		if(tp.returnPopup().isDisplayed())
		{
			tp.returnPopup().click();
		}
		String res= tp.returnProduct().getText();
		if(res.contains(l.get(1)))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
}
