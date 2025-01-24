import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CMV7Tests {

    @Test
    void testCMV7_True() {
        int[] x = {0, 1, 2, 15};
        int[] y = {0, 1, 2, 15};
        int K_PTS = 1;
        int LENGTH1 = 10;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv7(x, y, K_PTS, LENGTH1, NUMPOINTS);
        assertTrue(result, "cmv7 should return true when a pair of points separated by K_PTS exceeds LENGTH1");
    }

    @Test
    void testCMV7_False() {
        int[] x = {0, 1, 2, 5};
        int[] y = {0, 1, 2, 5};
        int K_PTS = 1;
        int LENGTH1 = 10;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv7(x, y, K_PTS, NUMPOINTS, LENGTH1);
        assertFalse(result, "cmv7 should return false when no pair of points separated by K_PTS exceeds LENGTH1");
    }

    // Test with invalid input: NUMPOINTS less than 3
    @Test
    void testCMV7__NumPointsLessThan3() {
        int[] x = {0, 1};
        int[] y = {0, 1};
        int K_PTS = 1;
        int LENGTH1 = 10;
        int NUMPOINTS = 2;

        boolean result = DECIDE.cmv7(x, y, K_PTS, NUMPOINTS, LENGTH1);
        assertFalse(result, "cmv7 should return false when NUMPOINTS is less than 3");
    }

}