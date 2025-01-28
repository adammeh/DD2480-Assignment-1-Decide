package group6.util;

import group6.common.Constants.ComparisonType;

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


    public static double computeAngle(double p0_x, double p0_y, double p1_x, double p1_y, double p2_x, double p2_y){
        double BAx = p0_x - p1_x;
        double BAy = p0_y - p1_y;
        double BCx = p2_x - p1_x;
        double BCy = p2_y - p1_y;

        double dotProduct = BAx * BCx + BAy * BCy;
        double magnitudeBA = Math.sqrt(BAx*BAx + BAy*BAy);
        double magnitudeBC = Math.sqrt(BCx*BCx + BCy*BCy);

        return Math.acos(dotProduct / (magnitudeBA * magnitudeBC));

    }
}
