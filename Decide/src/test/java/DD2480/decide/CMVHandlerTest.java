package DD2480.decide;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Arrays;

public class CMVHandlerTest{
    

    @Test
    public void CMVlicZero(){
    
        boolean[] CMV = new boolean[15];
        Parameter parameter = new Parameter();
            
        Points[] dataPoints = {
            new Points(0.0, 0.0),
            new Points(5.0, 5.0),
            new Points(4.0, 5.0),
            new Points(7.0, 9.0)
        };

        CMVHandler handler = new CMVHandler(parameter, dataPoints);
        parameter.length1 = 7;
        CMV = handler.generateCMV();
        assertTrue(CMV[0]);
        
        parameter.length1 = 10;
        CMV = handler.generateCMV();
        assertFalse(CMV[0]);

    }


}
