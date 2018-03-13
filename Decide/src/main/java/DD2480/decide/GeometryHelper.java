package DD2480.decide;
import java.lang.Math;
public class GeometryHelper {
	/**
	 *@param 3 Points in space where b does not coincide with a or c
	 *@return the angle betweeen lines ba and bc
	 */
	public static double angle(Points a, Points b, Points c){
		//Convert polar coordinate ba / bc become angle theta
		double ba = Math.atan2((a.x - b.x),(a.y - b.y));
		double bc = Math.atan2((c.x - b.x),(c.y -b.y));
		// return difference of angles
		return ba - bc;
	}
}
