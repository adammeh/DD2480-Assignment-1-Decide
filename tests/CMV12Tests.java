import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CMV12Tests {

    // Test with valid input where both conditions are met
    @Test
    void testCMV12_BothConditionsMet() {
        double[] x = {0, 1, 2, 15};
        double[] y = {0, 1, 2, 15};
        int K_PTS = 1;
        double LENGTH1 = 10;
        double LENGTH2 = 5;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv12(x, y, K_PTS, LENGTH1, LENGTH2, NUMPOINTS);
        assertTrue(result, "cmv12 should return true when both conditions are met: distance > LENGTH1 and distance < LENGTH2");
    }

    // Test with valid input where only the first condition is met
    @Test
    void testCMV12_OnlyFirstConditionMet() {
        double[] x = {0, 1, 2, 15};
        double[] y = {0, 1, 2, 15};
        int K_PTS = 1;
        double LENGTH1 = 10;
        double LENGTH2 = 2;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv12(x, y, K_PTS, LENGTH1, LENGTH2, NUMPOINTS);
        assertFalse(result, "cmv12 should return false when only the first condition (distance > LENGTH1) is met");
    }

    // Test with valid input where only the second condition is met
    @Test
    void testCMV12_OnlySecondConditionMet() {
        double[] x = {0, 1, 2, 3};
        double[] y = {0, 1, 2, 3};
        int K_PTS = 1;
        double LENGTH1 = 10;
        double LENGTH2 = 5;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv12(x, y, K_PTS, LENGTH1, LENGTH2, NUMPOINTS);
        assertFalse(result, "cmv12 should return false when only the second condition (distance < LENGTH2) is met");
    }

    // Test with valid input where neither condition is met
    @Test
    void testCMV12_NoConditionMet() {
        double[] x = {0, 1, 2, 3};
        double[] y = {0, 1, 2, 3};
        int K_PTS = 1;
        double LENGTH1 = 10;
        double LENGTH2 = 2;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv12(x, y, K_PTS, LENGTH1, LENGTH2, NUMPOINTS);
        assertFalse(result, "cmv12 should return false when neither condition is met");
    }

    // Test with invalid input: NUMPOINTS less than 3
    @Test
    void testCMV12_NumPointsLessThan3() {
        double[] x = {0, 1};
        double[] y = {0, 1};
        int K_PTS = 1;
        double LENGTH1 = 10;
        double LENGTH2 = 5;
        int NUMPOINTS = 2;

        boolean result = DECIDE.cmv12(x, y, K_PTS, LENGTH1, LENGTH2, NUMPOINTS);
        assertFalse(result, "cmv12 should return false when NUMPOINTS is less than 3");
    }
}