package DD2480.decide;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.Math;
import java.util.Arrays;
public class DecideTest{
	 	/**
	 	 * initialize base values for testing.
	 	 */
		Parameter parameters = new Parameter();


		Points [] points = {
			new Points(0.0,0.0),
			new Points(1.0,1.0),
			new Points(0.5,0.5),
			new Points(0.0,5.0),
			new Points(20.0,30.0),
			new Points(45.0,300.0),
			new Points(0.0,0.0)
		};
		Lcm lcm = new Lcm();
		boolean [] puv = new boolean[15];
	@Before
	public void setup(){
		parameters.length1 = 1;
		parameters.length2 = 1;
		parameters.radius1 = 1;
		parameters.radius2 = 1;
		parameters.epsilon = Math.PI/4;
		parameters.area1 = 1;
		parameters.area2 = 1;
		parameters.dist = 1;
		parameters.qPts = 1;
		parameters.quads = 1;
		parameters.nPts = 1;
		parameters.kPts = 1;
		parameters.aPts = 1;
		parameters.bPts = 1;
		parameters.cPts = 1;
		parameters.dPts = 1;
		parameters.ePts = 1;
		parameters.fPts = 1;
		parameters.gPts = 1;
		Arrays.fill(puv,false);
	}

	@Test
	/**
	 * @result When all values in the FUV are false yes is allways the output
	 */
	public void testFuV(){
		Decide decide = new Decide(parameters,lcm,puv,points);
		assertTrue( decide.Decide());
	}

    @Test
    /**
     * @result if every element in the logical connector matrix is set to NOTUSED
     * true all values in PUM evaluate to true and thusly decide returns true.
     */
    public void testPUM(){
    	Arrays.fill(puv,true);
        for(int i = 0; i < 15; i++){
                for (int j = 0; j < 15; j++){
                    lcm.setElement(i, j, Lcm.lcmElement.NOTUSED);
                }       
        }
        Decide decide = new Decide(parameters, lcm, puv, points);
        assertTrue(decide.Decide());
        lcm = new Lcm();
    }
    @Test
    public void derp(){
    	CMVHandler handler = new CMVHandler(parameters,points);
    	boolean[] cmv = handler.generateCMV();
    	for(int i = 0 ; i < 15; i ++){
    		System.out.println(cmv[i]);
    	}
    }
    @Test
    public void testSomething(){
    	Arrays.fill(puv,false);

    }
}
