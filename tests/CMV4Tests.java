import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CMV4Tests {

    @Test
    void testCMV4_True() {
        double[] x = {1, -1, -1, 1};
        double[] y = {1, 1, -1, -1};
        int Q_PTS = 3;
        int QUADS = 2;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv4(x, y, Q_PTS, QUADS, NUMPOINTS);
        assertTrue(result, "cmv4 should return true when Q_PTS points span more than QUADS quadrants");
    }

    @Test
    void testCMV4_False() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        int Q_PTS = 3;
        int QUADS = 2;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv4(x, y, Q_PTS, QUADS, NUMPOINTS);
        assertFalse(result, "cmv4 should return false when Q_PTS points do not span more than QUADS quadrants");
    }

    // Test with invalid input: NUMPOINTS less than Q_PTS
    @Test
    void testCMV4_NumPointsLessThanQPTS() {
        double[] x = {1, 2};
        double[] y = {1, 2};
        int Q_PTS = 3;
        int QUADS = 2;
        int NUMPOINTS = 2;

        boolean result = DECIDE.cmv4(x, y, Q_PTS, QUADS, NUMPOINTS);
        assertFalse(result, "cmv4 should return false when NUMPOINTS is less than Q_PTS");
    }

    // Test with edge case: Q_PTS equals NUMPOINTS
    @Test
    void testCMV4_EdgeCase_QPTSEqualsNumPoints() {
        double[] x = {1, -1, 1, -1};
        double[] y = {1, 1, -1, -1};
        int Q_PTS = 4;
        int QUADS = 3;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv4(x, y, Q_PTS, QUADS, NUMPOINTS);
        assertTrue(result, "cmv4 should return true when all NUMPOINTS span more than QUADS quadrants");
    }

    // Test with edge case: Points exactly on axes
    @Test
    void testCMV4_PointsOnAxes() {
        double[] x = {0, -1, 0, 1};
        double[] y = {1, 0, -1, 0};
        int Q_PTS = 3;
        int QUADS = 2;
        int NUMPOINTS = 4;

        boolean result = DECIDE.cmv4(x, y, Q_PTS, QUADS, NUMPOINTS);
        assertTrue(result, "cmv4 should return false when points lie exactly on the axes and do not fully span quadrants");
    }
}