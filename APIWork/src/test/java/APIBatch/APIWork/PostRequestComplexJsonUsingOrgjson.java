package APIBatch.APIWork;

import org.json.JSONException;
import org.json.JSONObject;
//do import RestAssured and write static keyword for given when then to work and .* in the end
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PostRequestComplexJsonUsingOrgjson {
	// hit post request
	// create data using org.json library
	// create complex JSON data
	public static void main(String[] args) throws JSONException {
		// data created here
		JSONObject address1 = new JSONObject();
		address1.put("houseno","201");
		address1.put("sector","50");
		address1.put("landmark","cinema");
		address1.put("address", "primaryAddress");
		
		JSONObject address2 = new JSONObject();
		address2.put("houseno","500");
		address2.put("sector","10");
		address2.put("address","secondaryAddress");
		
		//putting two inner objects in an outer object 		
		JSONObject outerObject = new JSONObject();
		outerObject.put("firstname", "kelly");
		outerObject.put("lastname", "krauss");
		outerObject.put("age", "27");
		outerObject.put("primaryAddress", address1);
		outerObject.put("secondaryAddress", address2);

		// RestAssured rest = new RestAssured();
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
