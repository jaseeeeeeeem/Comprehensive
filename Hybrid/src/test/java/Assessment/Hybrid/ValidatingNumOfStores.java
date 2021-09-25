package Assessment.Hybrid;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobject.HomePage;
import pageobject.StoresPage;
import resources.base;

public class ValidatingNumOfStores extends base {
	
private Logger log=LogManager.getLogger(ValidatingNumOfStores.class.getName());
	
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
	public void NumOfStores() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Page Entered");
		driver.manage().window().maximize();
		HomePage hp= new HomePage(driver);
		WebDriverWait wd= new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.visibilityOf(hp.returnClosePopup()));
		hp.returnClosePopup().click();
		Thread.sleep(2000L);
		hp.returnStores().click();
		StoresPage sp =new StoresPage(driver);
		int num=sp.returnStores().size();
		if(num==10)
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
}
