package PomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	@FindBy (xpath = "(//input[@type='radio'])[1]")
	private WebElement raginiaddrRadiobutton ;
	@FindBy (xpath = "//span[@id='shipToThisAddressButton']")
	private WebElement usethisAdd ;
	@FindBy (xpath = "(//input[@type='radio'])[1]")
	private WebElement axisCreditcardRadioButton ;
	@FindBy (xpath = "//input[@type='password']")
	private WebElement enterCVV ;
	@FindBy (xpath = "(//span[text()='Use this payment method'])[1]")
	private WebElement usepaymentMode ;
	@FindBy (xpath = "//span[@id='prime-interstitial-nothanks-button']")
	private WebElement noThanks ;
	@FindBy (xpath = "(//span[text()='Place Your Order and Pay'])[1]")
	private WebElement placeOrderandPay ;
	
	public CheckOutPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonraginiaddrRadiobutton()
	{
		raginiaddrRadiobutton.click();
	}
	public void ClickonUsethisAdd()
	{
		usethisAdd.click();
	}
	public void ClickaxisCreditcardRadioButton()
	{
		axisCreditcardRadioButton.click();;
	}
	
	public void EnterCVV(String num3or4digit)
	{
		enterCVV.sendKeys(num3or4digit);
	}
	public void ClickusepaymentMode()
	{
		usepaymentMode.click();
	}
	public void ClicknoThanks()
	{
		noThanks.click();
	}
	public void ClickplaceOrderandPay()
	{
		placeOrderandPay.click();
	}

}
