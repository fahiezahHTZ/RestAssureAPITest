package APIChaning;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;



public class CreateUser {

    //pre-requisite for create user
    //url
    //create request body- user data,

    //to create req body, use JSON Object class
    // dynamically create -->generate data - use Faker
    //access token/auth

    @Test
   void test_createUser(ITestContext context){
        Faker fk = new Faker();
        //here will use JSON object class, we can user other way ..HashMap..ets
        JSONObject data = new JSONObject();
        data.put("name",fk.name().firstName());
        data.put("gender","Male");
        data.put("email",fk.internet().emailAddress());
        data.put("status","inactive");

        String barerToken = "117eebe2cf0b3d0ce7f147f722dfe25fe89bdec3911ecf9782f149edcdcabb01";
       int  id =//instead of storing all body, only need to get id
                 given()
                        .headers("Authorization","Bearer "+barerToken)//for barer-need to give Bearer also
                        .contentType("application/json")
                        .body(data.toString()) //data is JSON obj-needs to convert as String
                 .when()
                         .post("https://gorest.co.in/public/v2/users")
                         .jsonPath().getInt("id");//instead of getting other values
            System.out.println("Generated id : "+ id);
        //context.setAttribute("user_id", id);//generating global var within test level
        context.getSuite().setAttribute("user_id",id); //suite level
   }



}
