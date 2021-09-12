package jsonResPkg;

import static com.jayway.restassured.RestAssured.given;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestAndParseUsingOrgjsonAllKeysAndValuesForDesignationTL {
	public static void main(String[] args) {
		Response res = given().when().contentType(ContentType.JSON).then()
				.get("http://localhost:3000/APIBatchStudents");
		System.out.println("The status code is " + res.statusCode());

		JSONArray ja = new JSONArray(res.asString());
		int length = ja.length();
		for (int i = 0; i < length; i++) {
			JSONObject object = ja.getJSONObject(i);// we have stored object here
			Set<String> keys = object.keySet(); // will give all the keys here
			
			for (String key : keys) {
				if (object.get(key).equals("TL")) {
					for (String k : keys)
						System.out.println("Key is " + k + " Value is " + object.get(k));
				}
			}
		}
	}
}