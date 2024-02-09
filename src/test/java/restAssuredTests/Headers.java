package restAssuredTests;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Headers {

    @Test
    public void testHeaders(){

        given()
        .when()
                .get("https://www.google.com/")
        .then()

                .header("Content-Encoding","gzip")
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .log().cookies()
                .log().body()
                .log().headers();


    }

    @Test
    public void getHeaders(){

       Response res = given()
                .when()
                .get("https://www.google.com/");

       //get header info
       //String header_value = res.getHeader("Content-Type");
       // System.out.println(header_value);


    //get all headers info
        io.restassured.http.Headers myheader= res.getHeaders();
        for (Header hd:myheader) {
            System.out.println(hd.getName()+" : "+hd.getValue());
        }

    }

}
