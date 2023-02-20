package TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PomModules.HomePage;
import PomModules.NewAddressForm;
import PomModules.SignIn;
import PomModules.SignOut;
import PomModules.YourAddress;

public class VerifyAddAddress {
	
	public static void main(String[] args) throws InterruptedException {
	
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\chromedriver.exe") ;
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	
	SignIn signIn = new SignIn(driver);
	JavascriptExecutor scroll = (JavascriptExecutor)driver;
	HomePage homepage = new HomePage(driver);
	YourAddress yourAddress = new YourAddress(driver);
	NewAddressForm newAddressForm = new NewAddressForm(driver) ;
	WebDriverWait wait = new WebDriverWait (driver,20);
	SignOut signOut = new SignOut(driver);
	signIn.ClickSignInbutton();
	signIn.EnterMobileNo("8879432145");
	signIn.ClickContinuebutton();
	signIn.EnterPassword("Anil@3003");
	signIn.ClickSignInSubmitbutton();
	Thread.sleep(2000);
	homepage.ClickDelivertoRagini();
	homepage.ClickOnAddAddressLink();
	yourAddress.ClickonAddAddress();
	newAddressForm.EnterFullName("Ragini Anil Khoje");
	newAddressForm.EnterMobileNo("8879432145");
	newAddressForm.EnterPincode("411018");
	newAddressForm.EnteraddressLine1("Building O/B 4/5,Flat no 201,O sector");
	newAddressForm.EnteraddressLine2("Atul Co operative society,Ajmera Housing society");
	newAddressForm.EnterlandMark("D Y patil Nagari training center and Queens aquarium");
	Thread.sleep(2000);
	String expectedtext = "PIMPRI CHINCHWAD";
	String actualtext = newAddressForm.EntertownCity();
	if(expectedtext.equals(actualtext))
	{
	System.out.println("Text is Validated");	
	}
	else
	{
		System.out.println("Text is wrong");
	}
	Thread.sleep(2000);
	String expectedtext1 = "MAHARASHTRA";
	String actualtext1 = newAddressForm.VerifyChooseAState();
	if(expectedtext1.equals(actualtext1))
	{
	System.out.println("Text is Validated");	
	}
	else
	{
		System.out.println("Text is wrong");
	}
	newAddressForm.ClickdefaultAddressCheckbox();
	Thread.sleep(2000);
	
	String expectedtext2 = "Preferences are used to plan your delivery. However, shipments can sometimes arrive early or later than planned.";
	String actualtext2 = newAddressForm.VerifydeliveryInstructionsText();
	if(expectedtext2.equals(actualtext2))
	{
	System.out.println("Text is Validated");	
	}
	else
	{
		System.out.println("Text is wrong");
	}
	Thread.sleep(2000);
	newAddressForm.SelectAddressType("RES");
	newAddressForm.WaitAfterselectAddressType();
	newAddressForm.ClickaddAddress();
	signOut.ClickAll();
	scroll.executeScript("window.scrollBy(0,1800)");
	signOut.ClickSignOut();
}
}
