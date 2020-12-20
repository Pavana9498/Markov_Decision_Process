package ai.project.value.iteration.algorithm;

import java.util.ArrayList;
import java.util.List;

import ai.project.value.iteration.Coordinates;
import ai.project.value.iteration.SetUtility;

public class ParameterReader {

	private Coordinates coordinates;

	private List<SetUtility> directionUp;

	private List<SetUtility> directionDown;

	private List<SetUtility> directionLeft;

	private List<SetUtility> directionRight;

	private double rewardValue;

	private double newParameterValue;

	private boolean terminalState;

	public boolean isTerminalState() {
		return terminalState;
	}

	public void setTerminalState(boolean terminalState) {
		this.terminalState = terminalState;
	}

	public ParameterReader(int x, int y) {

		coordinates = new Coordinates(x, y);
		directionUp = new ArrayList<SetUtility>();
		directionDown = new ArrayList<SetUtility>();
		directionLeft = new ArrayList<SetUtility>();
		directionRight = new ArrayList<SetUtility>();
	}

	public double getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(double rewardValue) {
		this.rewardValue = rewardValue;
	}

	public double getNewParameterValue() {
		return newParameterValue;
	}

	public void setNewParameterValue(double newParameterValue) {
		this.newParameterValue = newParameterValue;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public List<SetUtility> getDirectionUp() {
		return directionUp;
	}

	public void setNorth(List<SetUtility> directionUp) {
		this.directionUp = directionUp;
	}

	public List<SetUtility> getDirectionDown() {
		return directionDown;
	}

	public void setSouth(List<SetUtility> directionDown) {
		this.directionDown = directionDown;
	}

	public List<SetUtility> getDirectionLeft() {
		return directionLeft;
	}

	public void setWest(List<SetUtility> directionLeft) {
		this.directionLeft = directionLeft;
	}

	public List<SetUtility> getDirectionRight() {
		return directionRight;
	}

	public void setEast(List<SetUtility> directionRight) {
		this.directionRight = directionRight;
	}

}
