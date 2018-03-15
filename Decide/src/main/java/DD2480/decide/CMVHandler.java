package DD2480.decide;

import java.lang.Math;

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
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licFour() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licFive() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licSix() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licSeven() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licEigth() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licEleven() {
		// TODO Auto-generated method stub
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
