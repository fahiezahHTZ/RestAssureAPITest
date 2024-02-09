package authorizationAndAuthentication;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authentications {

    @Test(priority = 1)
    public void testBasicAuthentication() {

        given()
                .auth().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }

    @Test(priority = 2)
    public void testDigetAuthentication() {

        given()
                .auth().digest("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }

    @Test(priority = 3)
    public void testPreemptiveAuthentication() {

        given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }

    @Test(priority = 4)
    public void testBearerTokenAuthentication() {

        String myBearerToken = "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";
        //this token i generated from my github repository
        given()
                .headers("Authorization", "Bearer " + myBearerToken)
                .when()
                .get("https://github.com/fahiezahHTZ")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 5)
    public void testOAuth1Authentication() {

        given()
                .auth().oauth("consumerKey", "consumerSecret", "accessToken", "TokenSecret")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 6)
    public void testOAuth2Authentication() {

        given()
                .auth().oauth2("AccessTOKEN") //here we need first 2 steps manually, to get a token then we can add here
        .when()
                .get("url")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 7)
    public void testAPIKeyAuthentication() {

        given()
                .queryParam("appid","apikey's value")//according to api mentioned how to pass, we have to add
                //whether it needs to pass by headers() or queryParam...etc
        .when()
                .get("https://openweathermap.org/api")//check how to pass key for authorization
        .then()
                .statusCode(200)
                .log().all();
    }

}