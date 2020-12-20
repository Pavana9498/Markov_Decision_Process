package ai.project.value.iteration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
	
	private static final String INPUT_FILE_NAME = "/input.txt";
	
	

	private InputParser inputParser;
	
	public InputParser getInputParser() {
		return inputParser;
	}
	
	public void setValueIterationInput() throws IOException {
		
		InputStream in = this.getClass().getResourceAsStream(INPUT_FILE_NAME);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String input = "";
		StringTokenizer colonTokenizer;
		StringTokenizer spaceTokenizer;
		
		while((input= br.readLine())!= null){
			
			input = input.trim();
			if(input.equals("") || input.startsWith("#")) {
				continue;
			}
			
			if(input.contains("size")) {
				inputParser = new InputParser();
				
				colonTokenizer = new StringTokenizer(input,":");
				colonTokenizer.nextToken();
				String[] temp = colonTokenizer.nextToken().trim().split(" ");
				inputParser.setSizes(new Coordinates(Integer.parseInt(temp[0].trim()), Integer.parseInt(temp[1].trim())));
				
				
			}
			
			if(input.contains("walls")) {
				
				colonTokenizer = new StringTokenizer(input,":");
				colonTokenizer.nextToken();
				String[] temp = colonTokenizer.nextToken().split(",");
				List<Coordinates> walls = new ArrayList<Coordinates>();
				
				for(int i=0;i<temp.length;i++) {
					spaceTokenizer = new StringTokenizer(temp[i]," ");
					Coordinates p =new Coordinates(Integer.parseInt(spaceTokenizer.nextToken()), Integer.parseInt(spaceTokenizer.nextToken()));
					walls.add(p);
				}
				
				inputParser.setWalls(walls);
			}
			
			if(input.contains("terminal_states")) {
				
				colonTokenizer = new StringTokenizer(input,":");
				colonTokenizer.nextToken();
				
				String[] temp = colonTokenizer.nextToken().split(",");
				List<GoalState> goalStates = new ArrayList<GoalState>();
				
				List<Coordinates> terminalStateCoordinates = new ArrayList<Coordinates>();
				
				for(int i=0;i<temp.length;i++) {
					spaceTokenizer = new StringTokenizer(temp[i]," ");
					Coordinates p =new Coordinates(Integer.parseInt(spaceTokenizer.nextToken()), Integer.parseInt(spaceTokenizer.nextToken()));
					double r = Double.parseDouble(spaceTokenizer.nextToken());
					goalStates.add(new GoalState(p,r));
				}
				inputParser.setgoalStates(goalStates);
				
				
			}
			
		if(input.contains("reward")) {
			colonTokenizer = new StringTokenizer(input,":");
			colonTokenizer.nextToken();
			
			inputParser.setnoReward(Double.parseDouble(colonTokenizer.nextToken().trim()));
		}
		
		if(input.contains("transition_probabilities")) {
			colonTokenizer = new StringTokenizer(input,":");
			colonTokenizer.nextToken();
			String[] temp = colonTokenizer.nextToken().trim().split(" ");
			List<Double> transition = new ArrayList<Double>();
			transition.add(Double.parseDouble(temp[0].trim()));
			transition.add(Double.parseDouble(temp[1].trim()));
			transition.add(Double.parseDouble(temp[2].trim()));
			transition.add(Double.parseDouble(temp[3].trim()));
			inputParser.setTransitionProbability(transition);
			
		}
		
		if(input.contains("discount_rate")) {
			colonTokenizer = new StringTokenizer(input,":");
			colonTokenizer.nextToken();
			inputParser.setDiscount(Double.parseDouble(colonTokenizer.nextToken()));
		}
		
		if(input.contains("epsilon")) {
			colonTokenizer = new StringTokenizer(input,":");
			colonTokenizer.nextToken();
			inputParser.setEpsilon(Double.parseDouble(colonTokenizer.nextToken()));
		}
			
			
			
			
			
		}
		
	}
	
}
