package DD2480.decide;

public class CMVHandler {
	
	boolean[] CMV = new boolean[15]; 
	Parameter parameters;
	Points[] dataPoints;
	
	public CMVHandler(Parameter parameters, Points[] dataPoints) {
		this.parameters = parameters;
		this.dataPoints = dataPoints;
	}
	public boolean[] generateCMV() {
		CMV[0] = licZero();
		CMV[1] = licOne();
		CMV[2] = licTwo();
		CMV[3] = licThree();
		CMV[4] = licFour();
		CMV[5] = licFive();
		CMV[6] = licSix();
		CMV[7] = licSeven();
		CMV[8] = licEigth();
		CMV[9] = licNine();
		CMV[10] = licTen();
		CMV[11] = licEleven();
		CMV[12] = licTwelve();
		CMV[13] = licThirteen();
		CMV[14] = licFourteen();
		return CMV;
	}

    // There exists atleast one set of two consective data points that are a distance greater than the length, LENGTH1, apart.
    private boolean licZero() {
        Points dp1, dp2;
        // iterate through the list od datapoints, calculate the distance and compare to the length.
        for(int i = 0; i < this.dataPoints.length - 1; i++) {
            dp1 = this.dataPoints[i];
            dp2 = this.dataPoints[i+1];

            double dist = dp1.distance(dp2);

            if (dist > parameters.length1) {
                return true;
            }
        }

        return false;
    }


	private boolean licOne() {
		if(dataPoints.length<3){
			return false;
		}
		for(int i = 0; i<dataPoints.length-2;i++){
			if(!GeometryHelper.pointsWithinACircle(dataPoints[i],dataPoints[i+1],dataPoints[i+2],parameters.radius1)){
				return true;
			}
		}
		//if no point found return false
		return false;
	}

	private boolean licTwo() {
		if(dataPoints.length<3){
			return false;
		}
		for(int i = 0;i <dataPoints.length-2;i++){	
			//considered unsatisifed if any of point 1 or 3 is coincide with point 2
			if((dataPoints[i].x==dataPoints[i+1].x&&dataPoints[i].y==dataPoints[i+1].y)||(dataPoints[i+2].x==dataPoints[i+1].x&&dataPoints[i+2].y==dataPoints[i+1].y)){
				continue;
			}
			//get angle see if it is within the boundries
			double angle = GeometryHelper.angle(dataPoints[i],dataPoints[i+1],dataPoints[i+2]);
			if((angle<Math.PI -parameters.epsilon)||(angle>Math.PI+parameters.epsilon)){
				return true;
			}
		}
		return false;

	}

	private boolean licThree() {
        for (int index = 0; index < dataPoints.length - 2; index++) {
            if (GeometryHelper.area(dataPoints[index], dataPoints[index + 1], dataPoints[index + 2]) > parameters.area1)
                return true;
        }
        return false;
	}

	private boolean licFour() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licFive() {
        for (int i = 0; i < dataPoints.length - 1; i++) {
            if (dataPoints[i + 1].x - dataPoints[i].x < 0) {
                return true;
            }
        }
        return false;
	}

	private boolean licSix() {
		if(parameters.nPts < 3 || parameters.nPts > dataPoints.length || parameters.dist < 0)
			return false;
		for(int i = 0;i < dataPoints.length-parameters.nPts+1;i++){
			int k = i + parameters.nPts - 1;
			if(dataPoints[i].x == dataPoints[k].x && dataPoints[i].y == dataPoints[k].y){
				for(int j = i+1;j<k;j++){

					if(dataPoints[j].distance(dataPoints[i])>parameters.dist)
						return true;	
				}
			} else {
				double d = dataPoints[i].distance(dataPoints[k]);
				for(int j = i+1;j<k;j++){
					double s = GeometryHelper.area(dataPoints[i], dataPoints[k], dataPoints[j]);
					double l = s / d * 2.0;
					if(l > parameters.dist){
						return true;
					}
					else if(l < parameters.dist&&
						dataPoints[i].distance(dataPoints[j])>parameters.dist&&
						dataPoints[k].distance(dataPoints[j])>parameters.dist&&
						(Math.sqrt(Math.pow(dataPoints[i].distance(dataPoints[k]),2)+(parameters.dist*parameters.dist))<
						 Math.max(dataPoints[i].distance(dataPoints[k]),dataPoints[k].distance(dataPoints[j])))){
								return true;
					}
				}
			}
		}
		return false;
	}
    /*
     * There exits at least one set of two data points separated by exactly kPts consecutive intervening points that are a distance greater than the length,
     * LENGTH1, apart. The condition is not met whe NUMPOINTS < 3. 1 =< kPts =< NUMPOINTS - 2.
     */
	private boolean licSeven() {
        Points  dp1, dp2;
        if (dataPoints.length < 3){
            return false;
        }
        if (1 > parameters.kPts || parameters.kPts > (dataPoints.length - 2)){
            return false;
        }
        for (int i = 0; i < dataPoints.length - parameters.kPts - 1; i++){
            dp1 = dataPoints[i];
            dp2 = dataPoints[i + parameters.kPts + 1];

            double dist = dp1.distance(dp2);
            if (dist > parameters.length1){
                return true;
            }
        }
        return false;
	}

    /*There exists at least one set of three data points separated by exactly A_PTS and B_PTS
     *consecutive intervening points, respectively, that cannot be contained within or on a circle of
     *radius RADIUS1. The condition is not met when NUMPOINTS < 5.
     *1 =< A_PTS, 1 =< B_PTS
     *A_PTS+B_PTS =< (NUMPOINTS - 3)
     */

    private boolean licEigth() {
        Points dp1, dp2, dp3;
        if (dataPoints.length < 5){
            return false;
        }
        if (parameters.aPts < 1 || parameters.bPts < 1){
            return false;
        }
        if (parameters.aPts + parameters.bPts > (dataPoints.length -3)){
            return false;
        }
        if (parameters.radius1 < 0){
            return false;
        }
        for (int i = 0; i < dataPoints.length - parameters.aPts - parameters.bPts - 2; i++){
            dp1 = dataPoints[i];
            dp2 = dataPoints[i + parameters.aPts + 1];
            dp3 = dataPoints[i + parameters.aPts + parameters.bPts + 2];

            boolean circle = GeometryHelper.pointsWithinACircle(dp1, dp2, dp3, parameters.radius1);
                if (!circle){
                    return true;
                }
        }

        return false;
    }

	private boolean licNine() {
		if(dataPoints.length<5||parameters.cPts+parameters.dPts>dataPoints.length-3){
			return false;
		}
		for(int i = 0;i < dataPoints.length-2-parameters.cPts-parameters.dPts;i++){

			if((dataPoints[0].x==dataPoints[parameters.cPts+1].x&&
			    	dataPoints[0].y==dataPoints[parameters.cPts+1].y)||
			   (dataPoints[parameters.cPts+parameters.dPts+2].x==dataPoints[parameters.cPts+1].x&&
			    	dataPoints[parameters.cPts+parameters.dPts+2].y==dataPoints[parameters.cPts+1].y)){
					continue;
			}
			//get angle see if it is within the boundries
			double angle = GeometryHelper.angle(dataPoints[0],dataPoints[parameters.cPts+1],dataPoints[parameters.cPts+parameters.dPts+2]);
			if((angle<Math.PI -parameters.epsilon)||(angle>Math.PI+parameters.epsilon)){
				return true;
			}
		}
		return false;
	}

	private boolean licTen() {
		if(parameters.ePts < 1 || parameters.fPts < 1 || parameters.ePts+parameters.fPts+3 > dataPoints.length)
			return false;
		for(int i = 0;i<dataPoints.length-parameters.ePts-parameters.fPts-2;i++){
			double s = GeometryHelper.area(dataPoints[i], dataPoints[i+parameters.ePts+1],
                         dataPoints[i+parameters.ePts+parameters.fPts+2]);
			if(s > parameters.area1)
				return true;
		}
		return false;
	}

	private boolean licEleven() {
		if(parameters.gPts < 1 || parameters.gPts > dataPoints.length - 2)
			return false;
		for(int i = 0;i<dataPoints.length-parameters.gPts-1;i++){
			if(dataPoints[i+parameters.gPts+1].x-dataPoints[i].x<0)
				return true;
		}
		return false;
	}
	
	private boolean licTwelve() {
		if(dataPoints.length < 3 || parameters.length2 < 0) {
			return false;
		}
		boolean condition1 = false , condition2 = false;
		for (int i = 0; i < dataPoints.length - parameters.kPts - 1; i++) {
			if (dataPoints[i].distance(dataPoints[i + parameters.kPts +1]) > parameters.length1) {
				condition1 = true;
			}
			if (dataPoints[i].distance(dataPoints[i + parameters.kPts +1]) < parameters.length2) {
				condition2 = true;
			}
		}
		return condition1 && condition2;
	}

	private boolean licThirteen() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licFourteen() {
		// TODO Auto-generated method stub
		return false;
	}	
}
