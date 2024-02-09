package restAssuredTests;
import Utils.RestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {

    //https://reqres.in/api/users?page=2&id=5
    @Test
    void testQueryParameters(){

        given()
                .pathParam("mypath","users")
                .queryParam("page",2)
                .queryParam("id",5)
        .when()
                .get("https://reqres.in/api/{mypath}")
        .then()
                .statusCode(200)
                .log().all();

    }
}
