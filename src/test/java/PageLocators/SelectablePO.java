package PageLocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectablePO {
	public final static String Jquery_logo = "//h2[@class='logo']/a[text()='jQuery UI']";
	public final static String Selectable_Element = "//a[text()='Selectable']";
	public final static String Selectable_Header = "//h1[text()='Selectable']";
	public final static String IFrame = "//iframe[@class='demo-frame']";
	public final static String Itemlist = "//ol[@id='selectable']/li";
	public final static String Item = "//li[contains(@class,'selected')]";
	public final static String ScrollMid = "//a[text()='Selectable']";

	@FindBy(how = How.XPATH, using = ScrollMid)
	public static WebElement scrollmid;

	@FindBy(how = How.XPATH, using = Jquery_logo)
	public static WebElement jquerylogo;

	@FindBy(how = How.XPATH, using = Selectable_Element)
	public static WebElement selectablelink;

	@FindBy(how = How.XPATH, using = Selectable_Header)
	public static WebElement selectableheader;

	@FindBy(how = How.XPATH, using = IFrame)
	public static WebElement iframe;

	@FindBy(how = How.XPATH, using = Itemlist)
	public static List<WebElement> itemlist;

	@FindBy(how = How.XPATH, using = Item)
	public static WebElement item;

}
