package rishab;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Adele.Projectile;
import processing.core.PApplet;

public class Room { 
	
	private int[][] tileType;
	private int x = 42, y = 15;
	private Tile[] tileIndices = new Tile[6];
	private ArrayList<Projectile> projectiles;
	public static final int TILE_SIZE = 32; 
	private String fs = System.getProperty("file.separator");
	
	public Room(PApplet p) {
		//tileType = new int [x][y];
		assignIndices(p);
		readData("Levels"+fs+"Level1.txt",tileType);
		//assignTiles();
		
	}
	public Room(int rows, int cols, PApplet p) {
		assignIndices(p);
	}
	
	public void assignIndices(PApplet p) {
		tileIndices[0] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"LeftRockWall.gif"),0);
		tileIndices[1] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RightRockWall.gif"),1);
		tileIndices[2] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RockTopFront.gif"),2);
		tileIndices[3] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RockBottomFront.gif"),3);
		tileIndices[4] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RockWallBack.gif"),4);
		tileIndices[5] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"1Tile.gif"),5);
	}
	
	/*public void assignTiles() {
		
		for(int rows = 0; rows < x;rows++) {
			for(int cols = 0; cols < y; cols++) {
				if(rows == 0) {
					tileType[rows][cols] = 0;
				}
				else if(rows == y-1) {
					tileType[rows][cols] = 1;
				}
				else if(cols == 0) {
					tileType[rows][cols] = 2;
				}
				else if(cols == 1) {
					tileType[rows][cols] = 3;
				}
				else if(cols == x-1) {
					tileType[rows][cols] = 4;
				}
				else {
					tileType[rows][cols] = 5;
				}
			}
		}
	}*/

	
	public void readData (String filename, int[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					String s = in.nextLine();
					//x = Integer.parseInt(s.substring(0, s.indexOf(',')));
					s = s.substring(s.indexOf(',') + 1); 
					//y = Integer.parseInt(s.substring(0, s.indexOf(',')));
					//gameData= new int[x][y];
					

					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; line.indexOf(',') != -1; line = line.substring(line.indexOf(',') + 1) ) {
							i++;
							gameData[i][count] = Integer.parseInt(line.substring(0,line.indexOf(',')));
						}
						count++;
					}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
	
	
	public Tile tileAt(int x, int y) {
		return tileIndices[tileType[x][y]];
	}
	
	public void deleteProjectile(Projectile p) {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(PApplet p) {
		
		p.pushMatrix();
		for(int cols = 0; cols < y;cols++) {
			
			for(int rows = 0; rows < x; rows++) {
				tileIndices[tileType[rows][cols]].draw(p, TILE_SIZE);
				p.translate(TILE_SIZE, 0);
			}
			p.translate(-x * TILE_SIZE, TILE_SIZE);
		}
		p.popMatrix();
	}
}
