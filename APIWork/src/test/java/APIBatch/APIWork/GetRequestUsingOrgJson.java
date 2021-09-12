package APIBatch.APIWork;

//GET request + extracting single + multiple + all key value from get response
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetRequestUsingOrgJson {
	public static void main(String[] args) {
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:3000/APIBatchStudents");
		System.out.println("Status code is " + res.statusCode());
		System.out.println("Result is ");
		System.out.println(res.asString());

		// extracting single key from get response using jsonPath
		String sector = res.jsonPath().get("[0].address[0].sector");
		System.out.println("***********The sector is ************ " + sector);

		// extracting single key from get response using org.json
		JSONArray data = new JSONArray(res.asString());
		String reply = data.getJSONObject(0).get("firstname").toString();
		System.out.println("@@@@@@@@@@@@The extracted data is @@@@@@@@@@ " + reply);

		// extracting multiple id's from get response using org.json
		JSONArray jo = new JSONArray(res.asString());
		Integer length = jo.length();
		for (int i = 0; i < length; i++) {
			JSONObject object = jo.getJSONObject(i);
			System.out.println("The firstname is  " + object.get("id"));
		}

		// extracting all the keys and values inside one JSON object from get response
		// using org.json
		JSONArray data1 = new JSONArray(res.asString());
		JSONObject object1 = data1.getJSONObject(0); // we have stored object here
		Set<String> keys = object1.keySet(); // we are giving all the keys

		for (String key : keys) { // will loop through all keys and store each key
			System.out.println("******Key is " + key + " value is " + object1.get(key));
		}

		// extracting all keys & values from multiple JSON objects from get response using org.json
		JSONArray data2 = new JSONArray(res.asString());
		Integer length2 = data2.length();
		for (int i = 0; i < length2; i++) {

			JSONObject object2 = data2.getJSONObject(i); // we have stored object here
			Set<String> keys2 = object2.keySet(); // we are giving all the keys

			for (String key : keys2) { // will loop through all keys and store each key
				System.out.println("^^^^^^^^^^^^^^^Key is " + key + " value is " + object2.get(key));
			}
		}

		// extracting all the keys & values from get response where designation is TL
		// using org.json
		JSONArray data3 = new JSONArray(res.asString());
		Integer length3 = data3.length();
		for (int i = 0; i < length3; i++) {

			JSONObject object3 = data3.getJSONObject(i);
			Set<String> keys3 = object3.keySet();
			for (String key : keys3) {
				if (object3.get(key).equals("TL")) {
					for (String k : keys3) {
						System.out.println("$$$$$$$$$Key is " + k + " value is " + object3.get(k));
					}
				}

			}
		}
	}

}
