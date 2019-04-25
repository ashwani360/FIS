package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.CustomerSatisfactionPage_Helper;
import StepsDefinationsHelper.DetailPageHelper;

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

public class CustomerSatisfaction_Page_Step_defination {

	private BaseStepDefination contextSteps;
	private CustomerSatisfactionPage_Helper CustomerSatisfaction;
	public CustomerSatisfaction_Page_Step_defination(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		CustomerSatisfaction=new CustomerSatisfactionPage_Helper(contextSteps.getwebdriver());
	}

	@When("^User is click on a \"([^\"]*)\" with name Resolve$")
	public void user_is_click_on_a_with_name_Fix(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		if(!arg1.equals("")) {
			System.out.println("A ticket with Fixed State has been open");
			CustomerSatisfaction.OpenTicketinresolve(arg1,"Data");
			Thread.sleep(5000);
		}
		else if(!contextSteps.TicketID.equals("")) {
			System.out.println("A ticket with Fixed State has been open");
			CustomerSatisfaction.OpenTicketinresolve(contextSteps.TicketID,"Var");
			Thread.sleep(5000);
		}
		
		else
		{ System.out.println("With Name");
			CustomerSatisfaction.OpenTicketbyName();
			Thread.sleep(5000);
		}
		
	};

	@Then("^Customer Satisfaction Form should be open$")
	public void customer_Satisfaction_Form_should_be_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Customer Satisfaction Page gets open");
		CustomerSatisfaction.VerifyCustomerSatisfactionPage();
		contextSteps.Run_AccessibilityTest("Customer Satisfaction Page");
	};

	@Then("^User enter \"([^\"]*)\" details$")
	public void user_enter_details(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Desription infomration gets entered");
		CustomerSatisfaction.SelectNPSscore(arg1);
	};

	@Then("^The Cutomer Satisfaction \"([^\"]*)\" will save in Ticket$")
	public void the_Cutomer_Satisfaction_will_save_in_Ticket(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify Desription infomration gets updated");
		CustomerSatisfaction.VerifyNPSScore(arg1);
	};
	

	@Then("^Thank you message will get displayed$")
	public void thank_you_message_will_get_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Verify Thanksyou message gets displayed");
		CustomerSatisfaction.VerifyNextstage();
		contextSteps.Run_AccessibilityTest("Close Service Request Page");
		
	};
	

}
