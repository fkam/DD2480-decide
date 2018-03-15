package DD2480.decide;

public class Decide {
	
	// Parameters contains all input for Decide()
	Parameter parameters;
	// A set of input coordinates
	Points[] dataPoints;
	// Preliminary Unlocking Vector
	boolean[] PUV = new boolean[15];
	// Conditions Met Vector
	boolean[] CMV = new boolean[15];
	// Preliminary Unlocking Matrix
	boolean[][] PUM = new boolean[15][15];
	// Final Unlocking Vector
	boolean[] FUV = new boolean[15];
	// Logical Connector Matrix
	Lcm LCM;
	
	// This class handles all the LIC conditions
	CMVHandler CMVHandler;
	
	/**
	 *@param Parameters, LCM, PUV and datapoints.
	 * Decides if it is LAUNCH or NO LAUNCH based upon inputs.
	 *@return a boolean, true for LAUNCH or false for NO LAUNCH
	 */
	public Decide(Parameter parameters, Lcm LCM, boolean[] PUV,  Points[] dataPoints) {

		this.parameters = parameters;
		this.LCM = LCM;
		this.PUV = PUV;
		this.dataPoints = dataPoints;
		CMVHandler = new CMVHandler(parameters, dataPoints);
		CMV = generateCMV();
		PUM = generatePUM();
		FUV = generateFUV();
	}
  
	public boolean Decide(){
		return launch();
	}
	
	// Here are all the LIC contions processed

	private boolean[] generateCMV() {
		return CMVHandler.generateCMV();
	}
	
	private boolean[][] generatePUM() {
		for(int i = 0;i<15;i++){
			for( int j = 0;j<15;j++){
				switch (LCM.getElement(i,j)) {
					case ANDD:
						if(CMV[i] &&CMV[j]){
							PUM[i][j] = true;
						}else{
							PUM[i][j] = false;
						}
						break;
					case ORR:
						if(CMV[i]||CMV[j]){
							PUM[i][j] = true;
						}
						else{
							PUM[i][j] = false;
						}
						break;
					case NOTUSED:
						PUM[i][j] = true;					
				}
			}
		}
		return PUM;
	}
	
	private boolean[] generateFUV() {
	    for(int i = 0; i < FUV.length; i++){
            if(!PUV[i] || checkArray(PUM[i], i)){
                FUV[i] = true;
            } else {
                FUV[i] = false;
            }  
        }
        return FUV;
    }
    
	// This is the last decition metod that returns the final boolean
    private boolean launch(){
        for(int i = 0; i < FUV.length; i++){
            if (!FUV[i]){
                System.out.println("NO");
                return false;
            }
        }
        System.out.println("YES");
        return true;
    }

    // Used in generatePUV()
    private boolean checkArray(boolean[] array, int i){
        int j = 0;
        for(boolean x : array){
            if (j == i){
                j++;
                continue;
            }
            if (!x){
                return false;
            } j++;
        }
	    return true;
    }
}
