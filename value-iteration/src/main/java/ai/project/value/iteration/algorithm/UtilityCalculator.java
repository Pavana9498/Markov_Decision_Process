package ai.project.value.iteration.algorithm;

import java.util.ArrayList;
import java.util.List;

import ai.project.value.iteration.Coordinates;
import ai.project.value.iteration.SetUtility;

public class UtilityCalculator {
	
	public void X(Coordinates y) {
		int x1 = y.getX();
		int y1 = y.getY();
	}
	

	public List<SetUtility> searchNorth(Coordinates y, Coordinates border, String state, List<Coordinates> walls){
		int x1 = y.getX();
		int y1 = y.getY();
		int x2 = border.getX();
		int y2 = border.getY();
		List<SetUtility> northList = new ArrayList<SetUtility>();
		
		if(state.equals("center")) //2,2 3,2 
		{
			Coordinates x3 = new Coordinates(y1,x1+1);
			Coordinates y3 = new Coordinates(y1-1,x1);
			Coordinates z3 = new Coordinates(y1+1,x1);
			
			if(isAWall(walls,x3)) {			
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
			}
			
			else {
			
			northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.8")));
			}
			
			if(isAWall(walls,y3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
			
			}
			
			if(isAWall(walls,z3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			
			northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
			}
		}
		
		if(state.equals("corner")) {
			
			if(x1+1<=x2 && y1-1==0) //1,1 1,2
				{
				Coordinates x3 = new Coordinates(y1,x1+1);
				Coordinates z3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,x3)) {			
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.8")));
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			
			else if(x1+1<=x2 && y1==y2) //4,1 4,2 
				{
				
				Coordinates x3 = new Coordinates(y1,x1+1);
				Coordinates z3 = new Coordinates(y1-1,x1);
				
				if(isAWall(walls,x3)) {			
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.8")));
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			
			else if(x1-1==0 && y1-1!=0 && y1!=y2 ) // 2,1 3,1 
				{
				
				Coordinates x3 = new Coordinates(y1,x1+1);
				Coordinates y3 = new Coordinates(y1-1,x1);
				Coordinates z3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,x3)) {			
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.8")));
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
				
			}
		
			else if(x1==x2 && y1-1==0) // 1,3 
				{
				
				Coordinates x3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,x3)) {			
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
				
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
				
			    }
			
			else if(x1==x2 && y1-1!=0 && y1!=y2) // 2,3 3,3
			{
				
				Coordinates x3 = new Coordinates(y1+1,x1);
				Coordinates z3 = new Coordinates(y1-1,x1);
				
				if(isAWall(walls,x3)) {			
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
			
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				
			}
			
			
			else if(x1==x2 && y1==y2)//4,3
			{
				Coordinates x3 = new Coordinates(y1-1,x1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
				
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
			}
		}
	return northList;	
	}
	
	public List<SetUtility> searchSouth(Coordinates y, Coordinates border, String state, List<Coordinates> walls){
		int x1 = y.getX();
		int y1 = y.getY();
		int x2 = border.getX();
		int y2 = border.getY();
		List<SetUtility> northList = new ArrayList<SetUtility>();
		
		if(state.equals("center")) //2,2 3,2 
		{
			Coordinates x3 = new Coordinates(y1,x1-1);
			Coordinates y3 = new Coordinates(y1-1,x1);
			Coordinates z3 = new Coordinates(y1+1,x1);
			
			if(isAWall(walls,x3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
			}
			else {
			northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.8")));
			
			}
			
			if(isAWall(walls,y3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
			
			}
			
			if(isAWall(walls,z3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			
			northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
			}
					
			
		}
		
		if(state.equals("corner")) {
			if(x1-1!=0 && y1-1==0) //1,3 1,2
				{
				
				Coordinates x3 = new Coordinates(y1,x1-1);
				Coordinates z3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
					
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			else if(x1-1!=0 && y1==y2) //4,3 4,2 
				{
				
				Coordinates x3 = new Coordinates(y1,x1-1);
				Coordinates y3 = new Coordinates(y1-1,x1);
				
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			else if(x1==x2 && y1-1!=0 && y1!=y2 ) // 2,3 3,3 
				{
				Coordinates x3 = new Coordinates(y1,x1-1);
				Coordinates y3 = new Coordinates(y1-1,x1);
				Coordinates z3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
				
			}
		
			else if(x1-1==0 && y1-1==0) // 1,1 
				{
				Coordinates z3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
				
			    }
			
			
			else if(x1-1==0 && y1-1!=0 && y1!=y2) // 2,1 3,1
			{
				Coordinates y3 = new Coordinates(y1-1,x1);
				Coordinates z3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				
			}
			
			
			else if(x1-1==0 && y1==y2)//4,1
			{
				Coordinates y3 = new Coordinates(y1-1,x1);
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.1")));
				
				}
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
			}
		}

	return northList;	
	}
	
	
	
	
	public List<SetUtility> searchWest(Coordinates y, Coordinates border, String state, List<Coordinates> walls){
		int x1 = y.getX(); //x1=1,y1=3
		int y1 = y.getY();
		int x2 = border.getX();
		int y2 = border.getY();
		List<SetUtility> northList = new ArrayList<SetUtility>();
		
		if(state.equals("center")) //2,2 3,2 
		{
			Coordinates x3 = new Coordinates(y1-1,x1);
			Coordinates y3 = new Coordinates(y1,x1+1);
			Coordinates z3 = new Coordinates(y1,x1-1);
			
			if(isAWall(walls,x3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
			}
			else {
			northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.8")));
			
			}
			
			if(isAWall(walls,y3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
			
			}
			
			if(isAWall(walls,z3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			
			northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
			}
				
			
		}
		
		if(state.equals("corner")) {
			//System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
			
			if(x1==x2 && y1-1==0) //1,3
				{			
				
				Coordinates z3 = new Coordinates(y1,x1-1);
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
				
			}
			
		
			else if(x1==x2 && y1-1!=0 ) // 2,3 3,3   x1=3 y1 =3 x1=3 y1=2  x2=4 y2=3
				{
				
				Coordinates x3 = new Coordinates(y1-1,x1);
				Coordinates z3 = new Coordinates(y1,x1-1);
				

				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			
			else if(y1-1==0 && x1!=x2 && x1-1!=0 ) //1,2 
			{
				Coordinates y3 = new Coordinates(y1,x1+1);
				Coordinates z3 = new Coordinates(y1,x1-1);
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				
			}
			
			else if(y1==y2 && x1!=1 && x1<x2 ) //4,2 
			{
				Coordinates x3 = new Coordinates(y1-1,x1);
				Coordinates y3 = new Coordinates(y1,x1+1);
				Coordinates z3 = new Coordinates(y1,x1-1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
					
				
			}
		
			else if(x1-1==0 && y1-1==0) // 1,1 
				{
				
				Coordinates y3 = new Coordinates(y1,x1+1);
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
				
			    }
			
			
			else if(x1-1==0 && y1-1!=0 && y1!=y2) // 2,1 3,1
			{
				Coordinates x3 = new Coordinates(y1-1,x1);
				Coordinates y3 = new Coordinates(y1,x1+1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			
			
			else if(x1-1==0 && y1==y2)//4,1
			{
				Coordinates x3 = new Coordinates(y1-1,x1);
				Coordinates y3 = new Coordinates(y1,x1+1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1-1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
		}

	return northList;	
	}
	
	
	public List<SetUtility> searchEast(Coordinates y, Coordinates border, String state, List<Coordinates> walls){
		int x1 = y.getX();
		int y1 = y.getY();
		int x2 = border.getX();
		int y2 = border.getY();
		List<SetUtility> northList = new ArrayList<SetUtility>();
		
		if(state.equals("center")) //2,2 3,2 
		{
			Coordinates x3 = new Coordinates(y1+1,x1);
			Coordinates y3 = new Coordinates(y1,x1+1);
			Coordinates z3 = new Coordinates(y1,x1-1);
			
			if(isAWall(walls,x3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
			}
			else {
			northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.8")));
			
			}
			
			if(isAWall(walls,y3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
			
			}
			
			if(isAWall(walls,z3)) {
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			}
			else {
			
			northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
			}
					
			
		}
		
		if(state.equals("corner")) {

			if(x1==x2 && y1-1==0)
				{			
				
				Coordinates y3 = new Coordinates(y1,x1-1);
				Coordinates z3 = new Coordinates(y1+1,x1);
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.8")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			
			else if(x1==x2 && y1==y2) //4,3
				{
				
				Coordinates z3 = new Coordinates(y1,x1-1);
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
		
				
			}
			else if(y1!=y2 && x1-1!=0 && x1==x2 )
				{
				
				Coordinates x3 = new Coordinates(y1+1,x1);
				
				Coordinates z3 = new Coordinates(y1,x1-1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				
			}
			
			else if(y1-1==0 && x1!=x2 && x1-1!=0 ) //1,2 
			{
				Coordinates x3 = new Coordinates(y1+1,x1);
				Coordinates y3 = new Coordinates(y1,x1+1);
				Coordinates z3 = new Coordinates(y1,x1-1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
				
			}
			
			else if(y1==y2 && x1+1 ==x2 && x1-1!=0 ) //4,2 
			{
				
				Coordinates y3 = new Coordinates(y1,x1+1);
				Coordinates z3 = new Coordinates(y1,x1-1);
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				if(isAWall(walls,z3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				
				northList.add(new SetUtility(new Coordinates(y1,x1-1),Double.parseDouble("0.1")));
				}
				
			
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				
			}
		
			else if(x1-1==0 && y1-1==0 ) // 1,1
				{
				Coordinates x3 = new Coordinates(y1+1,x1);
				Coordinates y3 = new Coordinates(y1,x1+1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			    }
			
			
			else if(x1-1==0 && y1-1!=0 && y1!=y2) // 2,1 3,1
			{
				Coordinates x3 = new Coordinates(y1+1,x1);
				Coordinates y3 = new Coordinates(y1,x1+1);
				
				if(isAWall(walls,x3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.8")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1+1,x1),Double.parseDouble("0.8")));
				
				}
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
			    }
				
			
			
			
			else if(x1-1==0 && y1==y2)//4,1
			{
				Coordinates y3 = new Coordinates(y1,x1+1);
				
				if(isAWall(walls,y3)) {
					northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.1")));
				}
				else {
				northList.add(new SetUtility(new Coordinates(y1,x1+1),Double.parseDouble("0.1")));
				
				}
				
				northList.add(new SetUtility(new Coordinates(y1,x1),Double.parseDouble("0.9")));
				
			}
		}
	return northList;	
	}
	
	public static boolean isAWall(List<Coordinates> w, Coordinates p) {
		return w.contains(p);
	}

	
	
}
