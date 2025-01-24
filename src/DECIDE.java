import java.math.*;
import java.util.Arrays;

public class DECIDE {

    public static boolean cmv0(double[] x, double[] y, double LENGTH1, int NUMPOINTS) {
        for (int i = 0; i < NUMPOINTS - 1; i++) {
            double distance = Math.sqrt(Math.pow(x[i+1] - x[i], 2) + Math.pow(y[i+1] - y[i], 2));
            if (distance > LENGTH1) {
                return true;
            }
        }
        return false;
    }

    public static boolean cmv7(double[] x, double[] y, int K_PTS, double LENGTH1, int NUMPOINTS) {
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

    public static boolean cmv12(double[] x, double[] y, int K_PTS, double LENGTH1, double LENGTH2, int NUMPOINTS) {
        if (NUMPOINTS < 3) {
            return false;
        }
        boolean con1 = false;
        boolean con2 = false;

        for (int i = 0; i < NUMPOINTS - K_PTS - 1; i++) {
            double distance = Math.sqrt(Math.pow(x[i + K_PTS + 1] - x[i], 2) + Math.pow(y[i + K_PTS + 1] - y[i], 2));
            if (distance > LENGTH1) con1 = true;
            if (distance < LENGTH2) con2 = true;
            if (con1 && con2) return true;
        }
        return false;
    }

}