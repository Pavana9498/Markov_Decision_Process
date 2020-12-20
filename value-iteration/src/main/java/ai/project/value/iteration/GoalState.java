package ai.project.value.iteration;



public class GoalState {
	
	private Coordinates states;
	
	private double goalReward;
	
	public GoalState(Coordinates states, double goalReward) {
		this.states = states;
		this.goalReward =goalReward;
		
	}
	
	
	public double getgoalReward() {
		return goalReward;
	}

	public void setgoalReward(double reward) {
		this.goalReward = reward;
	}


	public Coordinates getStates() {
		return states;
	}


	public void setStates(Coordinates states) {
		this.states = states;
	}


}
