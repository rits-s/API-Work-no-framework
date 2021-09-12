package jsonResPkg;
//using jsonPath to get a single value from response
import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestAndParseUsingJsonPath {
	public static void main(String[] args) {
		Response res=
		given()
		.when()
		.contentType(ContentType.JSON)
		.then()
		.get("http://localhost:3000/APIBatchStudents");
		System.out.println("The status code is "+ res.statusCode());
		/*System.out.println("The data is");
		System.out.println(res.asString());*/
		
		String firstname=res.jsonPath().get("[0].firstname");
		System.out.println("Firstname is " +firstname);
	}
}
