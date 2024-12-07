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

public class LandingPageStepDefinitions {
	WebDriver driver;
	String offerPageProduct;
	String LandingPageProductName;
	TestContextSetup testContextSetup;
	//private Object landingPage;
	
	LandingPage landingPage;
	public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		// this.landingPage =testContextSetup.pageObjectManager.LandingPage();
		this.landingPage=testContextSetup.pageObjectManager.LandingPage();
	}
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		//Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		Assert.assertTrue(landingPage.getTitleofPage().contains("GreenKart"));
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		//added to contructor LandingPage landingPage=testContextSetup.pageObjectManager.LandingPage();//		LandingPage landingpage=new LandingPage(testContextSetup.driver);
				
		landingPage.SearchItem(shortName);
		
		// REPLACED THIS LINE>  testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		testContextSetup.LandingPageProductName =landingPage.GetProductName().split("-")[0].trim();
		System.out.println(LandingPageProductName +" is extractedFROM HOME PAGE.");
	}

	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
