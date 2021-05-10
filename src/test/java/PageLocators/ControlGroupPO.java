package PageLocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ControlGroupPO {
	public final static String Jquery_logo = "//h2[@class='logo']/a[text()='jQuery UI']";
	public final static String Cglink = "//a[text()='Controlgroup']";
	public final static String CGHeader = "//h1[text()='Controlgroup']";
	public final static String IFrame = "//iframe[@class='demo-frame']";
	public final static String CarVariant = "//span[@id='car-type-button']";
	public final static String CarType = "//label[@for='transmission-automatic']/span[1]	";
	public final static String Insurance = "//label[@for='insurance']/span[1]";
	public final static String NoFCar = "//input[@id='horizontal-spinner']";
	public final static String BookNow = "//button[text()='Book Now!']";
	public final static String ScrollMid = "//a[text()='Draggable']";
	public final static String CarDropdown = "//select[@id='car-type']";
	public final static String CarVariant2 = "//span[@id='ui-id-8-button']";
	public final static String CarType2 = "//label[@for='transmission-standard-v']";
	public final static String Insurance2 = "//label[@for='insurance-v']/span[1]";
	public final static String NoFCar2 = "//input[@id='vertical-spinner']";
	public final static String CarDropdown2 = "//select[@id='ui-id-8']";

	@FindBy(how = How.XPATH, using = Jquery_logo)
	public static WebElement jquerylogo;

	@FindBy(how = How.XPATH, using = Cglink)
	public static WebElement cglink;

	@FindBy(how = How.XPATH, using = CGHeader)
	public static WebElement cgheader;

	@FindBy(how = How.XPATH, using = CarVariant)
	public static WebElement carvarient;

	@FindBy(how = How.XPATH, using = CarType)
	public static WebElement cartype;

	@FindBy(how = How.XPATH, using = Insurance)
	public static WebElement insurance;

	@FindBy(how = How.XPATH, using = NoFCar)
	public static WebElement noofcar;

	@FindBy(how = How.XPATH, using = BookNow)
	public static WebElement booknow;

	@FindBy(how = How.XPATH, using = ScrollMid)
	public static WebElement scrollmid;

	@FindBy(how = How.XPATH, using = IFrame)
	public static WebElement iframe;

	@FindBy(how = How.XPATH, using = CarDropdown)
	public static List<WebElement> cardropdown;

	@FindBy(how = How.XPATH, using = CarVariant2)
	public static WebElement carvariant2;

	@FindBy(how = How.XPATH, using = CarType2)
	public static WebElement cartype2;

	@FindBy(how = How.XPATH, using = Insurance2)
	public static WebElement insurance2;

	@FindBy(how = How.XPATH, using = NoFCar2)
	public static WebElement nofCar2;

	@FindBy(how = How.XPATH, using = CarDropdown2)
	public static List<WebElement> cardropdown2;
	
}
