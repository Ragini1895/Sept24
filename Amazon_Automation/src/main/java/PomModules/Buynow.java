package PomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buynow {
	@FindBy (xpath = "//input[@id='buy-now-button']")
	private WebElement buynow ;
	@FindBy (xpath = "(//input[@type='radio'])[4]")
	private WebElement otherUPI ;
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement enterUPI ;
	@FindBy (xpath = "(//span[@class='a-button-text'])[3]")
	private WebElement verifyUPI ;
	@FindBy (xpath = "(//span[text()='Use this payment method'])[1]")
	private WebElement usepaymentmethod ;
	
	public Buynow (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickonBuyNow()
	{
		buynow.click();
	}
	public void ClickonUPIradiobutton()
	{
		otherUPI.click();;
	}
	public void EnterUPIID(String text)
	{
		enterUPI.sendKeys(text);
	}
	public void ClickonVerifyUPI()
	{
		verifyUPI.click();;
	}
	
	public void clickusepaymentmethod()
	{
		usepaymentmethod.click();
	}

	

}
