package StepsDefinations;

import org.testng.Assert;

import StepsDefinationsHelper.DetailPageHelper;
import StepsDefinationsHelper.LoginPage_Helper;

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

public class Login_Page_Step_defination {

	private BaseStepDefination contextSteps;
	private LoginPage_Helper LoginPage;
	public Login_Page_Step_defination(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		LoginPage=new LoginPage_Helper(contextSteps.getwebdriver());
	}

	@When("^User is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		Thread.sleep(5000);
		System.out.println("On Login Page");
		LoginPage.verifyLoginpage();
		contextSteps.Run_AccessibilityTest("Login Page");
	};
	
	@Then("^User Enters UserName and Password in the login form$")
	public void user_Enters_UserName_and_Password_in_the_login_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		System.out.println("Entering Username Passeword");
		LoginPage.EnterUsername(contextSteps.pr.getdata("Username"));
		LoginPage.Password(contextSteps.pr.getdata("Password"));
	};
	@Then("^Click on the login button$")
	public void click_on_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Clicked on Login button");
		LoginPage.ClickLogin();
		Thread.sleep(5000);
	};

	@Then("^User is on the Home Page$")
	public void user_is_on_the_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("On Home Page");
		LoginPage.VerifyHomepage();
		contextSteps.Run_AccessibilityTest("DashBoard Page");
		
	};
	

}
