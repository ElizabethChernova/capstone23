
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import

class DeactivateJobControllerTest {



    @Inject
    CommandHandler<CreateJob, JobCreated> handler;
    @Test
    @DisplayName("Deacrtivate job: valid input")
    public void testBasicJobDeactivating() {
        //CommandHandler<CreateJob, JobCreated> handler = null;

        CreateJob command = new CreateJob("Teacher", false);
        Result<JobCreated> result = handler.handle(command);

//        Map<String, Object> jsonAsMap = new HashMap<>();
//        ObjectId id = new ObjectId("64faf6ad341e202c91f76c84");
//        jsonAsMap.put("_id", id);

        given()
                .contentType("application/json")
                .when()
                .delete("/jobs/deactivate/".concat(result.getValue().getJobId().toString()))
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("Deacrtivate job: valid input, but already activated")
    public void testBasicAlreadyExistDeactivating() {
        //CommandHandler<CreateJob, JobCreated> handler = null;

        CreateJob command = new CreateJob("Teacher", true);
        Result<JobCreated> result = handler.handle(command);

//        Map<String, Object> jsonAsMap = new HashMap<>();
//        ObjectId id = new ObjectId("64faf6ad341e202c91f76c84");
//        jsonAsMap.put("_id", id);

        given()
                .contentType("application/json")
                .when()
                .delete("/jobs/deactivate/".concat(result.getValue().getJobId().toString()))
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("Deactivate job: invalid input")
    public void testJobDeactivateWithInvalidInput() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        ObjectId id = new ObjectId("64faf6ad322e202c91f76c84");
        jsonAsMap.put("_id", id);

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .delete("/jobs/deactivate/"+id)
                .then()
                .statusCode(400);
    }


}