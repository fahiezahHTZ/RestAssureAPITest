package APITest;

//import io.restassured.RestAssured; <-- this one n eed to use Restassure.get()
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestResponse1 {

    @Test
    public void checkResponse(){

        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println("Response"+ response.asString());
        System.out.println("Status code:" +response.getStatusCode());
        System.out.println("Body"+ response.getBody());
        System.out.println("Time taken:"+response.getTime());
        System.out.println("Header:"+ response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test()
    public void checkStatusCode(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().statusCode(200);
    }

}

