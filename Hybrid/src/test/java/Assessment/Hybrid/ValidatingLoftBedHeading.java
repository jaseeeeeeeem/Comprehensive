package Assessment.Hybrid;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoftBed;
import resources.base;

public class ValidatingLoftBedHeading extends base {
	
private Logger log=LogManager.getLogger(ValidatingLoftBedHeading.class.getName());
	
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
	public void validatingLoftBedHeading() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Page Entered");
		driver.manage().window().maximize();
		HomePage hp= new HomePage(driver);
		WebDriverWait wd= new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.visibilityOf(hp.returnClosePopup()));
		hp.returnClosePopup().click();
		Thread.sleep(2000L);
		Actions a=new Actions(driver);
		wd.until(ExpectedConditions.visibilityOf(hp.returnKids()));
		a.moveToElement(hp.returnKids()).build().perform();
		wd.until(ExpectedConditions.elementToBeClickable(hp.returnLoftBed()));
		a.moveToElement(hp.returnLoftBed()).click().build().perform();
		LoftBed lb=new LoftBed(driver);
		if(lb.returnHeading().getText().contains("Loft Beds"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
}
