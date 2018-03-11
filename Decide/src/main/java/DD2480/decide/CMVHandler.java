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
		CMV[9] = licLine();
		CMV[10] = licTen();
		CMV[11] = licEleven();
		CMV[12] = licTwelve();
		CMV[13] = licThirteen();
		CMV[14] = licFourteen();
		return CMV;
	}

	private boolean licZero() {
        Points dp1, dp2;
        
        for(int i = 0; i < this.dataPoints.length - 1; i++) {
            dp1 = this.dataPoints[i];
            dp2 = this.dataPoints[i+1];

            double dist = Math.sqrt(Math.pow(Math.abs(dp1.x - dp2.x), 2) + Math.pow(Math.abs(dp1.y - dp2.y), 2));

            if (dist > parameters.length1) {
                return true;
            }
        }

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

	private boolean licLine() {
		// TODO Auto-generated method stub
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
