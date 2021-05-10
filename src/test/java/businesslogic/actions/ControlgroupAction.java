package businesslogic.actions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Helpers.DriverHelper;
import Helpers.LoggerHelper;
import PageLocators.ControlGroupPO;
import PageLocators.DroppablePO;
import StepDefinationsRunnerandHooks.Hooks;

public class ControlgroupAction extends DriverHelper {

	public static void homePageVerification() {
		PageFactory.initElements(Hooks.driver, ControlGroupPO.class);
		LoggerHelper.log("verify user is able to see jquery ui home page");
		LoggerHelper.log("user navigate to home page");
		boolean jQuerylogo = Displayed(ControlGroupPO.jquerylogo);
		LoggerHelper.log("home page logo is visible-->" + jQuerylogo);
		Assert.assertEquals(jQuerylogo, true);
	}

	public static void userFindControlgroupLink() {
		LoggerHelper.log("Searching the Control link");
		scrollbyview(ControlGroupPO.scrollmid);
		LoggerHelper.log("Control link is visible for the action " + Displayed(ControlGroupPO.cglink));
		boolean link = Displayed(ControlGroupPO.cglink);
		Assert.assertEquals(link, true);

	}

	public static void clickOnControlLink() {
		LoggerHelper.log("User click on the control link perform the action");
		LoggerHelper.log("clicking on the link " + gettext(ControlGroupPO.cglink));
		scrollbyview(ControlGroupPO.scrollmid);

		click(ControlGroupPO.cglink);
		LoggerHelper.log("clicked on the link");

	}

	public static void verifyingUserOnDesiredPage() {
		LoggerHelper.log("verifying user on desired page");
		LoggerHelper.log("verify page title is -->" + Hooks.driver.getTitle());
		String pageheader = gettext(ControlGroupPO.cgheader);
		Assert.assertEquals("Controlgroup", pageheader);
		LoggerHelper.log("user is on the right page");
	}

	public static void carBookinMethods() {
		LoggerHelper.log("choose the car as per your need");
		LoggerHelper.log("scroll bar down to view control group");
		scrollbyview(ControlGroupPO.scrollmid);
		defaultsleep();
		LoggerHelper.log("switch on the frame to perform action");
		Hooks.driver.switchTo().frame(ControlGroupPO.iframe);
		LoggerHelper.log("select car varient");
		click(ControlGroupPO.carvarient);
		List<WebElement> list = ControlGroupPO.cardropdown;
		for (WebElement element : list) {
			if (element.getText().equals("SUV"))
				element.click();
			click(ControlGroupPO.cartype);
			LoggerHelper.log("select insurance");
			click(ControlGroupPO.insurance);
			LoggerHelper.log("how many car required enter the input box");
			sendkeys(ControlGroupPO.noofcar, "2");
			LoggerHelper.log("click on book now options");
			click(ControlGroupPO.booknow);

		}
		
		}

		public static void verifyingBooking()
		{	LoggerHelper.log("choose truck type as per your need");
			scrollbypixel();
			click(ControlGroupPO.carvariant2);
			List<WebElement> list2 = ControlGroupPO.cardropdown2;
			for (WebElement element : list2) {
				if (element.getText().equals("Truck"))
					element.click();
				click(ControlGroupPO.cartype2);
				LoggerHelper.log("select insurance");
				click(ControlGroupPO.insurance2);
				LoggerHelper.log("how many car required enter the input box");
				sendkeys(ControlGroupPO.nofCar2, "1");
				LoggerHelper.log("click on book now options");
				click(ControlGroupPO.booknow);
			
		}
	}
}
