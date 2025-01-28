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

    static double triangleArea(double x0, double y0, double x1, double y1, double x2, double y2) {
        return 0.5 * Math.abs(x0 * (y1 - y2) + x1 * (y2 - y0) + x2 * (y0 - y1));
    }
    
    static boolean existsTriangleWithCondition(List<Point> points, int gap1, int gap2, Predicate<Double> condition) {
        for ( int i = 0; i + 1 + gap1 + 1 + gap2 < points.size(); ++i ) {
            double a = triangleArea(
                points.get(i).getX(),
                points.get(i).getY(),
                points.get(i + 1 + gap1).getX(),
                points.get(i + 1 + gap1).getY(),
                points.get(i + 1 + gap1 + 1 + gap2).getX(),
                points.get(i + 1 + gap1 + 1 + gap2).getY()
            );
            if ( condition.test(a)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean evaluateLIC3(List<Point> points, Parameters parameters) {
        double AREA1 = parameters.getArea1();

        if ( AREA1 < 0 ) {
            return false;
        }
        Predicate<Double> condition = a -> (a > AREA1);
        return existsTriangleWithCondition(points, 0, 0, condition);
    }
    
    public boolean evaluateLIC10(List<Point> points, Parameters parameters) {
        int E_PTS = parameters.getEPts();
        int F_PTS = parameters.getFPts();
        int NUMPOINTS = points.size();
        double AREA1 = parameters.getArea1();

        if ( NUMPOINTS < 5 || E_PTS < 1 || F_PTS < 1 || NUMPOINTS - 3 < E_PTS + F_PTS) {
            return false;
        }
        Predicate<Double> condition = a -> (a > AREA1);
        return existsTriangleWithCondition(points, E_PTS, F_PTS, condition);
    }
    
    public boolean evaluateLIC14(List<Point> points, Parameters parameters) {
        int E_PTS = parameters.getEPts();
        int F_PTS = parameters.getFPts();
        int NUMPOINTS = points.size();
        double AREA1 = parameters.getArea1();
        double AREA2 = parameters.getArea2();

        if ( NUMPOINTS < 5 || AREA2 < 0 ) {
            return false;
        }
        Predicate<Double> condition1 = a -> (a > AREA1);
        Predicate<Double> condition2 = a -> (a < AREA2);
        
        return existsTriangleWithCondition(points, E_PTS, F_PTS, condition1) && existsTriangleWithCondition(points, E_PTS, F_PTS, condition2);
    }
}
