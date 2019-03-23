package rishab;

import java.util.ArrayList;

import Adele.Projectile;
import processing.core.PApplet;

public class Room { 
	
	private int[][] tileType;
	private int x = 10 , y =10;
	private ArrayList<Tile> tileIndices;
	private ArrayList<Projectile> projectiles;
	public static final int TILE_SIZE = 20; 
	private String fs = System.getProperty("file.separator");
	
	public Room() {
		tileType = new int [x][y];
	}
	public Room(int rows, int cols) {
		
	}
	
	public void assignIndices() {
		tileIndices.add(new Tile(new PApplet().loadImage("Image"+fs+"Map"+fs+"Wall"+fs+"Rock1BottomFront.gif"),0));
		tileIndices.add(new Tile(new PApplet().loadImage("Image"+fs+"Map"+fs+"Floor"+fs+"1Tile.gif"),2));
	}
	
	public void assignTiles() {
		
		for(int rows = 0; rows < x;rows++) {
			for(int cols = 0; cols < x; cols++) {
				if(rows == 0 || rows == x-1 || cols == 0 || cols == y-1 || cols == 1) {
					tileType[rows][cols] = 0;
				}
				else {
					tileType[rows][cols] = 2;
				}
			}
		}
	}

	public Tile tileAt(int x, int y) {
		return tileIndices.get(tileType[x][y]);
	}
	
	public void deleteProjectile(Projectile p) {
		
	}
	
}
