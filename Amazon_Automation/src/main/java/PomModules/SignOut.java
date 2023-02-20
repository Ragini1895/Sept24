package PomModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOut {
	private WebElement driver;
	@FindBy (xpath = "//a[@id='nav-hamburger-menu']")
	private WebElement all;
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement signOut;
	
	public SignOut (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void ClickAll() {
		all.click();
	}
	public void ClickSignOut() {
	
		
		signOut.click();
	}
}
