package DD2480.decide;
import java.lang.Math;
public class GeometryHelper {
	/**
	 *@param 3 Points in space where b does not coincide with a or c
	 *@return the angle betweeen lines ba and bc
	 */
	public static double angle(Points a, Points b, Points c){
		return Math.acos((Math.pow(b.distance(a),2)+Math.pow(b.distance(c),2)-Math.pow(a.distance(c),2))/(2*b.distance(a)*b.distance(c)));
	}
}
