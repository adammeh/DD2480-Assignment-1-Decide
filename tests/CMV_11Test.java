import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMV_11Test {

    @Test
    public void CMV_11TestNotEnoughPoints(){
        int NUMPOINTS = 2;
        double[] X = {0.0, 1.0};
        int G_PTS = 1;
        assertFalse(Decide.CMV_11(X,NUMPOINTS, G_PTS));
    }

    @Test
    public void CMV_11Test1(){
        int NUMPOINTS = 3;
        double[] X = {0.0, 1.0, 0.0};
        int G_PTS = 1;
        assertFalse(Decide.CMV_11(X,NUMPOINTS, G_PTS));
    }

    @Test
    public void CMV_11Test2(){
        int NUMPOINTS = 4;
        double[] X = {0.1, 0.0, 1.0, 2.0, 0.0};
        int G_PTS = 2;
        assertFalse(Decide.CMV_11(X,NUMPOINTS, G_PTS));
        G_PTS = 3;
        assertTrue(Decide.CMV_11(X,NUMPOINTS, G_PTS));
    }
}
