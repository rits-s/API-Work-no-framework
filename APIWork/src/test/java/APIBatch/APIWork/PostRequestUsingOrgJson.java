package APIBatch.APIWork;
// POST Request using Simple JSON 

import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
//manually add static and .* to the rest assured package name
import static com.jayway.restassured.RestAssured.*;

public class PostRequestUsingOrgJson {
	// create data using org.json library
	// create simple JSON data
	// hit post request
	public static void main(String[] args) throws JSONException {
		// data ready(created)
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("firstname", "jack");
		jsonobject.put("lastname", "joe");
		jsonobject.put("age", "28");

		// RestAssured rest = new RestAssured(); // for restassured library, put .* in the import
		//Import Response class
		Response res = given()
				.contentType(ContentType.JSON)
				.body(jsonobject.toString())
				.when()
				.post("http://localhost:3000/APIBatchStudents");
				//.then() is not mandatory		
		System.out.println("The status code is " + res.statusCode());
	}
}
