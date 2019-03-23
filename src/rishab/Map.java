package rishab;

public class Map {
	
	private Room[][] map;
	
	public Map() {
		map = new Room[10][10];
	}
	
	public Map(int rows , int cols) {
		map = new Room[rows][cols];	
	}

}
