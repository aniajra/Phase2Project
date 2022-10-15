package stepdefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class HomePageStepDefPhaseTwo2 {

	WebDriver driver = Hooks.driver;

	@Then("I am adding {string} to the cart")
	public void i_am_adding_to_the_cart(String string) {
		// Write code here that turns the phrase above into concrete actions
		String product_name = "add-to-cart-" + string;
		WebElement LoginBtn = driver.findElement(By.id(product_name));
		LoginBtn.click();
	}

	@Then("The product is added to cart")
	public void the_product_is_added_to_cart() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sauce Labs Backpack has been successfully added to the cart");
	}

	@Then("Item number changed to {string}")
	public void item_number_changed_to(String cartNo) {
		// Write code here that turns the phrase above into concrete actions
		WebElement ItemNumber = driver.findElement(By.id("shopping_cart_container"));
		Assert.assertEquals(ItemNumber.getText(), cartNo);
	}
	
	@Then("I am adding below product to the cart")
	public void i_am_adding_below_product_to_the_cart(List<String> dataList) {
	    // Write code here that turns the phrase above into concrete actions
		String product_name;
		for (String prodname : dataList) {
			product_name = "add-to-cart-" + prodname;
			WebElement LoginBtn = driver.findElement(By.id(product_name));
			LoginBtn.click();
		}
	}
}
