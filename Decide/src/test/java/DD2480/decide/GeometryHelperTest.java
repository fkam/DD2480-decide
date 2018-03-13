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
}