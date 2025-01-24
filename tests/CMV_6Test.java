import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMV_6Test {

    @Test
    public void CMV_6TestNotEnoughPoints() {
        int NUMPOINTS = 2;
        double[] X = {0.0, 1.0};
        double[] Y = {0.0, 1.0};
        double DIST = 5;
        int N_PTS = 3;
        assertFalse(Decide.CMV_6(X, Y, NUMPOINTS, DIST, N_PTS));
    }

    @Test
    public void CMV_6TestOverlappingPoints() {
        int NUMPOINTS = 3;
        double[] X = {0.0, 0.0, 0.0};
        double[] Y = {0.0, 5.0, 0.0};
        double DIST = 4;
        int N_PTS = 3;
        assertTrue(Decide.CMV_6(X, Y, NUMPOINTS, DIST, N_PTS));
        DIST = 5;
        assertFalse(Decide.CMV_6(X, Y, NUMPOINTS, DIST, N_PTS));

    }

    @Test
    public void CMV_6Test1() {
        //Distance calculated with Geogebra: 4.242...
        int NUMPOINTS = 5;
        double[] X = {0.0, 7.0, 2.0, 3.0, 4.0};
        double[] Y = {0.0, 1.0, 2.0, 3.0, 4.0};
        double DIST = 4;
        int N_PTS = 3;
        assertTrue(Decide.CMV_6(X, Y, NUMPOINTS, DIST, N_PTS));
        DIST = 5;
        assertFalse(Decide.CMV_6(X, Y, NUMPOINTS, DIST, N_PTS));
    }
}
