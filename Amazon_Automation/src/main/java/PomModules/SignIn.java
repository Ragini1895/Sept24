package PomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	@FindBy (xpath = "//a[@id='nav-link-accountList']")
	private WebElement signIn ;
	@FindBy (xpath = "//input[@id='ap_email']")
	private WebElement mobileno ;
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continue1 ;
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement password ;
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signInsubmit ;
	
	public SignIn (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickSignInbutton()
	{
		signIn.click();
	}
	public void EnterMobileNo(String num)
	{
		mobileno.sendKeys(num);
	}
	public void ClickContinuebutton()
	{
		continue1.click();
	}
	public void EnterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void ClickSignInSubmitbutton()
	{
		signInsubmit.click();
	}

}
