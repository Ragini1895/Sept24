package PomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement search ;
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement submitsearch ;
	@FindBy (xpath = "(//div[@cel_widget_id='MAIN-SEARCH_RESULTS-13']//div//a//span)[7]")
	private WebElement searchresults ;
	
	public Search (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void ClickSearch(String text)
	{
		search.sendKeys(text);
	}
	public void SubmitSearch()
	{
		submitsearch.click();
	}
	public void ClickResult()
	{
		searchresults.click();
	}
	

	
}
