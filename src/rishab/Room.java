package rishab;

import java.util.ArrayList;

import Adele.Projectile;
import processing.core.PApplet;

public class Room { 
	
	private int[][] tileType;
	private int x = 20 , y = 20;
	private Tile[] tileIndices = new Tile[2];
	private ArrayList<Projectile> projectiles;
	public static final int TILE_SIZE = 32; 
	private String fs = System.getProperty("file.separator");
	
	public Room(PApplet p) {
		tileType = new int [x][y];
		assignIndices(p);
		assignTiles();
		
	}
	public Room(int rows, int cols, PApplet p) {
		assignIndices(p);
	}
	
	public void assignIndices(PApplet p) {
		tileIndices[0] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RockBottomFront.gif"),0);
		tileIndices[1] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"1Tile.gif"),2);
	}
	
	public void assignTiles() {
		
		for(int rows = 0; rows < y;rows++) {
			for(int cols = 0; cols < x; cols++) {
				if(rows == 0 || rows == x-1 || cols == 0 || cols == y-1 || cols == 1) {
					tileType[rows][cols] = 0;
				}
				else {
					tileType[rows][cols] = 1;
				}
			}
		}
	}

	public Tile tileAt(int x, int y) {
		return tileIndices[tileType[x][y]];
	}
	
	public void deleteProjectile(Projectile p) {
		
	}
	
	public void draw(PApplet p) {
		
		p.pushMatrix();
		for(int rows = 0; rows < y;rows++) {
			
			for(int cols = 0; cols < x; cols++) {
				tileIndices[tileType[cols][rows]].draw(p, TILE_SIZE);
				p.translate(TILE_SIZE, 0);
			}
			p.translate(-x * TILE_SIZE, TILE_SIZE);
		}
		p.popMatrix();
	}
}
