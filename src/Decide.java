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