import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMV0Tests {

    @Test
    void testCmv0_True() {
        double[] x = {0, 11, 0};
        double[] y = {0, 0, 0};
        int NUMPOINTS = 2;
        int LENGTH1 = 10;

        boolean result = DECIDE.cmv0(x, y, NUMPOINTS, LENGTH1);
        assertTrue(result, "cmv0 should return true when two consecutive points have a distance greater than LENGTH1");
    }

    @Test
    void testCmv0_False() {
        double[] x = {0, 5, 0};
        double[] y = {0, 5, 0};
        int NUMPOINTS = 2;
        int LENGTH1 = 10;

        boolean result = DECIDE.cmv0(x, y, NUMPOINTS, LENGTH1);
        assertFalse(result, "cmv0 should return false when no two consecutive points have a distance greater than LENGTH1");
    }


}