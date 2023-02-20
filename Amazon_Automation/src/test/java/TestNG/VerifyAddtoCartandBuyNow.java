package TestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomModules.AddToCart;
import PomModules.Buynow;
import PomModules.Search;
import PomModules.SignIn;
import PomModules.SignOut;

public class VerifyAddtoCartandBuyNow {
	private WebDriver driver ;
	@BeforeClass
	public void launchBrowser (){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\chromedriver.exe") ;
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	@BeforeMethod
	public void Signin () throws InterruptedException {
	driver.get("https://www.amazon.in/");
	
	SignIn signIn = new SignIn(driver);
	signIn.ClickSignInbutton();
	signIn.EnterMobileNo("8879432145");
	signIn.ClickContinuebutton();
	signIn.EnterPassword("Anil@3003");
	signIn.ClickSignInSubmitbutton();
	Search search = new Search(driver);
	search.ClickSearch("baby");
	search.SubmitSearch();
	Thread.sleep(2000);
	JavascriptExecutor scroll = (JavascriptExecutor)driver;
    scroll.executeScript("window.scrollBy(0,1000)");
	search.ClickResult();
	ArrayList<String> address = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(address.get(1));
	}
	@Test    //Buynow
	public void ClickonBuyNow () throws InterruptedException	{
	Buynow buynow = new Buynow(driver);
	JavascriptExecutor scroll = (JavascriptExecutor)driver;
    scroll.executeScript("window.scrollBy(0,800)");
    buynow.ClickonBuyNow();
    buynow.ClickonUPIradiobutton();
    buynow.EnterUPIID("raginisawant23@oksbi");
    buynow.clickusepaymentmethod();
	}
    @Test 
    public void clickonAddtoCart () {
    AddToCart addtocart = new AddToCart(driver);
   // addtocart.ClickonseeallOptions();
   // addtocart.ClickonCount();
    JavascriptExecutor scroll = (JavascriptExecutor)driver;
    scroll.executeScript("window.scrollBy(0,800)");
    addtocart.SelectQuantity("3");
    addtocart.ClickAddtoCartButton();
    addtocart.ClickGotoCartButton();
    addtocart.ClickproceedtoBuy();
    }
	@AfterMethod
	public void gobacktoMainPage (){
    driver.close();
	ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(addr.get(0));
	driver.navigate().back();
	SignOut signOut = new SignOut(driver);
	signOut.ClickAll();
	JavascriptExecutor scroll = (JavascriptExecutor)driver;
    //scroll.executeScript("arguments[0].scrollIntoView(true);",signOut);
    scroll.executeScript("window.scrollBy(0,1800)");
	signOut.ClickSignOut();
	}
	@AfterClass
	public void closethebrowser (){
	driver.quit();
	}


}
