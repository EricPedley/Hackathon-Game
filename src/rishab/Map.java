package rishab;

import eric.BossRoom;
import processing.core.PApplet;

public class Map {
	
	private Room[][] map;
	private int x = 0,y = 0;
	private Room activeRoom;
	
	public Map() {
		map = new Room[5][5];
		for(int p=0;p<5;p++) {
			for(int q=0;q<5;q++) {
				map[p][q] = new Room(p*5+1+q,3);
				if(p*5+1+q==5)
					map[p][q] = new BossRoom();
			}
		}
		activeRoom = map[x][y];
	}
	
	public void changeActiveRoom(int x , int y) {
		if(this.x>0&&this.x<4)
			this.x+=x;
		if(this.y>0&&this.y<4)
			this.y+=y;
		activeRoom = map[this.x][this.y];
	}
	
	public Room getActiveRoom() {
		return activeRoom;
	}
	
	public void draw(PApplet p) {
		activeRoom.draw(p);
	}
}
