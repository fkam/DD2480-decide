package DD2480.decide;

import org.junit.Test;
import static org.junit.Assert.*;

public class CMVHandlerTest{

    @Test
    /**
     * @result return true/false if distance between two points is larger than LENGHT1.
    **/
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
		//System.out.println(CMV[1]);
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
		/*
		System.out.println(CMV[1]);
		for(boolean x: CMV){
			System.out.println(x);
		}*/
		assertTrue(CMV[1]);
	}
}
