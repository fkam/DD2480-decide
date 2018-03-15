package DD2480.decide;

import org.junit.Test;
import static org.junit.Assert.*;
public class GeometryHelperTest{
	@Test
	/**
	 *@result the angle between two lines given by 3 points is correctly calculated
	 */
	public void testAngle(){
		//given input for which output is defined output correct angle
		Points a = new Points(1,1);
		Points b = new Points(0,0);
		Points c = new Points(0,1);
		double angle = GeometryHelper.angle(a,b,c);
		assertTrue(Math.abs(Math.toDegrees(angle)-45.0)<0.00001);
		//switch Points

		a  =  new Points(0,1);
		b  =  new Points(1,1);
		c  =  new Points(0,0);
		angle = GeometryHelper.angle(a,b,c);

		assertTrue(Math.abs(Math.toDegrees(angle)-45.0)<0.00001);

		//switch points
		a  =  new Points(0,0);
		b  =  new Points(0,1);
		c  =  new Points(1,1);
		angle = GeometryHelper.angle(a,b,c);
		assertTrue(Math.abs(Math.toDegrees(angle)-90.0)<0.00001);
	}

	@Test
	/**
	 *@result the area of the triangle decided by 3 given points is correctly calculated
	 */
	public void testArea(){
		//given input for which output is defined output correct area
		Points a = new Points(1,1);
		Points b = new Points(2,0);
		Points c = new Points(0,1);
		double area = GeometryHelper.area(a,b,c);
		assertTrue(area==0.5);
		//switch points
		a  =  new Points(1,1);
		b  =  new Points(1,2);
		c  =  new Points(1,0);
		area = GeometryHelper.area(a,b,c);
		assertTrue(area==0.0);
		//switch points
		a  =  new Points(0,0);
		b  =  new Points(0,5);
		c  =  new Points(1,2);
		area = GeometryHelper.area(a,b,c);
		assertTrue(area==2.5);
	}

	@Test
	/**
	 *@result Three point 0;0 , 1;0 , 4,0 with radious 2 should return true
	 */
	public void testPointsInRightOrderWithinACircle1(){
		//given input for which output is defined output correct area
		double r = 2.0;
		Points a = new Points(0,0), b = new Points(1,0), c = new Points(4,0);
		boolean check1 = GeometryHelper.pointsWithinACircle(a, b, c, r);
		assertTrue(check1);
		//switch points
		a = new Points(1,0); b = new Points(4,0); c = new Points(0,0);
		boolean check2 = GeometryHelper.pointsWithinACircle(a, b, c, r);
		assertTrue(check2);
		//switch points
		a = new Points(4,0); b = new Points(0,0); c = new Points(1,0);
		boolean check3 = GeometryHelper.pointsWithinACircle(a, b, c, r);
		assertTrue(check3);
		
	}
  
	@Test
	/**
	 *@result Three point 0;0 , 1;0 , 4,0 with radious 1.99 should return false
	 */
	public void testPointsInRightOrderWithinACircle2(){
		//given input for which output is defined output correct area
		double r = 1.99;
		Points a = new Points(0,0), b = new Points(1,0), c = new Points(4,0);
		boolean check1 = GeometryHelper.pointsWithinACircle(a, b, c, r);
		assertFalse(check1);
	}
  
	@Test
	/**
	 *@result Three point 0;0 , 2;sqrt(12) , 4,0 with radious 2.31 should return true and
	 * 2.30 should return false
	 */
	
	public void testPointsInRightOrderWithinACircle3(){
		//given input for which output is defined output correct area
		double r = 2.31;
		Points a = new Points(0,0), b = new Points(4,0), c = new Points(2,Math.sqrt(12));
		boolean check1 = GeometryHelper.pointsWithinACircle(a, b, c, r);
		assertTrue(check1);
		
		//switch radious
		r = 2.30;
		boolean check2 = GeometryHelper.pointsWithinACircle(a, b, c, r);
		assertFalse(check2);
	}

}
