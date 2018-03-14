package DD2480.decide;

import org.junit.Test;
import static org.junit.Assert.*;
public class CMVHandlerTest{
	@Test
	/**
	 * @result when all consequite datapoints can be put into a circle returns false
	 **/
	public void testCMV1bad(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.radius1 = 2;
		Points[] datapoints = {
			new Points(0.0,0.0),
			new Points(1.0,0.0),
			new Points(2.0,0.0)	
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertFalse(CMV[1]);
	}
	@Test
	/**
	 * @result when there exists att least 3 consequite data points that can fittied into a circle with a given radius return true
	 **/
	public void testCMV1nice(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.radius1 = 2;
		Points[] datapoints = {
			new Points(0.0,0.0),
			new Points(1.0,0.0),
			new Points(2.0,0.0),
			new Points(0.0,2222.0)
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertTrue(CMV[1]);
	}

    @Test
    /*
     * @results - returns false when the length(NUMPOINTS) of data points is less then 3.
     */
    public void test1CMVSeven(){
        boolean[] CMV = new boolean[15];
        Parameter parameters = new Parameter();
        Points[] dataPoints = {
            new Points(0.0, 0.0),
            new Points(1.0, 0.0)
        };
        CMVHandler handler = new CMVHandler(parameters, dataPoints);
        CMV = handler.generateCMV();
        assertFalse(CMV[7]);
    }
    
    /*
     * @resulsts - returns true when there exists at least one set of two data points separated by kPts.
     */
    @Test
    public void test2CMVSeven(){
        Parameter parameters = new Parameter();
        boolean[] CMV = new boolean[15];
        Points[] dataPoints = {
            new Points(0.0, 0.0),
            new Points(1.0, 0.0),
            new Points(5.0, 5.0)
        };  
        parameters.kPts = 1;
        parameters.length1 = 3;
        CMVHandler handler = new CMVHandler(parameters, dataPoints);
        CMV = handler.generateCMV();                   
        assertTrue(CMV[7]);
    }         

            
    
}
