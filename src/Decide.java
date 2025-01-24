class Decide{
    static boolean CMV_2(double[] x_coordinates, double[] y_coordinates, int NUMPOINTS, double EPSILON){
        int index = 0;
        while (index+2 < NUMPOINTS){
            double angle = computeAngle(x_coordinates[index], y_coordinates[index],
                    x_coordinates[index+1], y_coordinates[index+1],
                    x_coordinates[index+2], y_coordinates[index+2]);
            if(angle < (Math.PI - EPSILON) || angle > (Math.PI + EPSILON)) {
                return true;
            }
            else{
                index += 1;
            }
        }
        return false;
    }

    static boolean CMV_6(double[] x_coordinates, double[] y_coordinates, int NUMPOINTS, double DIST, int N_PTS){
        if(NUMPOINTS < 3){
            return false;
        }
        int index = 0;
        while (index+N_PTS < NUMPOINTS+1){

            double[] p0 = {x_coordinates[index], y_coordinates[index]};
            double[] pn = {x_coordinates[index+N_PTS-1], y_coordinates[index+N_PTS-1]};
            //to avoid repeated computation calculate the factors of the equation of the line P0-Pn
            double a = pn[1] - p0[1];
            double b = p0[0] - pn[0];
            double c = pn[0] * p0[1] - pn[1] * p0[0];
            //overlapping points case
            if(a == 0 && b == 0){
                for(int i = 1; i < x_coordinates.length -1; i++){
                    double distance = Math.sqrt(x_coordinates[i]*x_coordinates[i] + y_coordinates[i]*y_coordinates[i]);
                    if(distance > DIST){
                        return true;
                    }
                }
            } else {
                for(int i = 1; i < x_coordinates.length -1; i++){
                    double distance = Math.abs(a*x_coordinates[i] + b*y_coordinates[i] + c) / Math.sqrt(a*a + b*b);
                    if(distance > DIST){
                        return true;
                    }
                }
            }
            index += 1;

        }
        return false;
    }

    static boolean CMV_9(double[] x_coordinates, double[] y_coordinates, int NUMPOINTS, double EPSILON,
                         int C_PTS, int D_PTS){
        if(NUMPOINTS < 5){
            return false;
        }
        int index = 0;
        while (index+C_PTS+D_PTS+2 < NUMPOINTS){
            double angle = computeAngle(x_coordinates[index], y_coordinates[index],
                    x_coordinates[index+C_PTS+1], y_coordinates[index+C_PTS+1],
                    x_coordinates[index+C_PTS+D_PTS+2], y_coordinates[index+C_PTS+D_PTS+2]);
            if(angle < (Math.PI - EPSILON) || angle > (Math.PI + EPSILON)) {
                return true;
            }
            else{
                index += 1;
            }
        }
        return false;
    }

    static double computeAngle(double p0_x, double p0_y, double p1_x, double p1_y, double p2_x, double p2_y){
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