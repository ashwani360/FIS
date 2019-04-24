package Utils;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.json.JSONException;
//import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import com.cucumber.listener.Reporter;
//import com.vimalselvam.cucumber.listener.Reporter;

import com.google.common.io.Files;
import cucumber.api.Scenario;

//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumTest {
	public WebDriver driver;

	public String baseUrl;

	public String browserName;

	public String browserVersion;
	//----------------------------------------------------------------------------
	CreateCycleAndAddTests zp=new CreateCycleAndAddTests();
	

	public void Launchbrowser() throws Exception 
      {
			//driver = new HtmlUnitDriver();
		ProeprtyReader pr=new ProeprtyReader("Config.properties");
		//Properties pr=new Properties();
		String targatedbrowser=pr.getdata("browser");
		String headless=pr.getdata("headless");
		String url=pr.getdata("siteName");
		System.out.println(url);
		 if(targatedbrowser.equals("chrome"))
		{ 
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
				
			 
			 if(headless.equals("true"))
			 {
				 ChromeOptions options = new ChromeOptions();
					// set chrome as Headless
					options.setHeadless(true);
					//Instantiate Chrome Driver
					 driver = new ChromeDriver(options); 
			 }
			 else {
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
		//capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			capabilities = new DesiredCapabilities();
	        LoggingPreferences logPrefs = new LoggingPreferences();
	        logPrefs.enable(LogType.BROWSER, Level.ALL);
	        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//	        
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
			driver= new ChromeDriver(capabilities);
			System.out.println(driver);
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			browserName = caps.getBrowserName();
			browserVersion = caps.getVersion();
			 }
		}
		else if (targatedbrowser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\Lib\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			browserName = caps.getBrowserName();
			browserVersion = caps.getVersion();
		}
	
		else
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Lib\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			browserName = caps.getBrowserName();
			browserVersion = caps.getVersion();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("Automated test run. We are running on "+browserName+" "+browserVersion);
		System.out.println("Launching browser"); 
		driver.get(url);
		System.out.println("In base class: "+driver.toString());
      }
//	public void addTestcaseinTestcycle(Scenario s,WebDriver getwebdriver,String Cycleid)
//	{
//		List<String> testcaseid=(List<String>) s.getSourceTagNames();
//		System.out.println(testcaseid.get(0));
//		
//	}
	public void tidyUp(String comment,Scenario s,WebDriver getwebdriver,String zephyrBaseUrl, String accessKey, String secretKey, String accountId, Long projectId, Long versionId, Map<String, String> CurrentExecutionID, String CycleID, String TestcaseID) throws IOException, IllegalStateException, JSONException, URISyntaxException, InterruptedException 
		{   
			 if (s.isFailed()) {
				 
				 String screenshotName = s.getName().replaceAll(" ", "_");
				 
				 //System.out.println("Passed"+screenshotName);
					try {
						//This takes a screenshot from the driver at save it to the specified location
						String sourcePath = "data:image/png;base64,"+((TakesScreenshot)getwebdriver).
				                getScreenshotAs(OutputType.BASE64);;
						
						//Building up the destination path for the screenshot to save
						//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
						//File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
						
						//Copy taken screenshot from source location to destination location
						//Files.copy(sourcePath, destinationPath);   

						//This attach the specified screenshot to the test
					Reporter.addScreenCaptureFromPath(sourcePath);
						List<String> stag=(List<String>) s.getSourceTagNames();
						String value = CurrentExecutionID.get(stag.get(stag.size()-1).toString().substring(1, stag.get(stag.size()-1).toString().length()));
						System.out.println("Execution ID need to Faild is"+value);
						zp.UpdateStatus(zephyrBaseUrl, accessKey, secretKey,accountId,projectId,versionId, "2", CurrentExecutionID, CycleID, TestcaseID,comment);
					} catch (IOException e) {
					} 
			 }
			 else{
				 System.out.println("Passed");
				 List<String> stag=(List<String>) s.getSourceTagNames();
					String value = CurrentExecutionID.get(stag.get(stag.size()-1).toString().substring(1, stag.get(stag.size()-1).toString().length()));
					System.out.println("Execution ID need to Pass is"+value);
					zp.UpdateStatus(zephyrBaseUrl, accessKey, secretKey,accountId,projectId,versionId, "1", CurrentExecutionID, CycleID, TestcaseID,comment);
			 }
				
				driver.quit();
		}
	

	
	//----------------------------------------------------------------------------

	
	
}
