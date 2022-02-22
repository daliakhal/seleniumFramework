package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	
public static String downloadpath = System.getProperty("user.dir")+ "\\Downloads";
	
	public static ChromeOptions chromeoption() {
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeprefs = new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadpath);
		options.setExperimentalOption("prefs",chromeprefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true );
		return options;					
	}

public static FirefoxOptions firefoxop() {
		
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadpath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe" );
		driver = new ChromeDriver(chromeoption());	
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/Drivers/geckodriver.exe" );
			driver = new FirefoxDriver(firefoxop());	
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "/Drivers/IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");			
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
	
	// take screenshot when test case fails and add it in the screenshot folder
	@AfterMethod
	public void screenshotonfailure (ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			System.out.println("Failed");
			System.out.println("Taking screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
		
		
	}
	

}
