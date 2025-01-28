package group6.model;

import java.util.List;

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
        for (int i = 0; i < points.size() - 1; i++) {
            double distance = Math.sqrt(Math.pow(points.get(i+1).getX() - points.get(i).getX(), 2) + Math.pow(points.get(i+1).getY() - points.get(i).getY(), 2));
            if (distance > parameters.getLength1()) {
                return true;
            }
        }
        return false;
    }

    public boolean evaluateLIC7(List<Point> points, Parameters parameters) {
        if (points.size() < 3) {
            return false;
        }
        for (int i = 0; i < points.size() - parameters.getKPts() - 1; i++) {
            double distance = Math.sqrt(Math.pow(points.get(i + parameters.getKPts() + 1).getX() - points.get(i).getX(), 2) + Math.pow(points.get(i + parameters.getKPts() + 1).getY() - points.get(i).getY(), 2));
            if (distance > parameters.getLength1()) {
                return true;
            }
        }
        return false;
    }

    public boolean evaluateLIC12(List<Point> points, Parameters parameters) {
        if (points.size() < 3) {
            return false;
        }
        boolean con1 = false;
        boolean con2 = false;

        for (int i = 0; i < points.size() - parameters.getKPts() - 1; i++) {
            double distance = Math.sqrt(Math.pow(points.get(i + parameters.getKPts() + 1).getX() - points.get(i).getX(), 2) + Math.pow(points.get(i + parameters.getKPts() + 1).getY() - points.get(i).getY(), 2));
            if (distance > parameters.getLength1()) con1 = true;
            if (distance < parameters.getLength2()) con2 = true;
            if (con1 && con2) return true;
        }
        return false;
    }

    public boolean evaluateLIC4(List<Point> points, Parameters parameters) {
        if (points.size() < parameters.getQPts()) {
            return false;
        }
        int count = 0;
        boolean[] quadrants = new boolean[4];
        
        for (int i = 0; i <= points.size() - parameters.getQPts(); i++) {
            for (int j = 0; j < parameters.getQPts(); j++) {
                double x = points.get(i+j).getX();
                double y = points.get(i+j).getY();

                if (x >= 0 && y >= 0) quadrants[0] = true; // Quadrant I
                if (x < 0 && y >= 0) quadrants[1] = true; // Quadrant II
                if (x <= 0 && y < 0) quadrants[2] = true; // Quadrant III
                if (x > 0 && y < 0) quadrants[3] = true; // Quadrant IV
            }
        }
        for (int k = 0; k < quadrants.length; k++) {
            if (quadrants[k]) {
                count++;
                if (count > parameters.getQuads()) return true;
            }
        }
        return false;
    }

    // todo: Methods for other LICs (LIC1 to LIC14)...
}