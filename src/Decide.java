import java.util.function.Predicate;

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
}
