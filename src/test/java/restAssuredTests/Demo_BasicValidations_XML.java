package restAssuredTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo_BasicValidations_XML {

    //1) Verify single content in XML Response

    @Test
    void testSingleContent(){

        given().
        when()
                .get("url").
        then()
                .body("CUSTOMER.ID",equalTo("15"))
                //here need to know how to read XML response to get ID linke JSONPATH Finder
                .log().all();
    }

    @Test
    void testMultipleContents(){//verify algon with ID 15, want to verify fname,lnaem..

        given().
                when()
                .get("url").
                then()
                .body("CUSTOMER.ID",equalTo("15"))
                .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
                .body("CUSTOMER.LASTNAME",equalTo("Clancy"))
                .body("CUSTOMER.STREET",equalTo("319 Upland P1."))
                .body("CUSTOMER.CITY",equalTo("Settle"));
    }

    @Test
    void testMultipleContentsInOneGo(){

        given().
                when()
                .get("url").
                then()
                .body("CUSTOMER.text()",equalTo("15BillClancy319 Upland P1.Settle"));//1 consider 1 text
                //text() method to verify in XML
    }

    //find value using XML path in XML response
    @Test
    void testUSingXPath(){

        given()
        .when()
                .get("url")
        .then()
                .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")))
//for eg if return many data for 1 attribute can find other way
                .body(hasXPath("/INVOICEList/INVOICE[text()='30']"));

    }
}



