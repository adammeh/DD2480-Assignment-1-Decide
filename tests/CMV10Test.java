import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CMV10Test {
    @Test
    public void cmv10Test1() {
        int NUMPOINTS = 8;
        double[] X = {0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 1.0};
        double[] Y = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0};
        double AREA1 = 1.99;
        int E_PTS = 2;
        int F_PTS = 3;
        
        assertTrue(Decide.cmv10(X, Y, NUMPOINTS, E_PTS, F_PTS, AREA1));
    }

    @Test
    public void cmv10Test2() {
        int NUMPOINTS = 10;
        double[] X = {675.299, 649.155, 787.103, 30.356, 518.131, 306.236, 466.805, 643.529, 356.091, 853.476};
        double[] Y = {675.601, 239.692, 803.359, 787.700, 790.492, 597.113, 263.745, 422.578, 609.727, 655.832};
        double AREA1 = 0.0;
        int E_PTS = 5;
        int F_PTS = 3;
        
        assertFalse(Decide.cmv10(X, Y, NUMPOINTS, E_PTS, F_PTS, AREA1));
    }
    
    @Test
    public void cmv10Test3() {
        int NUMPOINTS = 5;
        double[] X = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] Y = {4.0, 3.0, 2.0, 1.0, 0.0};
        int A_PTS = 0;
        int B_PTS = 1;
        double AREA1 = 0.0;

        assertFalse(Decide.cmv10(X, Y, NUMPOINTS, A_PTS, B_PTS, AREA1));
        assertFalse(Decide.cmv10(X, Y, NUMPOINTS, B_PTS, A_PTS, AREA1));        
    }
}
