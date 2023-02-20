package PomModules;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAddressForm {
	private WebElement driver;
	WebDriverWait wait ;
	@FindBy (xpath = "//input[@name='address-ui-widgets-enterAddressFullName']")
	private WebElement fullName ;
	@FindBy (xpath = "//input[@name='address-ui-widgets-enterAddressPhoneNumber']")
	private WebElement mobileNo ;
	@FindBy (xpath = "//input[@name='address-ui-widgets-enterAddressPostalCode']")
	private WebElement pinCode ;
	@FindBy (xpath = "//input[@name='address-ui-widgets-enterAddressLine1']")
	private WebElement addressLine1 ;
	@FindBy (xpath = "//input[@name='address-ui-widgets-enterAddressLine2']")
	private WebElement addressLine2 ;
	@FindBy (xpath = "//input[@name='address-ui-widgets-landmark']")
	private WebElement landMark ;
	@FindBy (xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
	private WebElement townCity ;
	@FindBy (xpath = "//span[@class='a-dropdown-prompt' and text()='MAHARASHTRA']")
	private WebElement 	viewState ;
	@FindBy (xpath = "//input[@name='address-ui-widgets-use-as-my-default']")
	private WebElement 	defaultAddressCheckbox ;
	@FindBy (xpath = "//div[text()='Preferences are used to plan your delivery. However, shipments can sometimes arrive early or later than planned.']")
	private WebElement 	deliveryInstructionsText ;
	@FindBy (xpath = "//select[@name='address-ui-widgets-addr-details-address-type-and-business-hours']")
	private WebElement 	selectAddressType ;
	@FindBy (xpath = "//span[@id='address-ui-widgets-form-submit-button']")
	private WebElement 	addAddress ;
	
	public NewAddressForm (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait (driver,20);	
	}
	public void EnterFullName(String name)
	{
		fullName.sendKeys(name);
	}
	public void EnterMobileNo(String num)
	{
		mobileNo.sendKeys(num);
	}
	public void EnterPincode(String num)
	{
		pinCode.sendKeys(num);
	}
	public void EnteraddressLine1(String address1)
	{
		addressLine1.sendKeys(address1);
	}
	public void EnteraddressLine2(String address2)
	{
		addressLine2.sendKeys(address2);
	}
	public void EnterlandMark(String text)
	{
		landMark.sendKeys(text);
	}
	public String EntertownCity()
	{
		String actualtext = townCity.getText();
		return actualtext ;
	}
	public String VerifyChooseAState()
	{
		String actualtext1 = viewState.getText();
		return actualtext1 ;
	}
	public void ClickchooseAState(String state)
	{
		Select select = new Select (viewState);
		select.selectByVisibleText(state);
	}
	public void ClickdefaultAddressCheckbox()
	{
		defaultAddressCheckbox.click();
	}
	public String VerifydeliveryInstructionsText()
	{
		String actualtext2 = deliveryInstructionsText.getText();
		return actualtext2 ;
	}
	public void SelectAddressType(String addresstype)
	{
		Select select = new Select (selectAddressType);
		select.selectByVisibleText(addresstype);
	}
	public void WaitAfterselectAddressType()
	{
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='address-ui-widgets-form-submit-button']")));
		selectAddressType.click();
	}
	
	public void ClickaddAddress()
	{
		addAddress.click();
	}
	public String GetFullName () {
		String actualName = fullName.getText();
		return actualName ;
       
	}
	public String GetMobileNo () {
		String actualNo = mobileNo.getText();
		return actualNo ;
       
	}
	public String GetPinCode () {
		String actualPincode = pinCode.getText();
		return actualPincode ;
	}
	public String GetAddr1 () {
		String actualAddr1 = addressLine1.getText();
		return actualAddr1 ;
	}
	public String GetAddr2 () {
		String actualAddr2 = addressLine2.getText();
		return actualAddr2 ;
	}
	public String GetlandMark () {
		String actuallandMark = landMark.getText();
		return actuallandMark ;
	}


}
