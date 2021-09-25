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
import pageobject.LoginPage;
import resources.base;

public class LoginInvalidCredentials extends base {
	private Logger log=LogManager.getLogger(LoginInvalidCredentials.class.getName());
	
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
	public void LoginWithInvalidCredential() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Page Entered");
		driver.manage().window().maximize();
		HomePage hp= new HomePage(driver);
		WebDriverWait wd= new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.visibilityOf(hp.returnClosePopup()));
		hp.returnClosePopup().click();
		Thread.sleep(2000L);
		Actions a = new Actions(driver);
		wd.until(ExpectedConditions.visibilityOf(hp.returnLoginIcon()));
		a.moveToElement(hp.returnLoginIcon()).build().perform();
		wd.until(ExpectedConditions.elementToBeClickable(hp.returnLogin()));
		a.moveToElement(hp.returnLogin()).click().build().perform();
		wd.until(ExpectedConditions.elementToBeClickable(hp.returnEmail()));
		hp.returnEmail().sendKeys("some123@gmail.com");
		hp.returnPassword().sendKeys("hello123");
		hp.returnLoginbtn().click();
		LoginPage lp= new LoginPage(driver);
		String error=lp.returnError().getText();
		Assert.assertEquals(error, "The email or password you entered is incorrect. Please try again.");
	}

}
