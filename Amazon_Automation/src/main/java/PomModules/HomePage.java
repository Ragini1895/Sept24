package PomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver ;
	@FindBy (xpath = "//a[@id='nav-global-location-popover-link']")
	private WebElement deliveryAddr ;
	@FindBy (xpath = "//span[@id='GLUXManageAddressLink']")
	private WebElement addAddrlink ;
	
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickDelivertoRagini()
	{
		deliveryAddr.click();
	}
	public void ClickOnAddAddressLink()
	{
		addAddrlink.click();
	}
	

}
