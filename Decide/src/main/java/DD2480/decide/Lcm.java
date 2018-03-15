package DD2480.decide;

public class Lcm{
	public enum lcmElement {
	    ANDD,
	    ORR,
	    NOTUSED;
	}
	lcmElement[][] theMatrix = new lcmElement[15][15];
	/**
	 * initialise matrix of lcm elements to contain only ANDD 
	 */
	public Lcm(){
		for(int i = 0;i<15;i++){
			for(int j = 0; j<15;j++){
				theMatrix[i][j] = lcmElement.ANDD;
			}
		}
	}
	public lcmElement getElement(int i,int j){
		return theMatrix[i][j];
	}
	public void setElement(int i,int j,lcmElement value){
		theMatrix[i][j] = value;
	}
}