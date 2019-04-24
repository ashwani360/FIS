package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.CreateNewPage_Helper;

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

public class CreateNew_Page_Step_defination {

	private BaseStepDefination contextSteps;
	private CreateNewPage_Helper CreateNew;
	public CreateNew_Page_Step_defination(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		
		System.out.println(this.contextSteps);
		CreateNew=new CreateNewPage_Helper(contextSteps.getwebdriver());
	}

	@When("^User is Click on the New button$")
	public void user_is_Click_on_the_New_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("User Clicked on New Link");
		Thread.sleep(6000);
		CreateNew.clickonnew();
		Thread.sleep(1000);
		CreateNew.clickonServicereques();
		Thread.sleep(5000);
	};

	@Then("^Create New should get displayed$")
	public void create_New_should_get_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Verify New Page is open");
		CreateNew.VerifyPageheader();
		contextSteps.Run_AccessibilityTest("Create New Page");
	};

	@Then("^User Select \"([^\"]*)\" and Enter \"([^\"]*)\" in the Form$")
	public void user_Select_and_Enter_in_the_Form(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Enter the Mandatory Fields");
		CreateNew.SelectProduct(arg1);
		CreateNew.EnterIssue(arg2);
	};

	@Then("^Click On Save button$")
	public void click_On_Save_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Clikced on Save button");
		contextSteps.TicketID=CreateNew.ClickSave();
		Thread.sleep(5000);
	};

	@Then("^The \"([^\"]*)\" and \"([^\"]*)\" Case Information will get save$")
	public void the_and_Case_Information_will_get_save(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Verify the Data Entered get saved into the Form");
		CreateNew.VerifyProduct(arg1);
		CreateNew.VerifyIssue(arg2);
	};

	@When("^User Click on the Submit button$")
	public void user_Click_on_the_Submit_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Clikced on Submit button");
		CreateNew.ClickSubmit();
		Thread.sleep(5000);
		contextSteps.Run_AccessibilityTest("Collect Customer Detail Page");
	};

	@Then("^Open Assignment updated as Collect Cutomer Detail$")
	public void open_Assignment_updated_as_Collect_Cutomer_Detail() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify the Next step");
		CreateNew.VerifyNext();
	};

	

	

}
