package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {

    /**
        Given
            https://restful-booker.herokuapp.com/booking/1
        When
	 		I send GET Request to the url
	 	Then
	 		Response body should be like that;
             {
                 "firstname": "Jim",
                 "lastname": "Ericsson",
                 "totalprice": 747,
                 "depositpaid": true,
                 "bookingdates": {
                 "checkin": "2016-01-28",
                 "checkout": "2018-06-16"
                 },
             "additionalneeds": "Breakfast"
             }

     Process finished with exit code 0

     */

    @Test
    public void get09(){

        //1.Step: Set the url
        spec.pathParams("first", "booking", "second", 1);

        //2.Step: Set the expected data
        Map<String, String> expectedBookingdates = new HashMap<>();
        expectedBookingdates.put("checkin", "2016-09-09");
        expectedBookingdates.put("checkout", "2017-09-21");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jim");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 555);
        expectedData.put("depositpaid", false);
        expectedData.put("bookingdates", expectedBookingdates);
        expectedData.put("additionalneeds","Breakfast");

        System.out.println(expectedData);

        //3.step
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // converting json to java object:
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        //4.Step: Do assertion
//        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
//        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
//        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
//        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
//        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        assertEquals(expectedBookingdates.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(expectedBookingdates.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));

        //Note: get() method comes from Map. we can not use get() for Object.

    }



}