package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {

    /**
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos
	    And
	        2, 7, and 9 should be among the userIds
     */

    /**
        Test Case Explain:

        When
	 	I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos
	    And Accept type is “application/json”
	    Then
	    HTTP Status Code should be 200
	    And Response format should be “application/json”
	    And there should be 200 todos
	    And “quis eius est sint explicabo” should be one of the todos
	    And 2, 7, and 9 should be among the userIds

     */



    @Test
    public void get04(){

        //1.Step: Set the URL
        spec.pathParam("first", "todos");

        //2.Step: Set the expected data

        //3.Step: Send request and get response
        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}");
        response.prettyPrint();

        //4.Step: Do the assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", hasSize(200)).
                body("title", hasItem("quis eius est sint explicabo")).
                body("userId", hasItems(2, 7, 9));
    }

    /**
     Note = import hasSize:(alt+enter) more action -> import static method -> Matchers.hasSize

            Inside Body(), We use those methods;
            equalTo:  Compare first parameter and second parameter
            hasSize:  Compare number of data
            hasItem:  (check for one item) look at the  in list element, if match with inside hasItem element then test is pass.
            hasItems: (check for multiple items)


     */

}

