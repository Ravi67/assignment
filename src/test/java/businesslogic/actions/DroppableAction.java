package businesslogic.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Helpers.DriverHelper;
import Helpers.LoggerHelper;
import PageLocators.DroppablePO;
import StepDefinationsRunnerandHooks.Hooks;

public class DroppableAction extends DriverHelper {

	public static void homePageVerification() {
		PageFactory.initElements(Hooks.driver, DroppablePO.class);
		LoggerHelper.log("verify user is able to see jquery ui home page");
		LoggerHelper.log("user navigate to home page");
		boolean jQuerylogo = Displayed(DroppablePO.jquerylogo);
		LoggerHelper.log("home page logo is visible-->" + jQuerylogo);
		Assert.assertEquals(jQuerylogo, true);
	}

	public static void userFindDroppableLink() {
		LoggerHelper.log("Searching the droppable link");
		LoggerHelper.log("Droppable link is visible for the action " + Displayed(DroppablePO.droppableElement));
		boolean droplink = Displayed(DroppablePO.droppableElement);
		Assert.assertEquals(droplink, true);

	}

	public static void clickOnDroppableLink() {
		LoggerHelper.log("User click on the droppable link perform the action");
		LoggerHelper.log("clicking on the link " + gettext(DroppablePO.droppableElement));
		click(DroppablePO.droppableElement);
		LoggerHelper.log("clicked on the link");

	}

	public static void verifyingUserOnDesiredPage() {
		LoggerHelper.log("verifying user on desired page");
		LoggerHelper.log("verify page title is -->" + Hooks.driver.getTitle());
		String pageheader = gettext(DroppablePO.header);
		Assert.assertEquals("Droppable", pageheader);
		LoggerHelper.log("user is on the right page");
	}

	public static void dragTargetToDestination() {
		LoggerHelper.log("Drag element to desired locaion");
		defaultsleep();
		if(Displayed(DroppablePO.iframe)) {
		Hooks.driver.switchTo().frame(DroppablePO.iframe);
		JavascriptExecutor j = (JavascriptExecutor) Hooks.driver;
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", DroppablePO.target);
		LoggerHelper.log("drag element visible-->>" + Displayed(DroppablePO.target));
		DragDrop(DroppablePO.target, DroppablePO.destination);

	}else
	{
		LoggerHelper.log("Droppable frame is not visible");
	}
	}
	
	public static void verifyTheSuccessMsg() {
		LoggerHelper.log("verifyt the success message");
		LoggerHelper.log("after dragged the element on destination");
		String messages = gettext(DroppablePO.destination);
		Assert.assertEquals(messages, "Dropped!");
		LoggerHelper.log("success message verified");
	}

	public static void verifyYelloBackground() {
		LoggerHelper.log("verify the destination background yellow visible");
		LoggerHelper.log("Get the css value of background color");
		String background = DroppablePO.destination.getCssValue("background-color");
		Assert.assertEquals("rgba(255, 250, 144, 1)", background);

	}
}