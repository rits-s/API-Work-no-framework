package jsonResPkg;

//using org.json to get a all id's from response
import static com.jayway.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestAndParseUsingOrgjsonAllFirstname {
	public static void main(String[] args) throws JSONException {
		Response res = given().when().contentType(ContentType.JSON).then()
				.get("http://localhost:3000/APIBatchStudents");
		System.out.println("The status code is " + res.statusCode());
		
		JSONArray array = new JSONArray(res.asString());

		int length = array.length();
		for (int i = 0; i < length; i++) {

			JSONObject object = array.getJSONObject(i);
			System.out.println("Id is " + object.get("id"));

		}
	}
}
