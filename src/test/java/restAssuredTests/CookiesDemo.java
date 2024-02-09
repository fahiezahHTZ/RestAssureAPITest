package restAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class CookiesDemo {

    @Test
    void getCookies(){

        given()
        . when()
                .get("https://www.google.com/")
        . then()
                .cookie("ACE","AakniG)LxRQ")
                .log().all();
    }

    @Test
    void getCookiesinfo(){

   Response res =given()
        .when()
               .get("//https:www.google.com");

    //get single cookie into
    // String cookievalue =  res.getCookie("JSESSIONID.365c8af5"); //the value of this particular cookie
    //System.out.println("value of cookie is  "+ cookievalue);

    //get all cookies info
     Map<String,String> cookies_values = res.getCookies();
     //getCookies()->bcoz of return type is Map, we need to store in Map type
   // System.out.println(cookies_values.keySet());//it will return all key only

        for (String k:cookies_values.keySet()) {
            String cookie_value = res.getCookie(k);
            System.out.println(k+" : "+cookie_value);
        }


    }

}
