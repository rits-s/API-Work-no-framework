package APIBatch.APIWork;
//POST request using POJO with Simple JSON
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import orgTestingWithBodyData.BasicInformation;

public class PostRequestUsingBodyDataUsingPOJO {
	public static void main(String[] args) {
		// defined the data using POJO concept
		BasicInformation basic = new BasicInformation();
		basic.setFirstname("John");
		basic.setLastname("Doe");
		basic.setDesignation("TL");
		basic.setId("john");

		// hit the POST request
		Response res = given().contentType(ContentType.JSON).body(basic).when()
				.post("http://localhost:3000/APIBatchStudents");

		System.out.println("The status code is " + res.statusCode());

	}
}
