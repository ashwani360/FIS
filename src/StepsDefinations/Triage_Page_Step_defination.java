package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.DetailPageHelper;
import StepsDefinationsHelper.TriagePage_Helper;

//import java.util.Base64;

//import org.junit.Assert;



//import com.google.common.net.MediaType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import java.io.IOException;
//import java.net.URI;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
import cucumber.api.java.en.When;

//import org.eclipse.jetty.util.Promise;
//import org.json.simple.JSONObject;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

public class Triage_Page_Step_defination {

	private BaseStepDefination contextSteps;
	private TriagePage_Helper TriagePage;
	public Triage_Page_Step_defination(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		TriagePage=new TriagePage_Helper(contextSteps.getwebdriver());
	}

	@When("^User is click on a \"([^\"]*)\" with name Triage$")
	public void user_is_click_on_a_with_name_Triage(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Open a Ticket with Triage");
		TriagePage.OpenTicketforTriage(arg1);
	};

	@Then("^Triage Form should be open$")
	public void triage_Form_should_be_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify Triage Form Opens");
		TriagePage.VerifyTriagePage();
	};

	@Then("^User enter \"([^\"]*)\" of the Ticket$")
	public void user_enter_of_the_Ticket(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter Priority");
		TriagePage.SelectPriority(arg1);
	};

	@Then("^The Triage \"([^\"]*)\" will save in Ticket$")
	public void the_Triage_will_save_in_Ticket(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify  Priority");
		TriagePage.VeryPriority(arg1);
	};

	@Then("^Open Assignment updated as Fix$")
	public void open_Assignment_updated_as_Fix() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify Next Stage");
		TriagePage.VerifyNextstage();
	};
	

	

}
