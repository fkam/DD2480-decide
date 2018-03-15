package DD2480.decide;

public class GeometryHelper {
	/**
	 *@param 3 Points in space where b does not coincide with a or c
	 *@return the angle betweeen lines ba and bc
	 */
	public static double angle(Points a, Points b, Points c){
		return Math.acos((Math.pow(b.distance(a),2)+Math.pow(b.distance(c),2)
                -Math.pow(a.distance(c),2))/(2*b.distance(a)*b.distance(c)));
	}

	/**
	 *@param 3 Points in space where b does not coincide with a or c
	 *@return the area of triangle abc, return 0 if they're on a line
	 */
	public static double area(Points a, Points b, Points c){

		//The idea is to convert the area of the triangle to the area of 
        //a right-angled trapezoidal minus the area of two right triangle 
        //The code will only show the simplified result
		double area = (a.x * b.y + a.y * c.x + b.x * c.y - a.x 
                        * c.y - a.y * b.x - b.y * c.x) / 2;

		return Math.abs(area);
	}


    /**
     * @param Three Points and a radious
	 * @return true if a cirkel with radious r can include all points within or on the egde
	 */
	public static boolean pointsWithinACircle(Points a, Points b, Points c, double r) {
		// Check if there is a distande between any two of the three points is longer than 2r
		if (a.distance(b) > 2*r || b.distance(c) > 2*r || c.distance(a) > 2*r) {
			return false;
		}
		// finds the larges distance between two points
		if (a.distance(b) >= a.distance(c) && a.distance(b) >= b.distance(c)) {
			return pointsInRightOrderWithinACircle(a,b,c,r);
		} else if (a.distance(c) >= a.distance(b) && a.distance(c) >= b.distance(c)) {
			return pointsInRightOrderWithinACircle(a,c,b,r);
		} else {
			return pointsInRightOrderWithinACircle(b,c,a,r);
		}
	}
	/**
	 * @param Three Points where the 2 first is the furtest away from each other and a radious
	 * @return true if a cirkel with radious r can include all points within or on the egde
	 */
	private static boolean pointsInRightOrderWithinACircle(Points c, Points d, Points e, double r) {
		// Finds the point inbetween c and d called center
		Points center = new Points((c.x+d.x)/2, (c.y+d.y)/2);
		// does a vector coresponding to center.
		Points vectorFromCenterToC = new Points(c.x-center.x, c.y-center.y);
		// Find the length of the vector
		double vectorLength = Math.sqrt(Math.pow(vectorFromCenterToC.x,2)+Math.pow(vectorFromCenterToC.y, 2));
		// calculate k witch is the factor to scale the ortogonal vector of the "vectorFromCenterToC" by
		// a vector (x,y) is perpendicular to (-y,x)
		double k = Math.sqrt((Math.pow(r, 2)-Math.pow(vectorLength, 2))/Math.pow(vectorLength, 2));
		// Write to cirkels with radoius r with centrum at c and d then you get two intersectpoint 
		// (they could be the same.)
		Points intersekt1 = new Points(center.x + k*vectorFromCenterToC.y ,center.y + -k*vectorFromCenterToC.x );
		Points intersekt2 = new Points(center.x + -k*vectorFromCenterToC.y ,center.y + k*vectorFromCenterToC.x );
		// if point e is within a distance equal or less then r to any of the two intercekt points then return true
		return e.distance(intersekt1) <= r || e.distance(intersekt2) <= r;
	}

    /**
     * Check which quadrant a point belongs to
     *
     * @param point that need to be checked
     * @return the belonging quadrant
     */
    public static int getQuadrant(Points point) {
        if (point.x >= 0 && point.y >= 0)
            return 1;
        if (point.x < 0 && point.y >= 0)
            return 2;
        if (point.x <= 0 && point.y < 0)
            return 3;
        if (point.x > 0 && point.y < 0)
            return 4;
        return -1;
    }
}
