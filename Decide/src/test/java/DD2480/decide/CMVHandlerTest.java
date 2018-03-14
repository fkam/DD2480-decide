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
		System.out.println(Math.PI - parameters.epsilon);
		System.out.println(Math.PI + parameters.epsilon);
		Points[] datapoints = {
			new Points(0.0,0.0),
			new Points(1.5,0.1),
			new Points(3.0,0.0)
		};
		System.out.println(GeometryHelper.angle(datapoints[0],datapoints[1],datapoints[2]));
		CMVHandler handler = new CMVHandler(parameters,datapoints);
		CMV = handler.generateCMV();
		System.out.println(CMV[2]);
		assertFalse(CMV[2]);
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
}