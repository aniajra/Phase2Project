package stepdefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefPhaseTwo2 {

	WebDriver driver = Hooks.driver;

	@When("I am adding {string} to the cart")
	public void i_am_adding_to_the_cart(String productName) {
		// Write code here that turns the phrase above into concrete actions
		String product_ID = getProductID(productName);

		WebElement LoginBtn = driver.findElement(By.id(product_ID));
		LoginBtn.click();
	}

	@Then("The product is added to cart")
	public void the_product_is_added_to_cart() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sauce Labs Backpack has been successfully added to the cart");
	}

	@Then("The product with {string} is added to cart")
	public void the_product_with_is_added_to_cart(String prodName) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("The Product " + prodName + " has been successfully added to the cart");

	}

	@Then("Item number changed to {string}")
	public void item_number_changed_to(String cartNo) {
		// Write code here that turns the phrase above into concrete actions
		WebElement ItemNumber = driver.findElement(By.id("shopping_cart_container"));
		Assert.assertEquals(ItemNumber.getText(), cartNo);
	}

	@When("I am adding below products to the cart")
	public void i_am_adding_below_product_to_the_cart(List<String> dataList) {
		// Write code here that turns the phrase above into concrete actions
		String product_ID;
		for (String productName : dataList) {
			product_ID = getProductID(productName);
			WebElement LoginBtn = driver.findElement(By.id(product_ID));
			LoginBtn.click();
		}
	}

	private String getProductID(String productName) {
		String product_ID = productName.toLowerCase().replace(' ', '-');
		product_ID = "add-to-cart-" + product_ID;
		System.out.println("The button ID for the given product name is " + product_ID);
		return product_ID;
	}

}
