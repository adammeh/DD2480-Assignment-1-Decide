import java.lang.Math;

public class Decide{


    public static boolean CMV1(double[] X, double[] Y, double RADIUS1){
        

        //Checks for every set of three consequtive datapoints
        for(int i=0; i<X.length-2;i++){

            double[] Xpoints ={X[i], X[i+1], X[i+2]};
            double[] Ypoints ={Y[i], Y[i+1], Y[i+2]};

            if (pointsFitInCircle(Xpoints, Ypoints, RADIUS1)){
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


    public static boolean pointsFitInCircle(double[] Xpoints, double[] Ypoints, double radius ){
        double a=distance(Xpoints[0],Ypoints[0],Xpoints[1],Ypoints[1]);
        double b=distance(Xpoints[0],Ypoints[0],Xpoints[2],Ypoints[2]);
        double c=distance(Xpoints[1],Ypoints[1],Xpoints[2],Ypoints[2]);

        //Uses the law of cosine to compute angle
        double angleA=Math.acos((Math.pow(b,2)+Math.pow(c,2)-Math.pow(a, 2))/(2*b*c)); 

        //Uses theorem from the law of Sines
        if (a/Math.sin(angleA)<2*radius){
            return true;
        }else{
            return false;
        }

    }

    public static boolean CMV8(double[] X, double[] Y, int A_PTS, int B_PTS, double RADIUS1, int NUMPOINTS){

        if (!(1<=A_PTS && 1<=B_PTS && A_PTS+B_PTS<=(NUMPOINTS-3))){
            return false;
        }

        for(int i=0; i<NUMPOINTS-(A_PTS+B_PTS+2);i++){
            double[] Xpoints ={X[i], X[i+A_PTS+1], X[i+A_PTS+B_PTS+2]};
            double[] Ypoints ={Y[i], Y[i+A_PTS+1], Y[i+A_PTS+B_PTS+2]};

            if (pointsFitInCircle(Xpoints, Ypoints, RADIUS1)){
                return true;
            }

        }
        return false;

    }




}