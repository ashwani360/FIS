package Runners;


import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;
//import com.vimalselvam.cucumber.listener.Reporter;
import Utils.ProeprtyReader;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(

features = {"src/FeatureFiles/Create.feature"},glue = { "StepsDefinations" },

plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
tags = {"@Regression"},
dryRun=false
)

public class CreateNew extends AbstractTestNGCucumberTests  {
	@AfterClass
	 public static void writeExtentReport() {
	 ProeprtyReader prpertyreader = new ProeprtyReader("Config.properties");
	 System.out.println(System.getProperty("user.dir") +"/"+prpertyreader.getdata("reportConfigPath"));
	 Reporter.loadXMLConfig(new File(System.getProperty("user.dir") +"/"+prpertyreader.getdata("reportConfigPath")));
	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
     Reporter.setSystemInfo("Selenium", "3.7.0");
     Reporter.setSystemInfo("Maven", "3.5.2");
     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}