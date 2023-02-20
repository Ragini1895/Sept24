package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\chromedriver.exe") ;
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
	public static WebDriver openOperaBrowser() {
		System.setProperty("webdriver.opera.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\operadriver_win32\\operadriver.exe") ;
		WebDriver driver = new OperaDriver();
		return driver ;
	}
	public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\Edge\\msedgedriver.exe") ;
		WebDriver driver = new EdgeDriver();
		return driver ;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Downloads\\SELENIUM\\geckodriver.exe") ;
		WebDriver driver = new FirefoxDriver();
		return driver ;
	}
}
