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

	/**
	 *@param 3 Points in space where b does not coincide with a or c
	 *@return the area of triangle abc, return 0 if they're on a line
	 */
	public static double area(Points a, Points b, Points c){
		//The idea is to convert the area of the triangle to the area of a right-angled trapezoidal minus the area of two right triangle
		//The code will only show the simplified result
		double area = (a.x * b.y + a.y * c.x + b.x * c.y - a.x * c.y - a.y * b.x - b.y * c.x) / 2;
		return Math.abs(area);
	}
}
