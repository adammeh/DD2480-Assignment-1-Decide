import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void cmv3Test1() {
        int NUMPOINTS = 5;
        double[] X = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] Y = {0.0, 1.0, 2.0, 3.0, 4.0};
        double AREA1 = -3;

        assertFalse(Decide.cmv3(X, Y, NUMPOINTS, AREA1));
    }
    
    @Test
    public void cmv3Test2() {
        int NUMPOINTS = 3;
        double[] X = {0.0, 2.0, 1.0};
        double[] Y = {0.0, 0.0, 2.0};
        double AREA1 = 1.99;
        
        assertTrue(Decide.cmv3(X, Y, NUMPOINTS, AREA1));
    }
    
    @Test
    public void cmv3Test3() {
        int NUMPOINTS = 10;
        double[] X = {4.920, 4.768, 3.694, 4.663, 4.294, 4.713, 3.742, 3.883, 3.292, 3.566};
        double[] Y = {3.722, 4.082, 3.947, 4.405, 4.265, 4.834, 4.850, 3.723, 4.547, 3.017};
        double AREA1 = 2.0;
        assertFalse(Decide.cmv3(X, Y, NUMPOINTS, AREA1));
    }
}
