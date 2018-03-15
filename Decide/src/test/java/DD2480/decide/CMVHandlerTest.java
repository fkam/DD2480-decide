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
	/**
	 *@result given a set of data points with a subset satisfying the condition true is returned
	 */
	public void testCMV2nice(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.epsilon = (Math.PI/4)*3;
		Points[] datapoints = {
			new Points(3.0,0.0),
			new Points(1.0,1.0),
			new Points(0.0,0.0),
			new Points(1.0,0.0),
			new Points(0.0,2222.0)
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertTrue(CMV[2]);
	}
  
	@Test 
	/**
	 *@result given a set of datapoints with no subset satisfying the condition false is returned
	 */
	public void testCMV2bad(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.epsilon = Math.PI/4;
		Points[] datapoints = {
			new Points(0.0,0.0),
			new Points(1.5,0.1),
			new Points(3.0,0.0)
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertFalse(CMV[2]);
	}

	@Test
	/**
	 * @result when there exists at least 1 data point that lies a distance greater than DIST from the line return true
	 **/
	public void testCMV6nice1(){
		boolean[] CMV = new boolean[15];

		Parameter parameters = new Parameter();
		parameters.dist = 2.0;
		parameters.nPts = 3;
		Points[] datapoints1 = {
			new Points(0.0 , 0.0),
			new Points(-1.0 , 2.5),
			new Points(2.0 , 0.0),
			new Points(0.0 , 2.0)
		};
		CMVHandler handler1 = new CMVHandler(parameters,datapoints1);
		CMV = handler1.generateCMV();
		assertTrue(CMV[6]);
    }

    @Test
    public void testCMV6nice2(){
        boolean[] CMV = new boolean[15];
        Parameter parameters = new Parameter();
        parameters.dist = 1.0;
        parameters.nPts = 3;
		Points[] datapoints2 = {
			new Points(0.0 , 0.0),
			new Points(-1.0 , 1.0),
			new Points(0.0 , 0.0),
			new Points(0.0 , 2.0)
		};
		CMVHandler handler2 = new CMVHandler(parameters,datapoints2);
		CMV = handler2.generateCMV();
		assertTrue(CMV[6]);
	}

	@Test 
	/**
	 *@result given a set of datapoints with no subset satisfying the condition false is returned
	 */
	public void testCMV6bad(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.dist = 20.0;
		parameters.nPts = 3;
		Points[] datapoints1 = {};
		CMVHandler handler1 = new CMVHandler(parameters,datapoints1);
		CMV = handler1.generateCMV();
		assertFalse(CMV[6]);
		Points[] datapoints2 = {
			new Points(0.0 , 0.0),
			new Points(1.5 , 0.1),
			new Points(3.0 , 0.0)
		};
		CMVHandler handler2 = new CMVHandler(parameters,datapoints2);
		CMV = handler2.generateCMV();
		assertFalse(CMV[6]);
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

            
  
  @Test

	/**
	 *@result
	 */
	public void testCMV9nice(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.epsilon = (Math.PI/4)*3;
		parameters.cPts = 1;
		parameters.dPts = 1;
		Points[] datapoints = {
			new Points(0.0,2222.0),
			new Points(1.0,1.0),
			new Points(3.0,0.0),
			new Points(0.0,0.0),
			new Points(0.0,2222.0),
			new Points(1.0,0.0)
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertTrue(CMV[9]);
	}
	@Test
	/**
	 *@result
	 */
	public void testCMV9bad(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.epsilon = Math.PI/4;
		parameters.cPts = 1;
		parameters.dPts = 1;
		Points[] datapoints = {
			new Points(0.0,0.0),
			new Points(0.0,0.0),
			new Points(1.5,0.1),
			new Points(1.5,0.1),
			new Points(3.0,0.0),
			new Points(3.0,0.0)
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertFalse(CMV[9]);
  }
    
	@Test
	/**
	 * @result when there exists 3 data points that separated by E_PTS and F_PTS points forms a triangle whose area is greater than AREA1 return true
	 **/
	public void testCMV10nice(){
		boolean[] CMV = new boolean[15];

		Parameter parameters = new Parameter();
		parameters.area1 = 2.0;
		parameters.ePts = 1;
		parameters.fPts = 1;
		Points[] datapoints = {
			new Points(0.0 , 0.0),
			new Points(-1.0 , 2.5),
			new Points(2.1 , 0.0),
			new Points(2.0 , 0.0),
			new Points(0.0 , 2.0)
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertTrue(CMV[10]);
	}

	@Test 
	/**
	 *@result given a set of datapoints with no subset satisfying the condition false is returned
	 */
	public void testCMV10bad(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.area1 = 20.0;
		parameters.ePts = 1;
		parameters.fPts = 1;
		Points[] datapoints1 = {};
		CMVHandler handler1 = new CMVHandler(parameters,datapoints1);
		CMV = handler1.generateCMV();
		assertFalse(CMV[10]);
		Points[] datapoints2 = {
			new Points(0.0 , 0.0),
			new Points(0.0 , 0.0),
			new Points(1.5 , 0.1),
			new Points(1.5 , 0.1),
			new Points(3.0 , 0.0)
		};
		CMVHandler handler2 = new CMVHandler(parameters,datapoints2);
		CMV = handler2.generateCMV();
		assertFalse(CMV[10]);
	}

	@Test
	/**
	 * @result when there exists 2 data points separated by G_PTS points that satisfied X[j]-X[i]<0 (j>i) return true
	 **/
	public void testCMV11nice(){
		boolean[] CMV = new boolean[15];

		Parameter parameters = new Parameter();
		parameters.gPts = 1;
		Points[] datapoints1 = {
			new Points(0.0 , 0.0),
			new Points(1.0 , 2.5),
			new Points(2.0 , 0.0),
			new Points(0.0 , 2.0)
		};
		CMVHandler handler1 = new CMVHandler(parameters,datapoints1);
		CMV = handler1.generateCMV();
		assertTrue(CMV[11]);
		parameters.gPts = 2;
		Points[] datapoints2 = {
			new Points(4.0 , 0.0),
			new Points(-1.0 , 1.0),
			new Points(0.0 , 0.0),
			new Points(0.0 , 2.0)
		};
		CMVHandler handler2 = new CMVHandler(parameters,datapoints2);
		CMV = handler2.generateCMV();
		assertTrue(CMV[11]);
	}

	@Test 
	/**
	 *@result given a set of datapoints with no subset satisfying the condition false is returned
	 */
	public void testCMV11bad(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.gPts = 1;
		Points[] datapoints1 = {
			new Points(1.0 , 0.0),
			new Points(0.0 , 0.0)
		};
		CMVHandler handler1 = new CMVHandler(parameters,datapoints1);
		CMV = handler1.generateCMV();
		assertFalse(CMV[11]);
		Points[] datapoints2 = {
			new Points(0.0 , 0.0),
			new Points(1.5 , 0.1),
			new Points(3.0 , 0.0)
		};
		CMVHandler handler2 = new CMVHandler(parameters,datapoints2);
		CMV = handler2.generateCMV();
		assertFalse(CMV[11]);
	}

	@Test
	/**
	 * @result when a set of 2 point seperated by kPts points has a distance > length1 also 
	 * a set of 2 point seperated by kPts points has a distance < length2
	 * This test has length1/length2 equal to max/min distance between a set of two points
	 * return false
	 **/
	public void testCMV12bad(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.kPts = 2;
		parameters.length1 = 3;
		parameters.length2 = 1;
		Points[] datapoints = {
			new Points(0.0,0.0),
			new Points(1.0,0.0),
			new Points(1.0,0.0),
			new Points(3.0,0.0),
			new Points(2.0,0.0)	
		};
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		assertFalse(CMV[12]);
	}
	@Test
	/**
	 * @result when a set of 2 point seperated by kPts points has a distance > length1 also 
	 * a set of 2 point seperated by kPts points has a distance < length2
	 * This test has length1/length2 less/more to max/min distance between a set of two points
	 * return true
	 **/
	public void testCMV12nice(){
		boolean[] CMV = new boolean[15];
		Parameter parameters = new Parameter();
		parameters.kPts = 2;
		parameters.length1 = 2;
		parameters.length2 = 2;
		Points[] dataPoints = {
			new Points(0.0,0.0),
			new Points(1.0,0.0),
			new Points(1.0,0.0),
			new Points(3.0,0.0),
			new Points(2.0,0.0)	
		};
		CMVHandler handler = new CMVHandler(parameters,dataPoints);
		CMV = handler.generateCMV();
		assertTrue(CMV[12]);

	}
}




