import java.lang.Math;

public class Decide{


    public static boolean CMV1(double[] X, double[] Y, double RADIUS1){

        //Checks for every set of three consequtive datapoints
        for(int i=0; i<X.length-2;i++){
            double a=distance(X[i],Y[i],X[i+1],Y[i+1]);
            double b=distance(X[i],Y[i],X[i+2],Y[i+2]);
            double c=distance(X[i+1],Y[i+1],X[i+2],Y[i+2]); 

            //Uses the law of cosine to compute angle
            double angleA=Math.acos((Math.pow(b,2)+Math.pow(c,2)-Math.pow(a, 2))/(2*b*c)); 

            //Uses theorem from the law of Sines
            if (a/Math.sin(angleA)<2*RADIUS1){
                return true;
            }
        }
        return false;

    }

    
    public static double distance(double x1, double y1, double x2, double y2){
        
        double xdiff=Math.abs(x1-x2); 
        double ydiff=Math.abs(y1-y2);
        return Math.sqrt(Math.pow(xdiff,2)+Math.pow(ydiff,2));
    }





}