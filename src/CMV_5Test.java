import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.beans.Transient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class CMV_5Test {
    //Arrange
    private Decide decide;

    @Before
    public void setUp(){
        decide= new Decide();
    }

    @Test
    public void CMV5True(){
        //Act 
        double[] X= {0,4,2}; 
        //Assert
        assertTrue(decide.CMV5(X));
    }

    @Test 
    public void CMV5False(){
         //Act 
         double[] X= {-2,4,5}; 

         //Assert
         assertFalse(decide.CMV5(X));
    }
}
