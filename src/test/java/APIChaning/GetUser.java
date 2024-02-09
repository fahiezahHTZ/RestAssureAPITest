package APIChaning;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

import org.testng.annotations.Test;

public class GetUser {

    @Test
    public void getUser(ITestContext context){

        //int id = (Integer) context.getAttribute("user_id);
        int id = (Integer) context.getSuite().getAttribute("user_id");

       //this should come from create user request
        String barerToken ="117eebe2cf0b3d0ce7f147f722dfe25fe89bdec3911ecf9782f149edcdcabb01";

        given()//we need to know what we need to pass?
                .headers("Authorization", "Bearer "+barerToken)
                .pathParam("id",id)
        .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
        .then()
                .statusCode(200)
                .log().all();
        System.out.println("id:"+id);


    }



}
