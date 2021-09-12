package APIBatch.APIWork;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import orgTestingWithBodyData.AddressDetails;
import orgTestingWithBodyData.BasicInformation;

//import orgTestingWithBodyDataforPOJO.AddressDetails;
//import orgTestingWithBodyDataforPOJO.BasicInformationOfPerson;

public class PostRequestUsingComplexJsonWithPOJO {
	public static void main(String[] args) {
		//complex body data creation
	AddressDetails address = new AddressDetails();
	address.setHouseno("20");
	address.setLandmark("Mall");
	address.setSector("80");
	
	BasicInformation basic = new BasicInformation();
	basic.setFirstname("Sarah");
	basic.setLastname("Smith");
	basic.setDesignation("TL");
	basic.setId("sarah");
	//set the getter setters for address in Basic information
	//basic.setAddress(address);  //correct this by uncommenting in BasicInformation class
	
	Response res =
	given()
	.contentType(ContentType.JSON)
	.body(basic)
	.when()
	.post("http://localhost:3000/APIBatchStudents");
	
	System.out.println("The status code is " + res.statusCode());
	
}
}
