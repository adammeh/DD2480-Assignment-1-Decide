import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CMV14Test {
    @Test
    public void cmv14Test1() {
        int NUMPOINTS = 12;
        double[] X = {0.0, 0.0, 2.0, 2.0, 0.0, 0.0, 1.0, 1.0, 5.0, 5.0, 5.0, 4.0};
        double[] Y = {0.0, 0.0, 0.0, 0.0, 3.0, 3.0, 0.0, 0.0, 1.0, 1.0, 1.0, 4.0};
        double AREA1 = 6.0;
        double AREA2 = 4.0;
        int E_PTS = 2;
        int F_PTS = 1;
        
        assertTrue(Decide.cmv14(X, Y, NUMPOINTS, E_PTS, F_PTS, AREA1, AREA2));
    }

    @Test
    public void cmv14Test2() {
        int NUMPOINTS = 4;
        double[] X = {0.0, 1.0, 1.0, 0.1};
        double[] Y = {0.0, 1.0, 0.0, 1.0};
        int E_PTS = 0;
        int F_PTS = 0;
        double AREA1 = 0.0;
        double AREA2 = 100.0;

        assertFalse(Decide.cmv14(X, Y, NUMPOINTS, E_PTS, F_PTS, AREA1, AREA2));
    }

    @Test
    public void cmv14Test3() {
        int NUMPOINTS = 5;
        double[] X = {0.0, 1.0, 1.0, 0.1, 10.0};
        double[] Y = {0.0, 1.0, 0.0, 1.0, 10.0};
        double AREA1 = 0.0;
        double AREA2 = -1.0;
        int E_PTS = 1;
        int F_PTS = 1;

        assertFalse(Decide.cmv14(X, Y, NUMPOINTS, E_PTS, F_PTS, AREA1, AREA2));
    }

    @Test
    public void cmv14Test4() {
        int NUMPOINTS = 5;
        double[] X = {0.0, 0.0, 100.0, -10.0, -10.0};
        double[] Y = {0.0, 0.0, 100.0, -10.0, -10.0};
        double AREA1 = 6.0;
        double AREA2 = 1.0;
        int E_PTS = 1;
        int F_PTS = 1;
        
        assertFalse(Decide.cmv14(X, Y, NUMPOINTS, E_PTS, F_PTS, AREA1, AREA2));
    }
}
