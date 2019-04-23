package Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.Jsoup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class AccessibilitySniffer implements IAccessibilityManager {

    public static  WebDriver driver;
    public static  JavascriptExecutor js;
    public static final String SAMPLE_CSV_FILE = "./sample"+System.currentTimeMillis()+".csv";
    public AccessibilitySniffer(WebDriver driver) throws IOException {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }
    
//    public static void main(String args[]) throws IOException
//    {
//    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
//			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
//			capabilities = new DesiredCapabilities();
//	        LoggingPreferences logPrefs = new LoggingPreferences();
//	        logPrefs.enable(LogType.BROWSER, Level.ALL);
//	        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//	        
//			driver= new ChromeDriver(capabilities);
//			js = (JavascriptExecutor) driver;
//			System.out.println(driver);
//			driver.get("Https://Google.com");
//			runCodeSniffer("WCAG2AA",js,driver);
//			//driver.quit();
//    }
    public static void runCodeSniffer(String Compliences) throws IOException {
    	System.out.println("In Code For sniffer");
    	String jquery_content = Jsoup.connect("http://squizlabs.github.io/HTML_CodeSniffer/build/HTMLCS.js").ignoreContentType(true).execute().body();
    	System.out.println("Content Get Fetched");
    	js.executeScript(jquery_content);
    	System.out.println("Java script Executor Runs");
        js.executeScript("window.HTMLCS_RUNNER.run('"+Compliences+"');");
        System.out.println("Script Run for Specific Com");
        LogEntries logs = driver.manage().logs().get("browser");
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE)); 
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("URL", "Time of Execution", "Report Type", "Detail"));
        ){
        for (LogEntry entry : logs) {
            System.out.println(new Date(entry.getTimestamp()) + " $$" + entry.getLevel() + "$$ " + entry.getMessage());
            csvPrinter.printRecord(driver.getCurrentUrl().toString(), new Date(entry.getTimestamp()).toString(), entry.getLevel().toString(), entry.getMessage().toString());
            csvPrinter.flush(); 
        }
        }
    }
        
    

    
   

    public String getAccessibilityErrors() {
        return null;
    }

    public String getAccessibilityWarnings() {
        return null;
    }

    public String getAccessibilityNotices() {
        return null;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
