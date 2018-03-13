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