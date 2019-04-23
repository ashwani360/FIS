package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.SearchResultPageHelper;
import cucumber.api.PendingException;

//import java.util.Base64;

//import org.junit.Assert;



//import com.google.common.net.MediaType;

import cucumber.api.java.en.Given;
//import java.io.IOException;
//import java.net.URI;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import org.eclipse.jetty.util.Promise;
//import org.json.simple.JSONObject;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

public class Search_Result_Page_StepDefinations {

	private BaseStepDefination contextSteps;
	private SearchResultPageHelper Searchresult;
	public Search_Result_Page_StepDefinations(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		Searchresult=new SearchResultPageHelper(contextSteps.getwebdriver());
	}

	@Then("^Search will displayed the \"([^\"]*)\"$")
	public void search_will_displayed_the(String s) throws Throwable{

	    System.out.println("Result Page - Step 1");
	    Searchresult.verifyLink(s);
	    //throw new PendingException();
	};
	@When("^I Click on the \"([^\"]*)\"$")
	public void i_Click_on_the(String s) throws Throwable {
		System.out.println("Result Page - Step 1");
	    Searchresult.ClickonLink(s);
	    Thread.sleep(2000);
	   // throw new PendingException();
	}
	

	


}
