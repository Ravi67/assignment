package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DroppablePO {
	public final static String Jquery_logo = "//h2[@class='logo']/a[text()='jQuery UI']";
	public final static String Droppable_Element = "//a[text()='Droppable']";
	public final static String Droppable_Header = "//h1[text()='Droppable']";
	public final static String IFrame = "//iframe[@class='demo-frame']";
	public final static String Target = "//div[@id='draggable']";
	public final static String Destination = "//div[@id='droppable']";

	@FindBy(how = How.XPATH, using = Jquery_logo)
	public static WebElement jquerylogo;

	@FindBy(how = How.XPATH, using = Droppable_Element)
	public static WebElement droppableElement;

	@FindBy(how = How.XPATH, using = IFrame)
	public static WebElement iframe;

	@FindBy(how = How.XPATH, using = Droppable_Header)
	public static WebElement header;

	@FindBy(how = How.XPATH, using = Target)
	public static WebElement target;

	@FindBy(how = How.XPATH, using = Destination)
	public static WebElement destination;

}
