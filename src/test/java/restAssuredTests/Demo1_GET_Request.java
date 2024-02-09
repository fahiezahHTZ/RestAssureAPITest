package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo1_GET_Request {

    @Test
    public void getUsers(){
//send - GET request as like Postman
            given()
            .when()
                .get("https://reqres.in/api/users?page=2") //pass req
            .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();
                /*
                .statusLine("HTTP/1.1. 200 OK")
                .assertThat().body("City", equalTo("Hyderabad"))
                .header("content-type", "application/json");
                */

    }
}
