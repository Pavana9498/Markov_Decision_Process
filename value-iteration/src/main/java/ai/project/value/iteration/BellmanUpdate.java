package ai.project.value.iteration;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

import ai.project.value.iteration.algorithm.UtilityCalculator;
import ai.project.value.iteration.algorithm.ParameterReader;

public class BellmanUpdate {

    public void runAlgorithm() throws IOException {
        Parser parser = new Parser();
        parser.setValueIterationInput();

        Map<String, Double> valueMap = new HashMap<String, Double>();

        UtilityCalculator utilityCalculator = new UtilityCalculator();

        InputParser inputParser = parser.getInputParser();

        Coordinates sizes = inputParser.getSizes();
        int sx = sizes.getY();
        int sy = sizes.getX();
        sizes = new Coordinates(sx, sy);

        List<Coordinates> walls = inputParser.getWalls();

        double gamma = inputParser.getDiscount();

        double epsilon = inputParser.getEpsilon();

        List<ParameterReader> parameterReaderList = new ArrayList<ParameterReader>();

        for (int i = 1; i <= sx; i++) {
            for (int j = 1; j <= sy; j++) {

                ParameterReader parameterReader = new ParameterReader(i, j);

                if (walls.contains(new Coordinates(j, i))) {
                    continue;
                }

                String state = "";

                if ((i == 1 || i == sx) || (j == 1 || j == sy)) {
                    state = "corner";
                } else {
                    state = "center";
                }
                parameterReader
                        .setNorth(utilityCalculator.searchNorth(new Coordinates(i, j), sizes, state, walls));
                parameterReader
                        .setSouth(utilityCalculator.searchSouth(new Coordinates(i, j), sizes, state, walls));
                parameterReader
                        .setWest(utilityCalculator.searchWest(new Coordinates(i, j), sizes, state, walls));
                parameterReader
                        .setEast(utilityCalculator.searchEast(new Coordinates(i, j), sizes, state, walls));

                boolean f1 = false;

                for (GoalState ts : inputParser.getgoalStates()) {

                    if (ts.getStates().getX() == j && ts.getStates().getY() == i) {

                        f1 = true;

                        valueMap.put(j + "" + i, ts.getgoalReward());

                        parameterReader.setNewParameterValue(ts.getgoalReward());
                        parameterReader.setRewardValue(ts.getgoalReward());
                        parameterReader.setTerminalState(true);

                        if (f1) {
                            break;
                        }
                    }
                }
                if (!f1) {
                    valueMap.put(j + "" + i, inputParser.getnoReward());
                    parameterReader.setNewParameterValue(inputParser.getnoReward());
                    parameterReader.setRewardValue(inputParser.getnoReward());
                }

                parameterReaderList.add(parameterReader);
            }

        }

        int c3 = 0;

        while (true) {

            int c1 = 0;
            int c2 = 0;

            printResult(inputParser, parameterReaderList, c3);
            c3++;

            for (ParameterReader v : parameterReaderList) {

                if (!v.isTerminalState()) {
                    c1++;

                    double result = Math.round(calculateParameterValue(inputParser, v, gamma, valueMap) * 10000D) / 10000D;

                    v.setNewParameterValue(result);
                    double r2 = Math.abs(result - valueMap.get(v.getCoordinates().getY() + "" + v.getCoordinates().getX()));
                    if (r2 < epsilon) {

                        c2++;
                    }

                }
            }
            if (c1 == c2) {
                displayResult(inputParser,valueMap);
                break;
            }
            for (ParameterReader v1 : parameterReaderList) {

                valueMap.put(v1.getCoordinates().getY() + "" + v1.getCoordinates().getX(), v1.getNewParameterValue());

            }

        }

    }
    static LinkedHashMap<Coordinates,String> hm = new LinkedHashMap<Coordinates, String>();
    static ArrayList<String> al = new ArrayList<String>();
    private static double calculateParameterValue(InputParser vp, ParameterReader vip, double gamma,
                                                  Map<String, Double> valueMap) {
       // System.out.print(vip.getCoordinates().getX() + "," + vip.getCoordinates().getY() + " ");
        //System.out.println(vp.getSizes().getX());
//        System.out.println(vp.getgoalStates().get(0).getStates().getX());
//        System.out.println(vp.getgoalStates().get(0).getStates().getY());
//        for( GoalState gs : vp.getgoalStates()){
//            int xcoord = gs.getStates().getY();
//            int ycoord = gs.getStates().getX();
//            hm.put("("+ xcoord + "," + ycoord + ")" , "T");
//        }
        int sizex = vp.getSizes().getX();
        List<SetUtility> up = vip.getDirectionUp();
        List<SetUtility> down = vip.getDirectionDown();
        List<SetUtility> left = vip.getDirectionLeft();
        List<SetUtility> right = vip.getDirectionRight();
        double upValue = calculateParameterValue(up, valueMap);
        double downValue = calculateParameterValue(down, valueMap);
        double leftValue = calculateParameterValue(left, valueMap);
        double rightValue = calculateParameterValue(right, valueMap);
        double policyValue = Math.max(upValue, Math.max(downValue, Math.max(leftValue, rightValue)));
        String policyStr = "";
        if(policyValue == upValue) policyStr = "N";
        if(policyValue == downValue) policyStr = "S";
        if(policyValue == leftValue) policyStr = "W";
        if(policyValue == rightValue) policyStr = "E";
        hm.put(vip.getCoordinates(),policyStr);
        return vip.getRewardValue() + (gamma * Math.max(upValue, Math.max(downValue, Math.max(leftValue, rightValue))));
    }

    private static double calculateParameterValue(List<SetUtility> sv, Map<String, Double> valueMap) {

        double result = 0d;

        for (SetUtility s : sv) {

            result += s.getStateMultiplier()
                    * valueMap.get(s.getStateCoordinates().getX() + "" + s.getStateCoordinates().getY());

        }

        return Math.round(result * 10000D) / 10000D;
    }
    static int prev = 1;
    private static void displayResult(InputParser ip, Map<String,Double> vm){
        int sizex = ip.getSizes().getX();
        System.out.print("Terminal States are " );
        for(GoalState g : ip.getgoalStates()){
            System.out.print("(" + g.getStates().getY() + "," + g.getStates().getX() + ") " );
        }
        System.out.println();
        System.out.print("Walls are ");
        for(Coordinates c: ip.getWalls()){
            System.out.print("(" + c.getY() + "," + c.getX() + ") " );
        }
        System.out.println();
        System.out.println("Final Policy Iteration:");
        for (Map.Entry<Coordinates, String> entry : hm.entrySet()) {
            int y_coord = entry.getKey().getY();
            int x_coord = entry.getKey().getX();
            Coordinates key = entry.getKey();
            String value = entry.getValue();
            if(x_coord == prev+1){
                System.out.println();
            }
            System.out.print(key + ""+ value + " ");
            prev = x_coord;

        }

//        Iterator<String> itrValue = hm.values().iterator();
//        Iterator<Coordinates> itrKey = hm.keySet().iterator();
//        while (itrKey.hasNext() && itrValue.hasNext()) {
//            if(y_coord == sizex) {
//                System.out.println();
//            }
//            System.out.println(itrKey.next() + " "+ itrValue.next());
//        }
//        int y_coord = vip.getCoordinates().getY();
//        System.out.print(vip.getCoordinates().toString() + " " + policyStr +"  ");
//        if(y_coord == sizex) {
//            System.out.println();
//        }

    }
    private static void printResult(InputParser vp , List<ParameterReader> parameterReaderList, int i) {
    	System.out.print("Walls are at ");
    	for(Coordinates p: vp.getWalls()) {
    		System.out.print("(" + p.getY() + "," + p.getX() + ")");
    	}
    	System.out.println("");
    	System.out.println("Iteration " + i + ":");
        int size = vp.getSizes().getX();
        for (ParameterReader v : parameterReaderList) {
        	int y_coord = v.getCoordinates().getY();
            System.out.print(v.getCoordinates().toString() + " " + v.getNewParameterValue()+"  ");
        	if(y_coord == size) {
        		System.out.println();
        	}
        }
        System.out.println("-------------------------------------");
    }

}
