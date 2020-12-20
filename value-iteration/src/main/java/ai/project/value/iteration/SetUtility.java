package ai.project.value.iteration;

public class SetUtility {
	
	private Coordinates stateCoordinates;
	
	private double stateMultiplier;
	
	public SetUtility() {
		
	}

	public SetUtility(Coordinates stateCoordinates, double stateMultiplier) {
		super();
		this.stateCoordinates = stateCoordinates;
		this.stateMultiplier = stateMultiplier;
	}

	public Coordinates getStateCoordinates() {
		return stateCoordinates;
	}

	public void setStateCoordinates(Coordinates stateCoordinates) {
		this.stateCoordinates = stateCoordinates;
	}

	public double getStateMultiplier() {
		return stateMultiplier;
	}

	public void setStateMultiplier(double stateMultiplier) {
		this.stateMultiplier = stateMultiplier;
	}
	
	@Override
	public String toString() {
		return this.stateMultiplier + "*" + "(" + this.stateCoordinates.getX() + "," + this.stateCoordinates.getY() + ")";
	}
	
	

}
