
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class DeactivateJobControllerTest {

    DeactivateJobController deactivedJobController;
    Create job1;
    Create job2;
    Create job3;

    @BeforeEach
    void setUp() {
        deactivedJobController = new DeactivateJobControllerTest();
        job1 = new CreateJob("1", "job1", true);
        job2 = new CreateJob("2", "job1", false);

    }

    @Test
    @DisplayName("deactivating job with  valid id ")
    void testValid() {
        assertEquals(200, deactivedJobController.deactivateJob("1"),
                "Valid should work");
    }

    @Test
    @DisplayName("deactivating job with invalid id ")
    void testValid() {
        assertEquals(400, deactivedJobController.deactivateJob("6"),
                "Not valid should have an error");
    }
    @Test
    @DisplayName("activating job with valid id, which is already activated")
    void testValid() {
        assertEquals(200, deactivedJobController.deactivateJob("2"),
                "Valid, should stay deactivated, and do not change anything");
    }
}