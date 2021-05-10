package StepDefinationsRunnerandHooks;

import businesslogic.actions.ControlgroupAction;
import cucumber.api.java.en.*;

public class StepdefsControlgroup {

	@Given("^Check that controlgroup link is clickable$")
	public void check_that_controlgroup_link_is_clickable() {
		ControlgroupAction.homePageVerification();

	}

	@When("^the user clicks on the controlgroup link$")
	public void the_user_clicks_on_the_controlgroup_link() {
		ControlgroupAction.userFindControlgroupLink();

	}

	@When("^User should navigate to the next controlgroup page$")
	public void user_should_navigate_to_the_next_controlgroup_page() {
		ControlgroupAction.clickOnControlLink();
		ControlgroupAction.verifyingUserOnDesiredPage();

	}

	@When("^User book the rental car as per need$")
	public void user_book_the_rental_car_as_per_need() {
		ControlgroupAction.carBookinMethods();

	}

	@Then("^Verify the selected element is highlight$")
	public void verify_the_selected_element_is_highlight() {
		ControlgroupAction.verifyingBooking();
	}
}
