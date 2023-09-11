
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import edu.kmaooad.capstone23.jobs.controllers.*;

class ActivateJobControllerTest {


    @Inject
    CommandHandler<CreateJob, JobCreated> handler;
    @Test
    @DisplayName("Acrtivate job: valid input")
    public void testBasicJobActivating() {
        //CommandHandler<CreateJob, JobCreated> handler = null;

        CreateJob command = new CreateJob("Teacher", false);
        Result<JobCreated> result = handler.handle(command);

//        Map<String, Object> jsonAsMap = new HashMap<>();
//        ObjectId id = new ObjectId("64faf6ad341e202c91f76c84");
//        jsonAsMap.put("_id", id);

        given()
                .contentType("application/json")
                .when()
                .delete("/jobs/activate/".concat(result.getValue().getJobId().toString()))
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("Acrtivate job: valid input, but already activated")
    public void testBasicAlreadyExistActivating() {
        //CommandHandler<CreateJob, JobCreated> handler = null;

        CreateJob command = new CreateJob("Teacher", true);
        Result<JobCreated> result = handler.handle(command);

//        Map<String, Object> jsonAsMap = new HashMap<>();
//        ObjectId id = new ObjectId("64faf6ad341e202c91f76c84");
//        jsonAsMap.put("_id", id);

        given()
                .contentType("application/json")
                .when()
                .delete("/jobs/activate/".concat(result.getValue().getJobId().toString()))
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("Activate job: invalid input")
    public void testJobActivateWithInvalidInput() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        ObjectId id = new ObjectId("64faf6ad322e202c91f76c84");
        jsonAsMap.put("_id", id);

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .when()
                .delete("/jobs/activate/"+id)
                .then()
                .statusCode(400);
    }



}