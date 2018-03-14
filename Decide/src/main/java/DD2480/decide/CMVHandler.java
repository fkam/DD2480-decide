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

	private boolean licZero() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licOne() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licTwo() {
		// TODO Auto-generated method stub
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
		if(nPts < 3 || nPts > dataPoints.length || dist < 0)
			return false;
		for(int i = 0;i < dataPoints.length-nPts+1;i++){
			int k = i + nPts - 1;
			if(dataPoints[i].x == dataPoints[k].x && dataPoints[i].y == dataPoints[k].y){
				for(int j = i+1;j<k;j++){
					if(dataPoints[j].x!=dataPoints[i].x || dataPoints[j].y!=dataPoints[i].y)
						return true;
				}
			} else {
				double d = Math.sqrt((dataPoints[i].x-dataPoints[k].x) * (dataPoints[i].x-dataPoints[k].x) + (dataPoints[i].y-dataPoints[k].y) * (dataPoints[i].y-dataPoints[k].y));
				for(int j = i+1;j<k;j++){
					double s = GeometryHelper.area(dataPoints[i], dataPoints[k], dataPoints[j]);
					double l = s / d;
					if(l > dist)
						return true;
				}
			}
		}
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
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licTen() {
		// TODO Auto-generated method stub
		if(ePts < 1 || fPts < 1 || ePts+fPts+2<dataPoints.length)
			return false;
		for(int i = 0;i<dataPoints.length-ePts-fPts-2;i++){
			double s = GeometryHelper.area(dataPoints[i], dataPoints[i+ePts+1], dataPoints[i+ePts+fPts+2]);
			if(s > area1)
				return true;
		}
		return false;
	}

	private boolean licEleven() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean licTwelve() {
		// TODO Auto-generated method stub
		return false;
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
