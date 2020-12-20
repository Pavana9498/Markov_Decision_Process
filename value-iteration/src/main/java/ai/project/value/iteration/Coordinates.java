package ai.project.value.iteration;

public class Coordinates {
	
	private int x;
	
	private int y;
	
	public Coordinates() {
		
	}
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object p) {
		
		if(!(p instanceof Coordinates)) {
			return false;
		}
		return this.x == ((Coordinates)p).getX() && this.y == ((Coordinates)p).getY();
		
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ") ";
	}
	

}
