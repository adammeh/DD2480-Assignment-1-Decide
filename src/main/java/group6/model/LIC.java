package group6.model;
import java.util.List;
import java.util.function.Predicate;
import group6.util.MathUtil;

import static group6.util.MathUtil.computeAngle;

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
    
    public boolean evaluateLIC3(List<Point> points, Parameters parameters) {
        double AREA1 = parameters.getArea1();

        if ( AREA1 < 0 ) {
            return false;
        }
        Predicate<Double> condition = a -> (a > AREA1);
        return MathUtil.existsTriangleWithCondition(points, 0, 0, condition);
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
        return MathUtil.existsTriangleWithCondition(points, E_PTS, F_PTS, condition);
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
        
        return MathUtil.existsTriangleWithCondition(points, E_PTS, F_PTS, condition1) && MathUtil.existsTriangleWithCondition(points, E_PTS, F_PTS, condition2);
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


    public boolean evaluateLIC2(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        double EPSILON = parameters.getEpsilon();
        int index = 0;
        while (index+2 < numpoints){
            double angle = computeAngle(points.get(index).getX(), points.get(index).getY(),
                    points.get(index+1).getX(), points.get(index+1).getY(),
                    points.get(index+2).getX(), points.get(index+2).getY());
            if(angle < (Math.PI - EPSILON) || angle > (Math.PI + EPSILON)) {
                return true;
            }
            else{
                index += 1;
            }
        }
        return false;
    }

    public boolean evaluateLIC6(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        int N_PTS = parameters.getNPts();
        double DIST = parameters.getDist();
        if(numpoints < 3){
            return false;
        }
        int index = 0;
        while (index+N_PTS < numpoints+1){

            double[] p0 = {points.get(index).getX(), points.get(index).getY()};
            double[] pn = {points.get(index+N_PTS-1).getX(), points.get(index+N_PTS-1).getY()};
            //to avoid repeated computation calculate the factors of the equation of the line P0-Pn
            double a = pn[1] - p0[1];
            double b = p0[0] - pn[0];
            double c = pn[0] * p0[1] - pn[1] * p0[0];
            //overlapping points case
            if(a == 0 && b == 0){
                for(int i = 1; i < numpoints -1; i++){
                    double distance = Math.sqrt(points.get(i).getX()*points.get(i).getX() + points.get(i).getY()*points.get(i).getY());
                    if(distance > DIST){
                        return true;
                    }
                }
            } else {
                for(int i = 1; i < numpoints -1; i++){
                    double distance = Math.abs(a*points.get(i).getX() + b*points.get(i).getY() + c) / Math.sqrt(a*a + b*b);
                    if(distance > DIST){
                        return true;
                    }
                }
            }
            index += 1;

        }
        return false;
    }

    public boolean evaluateLIC9(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        int C_PTS = parameters.getCPts();
        int D_PTS = parameters.getDPts();
        double EPSILON = parameters.getEpsilon();
        if(numpoints < 5){
            return false;
        }
        int index = 0;
        while (index+C_PTS+D_PTS+2 < numpoints){
            double angle = computeAngle(points.get(index).getX(), points.get(index).getY(),
                    points.get(index+C_PTS+1).getX(), points.get(index+C_PTS+1).getY(),
                    points.get(index+C_PTS+D_PTS+2).getX(), points.get(index+C_PTS+D_PTS+2).getY());
            if(angle < (Math.PI - EPSILON) || angle > (Math.PI + EPSILON)) {
                return true;
            }
            else{
                index += 1;
            }
        }
        return false;
    }
    public boolean evaluateLIC11(List<Point> points, Parameters parameters){
        int numpoints = points.size();
        int G_PTS = parameters.getGPts();
        if(numpoints < 3){
            return false;
        }
        int index = 0;
        while (index+G_PTS +1< numpoints){
            if((points.get(index+G_PTS+1).getX() - points.get(index).getX()) < 0){
                return true;
            }
            index += 1;
        }
        return false;
    }


}

    // todo: Methods for other LICs (LIC1 to LIC14)...
}

