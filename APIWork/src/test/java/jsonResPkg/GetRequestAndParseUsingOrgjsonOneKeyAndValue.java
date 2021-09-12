package jsonResPkg;
// to extract all key values of an object
import static com.jayway.restassured.RestAssured.given;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestAndParseUsingOrgjsonOneKeyAndValue {
	public static void main(String[] args) {
		Response res = given().when().contentType(ContentType.JSON).then()
				.get("http://localhost:3000/APIBatchStudents");
		System.out.println("The status code is " + res.statusCode());

		JSONArray ja = new JSONArray(res.asString());
		JSONObject jo = ja.getJSONObject(0);// we have stored object here
		//for only one object's key and value
		Set<String> keys = jo.keySet(); // will give all the keys here

		for (String key : keys) {
			System.out.println("Key is " + key + " Value is " + jo.get(key));
		}
		
		// for all keys and values
			/*	Integer l = ja.length();
				for (int i=0; i<l;i++) {
					JSONObject j = ja.getJSONObject(i);
					Set<String> keys = j.keySet();
					for(String key:keys)
						System.out.println(key +" "+j.get(key));
				}
			*/	
		}
	}
