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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;

public class CheckoutPageStepDefinitions2 {
	WebDriver driver;
	String offerPageProduct;
	String LandingPageProductName;
	TestContextSetup testContextSetup;
	private Object landingPage;
	public CheckoutPage checkoutPage;
	public CheckoutPageStepDefinitions2(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.checkoutPage=	testContextSetup.pageObjectManager.getCheckoutPage(); // removed from next then and added here
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void Verify_user_has_ability_to_enter_promo_code() {
	
		Assert.assertTrue(checkoutPage.verifyPromobutton());
		Assert.assertTrue(checkoutPage.verifyplaceOrderButton());
	}
	@Then("^User proceed to checkout and validate the (.+) items in checkout page$")
		public void User_proceed_to_checkout(String name) throws InterruptedException {
		checkoutPage.checkoutItems();
	//	Thread.sleep(2000);     // added implicit wait in TestBase class
		
	}

}
