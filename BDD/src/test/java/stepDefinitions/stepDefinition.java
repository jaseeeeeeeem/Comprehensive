package stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageobject.GiftPage;
import pageobject.HelpPage;
import pageobject.HomePage;
import pageobject.LoftBed;
import pageobject.LoginPage;
import pageobject.StoragePage;
import pageobject.StoresPage;
import pageobject.TablePage;
import pageobject.TrackPage;
import resources.ExcelDriven;
import resources.base;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


@RunWith(Cucumber.class)
public class stepDefinition extends base {
	private Logger log=LogManager.getLogger(stepDefinition.class.getName());

    @Given("^user is in the homepage$")
    public void user_is_in_the_homepage() throws Throwable {
    	initialiseDriver();
		log.info("initialised driver");
		driver.get(prop.getProperty("url"));
		log.info("Page Entered");
		driver.manage().window().maximize();
		HomePage hp= new HomePage(driver);
		WebDriverWait wd= new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.visibilityOf(hp.returnClosePopup()));
		hp.returnClosePopup().click();
		Thread.sleep(2000L);
    }

    @When("^user moves to kids section and clicks Loft Beds$")
    public void user_moves_to_kids_section_and_clicks_loft_beds() throws Throwable {
    	WebDriverWait wd= new WebDriverWait(driver,10);
    	HomePage hp= new HomePage(driver);
    	Actions a=new Actions(driver);
		wd.until(ExpectedConditions.visibilityOf(hp.returnKids()));
		a.moveToElement(hp.returnKids()).build().perform();
		wd.until(ExpectedConditions.elementToBeClickable(hp.returnLoftBed()));
		a.moveToElement(hp.returnLoftBed()).click().build().perform();
    }

    @Then("^the page displayed should have the heading Loft Beds$")
    public void the_page_displayed_should_have_the_heading_loft_beds() throws Throwable {
    	LoftBed lb=new LoftBed(driver);
		if(lb.returnHeading().getText().contains("Loft Beds"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.close();
		driver=null;
    }
    
    @When("^user moves to the login icon and clicks login$")
    public void user_moves_to_the_login_icon_and_clicks_login() throws Throwable {
    	WebDriverWait wd= new WebDriverWait(driver,10);
    	HomePage hp= new HomePage(driver);
    	Actions a = new Actions(driver);
		wd.until(ExpectedConditions.visibilityOf(hp.returnLoginIcon()));
		a.moveToElement(hp.returnLoginIcon()).build().perform();
		wd.until(ExpectedConditions.elementToBeClickable(hp.returnLogin()));
		a.moveToElement(hp.returnLogin()).click().build().perform();
    }

    @Then("^error message should be displayed$")
    public void error_message_should_be_displayed() throws Throwable {
    	LoginPage lp= new LoginPage(driver);
		String error=lp.returnError().getText();
		Assert.assertEquals(error, "The email or password you entered is incorrect. Please try again.");
		driver.close();
		driver=null;
    }

    @And("^user enters \"([^\"]*)\" as email and \"([^\"]*)\" as password$")
    public void user_enters_something_as_email_and_something_as_password(String strArg1, String strArg2) throws Throwable {
    	WebDriverWait wd= new WebDriverWait(driver,10);
    	HomePage hp= new HomePage(driver);
    	wd.until(ExpectedConditions.elementToBeClickable(hp.returnEmail()));
		hp.returnEmail().sendKeys(strArg1);
		hp.returnPassword().sendKeys(strArg2);
    }

    @And("^user clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
    	HomePage hp= new HomePage(driver);
    	hp.returnLoginbtn().click();
    }
    
    @When("^user clicks on Help and navigate to the page$")
    public void user_clicks_on_help_and_navigate_to_the_page() throws Throwable {
    	HomePage hp=new HomePage(driver);
    	hp.returnHelp().click();
    }

    @Then("^The Help page should contain \"([^\"]*)\" questions$")
    public void the_help_page_should_contain_something_questions(String strArg1) throws Throwable {
    	HelpPage hlp = new HelpPage(driver);
		int num=hlp.returnQuestions().size();
		if(num==10)
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.close();
		driver=null;
    }
    @Then("^The Help page should contain \"([^\"]*)\" topics$")
    public void the_help_page_should_contain_something_topics(String strArg1) throws Throwable {
    	HelpPage hlp = new HelpPage(driver);
		int num = hlp.returnTopics().size();
		if(num==10)
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
    	driver.close();
		driver=null;
    }
    
    @When("^user clicks on Track Order$")
    public void user_clicks_on_track_order() throws Throwable {
    	HomePage hp=new HomePage(driver);
    	hp.returnTrack().click();
    }

    @Then("^Error message is displayed to the user$")
    public void error_message_is_displayed_to_the_user() throws Throwable {
    	TrackPage tp = new TrackPage(driver);
    	Boolean res= tp.returnError().isDisplayed();
		Assert.assertTrue(res);
		driver.close();
		driver=null;
    }

    @And("^User enters the order id and Phone number and submits$")
    public void user_enters_the_order_id_and_phone_number_and_submits() throws Throwable {
    	TrackPage tp = new TrackPage(driver);
		tp.returnOrderNum().sendKeys("321788213");
		tp.returnPhone().sendKeys("7991234566");
		tp.returnSubmit().click();
    }
    
    @When("^user clicks on gifts and the page is displayed$")
    public void user_clicks_on_gifts_and_the_page_is_displayed() throws Throwable {
    	HomePage hp=new HomePage(driver);
    	hp.returnGift().click();
    }

    @Then("^The Gift Page should contain 6 occasions$")
    public void the_gift_page_should_contain_6_occasions() throws Throwable {
    	GiftPage gp= new GiftPage(driver);
		int num=gp.returnOccasion().size();
		if(num==6)
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.close();
		driver=null;
    }
    
    @When("^user clicks on stores and navigate to the page$")
    public void user_clicks_on_stores_and_navigate_to_the_page() throws Throwable {
    	HomePage hp=new HomePage(driver);
    	hp.returnStores().click();
    }

    @Then("^The Stores page should contain 10 stores displayed$")
    public void the_stores_page_should_contain_10_stores_displayed() throws Throwable {
    	StoresPage sp =new StoresPage(driver);
		int num=sp.returnStores().size();
		if(num==10)
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.close();
		driver=null;
    }
    
    @When("^user clicks on storage and navigate to the page$")
    public void user_clicks_on_storage_and_navigate_to_the_page() throws Throwable {
    	HomePage hp= new HomePage(driver);
    	hp.returnStorage().click();
    }

    @Then("^The storage page should contains 10 types of storage$")
    public void the_storage_page_should_contains_10_types_of_storage() throws Throwable {
    	StoragePage sp=new StoragePage(driver);
		List<WebElement> l = sp.returnTypes();
		if(l.size()==10)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.close();
		driver=null;
    }
    
    @When("^user user enters \"([^\"]*)\" and search$")
    public void user_user_enters_something_and_search(String strArg1) throws Throwable {
    	HomePage hp= new HomePage(driver);
    	String k= Keys.chord(strArg1,Keys.ENTER);
		hp.returnSearchBar().sendKeys(k);
    }
    
    @Then("^The storage should contain \"([^\"]*)\" as the first type$")
    public void the_storage_should_contain_something_as_the_first_type(String strArg1) throws Throwable {
    	StoragePage sp= new StoragePage(driver);
		Boolean res=sp.returnFirstHeading().getText().contains(strArg1);
		Assert.assertTrue(res);
		driver.close();
		driver=null;
    }

    @Then("^the first result should contain \"([^\"]*)\" keyword$")
    public void the_first_result_should_contain_something_keyword(String strArg1) throws Throwable {
    	TablePage tp=new TablePage(driver);
		if(tp.returnPopup().isDisplayed())
		{
			tp.returnPopup().click();
		}
		ExcelDriven ed= new ExcelDriven();
		ed.initialiseWorkbook("Sheet1");
		List<String> l=ed.getData("tosearch");
		
		String res= tp.returnProduct().getText();
		if(res.contains(l.get(1)))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.close();
		driver=null;
    } 

}