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
        // Method for LIC0 evaluation
        return false;
    }



    // todo: Methods for other LICs (LIC1 to LIC14)...
    /**
     * There exists at least one set of two consecutive data points
     * (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1) 
     * 
     * @param points the list of points
     * @param parameters the configuration parameters
     * @return true if requirement LIC 5 is satisfied
     */
    public boolean evaluateLIC5(List<Point> points, Parameters parameters){

        //checks for two consecutive datapoints
        for(int i=0; i<points.size()-1;i++){

            // checks X[i+1] - X[i] < 0
            if(points.get(i+1).getX()-points.get(i).getX()<0){
                return true;
            }           
        }
        return false;
    }

}