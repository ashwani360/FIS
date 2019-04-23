package Runners;


import cucumber.api.CucumberOptions;
import java.io.*;

import org.testng.annotations.AfterClass;

import java.io.*;
import com.cucumber.listener.Reporter;
//import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import Utils.ProeprtyReader;

//@RunWith(Cucumber.class)

@CucumberOptions(

features = {"src/FeatureFiles/Google_Search2.feature"},glue = { "StepsDefinations" },

plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
tags = {"@Regression"},
dryRun=false
)

public class Search2 extends AbstractTestNGCucumberTests  {
	@AfterClass
	 public static void writeExtentReport() {
	 ProeprtyReader prpertyreader = new ProeprtyReader("Config.properties");
	 Reporter.loadXMLConfig(new File(System.getProperty("user.dir") +prpertyreader.getdata("reportConfigPath")));
	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
     Reporter.setSystemInfo("Selenium", "3.7.0");
     Reporter.setSystemInfo("Maven", "3.5.2");
     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}