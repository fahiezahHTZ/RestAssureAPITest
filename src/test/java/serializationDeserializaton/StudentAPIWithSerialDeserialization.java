package serializationDeserializaton;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/*
          json format //for this file, we need to create class and obj

          {
              "id" : 101,
              "firstName" : "Paven",
              "lastName" : "Kumar",
              "email" : "abcxyz@gmail.com",
              "courses" : [
                              "Java",
                              "Selenium"
                          ]
          }
   */
public class StudentAPIWithSerialDeserialization {


    @Test  //serialization - add student record to json file
    public void createNewStudentSerialization(){

        ArrayList<String> courselist = new ArrayList<String>();
        courselist.add("Java");
        courselist.add("Selenium");

        Student st = new Student();

        st.setId(101);
        st.setFirstName("Paven");
        st.setLastName("Kumar");
        st.setEmail("abcxyz@gmail.com");
        st.setCourses(courselist);

        given()
                .contentType(ContentType.JSON)
                .body(st)
        .when()
                .post("http://localhost:8085/student")
        .then()
                .statusCode(201)
                .assertThat().body("msg",equalTo("Student added"));

    }

    @Test
    public void getStudentRecordDeSerialization(){

       Student student = get("http://localhost:8085/student/101").as(Student.class);
       System.out.println(student.getStudentRecord());
        Assert.assertEquals(student.getId(),101);


    }

}
