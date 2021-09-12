package orgTestingWithBodyData;
//POST request using POJO with complex JSON
import orgTestingWithBodyData.AddressDetails;

public class BasicInformation {
	public String firstname;
	public String lastname;
	public String designation;
	public String id;
	public AddressDetails[] address;   //only for PostRequestUsingArrayWithPOJO class
	
	//public AddressDetails address;	//uncomment when using for complex JSON with POJO
									// belong to PostRequestUsingComplexJsonWithPOJO class
	
	//comment out the following 18-23 to run for complex JSON using POJO
	//18-23 is for PostRequestUsingArrayWithPOJO class
		
	public AddressDetails[] getAddress() {
		return address;
	}
	public void setAddress(AddressDetails[] address) {
		this.address = address;
	}
	//comment out the above 18-23 to run for complex JSON using POJO
	
		
	 //uncomment when using for complex JSON with POJO
	 /* public AddressDetails getAddress() {   
		return address;
	}
	public void setAddress(AddressDetails address) {
		this.address = address;
	}*/	
	//		uncomment when using for complex JSON with POJO
	 
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {  //to assign a value to the variable
		this.firstname = firstname;
	}
	public String getLastname() {    // to get a value of a variable
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
