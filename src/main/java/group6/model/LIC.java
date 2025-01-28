class LIC{

    public boolean CMV5(double[] X){

        for(int i=0; i<X.length-1;i++){
            if(X[i+1]-X[i]<0){
                return true;
            }           
        }
        return false;
    }

}