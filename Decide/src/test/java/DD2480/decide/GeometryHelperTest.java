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
		assertTrue(Math.toDegrees(angle)==45.0);
		//switch points
		a  =  new Points(0,1);
		b  =  new Points(1,1);
		c  =  new Points(0,0);
		angle = GeometryHelper.angle(a,b,c);
		assertTrue(Math.toDegrees(angle)==45.0);
		//switch points
		a  =  new Points(0,0);
		b  =  new Points(0,1);
		c  =  new Points(1,1);
		angle = GeometryHelper.angle(a,b,c);
		assertTrue(Math.toDegrees(angle)==90.0);
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
}

