class Decide{
    static boolean CMV_2( double[] x_coordinates, double[] y_coordinates, int numpoints, double EPSILON){
        int index = 0;
        while (index+2 < numpoints){
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

    /*This method does not return the true angle!!! But the non-reflex angle formed by the three points [0, Math.PI]
    Fine for our intended use (non-reflex < PI-EPSILON) <=> (reflex > PI 1 EPSILON)
    Will return NaN if a another point overlaps with the vertex point*/
    static double computeAngle(double p0_x, double p0_y, double p1_x, double p1_y, double p2_x, double p2_y){
        double ABx = p1_x - p0_x;
        double ABy = p1_y - p0_y;
        double BCx = p2_x - p1_x;
        double BCy = p2_y - p1_y;

        double dotProduct = ABx * BCx + ABy * BCy;
        double magnitudeAB = Math.sqrt(ABx*ABx + ABy*ABy);
        double magnitudeBC = Math.sqrt(BCx*BCx + BCy*BCy);

        return Math.PI - Math.acos(dotProduct / (magnitudeAB * magnitudeBC));

    }

}