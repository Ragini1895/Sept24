package PomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCart {
	@FindBy (xpath = "//span[@id='a-autoid-16']")
	private WebElement countOptions ;
	@FindBy (xpath = "(//span[@id='size_name_13'])[2]")
	private WebElement selectcount ;
	@FindBy (xpath = "//select[@id='quantity']")
	private WebElement selectQuantity ;
	@FindBy (xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCart ;
	@FindBy (xpath = "//a[@data-csa-c-content-id='sw-gtc_CONTENT']")
	private WebElement goToCart ;
	@FindBy (xpath = "//input[@value='Proceed to checkout']")
	private WebElement proceedtoBuy ;
	
	public AddToCart (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonseeallOptions()
	{
		countOptions.click();
	}
	public void ClickonCount()
	{
		selectcount.click();
	}
	public void SelectQuantity(String value)
	{
		Select S = new Select(selectQuantity);
		S.selectByValue(value);
	}
	public void ClickAddtoCartButton()
	{
		addToCart.click();;
	}
	
	public void ClickGotoCartButton()
	{
		goToCart.click();
	}
	public void ClickproceedtoBuy()
	{
		proceedtoBuy.click();
	}
	

}
