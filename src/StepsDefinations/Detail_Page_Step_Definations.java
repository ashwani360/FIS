package StepsDefinations;

import org.testng.Assert;

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

//import org.eclipse.jetty.util.Promise;
//import org.json.simple.JSONObject;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

public class Detail_Page_Step_Definations {

	private BaseStepDefination contextSteps;
	private DetailPageHelper detailPage;
	public Detail_Page_Step_Definations(BaseStepDefination contextSteps) throws Exception {
		this.contextSteps = contextSteps;
		System.out.println(this.contextSteps);
		detailPage=new DetailPageHelper(contextSteps.getwebdriver());
	}

	@Given("^Detail Page will open$") 
	public void Detail_Page_will_open() throws Throwable{

	    System.out.println("Deposit In step 2");
	    detailPage.verifyDetailPage();
	    Thread.sleep(2000);
	};
	

	

}
