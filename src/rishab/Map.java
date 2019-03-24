package rishab;

import processing.core.PApplet;

public class Map {
	
	private Room[][] map;
	private int x = 0,y = 0;
	private Room activeRoom;
	
	public Map() {
		map = new Room[5][5];
		activeRoom = map[x][y];
	}
	
	public Map(int rows , int cols) {
		map = new Room[rows][cols];	
		activeRoom = map[0][0];
	}
	
	public void changeActiveRoom(int x , int y) {
		activeRoom = map[this.x+=x][this.y+=y];
	}
	
	public Room getActiveRoom() {
		return activeRoom;
	}
	
	public void draw(PApplet p) {
		activeRoom.draw(p);
	}
}
