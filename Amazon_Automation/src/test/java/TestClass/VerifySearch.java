package TestClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomModules.Buynow;
import PomModules.Search;
import PomModules.SignIn;

public class VerifySearch {
	public static void main(String[] args) throws InterruptedException {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\chromedriver.exe") ;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		SignIn signin = new SignIn(driver);
		signin.ClickSignInbutton();
		signin.EnterMobileNo("8879432145");
		signin.ClickContinuebutton();
		signin.EnterPassword("Anil@3003");
		signin.ClickSignInSubmitbutton();
		
		Search search = new Search(driver);
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		search.ClickSearch("baby");
		search.SubmitSearch();
		Thread.sleep(5000);
		
	    scroll.executeScript("window.scrollBy(0,1000)");
		search.ClickResult();
		ArrayList<String> address = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(address.get(1));
		
		Buynow buynow = new Buynow(driver);
	    scroll.executeScript("window.scrollBy(0,800)");
	    buynow.ClickonBuyNow();
	    buynow.ClickonUPIradiobutton();
	    buynow.EnterUPIID("raginisawant23@oksbi");
	    buynow.clickusepaymentmethod();
	
	}
}
