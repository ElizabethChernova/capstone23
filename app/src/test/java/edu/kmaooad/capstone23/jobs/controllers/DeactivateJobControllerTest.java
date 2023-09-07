
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import

class DeactivateJobControllerTest {

    DeactivateJobController deactivedJobController;
//    Create job1;
//    Create job2;
//    Create job3;

    @BeforeEach
    void setUp() {
        deactivedJobController = new DeactivateJobControllerTest();
//        job1 = new CreateJob("1", "job1", true);
//        job2 = new CreateJob("2", "job1", false);

    }
    @Test
    @DisplayName("deacrtivate job: valid input")
    public void testValid() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", "1");

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .put("/jobs/deactivateJob")
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("deacctivate job: notvalid input")
    public void testNotValid() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", "1000");
        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .put("/jobs/deactivateJob")
                .then()
                .statusCode(400);
    }
    @Test
    @DisplayName("deactivating job with valid id, which is already deactivated")
    public void testValid2() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", "2");

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .put("/jobs/deactivateJob")
                .then()
                .statusCode(200);
    }

//    @Test
//    @DisplayName("deactivating job with  valid id ")
//    void test0() {
//        assertEquals(200, deactivedJobController.deactivateJob("1"),
//                "Valid should work");
//    }
//
//    @Test
//    @DisplayName("deactivating job with invalid id ")
//    void test1() {
//        assertEquals(400, deactivedJobController.deactivateJob("6"),
//                "Not valid should have an error");
//    }
//    @Test
//    @DisplayName("activating job with valid id, which is already activated")
//    void test2() {
//        assertEquals(200, deactivedJobController.deactivateJob("2"),
//                "Valid, should stay deactivated, and do not change anything");
//    }
}