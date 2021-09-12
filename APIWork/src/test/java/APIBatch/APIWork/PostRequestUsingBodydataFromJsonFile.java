package APIBatch.APIWork;
//POST request using external JSON file
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PostRequestUsingBodydataFromJsonFile {
	public static void main(String[] args) throws FileNotFoundException, JSONException {
		File f = new File("../APIWork/src/test/java/org/testing/Payloads/SimpleJson.json");
		FileInputStream fis = new FileInputStream(f);
		JSONTokener js = new JSONTokener(fis);
		// use JSONObject as this is simple JSON object
		JSONObject jo = new JSONObject(js);

		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(jo.toString())
				.when()
				.post("http://localhost:3000/APIBatchStudents");
		System.out.println("The status code is " + res.statusCode());
	}
}
