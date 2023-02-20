package PomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddress {
	@FindBy (xpath = "//h2[text()='Add address']")
	private WebElement AddAddress ;
	@FindBy (xpath = "//a[text()='Edit            ']")
	private WebElement editAddress2 ;
	@FindBy (xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	private WebElement mobileNo ;
	@FindBy (xpath = "//span[@id='address-ui-widgets-form-submit-button']")
	private WebElement saveChanges ;

	public YourAddress (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickonAddAddress()
	{
		AddAddress.click();
	}
	public void ClickoneditAddress2()
	{
		editAddress2.click();
	}
	public void EntermobileNo(String number)
	{
		mobileNo.sendKeys(number);
	}
	public void ClickonsaveChanges()
	{
		saveChanges.click();
	}
	
	
	
	
	
	
	
	
	
}
