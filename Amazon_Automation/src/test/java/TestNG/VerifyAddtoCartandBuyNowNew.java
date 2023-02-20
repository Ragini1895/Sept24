package TestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Browser;
import PomModules.AddToCart;
import PomModules.Buynow;
import PomModules.Search;
import PomModules.SignIn;
import PomModules.SignOut;

public class VerifyAddtoCartandBuyNowNew  extends Browser {
	private WebDriver driver ;
	private SignIn signIn;
	private JavascriptExecutor scroll;
	private Buynow buynow ;
	private AddToCart addtocart ;
	private SignOut signOut ;
	private Search search ;
	@Parameters("AmazonTest")
	@BeforeTest
	public void launchBrowser (String browser){
		if(browser.equals("Chrome")) {
			driver = openChromeBrowser ();
			}	
			if(browser.equals("Opera")) {
			driver = openOperaBrowser ();
			}
			if(browser.equals("Edge")) {
			driver = openEdgeBrowser ();
			}
			if(browser.equals("Firefox")) {
			driver = openFirefoxBrowser ();
			}
//    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\chromedriver.exe") ;
//	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	@BeforeClass
	public void CreatePOMClassObjects() {
		signIn = new SignIn(driver);
		scroll = (JavascriptExecutor)driver;
		buynow = new Buynow(driver);
		addtocart = new AddToCart(driver);
		signOut = new SignOut(driver);
		search = new Search(driver);
	}
	@BeforeMethod
	public void Signin () throws InterruptedException {
	driver.get("https://www.amazon.in/");

	signIn.ClickSignInbutton();
	signIn.EnterMobileNo("8879432145");
	signIn.ClickContinuebutton();
	signIn.EnterPassword("Anil@3003");
	signIn.ClickSignInSubmitbutton();
	search.ClickSearch("baby");
	search.SubmitSearch();
	Thread.sleep(2000);
    scroll.executeScript("window.scrollBy(0,1000)");
	search.ClickResult();
	ArrayList<String> address = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(address.get(1));
	}
	@Test  
	public void ClickonBuyNow () throws InterruptedException	{
    scroll.executeScript("window.scrollBy(0,800)");
    buynow.ClickonBuyNow();
    buynow.ClickonUPIradiobutton();
    buynow.EnterUPIID("raginisawant23@oksbi");
    buynow.clickusepaymentmethod();
	}
    @Test 
    public void clickonAddtoCart () {
   // addtocart.ClickonseeallOptions();
   // addtocart.ClickonCount();
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
	signOut.ClickAll();
    scroll.executeScript("window.scrollBy(0,1800)");
	signOut.ClickSignOut();
	}
	@AfterClass
	public void clearObjects (){
	signIn =null;
    scroll = null;
    buynow = null ;
	addtocart = null ;
	signOut = null ;
	search = null ;
	System.gc(); //garbage collector
	}
	@AfterTest
	public void closethebrowser (){
	driver.quit();
	
	}

}
