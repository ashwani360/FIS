package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.HomePage_Helper;

import cucumber.api.PendingException;

//import java.util.Base64;

//import org.junit.Assert;



//import com.google.common.net.MediaType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
//import java.io.IOException;
//import java.net.URI;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;

//import org.eclipse.jetty.util.Promise;
//import org.json.simple.JSONObject;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

public class Home_Page_Step_Definations {

	private BaseStepDefination contextSteps;
	private HomePage_Helper HomePage;
	public Home_Page_Step_Definations(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		HomePage=new HomePage_Helper(contextSteps.getwebdriver());
	}

@Given("^I am on the Homepage of Google$") 
	public void I_am_on_the_Homepage_of_Google() throws Throwable{

	    System.out.println("Google Search - Step 1");
	    HomePage.verifyTitle();
	};
	
@When("^I enter the \"([^\"]*)\" in test input$")
	public void i_enter_the_in_test_input(String s) throws Throwable {

    System.out.println("Google Search - Step 2");
    HomePage.EnterSearchData(s);
    Thread.sleep(2000);
    //throw new PendingException();
};
@When("^I enter the \"([^\"]*)\" in input box$")
public void i_enter_the_in_input_box(String s) throws Throwable {
	System.out.println("Google Search - Step 2");
    HomePage.EnterSearchData(s);
    Thread.sleep(2000);
    //throw new PendingException();
}
@When("^I select the \"([^\"]*)\" from the suggestion list$")
public void i_select_the_$_SuggestionstoSelect_from_the_suggestion_list(String s) throws Throwable {

    System.out.println("Deposit In step 2");
    HomePage.SelectSuggestions(s);
    Thread.sleep(1000);
    //throw new PendingException();
};




}
