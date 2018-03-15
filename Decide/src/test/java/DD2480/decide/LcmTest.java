package DD2480.decide;

import org.junit.Test;
import static org.junit.Assert.*;
public class LcmTest{
	@Test
	/**
	 *@return The Lcm was correctly initialized to have all values
	 * be ANDD and 
	 */
	public void testLcmBuild(){
		Lcm lcm = new Lcm();
		for(int i = 0; i<15;i++){
			for(int j = 0; j<15;j++) {
				assertTrue(lcm.getElement(i,j).toString() == "ANDD");
			}
		}
	}
	@Test
	/**
	 *@return new Values are correctly put into the LcmElement matrix
	 */
	public void testLcmSet(){
		Lcm lcm = new Lcm();
		assertTrue(lcm.getElement(4,4).toString()== "ANDD");
		lcm.setElement(4,4,Lcm.lcmElement.ORR);
		assertTrue(lcm.getElement(4,4).toString()== "ORR");
	}
}