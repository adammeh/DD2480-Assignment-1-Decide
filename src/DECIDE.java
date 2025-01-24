import java.math.*;
import java.util.Arrays;

public class DECIDE {

    public static boolean cmv0(double[] x, double[] y, int NUMPOINTS, int LENGTH1) {
        for (int i = 0; i < NUMPOINTS; i++) {
            double distance = Math.sqrt(Math.pow(x[i+1] - x[i], 2) + Math.pow(y[i+1] - y[i], 2));
            if (distance > LENGTH1) {
                return true;
            }
        }
        return false;
    }

    public static boolean cmv7(int[] x, int[] y, int K_PTS, int NUMPOINTS, int LENGTH1) {
        if (NUMPOINTS < 3) {
            return false;
        }
        for (int i = 0; i < NUMPOINTS - K_PTS - 1; i++) {
            double distance = Math.sqrt(Math.pow(x[i + K_PTS + 1] - x[i], 2) + Math.pow(y[i + K_PTS + 1] - y[i], 2));
            if (distance > LENGTH1) {
                return true;
            }
        }
        return false;
    }

}