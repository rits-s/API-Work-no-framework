package jsonResPkg;
//using org.json to get a single value from response
import static com.jayway.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestAndParseUsingOrgjson {
	public static void main(String[] args) throws JSONException {
		Response res=
		given()
		.when()
		.contentType(ContentType.JSON)
		.then()
		.get("http://localhost:3000/APIBatchStudents");
		System.out.println("The status code is "+ res.statusCode());
		
		JSONArray jsonarray =new JSONArray(res.asString());
		String firstname = jsonarray.getJSONObject(1).get("firstname").toString();
		System.out.println("Firstname is " + firstname);
	}
}
