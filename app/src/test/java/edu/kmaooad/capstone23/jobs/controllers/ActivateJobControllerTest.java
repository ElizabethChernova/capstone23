
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import edu.kmaooad.capstone23.jobs.controllers.*;

class ActivateJobControllerTest {

    ActivateJobController activedJobController;


    @BeforeEach
    void setUp() {
        activedJobController = new ActivateJobControllerTest();


    }
    @Test
    @DisplayName("Acrtivate job: valid input")
    public void testValid() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", "1");

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .put("/jobs/activateJob")
                .then()
                .statusCode(200);
   }
    @Test
    @DisplayName("Acrtivate job: notvalid input")
    public void testNotValid() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", "1000");
        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .put("/jobs/activateJob")
                .then()
                .statusCode(400);
    }
    @Test
    @DisplayName("activating job with valid id, which is already activated")
    public void testValid2() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", "2");

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .put("/jobs/activateJob")
                .then()
                .statusCode(200);
    }
//    @Test
//    @DisplayName("activating job with  valid id ")
//    void test0() {
//        assertEquals(200, activedJobController.activateJob("1"),
//                "Valid should work");
//    }

//    @Test
//    @DisplayName("activating job with invalid id ")
//    void test1() {
//        assertEquals(400, activedJobController.activateJob("6"),
//                "Not valid should have an error");
//    }
//    @Test
//    @DisplayName("activating job with valid id, which is already activated")
//    void test2() {
//        assertEquals(200, activedJobController.activateJob("2"),
//                "Valid, should stay activated, and do not change anything");
//    }
}