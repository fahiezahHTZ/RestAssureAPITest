package restAssuredTests;

import Utils.RestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Demo3_PUT_Request {

    public static HashMap map = new HashMap();
   String empName = RestUtils.getempName();
   String empSalary = RestUtils.getempSal();
   String empAge = RestUtils.getempAge();
   int emp_id = 11254; // we need to know this id to update his data
    //so we have to take employee_id from get req

   @BeforeClass
    public void putData(){
        map.put("name",empName);
       map.put("salary",empSalary);
       map.put("age",empAge);

       baseURI = "http://dummy.restapiexample.com/api/v1";
       basePath = "/update/"+emp_id;// we need to pass emp_id here to update his

    }

    @Test
    public void checkPUT(){
       given()
               .contentType("application/json")
               .body(map)
       .when()
               .put()
       .then()
               .statusCode(200)
               .log().all(); //if you want to see really update properly

    }


}
