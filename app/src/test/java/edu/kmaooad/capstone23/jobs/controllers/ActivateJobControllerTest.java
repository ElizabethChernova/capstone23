
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import edu.kmaooad.capstone23.jobs.controllers.*;

class ActivateJobControllerTest {

    ActivateJobController activedJobController;
    Create job1;
    Create job2;
    Create job3;

    @BeforeEach
    void setUp() {
        activedJobController = new ActivateJobControllerTest();
        job1 = new CreateJob("1", "job1", false);
        job2 = new CreateJob("2", "job1", true);

    }

    @Test
    @DisplayName("activating job with  valid id ")
    void test0() {
        assertEquals(200, activedJobController.activateJob("1"),
                "Valid should work");
    }

    @Test
    @DisplayName("activating job with invalid id ")
    void test1() {
        assertEquals(400, activedJobController.activateJob("6"),
                "Not valid should have an error");
    }
    @Test
    @DisplayName("activating job with valid id, which is already activated")
    void test2() {
        assertEquals(200, activedJobController.activateJob("2"),
                "Valid, should stay activated, and do not change anything");
    }
}