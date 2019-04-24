package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.DetailPageHelper;
import StepsDefinationsHelper.FixPage_Helper;

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

public class Fix_Page_Step_defination {

	private BaseStepDefination contextSteps;
	private FixPage_Helper FixPage;
	public Fix_Page_Step_defination(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		FixPage=new FixPage_Helper(contextSteps.getwebdriver());
	}

	@When("^User is click on a \"([^\"]*)\" with name Fix$")
	public void user_is_click_on_a_with_name_Fix(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" Select A ticket with  Fix stage");
		if(!arg1.equals("")) {
			System.out.println("A ticket with Fixed State has been open");
			FixPage.OpenTicketinfix(arg1);
			Thread.sleep(5000);
		}
		else if(!contextSteps.TicketID.equals("")) {
			System.out.println("A ticket with Fixed State has been open");
			FixPage.OpenTicketinfix(contextSteps.TicketID);
			Thread.sleep(5000);
		}
		
		else
		{ System.out.println("With Name");
		FixPage.OpenTicketbyName();
		Thread.sleep(5000);
		}
		
	};

	@Then("^Fix Form should be open$")
	public void fix_Form_should_be_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" Verify Currect Forms opens");
		FixPage.VerifyFixPage();
		contextSteps.Run_AccessibilityTest("Fix Page");
	};

	@Then("^User enter \"([^\"]*)\" of the fix$")
	public void user_enter_of_the_fix(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" Enter Fix Information");
		FixPage.EnterFixDescription(arg1);
	};

	@Then("^The Fix \"([^\"]*)\" will save in Ticket$")
	public void the_Fix_will_save_in_Ticket(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" Verify Detail Saved");
		FixPage.VerifyFixDescription(arg1);
	};

	@Then("^Open Assignment updated as Customer satisfaction \\(Resolved\\)$")
	public void open_Assignment_updated_as_Customer_satisfaction_Resolved() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" Verify Next stage after Fix");
		FixPage.VerifyNextstage();
		
	};

	

}
