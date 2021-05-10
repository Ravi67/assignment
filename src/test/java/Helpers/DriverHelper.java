package Helpers;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinationsRunnerandHooks.Hooks;
import StepDefinationsRunnerandHooks.TestSuiteRunner;

public class DriverHelper {

	static Select select;
	static Actions action;
	static WebDriverWait wait;

	public static void sleepwithtime(int i) throws InterruptedException {
		Thread.sleep(i);
	}

	public static void defaultsleep() {
		try {
			Thread.sleep(ConfigReader.getIntValue("Sleep"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String gettext(WebElement e) {
		LoggerHelper.log("Element for getting Text: " + e);
		Hooks.text = e.getText();
		return Hooks.text;

	}

	public static void sendkeys(WebElement e, String a) {
		LoggerHelper.log("Element to Send Keys: " + e);
		e.clear();
		e.sendKeys(a);
		LoggerHelper.log("Exit sendkeys");

	}

	public static String getelementattribute(WebElement e, String s) {
		return e.getAttribute(s);

	}

	public static void elementwithkeyboardkeys(WebElement e) {
		e.sendKeys(Keys.ENTER);

	}

	public static void click(WebElement e) {
		Performaction(e);
	}

	public static void jsclick(WebElement e) {
		LoggerHelper.log("Element to Click: " + e);
		((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", e);
	}

	public static void clear(WebElement e) {
		e.clear();

	}

	@SuppressWarnings("unused")
	public static void elementvisiblewaitwithtime(WebElement e, int i) {
		try {
			wait = new WebDriverWait(Hooks.driver, i);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(e));
		} catch (Exception e1) {
		}

	}

	public static int getsize(List<WebElement> e) {
		return e.size();
	}

	public static void DragDrop(WebElement e1, WebElement e2) {
		defaultsleep();
		action = new Actions(Hooks.driver);
		action.dragAndDrop(e1, e2).build().perform();

	}

	public static boolean Displayed(WebElement e) {
		LoggerHelper.log("Element Status: " + e.isDisplayed());
		return e.isDisplayed();
	}

	public static boolean Enabled(WebElement e) {
		LoggerHelper.log("Element Status: " + e.isEnabled());
		return e.isEnabled();
	}

	public static boolean Selected(WebElement e) {
		LoggerHelper.log("Element Status: " + e.isSelected());
		return e.isSelected();
	}

	public static void Performaction(WebElement e) {
		action = new Actions(Hooks.driver);
		if (e != null) {
			action.moveToElement(e);
			action.click().build().perform();
		} else {
			action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
		}

	}

	public static void scrollbypixel() {
		LoggerHelper.log("Scrolling... by Pixel");
		((JavascriptExecutor) Hooks.driver).executeScript("scroll(0, 250)");
		LoggerHelper.log("Scroll Done");

	}

	public static void scrollbyview(WebElement e) {
		LoggerHelper.log("Scrolling...by View");
		((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView();", e);
		LoggerHelper.log("Scroll Done");

	}

	public static void selectElementByValue(WebElement ele, String text) {
		select = new Select(ele);
		select.selectByVisibleText(text);
	}

	public static void selectElementByIndex(WebElement ele, int index) {
		select = new Select(ele);
		select.selectByIndex(index);
	}

	public static Object[] getListElements(List<WebElement> e, String s) {
		boolean returnflag = false;
		Object[] data = null;
		LoggerHelper.log("Return List Flag before Start: " + returnflag);
		int listsize = getsize(e);
		LoggerHelper.log("List Size coming is: " + listsize);
		if (listsize == 0) {
			Assert.assertEquals("List Size should not be Zero", "List Size coming is Zero");
		} else {
			LoggerHelper.log("Need to Get Text of the Element along with Click");
			for (int i = 0; i < listsize; i++) {
				WebElement element = e.get(i);
				LoggerHelper.log("Element coming is: " + element);
				String elementcontent = element.getText();
				LoggerHelper.log("Element Content Coming is: " + elementcontent);
				if (elementcontent.equalsIgnoreCase(s) == true || elementcontent.contains(s) == true) {
					LoggerHelper.log("Element Content got matched with given String");
					element.click();
					LoggerHelper.log("Setting Boolean Falg to TRUE");
					returnflag = true;
					LoggerHelper.log("Value in Return List boolean flag is :" + returnflag);
					data = new Object[] { elementcontent, i, returnflag };
					LoggerHelper.log("Content in Object Array: " + Arrays.toString(data));
					break;

				} else {

					LoggerHelper.log("Keep Checking Other Records");

				}

			}
		}
		return data;

	}

	public static void loaddom() {
		Boolean readyStateComplete = false;
		Boolean readyStateInteractive = false;
		while (!readyStateComplete && !readyStateInteractive) {
			LoggerHelper.log("Waiting for DOM to be loaded");
			JavascriptExecutor executor = (JavascriptExecutor) Hooks.driver;
			String st = executor.executeScript("return document.readyState").toString();
			LoggerHelper.log("DOM Status coming is: " + st);
			readyStateComplete = executor.executeScript("return document.readyState").toString().equals("complete");
			readyStateInteractive = executor.executeScript("return document.readyState").toString()
					.equals("interactive");
			LoggerHelper.log("DOM ready state flag for complete: " + readyStateComplete);
			LoggerHelper.log("DOM ready state flag for interactive: " + readyStateInteractive);
		}
		LoggerHelper.log("DOM loaded successfully");
	}

	public static void DragDropByPixel(WebElement e, int xOffset, int yOffset) {
		action = new Actions(Hooks.driver);
		action.dragAndDropBy(e, xOffset, yOffset).build().perform();

	}

	public static void waitTillElementClickable(WebElement e) {
		try {
			wait = new WebDriverWait(Hooks.driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(e));
		} catch (Exception e1) {
		}

	}

	public static void waitForInvisibilty(WebElement e, int i) {
		try {
			wait = new WebDriverWait(Hooks.driver, i);
			wait.until(ExpectedConditions.invisibilityOf(e));
		} catch (Exception e1) {
		}

	}

	public static void DoubleClick(WebElement e) {
		action = new Actions(Hooks.driver);
		if (e != null) {
			action.moveToElement(e);
			action.doubleClick().build().perform();
		} else {
			action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
		}

	}
}
