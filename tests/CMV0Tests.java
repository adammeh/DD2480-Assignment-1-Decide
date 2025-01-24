import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMV0Tests {

    @Test
    void testCmv0_True() {
        double[] x = {0, 11};
        double[] y = {0, 0};
        double LENGTH1 = 10;
        int NUMPOINTS = 2;

        boolean result = DECIDE.cmv0(x, y, LENGTH1, NUMPOINTS);
        assertTrue(result, "cmv0 should return true when two consecutive points have a distance greater than LENGTH1");
    }

    @Test
    void testCmv0_False() {
        double[] x = {0, 5};
        double[] y = {0, 5};
        double LENGTH1 = 10;
        int NUMPOINTS = 2;

        boolean result = DECIDE.cmv0(x, y, LENGTH1, NUMPOINTS);
        assertFalse(result, "cmv0 should return false when no two consecutive points have a distance greater than LENGTH1");
    }


}