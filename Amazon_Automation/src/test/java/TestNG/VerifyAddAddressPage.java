package TestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;

import com.beust.jcommander.Parameter;

import Base.Browser;
import PomModules.HomePage;
import PomModules.NewAddressForm;

import PomModules.SignIn;
import PomModules.SignOut;
import PomModules.YourAddress;
import utils.Utility;

public class VerifyAddAddressPage extends Browser {
	private WebDriver driver ;
	private SignIn signIn;
	private JavascriptExecutor scroll;
	private HomePage homepage ;
	private YourAddress yourAddress ;
	private NewAddressForm newAddressForm ;
	private SignOut signOut ;
	private SoftAssert soft ;
	String testID ;
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
	homepage = new HomePage(driver);
	yourAddress = new YourAddress(driver);
	newAddressForm = new NewAddressForm(driver) ;
	signOut = new SignOut(driver);
	soft = new SoftAssert();
	}
	@BeforeMethod
	public void Signin () throws InterruptedException, EncryptedDocumentException, IOException {
	driver.get(Utility.fetchDataFromExcel("ConfigData", 1, 1));
	signIn.ClickSignInbutton();
	signIn.EnterMobileNo(Utility.fetchDataFromExcel("ConfigData", 1, 2));
	signIn.ClickContinuebutton();
	signIn.EnterPassword(Utility.fetchDataFromExcel("ConfigData", 1, 3));
	signIn.ClickSignInSubmitbutton();
	Thread.sleep(2000);
	homepage.ClickDelivertoRagini();
	homepage.ClickOnAddAddressLink();
	}
	@Test (priority = 1)
	public void AddNewAddress () throws InterruptedException, EncryptedDocumentException, IOException	{
		testID = "T001";
		yourAddress.ClickonAddAddress();
		newAddressForm.EnterFullName(Utility.fetchDataFromExcel("Amazon", 0, 1));
		newAddressForm.EnterMobileNo(Utility.fetchDataFromExcel("Amazon", 1, 1));
		newAddressForm.EnterPincode(Utility.fetchDataFromExcel("Amazon", 2, 1));
		newAddressForm.EnteraddressLine1(Utility.fetchDataFromExcel("Amazon", 3, 1));
		newAddressForm.EnteraddressLine2(Utility.fetchDataFromExcel("Amazon", 4, 1));
		newAddressForm.EnterlandMark(Utility.fetchDataFromExcel("Amazon", 5, 1));
		Thread.sleep(2000);
		String expectedtext = "PIMPRI CHINCHWAD";
		String actualtext = newAddressForm.EntertownCity();
		Assert.assertEquals(actualtext, expectedtext);
		Thread.sleep(2000);
		String expectedtext1 = "MAHARASHTRA";
		String actualtext1 = newAddressForm.VerifyChooseAState();
		Assert.assertEquals(actualtext1, expectedtext1);
		newAddressForm.ClickdefaultAddressCheckbox();
		Thread.sleep(2000);
		String expectedtext2 = "Preferences are used to plan your delivery. However, shipments can sometimes arrive early or later than planned.";
		String actualtext2 = newAddressForm.VerifydeliveryInstructionsText();
		soft.assertEquals(actualtext2, expectedtext2);
		Thread.sleep(2000);
		newAddressForm.SelectAddressType(Utility.fetchDataFromExcel("Amazon", 6, 1));
		Thread.sleep(2000);
		newAddressForm.ClickaddAddress();
		soft.assertAll();
	}
    @Test 
    public void VerifyEditAddress () throws EncryptedDocumentException, IOException {
    testID = "T002";
    yourAddress.ClickoneditAddress2();
    yourAddress.EntermobileNo(Utility.fetchDataFromExcel("Amazon", 1, 3));
//    String expectedName = "Anil Khoje";
//    String actualName = newAddressForm.GetFullName();
//    soft.assertEquals(actualName, expectedName, "Full Name is Wrong");
//    String expectedNo = "9967323883";
//    String actualNo = newAddressForm.GetMobileNo();
//    soft.assertEquals(actualNo, expectedNo, "Phone Number is Wrong");
//    String expectedPincode = "431136";
//    String actualPincode = newAddressForm.GetPinCode();
//    soft.assertEquals(actualPincode, expectedPincode, "Pincode is Wrong");
//    String expectedAddr1 = "Plot No. B/139";
//    String actualAddr1 = newAddressForm.GetAddr1();
//    soft.assertEquals(actualAddr1, expectedAddr1, "AddressLine 1 is Wrong");
//    String expectedAddr2 = "South City, Cidco Mahanagar 2,";
//    String actualAddr2 = newAddressForm.GetAddr2();
//    soft.assertEquals(actualAddr2, expectedAddr2, "AddressLine 2 is Wrong");
//    String expectedlandMark = "Near Hotel Kailash Residency";
//    String actuallandMark = newAddressForm.GetlandMark();
//    soft.assertEquals(actuallandMark, expectedlandMark, "Landmark is Wrong");
    scroll.executeScript("window.scrollBy(0,600)");
    yourAddress.ClickonsaveChanges();
   // soft.assertAll();
    
    }
    
	@AfterMethod
	public void gobacktoMainPage (ITestResult result) throws IOException{	
		if(TestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(testID, driver);
		}
	signOut.ClickAll();
    scroll.executeScript("window.scrollBy(0,1800)");
	signOut.ClickSignOut();
	}
	@AfterClass
	public void clearObjects (){
	signIn =null;
    scroll = null;
    homepage = null ;
    yourAddress = null ;
    newAddressForm = null ;
	signOut = null ;
	System.gc(); //garbage collector
	}
	@AfterTest
	public void closethebrowser (){
	driver.quit();
	
	}

}
