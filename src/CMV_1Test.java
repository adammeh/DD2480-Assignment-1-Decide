
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class CMV_1Test{
    //Arrange
    private Decide decide;

    @Before
    public void setUp(){
        decide= new Decide();
    }

    @Test
    public void correctDistance(){
        
        //Assert
        assertThat(0.0, equalTo(decide.distance(0.0, 0.0, 0.0, 0.0)));
        assertThat(5.0, equalTo(decide.distance(3.0, 4.0, 0.0, 0.0)));
        assertThat(5.0, equalTo(decide.distance(-3.0, -4.0, 0.0, 0.0)));
  
    }   

    @Test
    public void pointsInsideCircle(){
        //Act 
        double RADIUS1=1; 
        double[] X1= {0.0,1.0,0.0}; 
        double[] Y1= {0.0,0.0,1.0}; 

        double RADIUS2=2; 
        double[] X2= {0.0,3.0,0.0,0.0,1.0,0.0}; 
        double[] Y2= {0.0,0.0,3.0,0.0,0.0,1.0}; 
        
        //Assert
        assertTrue(decide.CMV1(X1,Y1, RADIUS1));
        assertTrue(decide.CMV1(X2,Y2, RADIUS2));


    }


    @Test
    public void pointsOutsideCircle(){
        //Act 
        double RADIUS1=0.5; 
        double[] X= {0.0,1.0,0.0}; 
        double[] Y= {0.0,0.0,1.0}; 

        double[] X2= {0.0,3.0,0.0,0.0,1.0,0.0}; 
        double[] Y2= {0.0,0.0,3.0,0.0,0.0,1.0}; 
        
        //Assert
        assertFalse(decide.CMV1(X,Y, RADIUS1));
        assertFalse(decide.CMV1(X2,Y2, RADIUS1));

    }


    @Test
    public void pointsInsideCircle_CMV2(){
        //Act 
        int A_PTS=1; 
        int B_PTS=2;
        int NUMPOINTS=6;
        
        double RADIUS1=3; 
        double[] X= {2, 0,3, 0,0,-2}; 
        double[] Y= {2,0,0,0,0,-1}; 
        
        //Assert
        assertTrue(decide.CMV2(X,Y,A_PTS, B_PTS, RADIUS1,NUMPOINTS));

    }


    @Test
    public void pointsOutsideCircle_CMV2(){
        //Act
        int A_PTS=1; 
        int B_PTS=2;
        int NUMPOINTS=6;
        
        double RADIUS1=3;
        double[] X= {0,0,-5,0,0,3}; 
        double[] Y= {4,0,0,0,0,3}; 

        //Assert
        assertFalse(decide.CMV2(X,Y,A_PTS, B_PTS, RADIUS1,NUMPOINTS));
    }


    @Test
    public void notEnoughPoints_CMV2(){
        //Act 
        int A_PTS=1; 
        int B_PTS=1;
        int NUMPOINTS=3;
        
        double RADIUS1=3; 
        double[] X= {2, 3, -2}; 
        double[] Y= {2,0,-1}; 
        
        //Assert
        assertFalse(decide.CMV2(X,Y,A_PTS, B_PTS, RADIUS1,NUMPOINTS));

    }



}
