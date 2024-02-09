package APIChaning;
import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateUser {


    @Test
    public void testUpdateUser(ITestContext context){

        Faker fk = new Faker();
        //here will use JSON object class, we can user other way ..HashMap..ets
        JSONObject data = new JSONObject();
        data.put("name",fk.name().firstName());
        data.put("gender","female");
        data.put("email",fk.internet().emailAddress());
        data.put("status","active");

      //  int id = (Integer) context.getAttribute("user_id");
        int id = (Integer) context.getSuite().getAttribute("user_id");
        String barerToken = "117eebe2cf0b3d0ce7f147f722dfe25fe89bdec3911ecf9782f149edcdcabb01";
        given()
                .headers("Authorization","Bearer "+barerToken)//for barer-need to give Bearer also
                .contentType("application/json")
                .pathParam("id",id)
                .body(data.toString()) //data is JSON obj-needs to convert as String
        .when()
                .put("https://gorest.co.in/public/v2/users/{id}")
        .then()
                .statusCode(200)
                .log().all();


    }

}
