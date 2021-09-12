package jsonResPkg;

//using org.json to get all keys and values of an object from response
import static com.jayway.restassured.RestAssured.given;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestAndParseUsingOrgjsonAllKeysAndValues {
	public static void main(String[] args) {
		Response res = given().when().contentType(ContentType.JSON).then()
				.get("http://localhost:3000/APIBatchStudents");
		System.out.println("The status code is " + res.statusCode());

		JSONArray ja = new JSONArray(res.asString());
		int length = ja.length();
		for (int i = 0; i < length; i++) { // outer loop
			JSONObject object = ja.getJSONObject(i); // we stored the object here
			Set<String> keys = object.keySet(); // will give all the keys here

			for (String key : keys) {   //inner loop
				System.out.println("Key is " + key + " Value is " + object.get(key));
			}
		}
	}
}
