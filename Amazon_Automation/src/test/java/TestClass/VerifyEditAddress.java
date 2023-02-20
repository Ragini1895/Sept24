package TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomModules.HomePage;
import PomModules.SignIn;
import PomModules.SignOut;
import PomModules.YourAddress;

public class VerifyEditAddress {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\chromedriver.exe") ;
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	
	SignIn signIn = new SignIn(driver);
	JavascriptExecutor scroll = (JavascriptExecutor)driver;
	HomePage homepage = new HomePage(driver);
	YourAddress yourAddress =new YourAddress(driver);
	SignOut signOut = new SignOut(driver);
	signIn.ClickSignInbutton();
	signIn.EnterMobileNo("8879432145");
	signIn.ClickContinuebutton();
	signIn.EnterPassword("Anil@3003");
	signIn.ClickSignInSubmitbutton();
	Thread.sleep(2000);
	homepage.ClickDelivertoRagini();
	homepage.ClickOnAddAddressLink();
	yourAddress.ClickoneditAddress2();
	yourAddress.EntermobileNo("9967323883");
	scroll.executeScript("window.scrollBy(0,600)");
	yourAddress.ClickonsaveChanges();
	signOut.ClickAll();
	scroll.executeScript("window.scrollBy(0,1800)");
	signOut.ClickSignOut();
}
}
