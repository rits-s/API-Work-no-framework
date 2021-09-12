package APIBatch.APIWork;

import static com.jayway.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured .*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PostRequestArrayUsingOrgJson {
	public static void main(String[] args) throws JSONException {
		JSONObject address1 = new JSONObject();
		address1.put("houseno","400");
		address1.put("sector","20");
		address1.put("landmark","temple");
		address1.put("address", "primaryAddress");
		
		JSONObject address2 = new JSONObject();
		address2.put("houseno","300");
		address2.put("sector","30");
		address2.put("address","secondaryAddress");
						
		//Putting the two inner objects in an array using JSONArray class	
		JSONArray jsonarray = new JSONArray();
		jsonarray.put(0, address1);
		jsonarray.put(1, address2);
		
		JSONObject outerObject = new JSONObject();
		outerObject.put("firstname", "sally");
		outerObject.put("lastname", "sauser");
		outerObject.put("age", "30");
		outerObject.put("address", jsonarray);

		//Import Response class
		Response res = given()
				.contentType(ContentType.JSON)
				.body(outerObject.toString())
				.when()
				.post("http://localhost:3000/APIBatchStudents");
				//.then() is not mandatory
		
		System.out.println("The status code is " + res.statusCode());
		
	}
}
