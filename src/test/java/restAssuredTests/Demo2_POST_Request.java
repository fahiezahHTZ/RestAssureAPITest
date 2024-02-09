package restAssuredTests;

import Utils.RestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Demo2_POST_Request {
    int id;
       /*
    @BeforeClass  // to pass data first before check
    public void postData()
    {

        data.put("FirstName", RestUtils.getFirstName());
        data.put("LastName",RestUtils.getLastName());
        data.put("UserName",RestUtils.getUserName());
        data.put("Password",RestUtils.getPassword());
        data.put("Email",RestUtils.getEmail());


        baseURI="http://restapi.demoqa.com/customer";
        basePath="/register";

    }
     */

    @Test(priority = 1)
    public void createUser(){
        HashMap data = new HashMap();
        data.put("name","pavaner");
        data.put("job","trainer");

       id = given()
                .contentType(("application/json"))
                .body(data). // pass body (like in Postman)
        when()
                .post("https://reqres.in/api/users") // POST method
                .jsonPath().getInt("id");

               /*
                .then()
                .statusCode(201)
                .log().all();

                */

    }

    @Test(priority = 2,dependsOnMethods ={"createUser"} )//one create user method pass, can run update user
    public void updateUser(){
        HashMap data1 = new HashMap();

        data1.put("name","John");
        data1.put("job","Teacher");

        given()
                .contentType("application/json")
                .body(data1)
        .when()
                .put("https://reqres.in/api/users/"+id)
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 3)
    public void deleteUser(){
        given()
        .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();

    }


}
