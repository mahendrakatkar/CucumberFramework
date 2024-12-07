package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utiles.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;


public class OfferPageStepDefinitions2 {
	public String offerPageProduct;

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinitions2(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {

		swithToOfferPage();
		OffersPage offersPage= testContextSetup.pageObjectManager.OffersPage();
		offersPage.SearchItem(shortName);
		// testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(3000);
	 offerPageProduct=offersPage.GetProductName();

	}
	public void swithToOfferPage() {
		// pageObjectManager = new PageObjectManager(testContextSetup.driver);
		 LandingPage landingPage=testContextSetup.pageObjectManager.LandingPage();//		LandingPage landingPage= new LandingPage(testContextSetup.driver);
		landingPage.selectTopDealsPage();		// testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		testContextSetup.genericUtils.SwitchWindowToChild();
		
	

	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	  Assert.assertEquals(offerPageProduct, testContextSetup.LandingPageProductName);
	}

}
