package businesslogic.actions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Helpers.DriverHelper;
import Helpers.LoggerHelper;
import PageLocators.DroppablePO;
import PageLocators.SelectablePO;
import StepDefinationsRunnerandHooks.Hooks;

public class SelectableAction extends DriverHelper {

	public static void homePageVerification() {
		PageFactory.initElements(Hooks.driver, SelectablePO.class);
		LoggerHelper.log("verify user is able to see jquery ui home page");
		LoggerHelper.log("user navigate to home page");
		boolean jQuerylogo = Displayed(SelectablePO.jquerylogo);
		LoggerHelper.log("home page logo is visible-->" + jQuerylogo);
		Assert.assertEquals(jQuerylogo, true);
	}

	public static void userFindSelectableLink() {
		LoggerHelper.log("Searching the Selectable link");
		LoggerHelper.log("Selectable link is visible for the action " + Displayed(SelectablePO.selectablelink));
		boolean selectlink = Displayed(SelectablePO.selectablelink);
		Assert.assertEquals(selectlink, true);

	}

	public static void clickOnSelectableLink() {
		LoggerHelper.log("User click on the Selectable link perform the action");
		LoggerHelper.log("clicking on the link " + gettext(SelectablePO.selectablelink));
		click(SelectablePO.selectablelink);
		LoggerHelper.log("clicked on the link");

	}

	public static void verifyingUserOnDesiredPage() {
		LoggerHelper.log("verifying user on desired page");
		LoggerHelper.log("verify page title is -->" + Hooks.driver.getTitle());
		String pageheader = gettext(SelectablePO.selectableheader);
		Assert.assertEquals("Selectable", pageheader);
		LoggerHelper.log("user is on the right page");
	}

	public static void multiSelectItemFromList() {
		LoggerHelper.log("Select element from the list");
		JavascriptExecutor j = (JavascriptExecutor) Hooks.driver;
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", SelectablePO.scrollmid);
		if (Displayed(SelectablePO.iframe)) {
			Hooks.driver.switchTo().frame(SelectablePO.iframe);
			List<WebElement> list = SelectablePO.itemlist;
			System.out.println("list size-->" + list.size());
			Actions builder = new Actions(Hooks.driver);
			Action multiselect = builder.keyDown(Keys.CONTROL).click(list.get(0)).click(list.get(2)).click(list.get(6))
					.build();
			multiselect.perform();

		} else {
			LoggerHelper.log("Selectable frame is not visible");
		}
	}

	public static void verifyTheSuccessMsg() {
		LoggerHelper.log("verifying the desirable item selected");
		LoggerHelper.log("after select the element from the list");
		String messages = gettext(SelectablePO.item);
		Assert.assertEquals(messages, "Item 1");
		LoggerHelper.log("selected items verified");
	}

}