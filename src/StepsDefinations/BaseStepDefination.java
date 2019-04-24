package StepsDefinations;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.reflect.FieldUtils;
import org.json.JSONException;
import org.openqa.selenium.By;

//import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Utils.AccessibilitySniffer;

import Utils.CreateCycleAndAddTests;
import Utils.ProeprtyReader;
import Utils.SeleniumTest;
import cucumber.api.DataTable;

//import com.google.common.net.MediaType;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;

//import org.eclipse.jetty.util.Promise;
//import org.json.simple.JSONObject;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

public class BaseStepDefination extends SeleniumTest{
	//public WebDriver driver;
	private static boolean initialized = false;
	public static String zephyrBaseUrl ;
 	// zephyr accessKey , we can get from Addons >> zapi section
 	public static String accessKey ;
 	public static String secretKey;
 	public static String accountId;
 	public static Long projectId;
 	public static Long versionId;
 	public static String Cycleid ;
 	public static boolean cyclecreated=false;
 	public static Map<String, String> CurrentExecutionID = new HashMap<String, String>();
 	public static String TicketID="";
 	ProeprtyReader pr=new ProeprtyReader("Config.properties");
	CreateCycleAndAddTests zp=new CreateCycleAndAddTests();
	public AccessibilitySniffer accessibilitySniffer;

	@Before
	   public void setUp(Scenario s) throws Exception {
	      if (!initialized) {
	    	  System.out.println("Cycle created in :"+cyclecreated);
		  		//Properties pr=new Properties();
	    	  if(!cyclecreated) {
	  		zephyrBaseUrl=pr.getdata("ZephyreBaseURL");
	  		accessKey=pr.getdata("AccessKey");
	  		secretKey=pr.getdata("SecreteKey");
	  		accountId=pr.getdata("Jirausername");
	  		projectId=Long.parseLong(pr.getdata("projectId"));
			versionId = Long.parseLong(pr.getdata("versionId"));
			Cycleid=zp.Cyclecreation(zephyrBaseUrl, accessKey, secretKey, accountId,projectId,versionId);
	        System.out.println(zephyrBaseUrl);
	        System.out.println(accessKey);
	        System.out.println(secretKey);
	        System.out.println(accountId);
	        System.out.println(projectId);
	        System.out.println(versionId);
	        System.out.println(versionId);
	        cyclecreated=true;
	    	}
			this.Launchbrowser();
			System.out.println("Browser Launched");
	        this.addTestcaseinTestcycle(s,this.getwebdriver(),Cycleid);
	        this.GetAllExecutions(this.getwebdriver(),Cycleid);
			//zp.GetTestcaseId(zephyrBaseUrl, accessKey, secretKey, accountId,"FD-3");
	        accessibilitySniffer=new AccessibilitySniffer(driver);
	        initialized = true;
	      }
	      
	   }
	
	public void addTestcaseinTestcycle(Scenario s,WebDriver dr, String Cycleid) throws JSONException, IllegalStateException, URISyntaxException, IOException
	{  List<String> stag=(List<String>) s.getSourceTagNames();
	Collections.sort(stag);
//	for(int i=0;i<=stag.size()-1;i++)
//	{
//		System.out.println(stag.get(i).toString());
//	}
	
		System.out.println(stag.get(0).toString());
		System.out.println(stag.get(0).toString().substring(1, stag.get(0).toString().length()));
		System.out.println(Cycleid.toString());
		zp.Testcaseaddition(zephyrBaseUrl, accessKey, secretKey, accountId,projectId,versionId,Cycleid.toString(),stag.get(0).toString().substring(1, stag.get(0).toString().length()));
	}
	public void GetAllExecutions(WebDriver dr,String Cycleid) throws JSONException, IllegalStateException, URISyntaxException, IOException
	{  //List<String> stag=(List<String>) s.getSourceTagNames();
		//System.out.println(stag.get(0).toString());
		//System.out.println(Cycleid.toString());
		CurrentExecutionID=zp.GetAllExecutions(zephyrBaseUrl, accessKey, secretKey, accountId,projectId,versionId,Cycleid.toString());
	}
	
	//UpdateStatus(zephyrBaseUrl, accessKey, secretKey,accountId,pid,vid, "1", CurrentExecutionID, CycleID, stag.get(stag.size()-1).toString().substring(1, stag.get(stag.size()-1).toString().length()))
	@After
	public void Teardown(Scenario s) throws Throwable{
		
		//System.out.println("Current Error in Screen"+Reporter.getCurrentTestResult().getName().toString());
		//System.out.println("Current Error in Screen2"+Reporter.getCurrentTestResult().getStatus());
		//System.out.println("Current Attributes"+Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().);
		String Error = "Test Has been Passed";
		Field field = FieldUtils.getField(((ScenarioImpl) s).getClass(), "stepResults", true);
		   field.setAccessible(true);
		   try {
		       ArrayList<Result> results = (ArrayList<Result>) field.get(s);
		       for (Result result : results) {
		           if (result.getError() != null)
		               System.out.println("Error Thrown Was:"+result.getError().toString());
		           System.out.println("Message for Error Thrown Was:"+result.getError().getMessage());
		           Error="Error Thrown Was:"+result.getError().toString();
		       } 
		   } catch (Exception e) {
			   System.out.println("Error while logging error"+e.toString()+"-"+e.getMessage().toString());
			   Error=e.toString()+"-"+e.getMessage().toString();
		   }
		
		List<String> stag=(List<String>) s.getSourceTagNames();
		this.tidyUp(Error,s,this.getwebdriver(),zephyrBaseUrl,accessKey,secretKey,accountId,projectId,versionId,CurrentExecutionID,Cycleid.toString(),stag.get(stag.size()-1).toString().substring(1, stag.get(stag.size()-1).toString().length()));

		initialized = false;
	}
	
	@Then("^Run the Accessibility Test$") 
	public void Run_AccessibilityTest(String page) throws Throwable{

	    System.out.println("In Accessibilty Test for:"+pr.getdata("Accessibility_Comp"));
	    accessibilitySniffer.runCodeSniffer(pr.getdata("Accessibility_Comp"),page);
	    //Thread.sleep(2000);
	};	
	
	public WebDriver getwebdriver(){
		return driver;
		
	}
}
