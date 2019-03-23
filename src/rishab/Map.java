package rishab;

public class Map {
	
	private room[][] map;
	
	public Map() {
		map = new room[10][10];
	}
	
	public Map(int rows , int cols) {
		map = new room[rows][cols];	
	}

}
