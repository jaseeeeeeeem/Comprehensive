package Assessment.Hybrid;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.TrackPage;
import resources.base;

public class TrackingInvalidOrder extends base {
	
private Logger log=LogManager.getLogger(TrackingInvalidOrder.class.getName());
	
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
	public void TrackingInvalidOrders() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Page Entered");
		driver.manage().window().maximize();
		HomePage hp= new HomePage(driver);
		WebDriverWait wd= new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.visibilityOf(hp.returnClosePopup()));
		hp.returnClosePopup().click();
		Thread.sleep(2000L);
		hp.returnTrack().click();
		TrackPage tp = new TrackPage(driver);
		tp.returnOrderNum().sendKeys("321788213");
		tp.returnPhone().sendKeys("7991234566");
		tp.returnSubmit().click();
		Boolean res= tp.returnError().isDisplayed();
		Assert.assertTrue(res);
		
	}
	
}
