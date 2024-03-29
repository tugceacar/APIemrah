package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Get08 extends JsonPlaceHolderBaseUrl {

    /**
    The biggest challenge in API Testing is data type
    1)  Java uses Objects and Primitives as data type, API uses XML, Json, etc.
        Java and API are using different data types. buy they should communicat with each other.
        Communication is impossible with different data types.


    We have 2 options :
    i) Convert Jason to Java Object ==> De-Serialization
    ii) Convert Java Onject to Json ==> Serialization

    For Serialization and De-Serialization , we have 2 option
    a) GSON  --> Google created it (We use this one Gson)
    b) Object Mapper --> More popular

     */

    /*
    Given
        https://jsonplaceholder.typicode.com/todos/2
    When
        I send GET Request to the URL
    Then
        Status code is 200
        And "completed" is false
        And "userId" is 1
        And "title" is "quis ut nam facilis et officia qui"
        And header "Via" is "1.1 Vegur"
        And header "Server" is "cloudflare"

        {
            "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
        }
    */

    @Test
    public void get08(){

        //1.step: set the url
        spec.pathParams("first","todos","second",2);

        //2.step: set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        expectedData.put("Status Code", 200);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server","cloudflare");
        System.out.println(expectedData);

        //3.step: send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //as() method comes from GSON.
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        //4.step: Do assertions
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("Status Code"), response.getStatusCode());
        assertEquals(expectedData.get("via"), response.getHeader("Via"));
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));

    }
}
