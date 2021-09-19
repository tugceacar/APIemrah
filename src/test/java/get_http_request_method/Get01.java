package get_http_request_method;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /**
        We will use Gherkin Language.
        In Gherkin Language we use some keywords: Given, When, Then, And

        Given : Begin statement/for prerequisite.   (It declares pre-requisites)
        When  : For action.                         (It is used to declare actions)
        Then  : for outputs/validation.             (It is for outputs)
        And   : For more action.                    (It is used for multiple Given, When, Then)
    */

    /**  ---> Test case:

        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User send a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    /**
        You have to import " @test annotation" in Junit. Junit is a framework.
        After @test annotation, you don't need the main method. We do NOT use main method for test.
     */

    @Test
    public void get01(){

        //1)Set the url
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2)Set the expected data

        //3)Type automation script to send "GET Request" and get "Response"
        Response response = given().when().get(url); //"given().when().get(url)" that code send to request.
        response.prettyPrint(); //print response body on the console.

        /**
        import Given():
        --The mouse cursor put on the Given() and wait little bit then new screen popup, click "More Action".
        then choose "import static method"
        --Change: " Given -> * "
                 "import static io.restassured.RestAssured.given;"
                 "import static io.restassured.RestAssured.*;"
        */


        //4)Do assertion

         /**
         Assert is confirm,verify,check "ispat,teyit".
         It means you got response and, you need to check all.
         like status code, type of context etc.

         HARD ASSERTION: If after the first error, execution stop, it is called HARD ASSERTION.
         SOFT ASSERTION (Verification): All codes will be executed and, you will get report for all assertions

         (If you have multiple errors on Assertion, execution will be stopped in the first error.
         Next codes will not be executed.
         You will not get any error messages about the second, third, etc. errors.
         That kind of assertions are called "HARD ASSERTION")
         */

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //How to print status code, status line, content type, etc. on the console
        System.out.println("Status Code is " + response.getStatusCode());
        System.out.println("Status Line is " + response.getStatusLine());
        System.out.println("Content Type is " + response.getContentType());
        System.out.println("Time is " + response.getTime());
        System.out.println("Headers are \n" + response.getHeaders());
        System.out.println("Via is " + response.getHeader("Via"));


    }

}