class Decide{
    static double triangleArea(double x0, double y0, double x1, double y1, double x2, double y2) {
        return 0.5 * Math.abs(x0 * (y1 - y2) + x1 * (y2 - y0) + x2 * (y0 - y1));
    }
    
    static boolean existsTriangleLargerThan(double[] X, double[] Y, int NUMPOINTS, int offset1, int offset2, double area) {
        for ( int i = 0; i + offset1 + offset2 < NUMPOINTS; ++i ) {
            double a = triangleArea(
                X[i],
                Y[i],
                X[i + offset1],
                Y[i + offset1],
                X[i + offset1 + offset2],
                Y[i + offset1 + offset2]
            );
            if ( a > area ) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean cmv3(double[] X, double[] Y, int NUMPOINTS, double AREA1) {
        if ( AREA1 < 0 ) {
            return false;
        }
        return existsTriangleLargerThan(X, Y, NUMPOINTS, 1, 1, AREA1);
    }
}
