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
}
