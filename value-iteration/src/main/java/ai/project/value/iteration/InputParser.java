package ai.project.value.iteration;

import java.util.List;

public class InputParser {
	
	private Coordinates sizes;
	private List<Coordinates> walls;
	private List<GoalState> goalStates;
	private double noReward;
	private List<Double> transitionProbability;
	private double discount;
	private double epsilon;
	
	
	public InputParser() {
		
	}

	public List<Coordinates> getWalls() {
		return walls;
	}


	public void setWalls(List<Coordinates> walls) {
		this.walls = walls;
	}


	public List<GoalState> getgoalStates() {
		return goalStates;
	}


	public void setgoalStates(List<GoalState> goalStates) {
		this.goalStates = goalStates;
	}


	public double getnoReward() {
		return noReward;
	}


	public void setnoReward(double noReward) {
		this.noReward = noReward;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getEpsilon() {
		return epsilon;
	}


	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}




	public Coordinates getSizes() {
		return sizes;
	}




	public void setSizes(Coordinates sizes) {
		this.sizes = sizes;
	}

	public List<Double> getTransitionProbability() {
		return transitionProbability;
	}

	public void setTransitionProbability(List<Double> transitionProbability) {
		this.transitionProbability = transitionProbability;
	}
	
	
	
	
	

}
