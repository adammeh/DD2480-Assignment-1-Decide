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

    public boolean CMV5(double[] X){

        for(int i=0; i<X.length-1;i++){
            if(X[i+1]-X[i]<0){
                return true;
            }           
        }
        return false;
    }

}