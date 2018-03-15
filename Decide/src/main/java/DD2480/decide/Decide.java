package DD2480.decide;

public class Decide {
	
	Parameter parameters;
	Points[] dataPoints;
	
	boolean[] PUV = new boolean[15];
	boolean[] CMV = new boolean[15];
	boolean[][] PUM = new boolean[15][15];
	boolean[] FUV = new boolean[15];
	Lcm LCM;
	
	CMVHandler CMVHandler;

	public static void main(String[] args) {
		
	}
	
	public Decide( Parameter parameters, Lcm LCM, boolean[] PUV,  Points[] dataPoints) {
		this.parameters = parameters;
		this.LCM = LCM;
		this.PUV = PUV;
		this.dataPoints = dataPoints;
		CMVHandler = new CMVHandler(parameters, dataPoints);
		CMV = generateCMV();
		PUM = generatePUM();
		FUV = generateFUV();
	}

	private boolean[] generateCMV() {
		return CMVHandler.generateCMV();
	}
	
	private boolean[][] generatePUM() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean[] generateFUV() {
		// TODO Auto-generated method stub
		return null;
	}

    	public boolean launch(){
        	for(int i = 0; i < FUV.length; i++){
            	if (!FUV[i]){
                	System.out.println("NO");
                	return false;
            }
        }
        	System.out.println("YES");
        	return true;
    }

	
}
