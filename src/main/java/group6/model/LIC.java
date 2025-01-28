package group6.model;

import java.util.List;

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
        // Method for LIC0 evaluation
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