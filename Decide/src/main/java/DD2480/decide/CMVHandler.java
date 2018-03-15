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
		//first 3 consecutive datapoints
		Points first = dataPoints[0];
		Points second = dataPoints[1];
		Points third = dataPoints[2];
		boolean keepSearching = (dataPoints.length>3) ? true : false;
		for(int i = 2; i<dataPoints.length;){
			//calculate point equidistant from all 3 points
			double centerX = (first.x + second.x + third.x)/3;
			double centerY = (first.y + second.y + third.y)/3;
			Points center = new Points(centerX,centerY);
			//if the distance is between the center of the circle and the 
			//3 points return true
			if(center.distance(first) > parameters.radius1 ||
			   center.distance(second)> parameters.radius1 ||
			   center.distance(third) > parameters.radius1){
				return true;
			}
			i++;
			//shift the consecutive datapoint forward one step if we have a set of points larger than 3
			if(keepSearching){
				first = second;
				second = third;
				third = dataPoints[i];
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
		boolean keepSearching = (dataPoints.length>3+parameters.cPts+parameters.dPts) ? true : false;
		//first 3 consecutive datapoints
		Points first = dataPoints[0];
		Points second = dataPoints[parameters.cPts+1];
		Points third = dataPoints[parameters.cPts+parameters.dPts+2];
		int pos = 0;
		for(int i = 2+parameters.cPts+parameters.dPts;i < dataPoints.length;i++){

			if((first.x==second.x&&first.y==second.y)||(third.x==second.x&&third.y==second.y)){
				continue;
			}
			//get angle see if it is within the boundries
			double angle = GeometryHelper.angle(first,second,third);
			if((angle<Math.PI -parameters.epsilon)||(angle>Math.PI+parameters.epsilon)){
				return true;
			}

			if(keepSearching&&(pos+parameters.cPts+parameters.dPts+2)>=dataPoints.length){
				pos++;
				first = dataPoints[pos];
				second = dataPoints[pos+parameters.cPts+1];
				third = dataPoints[pos+parameters.cPts+parameters.dPts+2];
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
