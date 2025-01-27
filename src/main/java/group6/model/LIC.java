package group6.model;
import java.util.List;
import java.util.function.Predicate;

/**
 * Implements logic for all Launch Interceptor Conditions (LICs).
 */
public class LIC {

    /**
     * todo: Evaluates LIC0: Checks if any two points are farther apart than LENGTH1.
     *
     * @param points     the list of points
     * @param parameters the configuration parameters
     * @return true if the condition is satisfied, false otherwise
     */
    public boolean evaluateLIC0(List<Point> points, Parameters parameters) {
        // Method for LIC0 evaluation
        return false;
    }

    // todo: Methods for other LICs (LIC1 to LIC14)...
}

class Decide{
    static double triangleArea(double x0, double y0, double x1, double y1, double x2, double y2) {
        return 0.5 * Math.abs(x0 * (y1 - y2) + x1 * (y2 - y0) + x2 * (y0 - y1));
    }
    
    static boolean existsTriangleWithCondition(double[] X, double[] Y, int NUMPOINTS, int gap1, int gap2, Predicate<Double> condition) {
        for ( int i = 0; i + 1 + gap1 + 1 + gap2 < NUMPOINTS; ++i ) {
            double a = triangleArea(
                X[i],
                Y[i],
                X[i + 1 + gap1],
                Y[i + 1 + gap1],
                X[i + 1 + gap1 + 1 + gap2],
                Y[i + 1 + gap1 + 1 + gap2]
            );
            if ( condition.test(a)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean cmv3(double[] X, double[] Y, int NUMPOINTS, double AREA1) {
        if ( AREA1 < 0 ) {
            return false;
        }
        Predicate<Double> condition = a -> (a > AREA1);
        return existsTriangleWithCondition(X, Y, NUMPOINTS, 0, 0, condition);
    }
    
    public static boolean cmv10(double[] X, double[] Y, int NUMPOINTS, int E_PTS, int F_PTS, double AREA1) {
        if ( NUMPOINTS < 5 || E_PTS < 1 || F_PTS < 1 || NUMPOINTS - 3 < E_PTS + F_PTS) {
            return false;
        }
        Predicate<Double> condition = a -> (a > AREA1);
        return existsTriangleWithCondition(X, Y, NUMPOINTS, E_PTS, F_PTS, condition);
    }
    
    public static boolean cmv14(double[] X, double[] Y, int NUMPOINTS, int E_PTS, int F_PTS, double AREA1, double AREA2) {
        if ( NUMPOINTS < 5 || AREA2 < 0 ) {
            return false;
        }
        Predicate<Double> condition1 = a -> (a > AREA1);
        Predicate<Double> condition2 = a -> (a < AREA2);
        
        return existsTriangleWithCondition(X, Y, NUMPOINTS, E_PTS, F_PTS, condition1) && existsTriangleWithCondition(X, Y, NUMPOINTS, E_PTS, F_PTS, condition2);
    }
}
