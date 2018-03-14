package DD2480.decide;
import java.lang.Math;
public class Points {

    public double x, y;

    public Points(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**	
     *	@Param a point in space
     *  @Return the distance betweent this point and the given point
     **/
    public double distance(Points otherPoint){
    	return Math.sqrt(Math.pow(x-otherPoint.x,2)+Math.pow(y-otherPoint.y,2));
    }
}
