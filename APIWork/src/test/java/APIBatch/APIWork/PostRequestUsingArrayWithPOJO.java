package APIBatch.APIWork;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import orgTestingWithBodyData.AddressDetails;
import orgTestingWithBodyData.BasicInformation;

public class PostRequestUsingArrayWithPOJO {
	public static void main(String[] args) {
		
		//complex body data creation in the form of array using POJO from
	    //BasicInformation and AddressDetails class
		 
	    AddressDetails[] address = new AddressDetails[2];
		address[0] = new AddressDetails();
		address[0].setHouseno("20");
		address[0].setLandmark("Mall");
		address[0].setSector("80");

		address[1] = new AddressDetails();
		address[1].setHouseno("20");
		address[1].setLandmark("Mall");
		address[1].setSector("80");

		BasicInformation basic = new BasicInformation();
		basic.setFirstname("Leo");
		basic.setLastname("Lee");
		basic.setDesignation("TL");
		basic.setId("leo1");
		// set the getter setters for AddressDetails[] for array in BasicInformation class		
		basic.setAddress(address);

		Response res = given().contentType(ContentType.JSON).body(basic).when()
				.post("http://localhost:3000/APIBatchStudents");

		System.out.println("The status code is " + res.statusCode());

	}
}
