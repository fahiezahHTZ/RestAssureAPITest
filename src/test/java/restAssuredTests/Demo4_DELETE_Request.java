package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo4_DELETE_Request {

    //pre-require -api url, id
    int emp_id = 11493;

    @Test
    public void checkDeleteEmployeeRecord(){
        baseURI="http://dummy.restapiexample.com/api/v1";
        basePath="/delete/EMPID"+emp_id;

        Response response = // it will save with Json format
        given(). //if nothing pre-requisite here can remove
        when().
                delete().
        then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all()// print the log in console window
                .extract().response();// this will give the whole response body

       String jsonAsString = response.asString();//we need to convert Json to String
        Assert.assertEquals(jsonAsString.contains("Successfully! deleted record"),true);
    }
}
