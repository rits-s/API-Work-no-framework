package APIBatch.APIWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


//to give {{id}} value at runtime by generating random number
public class ComplexJsonWithIdPassedWithRandomNumberWithPOJO {
			public static void main(String[] args) throws FileNotFoundException, JSONException {
			File f = new File("../APIWork/src/test/java/org/testing/Payloads/ComplexJSONwithIdVariable");
			FileInputStream fis = new FileInputStream(f);
			JSONTokener js = new JSONTokener(fis);// use JSONObject as this is simple JSON object
			JSONObject jo = new JSONObject(js);
			String data = jo.toString();
			// doing it by generating random number for id
			Random r=new Random();
			Integer i = r.nextInt();
			System.out.println(i);
			data = data.replaceAll(Pattern.quote("{{"+"id"+"}}"), i.toString());					
			System.out.println("Data is " + data);

	       // System.out.println(jo.toString()); do this if the string with "{{id}}" is printing in console
			
			// to replace "{{id}}"with hard coded value (not a good approach)
			 /*data = data.replaceAll(Pattern.quote("{{"+"id"+"}}"), "50");
			   System.out.println("Data is " + data);
			 */
		}
}
	

