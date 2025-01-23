import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMV_2AND9Test {

    @Test
    public void computeAngleOverlappingPointsTest() {
        assertEquals(Double.NaN, Decide.computeAngle(0,0,0,0,0,0), "Error when computing same point angle");
    }
    @Test
    public void computesAngleTest() {
        assertEquals(Math.PI/2,Decide.computeAngle(0,-2,0,4,4,4), "Error on 90 deg angle");
        assertEquals(Math.PI, Decide.computeAngle(0,0,0,1,0,2), "Error on 180 deg angle");
        assertEquals(Math.PI*3/4,Decide.computeAngle(3,7,0,4,0,-2), "Error on 135 deg angle");
        assertEquals(Math.PI/4,Decide.computeAngle(0,-2,0,4,3,1), "Error on 45 deg angle");
        assertEquals(2.677945044588987, Decide.computeAngle(0, -2,3,1,4,4), "Error on  angle");

    }
    @Test
    public void CMV_2Test1() {
        int NUMPOINTS = 5;
        double[] X = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] Y = {0.0, 1.0, 2.0, 3.0, 4.0};
        double EPSILON = 0.002;

        assertFalse(Decide.CMV_2(X, Y, NUMPOINTS, EPSILON));
    }

    @Test
    public void CMV_2Test2() {
        int NUMPOINTS = 3;
        double[] X = {0.0, 2.0, 1.0};
        double[] Y = {0.0, 0.0, 2.0};
        double EPSILON = 2;

        assertTrue(Decide.CMV_2(X, Y, NUMPOINTS, EPSILON));
    }

    @Test
    public void CMV_2Test3() {
        int NUMPOINTS = 10;
        double[] X = {4.920, 4.768, 3.694, 4.663, 4.294, 4.713, 3.742, 3.883, 3.292, 3.566};
        double[] Y = {3.722, 4.082, 3.947, 4.405, 4.265, 4.834, 4.850, 3.723, 4.547, 3.017};
        double EPSILON = 3.05;
        assertTrue(Decide.CMV_2(X, Y, NUMPOINTS, EPSILON));
    }
}
