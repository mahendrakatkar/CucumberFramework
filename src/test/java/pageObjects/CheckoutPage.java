package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	 public WebDriver driver;
	 
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}

	By cartBag= By.cssSelector("[alt='Cart']");
	By checkoutButton= By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]");
	By promobutton = By.cssSelector(".promoBtn");
	By placeOrderButton= By.xpath("//*[contains(text(),'Place Order')]");
	
	public void checkoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	public boolean verifyPromobutton() {
	return	driver.findElement(promobutton).isDisplayed();
	}
	public boolean verifyplaceOrderButton() {
		return	driver.findElement(placeOrderButton).isDisplayed();
		}
}
