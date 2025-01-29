package group6.util;
import java.util.function.Predicate;
import group6.common.Constants.ComparisonType;
import java.util.List;
import group6.model.Point;

/**
 * Utility class for mathematical operations(e.g. calculate distance/angle/area, etc.).
 */
public class MathUtil {

    private static final double EPSILON = 0.000001;

    /**
     * Compares two doubles.
     *
     * @param a the first double
     * @param b the second double
     * @return the comparison type
     */
    public static ComparisonType compareDouble(double a, double b) {
        if (Math.abs(a - b) < EPSILON) {
            return ComparisonType.EQ;
        } else if (a < b) {
            return ComparisonType.LT;
        } else {
            return ComparisonType.GT;
        }
    }

    public static double computeAngle(double p0_x, double p0_y, double p1_x, double p1_y, double p2_x, double p2_y) {
        double BAx = p0_x - p1_x;
        double BAy = p0_y - p1_y;
        double BCx = p2_x - p1_x;
        double BCy = p2_y - p1_y;

        double dotProduct = BAx * BCx + BAy * BCy;
        double magnitudeBA = Math.sqrt(BAx * BAx + BAy * BAy);
        double magnitudeBC = Math.sqrt(BCx * BCx + BCy * BCy);

        return Math.acos(dotProduct / (magnitudeBA * magnitudeBC));
    }

    static double triangleArea(double x0, double y0, double x1, double y1, double x2, double y2) {
        return 0.5 * Math.abs(x0 * (y1 - y2) + x1 * (y2 - y0) + x2 * (y0 - y1));
    }
    
    public static boolean existsTriangleWithCondition(List<Point> points, int gap1, int gap2, Predicate<Double> condition) {
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
}
