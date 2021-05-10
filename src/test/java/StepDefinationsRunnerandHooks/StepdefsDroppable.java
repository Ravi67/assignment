package StepDefinationsRunnerandHooks;

import businesslogic.actions.DroppableAction;
import cucumber.api.java.en.*;

public class StepdefsDroppable {

	@Given("^User should be able to see home page$")
	public void user_should_be_able_to_see_home_page() {

		DroppableAction.homePageVerification();
	}

	@And("^Check that the droppable link is clickable$")
	public void check_that_the_droppable_link_is_clickable() {
		DroppableAction.userFindDroppableLink();
	}

	@When("^the user clicks on the droppable link$")
	public void the_user_clicks_on_the_droppable_link() {
		DroppableAction.clickOnDroppableLink();
	}

	@And("^User should navigate to the next page$")
	public void user_should_navigate_to_the_next_page() {
		DroppableAction.verifyingUserOnDesiredPage();
	}

	@And("^Able to drag and drop the square element to destination$")
	public void able_to_drag_and_drop_the_square_element_to_destination() {
		DroppableAction.dragTargetToDestination();
	}

	@Then("^verify the dropped message appears$")
	public void verify_the_dropped_message_appears() {
		DroppableAction.verifyTheSuccessMsg();
	}

	@And("^also check background should be yellow visible$")
	public void also_check_background_should_be_yellow_visible() {
		DroppableAction.verifyYelloBackground();
	}

}
