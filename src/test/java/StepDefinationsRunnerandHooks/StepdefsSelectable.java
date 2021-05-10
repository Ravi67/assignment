package StepDefinationsRunnerandHooks;

import businesslogic.actions.SelectableAction;
import cucumber.api.java.en.*;

public class StepdefsSelectable {

	@Given("^Check that the selectable link is clickable$")
	public void check_that_the_selectable_link_is_clickable() {

		SelectableAction.homePageVerification();
	}

	@When("^the user clicks on the selectable link$")
	public void the_user_clicks_on_the_selectable_link() {
		SelectableAction.userFindSelectableLink();
	}

	@When("^User should navigate to the next selectable page$")
	public void user_should_navigate_to_the_next_selectable_page() {
		SelectableAction.clickOnSelectableLink();

	}

	@When("^User multi select the items from the item list$")
	public void user_multi_select_the_items_from_the_item_list() {
		SelectableAction.verifyingUserOnDesiredPage();
	}

	@Then("^background color of the items list should be change$")
	public void background_color_of_the_items_list_should_be_change() {
		SelectableAction.multiSelectItemFromList();
		SelectableAction.verifyTheSuccessMsg();
	}
}
