package stepdef;
import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reporting.Logs;

public class InsuranceQuoteSteps {
	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		String title = BaseClass.driver.getTitle();
		Logs.log("Title of the page is : " + title);
	
	}

	@When("user select Small Business option from product drop down")
	public void user_select_Small_Business_option_from_product_drop_down() {
		BaseClass.landingPage.productDropDownMethod(BaseClass.cA);
		Logs.log("This is a when statement");
	}

	@And("put zip code in zipcode field")
	public void put_zip_code_in_zipcode_field() {
		BaseClass.landingPage.zipCodeFieldMethod(BaseClass.cA);

	}

	@And("click on Start a quote button")
	public void click_on_Start_a_quote_button() {
		BaseClass.landingPage.startAQuoteTabMethod(BaseClass.cA);
	}

	@Then("Find a State Farm Agent Near You page shows up")
	public void test6() {
		String nextTitle = BaseClass.driver.getTitle();
		Logs.log("This is a then statement title: " + nextTitle);
	}

}
