package get_method;
import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class DummyGet05 extends DummyApiBaseUrl {
    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
            This user exists in the system
            {
            "id": 6,
            "employee_name": "Brielle Williamson",
            "employee_salary": 372000,
            "employee_age": 61,
        },
    "message": "Successfully! Record has been fetched."
        },
     */
    @Test
    public void test05(){
        spec.pathParams("first", "api","second", "v1","third","employee", "final","6");
        Response  response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("data.id",equalTo(6),
                "data.employee_name",equalTo("Brielle Williamson"),
                "data.employee_salary",equalTo(372000),
                "data.employee_age",equalTo(61),
                "message",equalTo("Successfully! Record has been fetched."));
    }
}
