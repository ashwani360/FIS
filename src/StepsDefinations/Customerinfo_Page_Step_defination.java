package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.CustomerInfoPage_Helper;


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

public class Customerinfo_Page_Step_defination {

	private BaseStepDefination contextSteps;
	private CustomerInfoPage_Helper CustomerInfo;
	public Customerinfo_Page_Step_defination(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		CustomerInfo=new CustomerInfoPage_Helper(contextSteps.getwebdriver());
	}

	@When("^User is click on a \"([^\"]*)\" with name Collect Customer infomration$")
	public void user_is_click_on_a_with_name_Collect_Customer_infomration(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Open a Ticket in Collect Customer Information");
		
		if(!arg1.equals("")) {
		System.out.println("With Data Table");
		CustomerInfo.OpenTicket(arg1,"Data");
		Thread.sleep(5000);
		
		
		}
		else if(!contextSteps.TicketID.equals("")){
			System.out.println("With Global Value");
			CustomerInfo.OpenTicket(contextSteps.TicketID,"Var");
			Thread.sleep(5000);
		}
		else
		{ System.out.println("With Name");
			CustomerInfo.OpenTicketbyName();
			Thread.sleep(5000);
		}
		
		System.out.println("Ticket Id in other method"+contextSteps.TicketID);
	};

	@Then("^Cutomer Detail form should be open$")
	public void cutomer_Detail_form_should_be_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Customer Infomr form should be open");
		CustomerInfo.VerifyCustomerinfopage();
		contextSteps.Run_AccessibilityTest("Collect Customer Detail Page");
	};

	@Then("^User enter \"([^\"]*)\" and \"([^\"]*)\" in the form$")
	public void user_enter_and_in_the_form(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter the name and Phone");
		CustomerInfo.EnterName(arg1);
		CustomerInfo.EnterPhone(arg2);
	};

	@Then("^The Cutomer \"([^\"]*)\" and \"([^\"]*)\" will save in Ticket$")
	public void the_Cutomer_and_will_save_in_Ticket(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Customer Email and Phone get saved");
		CustomerInfo.VerifyName(arg1);
		CustomerInfo.VerifyPhone(arg2);
		contextSteps.Run_AccessibilityTest("Collect Customer Detail Page");
	};

	@Then("^Open Assignment updated as Triage$")
	public void open_Assignment_updated_as_Triage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify the next stage");
		CustomerInfo.VerifyNextstage();
		
	};
	

}
