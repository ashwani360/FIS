
package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.json.JSONObject;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;


public class CreateCycleAndAddTests {
	
	Map<String, String> executionIds = new HashMap<String, String>();
	
	public static String Cyclecreation(String zephyrBaseUrl, String accessKey, String secretKey, String accountId,long pid,long vid) throws URISyntaxException, JarException, IllegalStateException, JSONException, IOException {
		// Replace zephyr baseurl <ZAPI_Cloud_URL 557058> shared with the user for ZAPI Cloud
		
		ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
				.build();

		/** Declare the Variables here **/
		
		String cycleName = "Test Cycle -- API DEMO"+System.currentTimeMillis();
		String cycleDescription = "Created by ZAPI CLOUD API";
		
		String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/cycle?expand=&clonedCycleId=";
		
		/** Cycle Object created - DO NOT EDIT **/
		JSONObject createCycleObj = new JSONObject();
		createCycleObj.put("name", cycleName);        			
		createCycleObj.put("description", cycleDescription);			
		createCycleObj.put("startDate", System.currentTimeMillis());
		createCycleObj.put("projectId", pid);
		createCycleObj.put("versionId", vid);

		StringEntity cycleJSON = null;
		try {
			cycleJSON = new StringEntity(createCycleObj.toString());
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		CreateCycleAndAddTests cc = new CreateCycleAndAddTests();
		String cycleID = cc.createCycle(createCycleUri, client, accessKey, cycleJSON);
		System.out.println("Cycle Created with Cycle Id :" + cycleID);
        return cycleID;
		/**
		 * Add tests to Cycle IssueId's
		 * 
		 */
	}
	public static void Testcaseaddition(String zephyrBaseUrl, String accessKey, String secretKey, String accountId,long pid,long vid,String cycleID,String Testcasekey) throws URISyntaxException, JSONException, IllegalStateException, IOException {
			
		String addTestsUri = zephyrBaseUrl + "/public/rest/api/1.0/executions/add/cycle/" + cycleID;
		String[] issueIds = { Testcasekey }; //Issue Id's to be added to Test Cycle, add more issueKeys separated by comma

		JSONObject addTestsObj = new JSONObject();
		addTestsObj.put("issues", issueIds);
		addTestsObj.put("method", "1");
		addTestsObj.put("projectId", pid);
		addTestsObj.put("versionId", vid);
		ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
				.build();
		StringEntity addTestsJSON = null;
		try {
			addTestsJSON = new StringEntity(addTestsObj.toString());
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		CreateCycleAndAddTests cc = new CreateCycleAndAddTests();
		String ID = cc.addTestsToCycle(addTestsUri, client, accessKey, addTestsJSON);
		System.out.println("Tests added successfully "+ID);
		String latestexecution = zephyrBaseUrl + "/public/rest/api/1.0/execution/";
		JSONObject ExecutionsObj = new JSONObject();
		//ExecutionsObj.put("issueId", issueIds);
		
		//ExecutionsObj.put("projectId", pid);
		//ExecutionsObj.put("versionId", vid);
		//ExecutionsObj.put("cycleId", cycleID);
		String addExecutionUri = latestexecution;
		
		//issueId=issueId&projectId=pid&versionId=vid&cycleId=cycleID
				StringEntity addExecutionJSON = null;
		try {
			addExecutionJSON = new StringEntity(ExecutionsObj.toString());
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		CreateCycleAndAddTests ccc = new CreateCycleAndAddTests();
		HttpResponse response = null;
		//String executionid = ccc.GetExecution(addExecutionUri, client, accessKey, addExecutionJSON);
		//System.out.println("Execution ID"+executionid);
	}
	public static Map<String, String> GetAllExecutions(String zephyrBaseUrl, String accessKey, String secretKey, String accountId,long pid,long vid,String cycleID) throws URISyntaxException, JarException, IllegalStateException, JSONException, IOException {
		 
		Map<String, String> executionIds = new HashMap<String, String>();
		ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
				.build();
		final String getExecutionsUri = zephyrBaseUrl+"/public/rest/api/1.0/executions/search/cycle/" + cycleID + "?projectId="
				+ pid + "&versionId=" + vid;

		executionIds = getExecutionsByCycleId(getExecutionsUri, client, accessKey);
		System.out.println("Execution ID"+executionIds);
		return executionIds;
	}
	
	
	public static void UpdateStatus(String zephyrBaseUrl, String accessKey, String secretKey, String accountId,long pid,long vid, String status,Map<String,String> executionmapes, String CycleID, String Testcaseid,String Comment) throws URISyntaxException, JarException, IllegalStateException, JSONException, IOException {
		// Replace zephyr baseurl <ZAPI_Cloud_URL 557058> shared with the user for ZAPI Cloud
		ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
				.build();
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		JSONObject statusObj = new JSONObject();
		statusObj.put("id", status);

		JSONObject executeTestsObj = new JSONObject();
		executeTestsObj.put("status", statusObj);
		executeTestsObj.put("cycleId", CycleID);
		executeTestsObj.put("projectId", String.valueOf(pid));
		executeTestsObj.put("versionId", String.valueOf(vid));
		executeTestsObj.put("comment", Comment);
		Map<String,String> map=new HashMap<String,String>();          
	    map.put("ExecutionID",executionmapes.get(Testcaseid));
	    map.put("TestcaseID",Testcaseid);
	    final String updateExecutionUri = zephyrBaseUrl+"/public/rest/api/1.0/execution/" + map.get("ExecutionID");
	    executeTestsObj.put("issueId", map.get("TestcaseID"));
		// System.out.println(executeTestsObj.toString());
		StringEntity executeTestsJSON = null;
		try {
			executeTestsJSON = new StringEntity(executeTestsObj.toString());
			} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		updateExecutions(updateExecutionUri, client, accessKey, executeTestsJSON);
	
	}
	
	public static String updateExecutions(String uriStr, ZFJCloudRestClient client, String accessKey,
			StringEntity executionJSON) throws URISyntaxException, JSONException, ParseException, IOException {

		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);
		// System.out.println(uri.toString());
		// System.out.println(jwt);

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();

		HttpPut executeTest = new HttpPut(uri);
		executeTest.addHeader("Content-Type", "application/json");
		executeTest.addHeader("Authorization", jwt);
		executeTest.addHeader("zapiAccessKey", accessKey);
		executeTest.setEntity(executionJSON);

		try {
			response = restClient.execute(executeTest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int statusCode = response.getStatusLine().getStatusCode();
		// System.out.println(statusCode);
		String executionStatus = "No Test Executed";
		// System.out.println(response.toString());
		HttpEntity entity = response.getEntity();

		if (statusCode >= 200 && statusCode < 300) {
			String string = null;
			try {
				string = EntityUtils.toString(entity);
				JSONObject executionResponseObj = new JSONObject(string);
				JSONObject descriptionResponseObj = executionResponseObj.getJSONObject("execution");
				JSONObject statusResponseObj = descriptionResponseObj.getJSONObject("status");
				executionStatus = statusResponseObj.getString("description");
				System.out.println(executionResponseObj.get("issueKey") + "--" + executionStatus);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			try {
				String string = null;
				string = EntityUtils.toString(entity);
				JSONObject executionResponseObj = new JSONObject(string);
				//cycleId = executionResponseObj.getString("clientMessage");
				System.out.println(executionResponseObj.toString());
				throw new ClientProtocolException("Unexpected response status: " + statusCode);

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			}
		}
		return executionStatus;
	}
	
	public String createCycle(String uriStr, ZFJCloudRestClient client, String accessKey, StringEntity cycleJSON)
			throws URISyntaxException, JSONException {

		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
		System.out.println(uri.toString());
		System.out.println(jwt);

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();

		HttpPost createCycleReq = new HttpPost(uri);
		createCycleReq.addHeader("Content-Type", "application/json");
		createCycleReq.addHeader("Authorization", jwt);
		createCycleReq.addHeader("zapiAccessKey", accessKey);
		createCycleReq.setEntity(cycleJSON);

		try {
			response = restClient.execute(createCycleReq);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		String cycleId = "-1";
		if (statusCode >= 200 && statusCode < 300) {
			HttpEntity entity = response.getEntity();
			String string = null;
			try {
				string = EntityUtils.toString(entity);
				JSONObject cycleObj = new JSONObject(string);
				cycleId = cycleObj.getString("id");
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				throw new ClientProtocolException("Unexpected response status: " + statusCode);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			}
		}
		return cycleId;
	}

	public String addTestsToCycle(String uriStr, ZFJCloudRestClient client, String accessKey, StringEntity addTestsJSON)
			throws URISyntaxException, JSONException, IllegalStateException, IOException {

		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
		System.out.println(uri.toString());
		System.out.println(jwt);

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();

		HttpPost addTestsReq = new HttpPost(uri);
		addTestsReq.addHeader("Content-Type", "application/json");
		addTestsReq.addHeader("Authorization", jwt);
		addTestsReq.addHeader("zapiAccessKey", accessKey);
		addTestsReq.setEntity(addTestsJSON);

		try {
			response = restClient.execute(addTestsReq);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		System.out.println(response.toString());
		String string = null;
		if (statusCode >= 200 && statusCode < 300) {
			HttpEntity entity = response.getEntity();			
			try {
				string = EntityUtils.toString(entity);
				//System.out.println(string);
				JSONObject cycleObj = new JSONObject(entity);
				System.out.println("Test case Added"+cycleObj.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				throw new ClientProtocolException("Unexpected response status: " + statusCode);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	public static Map<String, String> getExecutionsByCycleId(String uriStr, ZFJCloudRestClient client,
			String accessKey) throws URISyntaxException, JSONException {
		Map<String, String> executionIds = new HashMap<String, String>();
		System.out.println("URI String is "+uriStr);
		System.out.println("Client is"+client.toString());

		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);
		System.out.println(uri.toString());
		System.out.println(jwt);

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Authorization", jwt);
		httpGet.setHeader("zapiAccessKey", accessKey);

		try {
			response = restClient.execute(httpGet);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status for the Execution Id's"+statusCode);

		if (statusCode >= 200 && statusCode < 300) {
			HttpEntity entity1 = response.getEntity();
			String string1 = null;
			try {
				string1 = EntityUtils.toString(entity1);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// System.out.println(string1);
			JSONObject allIssues = new JSONObject(string1);
			JSONArray IssuesArray = allIssues.getJSONArray("searchObjectList");
			// System.out.println(IssuesArray.length());
			if (IssuesArray.length() == 0) {
				return executionIds;
			}
			for (int j = 0; j <= IssuesArray.length() - 1; j++) {
				JSONObject jobj = IssuesArray.getJSONObject(j);
				JSONObject jobj2 = jobj.getJSONObject("execution");
				System.out.println("Complete list"+jobj2.toString());
				String executionId = jobj2.getString("id");
				System.out.println("Test Execution ID is"+executionId);
				long IssueId = jobj2.getLong("issueId");
				System.out.println("Test Execution ID is"+IssueId);
				executionIds.put(String.valueOf(IssueId),executionId);
				//String issuesKey = jobj2.getString("issueKey");
				//System.out.println("Test Execution Key is"+issuesKey);
			}
		}
		return executionIds;
	}
}