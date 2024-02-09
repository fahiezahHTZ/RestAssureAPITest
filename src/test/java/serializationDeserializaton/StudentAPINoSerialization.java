package serializationDeserializaton;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class StudentAPINoSerialization {

    /*
            json format

            {
                "id" : 101,
                "firstName" : "Paven",
                "lastName" : "Kumar",
                "email" : "abcxyz@gmail.com",
                "courses" : [
                                "java",
                                "Selenium"
                            ]
            }
     */

    HashMap map = new HashMap<>(); //if we don't use serial/deserial need to use Hashmap

    @Test //POST req create a new student record
    public void createNewStudent(){

        map.put("id",101);
        map.put("firstName","Pavan");
        map.put("lastName","kumar");
        map.put("email","abcxyz@gmail.com");
        map.put("programme","Manager");

        ArrayList<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Selenium");
        map.put("courses",courseList);

        given()
                .contentType(ContentType.JSON)
                .body(map)
        .when()
                .post("http://localhost:8085/student")
        .then()
                .statusCode(201)
                .assertThat()
                .body("msg",equalTo("Student added"));
    }
    //GET req : to retrieve student details
    @Test
    public void getStudentRecord(){

        given()
        .when()
                .get("http://localhost:8085/student/101")
        .then()
                .statusCode(200)
                .assertThat()
                .body("id",equalTo(101));
    }
}
