package DD2480.decide;

import org.junit.Test;
import static org.junit.Assert.*;

public class PointsTest{
    @Test
    /**
     * @result the distance between two points is correctly calculated 
     **/
    public void testDistance(){
        Points a = new Points(10,12);
        Points b = new Points(12,12);
        Double result1 = new Double(a.distance(b));
        Double result2 = new Double(b.distance(a));
        //System.out.println(result1);
        //System.out.println(result2);
        
        //test that distance does not dependant on which point calls the method 
        assertTrue(result1.equals(result2));
        //test that the distance was calculated correctly
        assertTrue(result1.equals(new Double(2)));
    }
}
