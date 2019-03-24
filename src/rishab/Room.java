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
	private Tile[] tileIndices = new Tile[19];
	private ArrayList<Projectile> myProjectiles;
	private ArrayList<Projectile> enemyProjectiles;
	public static final int TILE_SIZE = 64; 
	private String fs = System.getProperty("file.separator");
	
	public Room(PApplet p) {
		//tileType = new int [x][y];
		assignIndices(p);
		readData("Levels"+fs+"Level1.txt");
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
		tileIndices[5] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerBottomLeft.gif"),5);
		tileIndices[6] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerBottomRight.gif"),6);
		tileIndices[7] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerTopLeft.gif"),7);
		tileIndices[8] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerTopRight.gif"),8);
		tileIndices[9] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutwardRockCornerBottomLeft.gif"),9);
		tileIndices[10] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutWardRockCornerBottomRight.gif"),10);
		tileIndices[11] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutwardRockCornerTopLeft.gif"),11);
		tileIndices[12] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutwardRockCornerTopRight.gif"),12);
		tileIndices[13] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"1Tile.gif"),13);
		tileIndices[14] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"4Tile.gif"),14);
		tileIndices[15] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileBottomLeft.gif"),15);
		tileIndices[16] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileBottomRight.gif"),16);
		tileIndices[17] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileTopLeft.gif"),17);
		tileIndices[18] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileTopRight.gif"),18);
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

	
	private void readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					String s = in.nextLine();
					x = Integer.parseInt(s.substring(0, s.indexOf(',')));
					s = s.substring(s.indexOf(',') + 1); 
					y = Integer.parseInt(s.substring(0, s.indexOf(',')));
					tileType = new int[x][y];
					

					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; line.indexOf(',') != -1; line = line.substring(line.indexOf(',') + 1) ) {
							
							
							tileType[i][count] = Integer.parseInt(line.substring(0,line.indexOf(',')));
							i++;
							//System.out.println(gameData[i][count]);
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
	
	public void addProjectile(Projectile p,boolean isHero) {
		if(isHero)
		myProjectiles.add(p);
		else
			enemyProjectiles.add(p);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(PApplet p) {
		
		p.pushMatrix();
		tileIndices[0].draw(p, TILE_SIZE);
		for(int cols = 0; cols < y;cols++) {
			
			for(int rows = 0; rows < x; rows++) {
				//System.out.println(tileType[rows][cols]);
				tileIndices[tileType[rows][cols]].draw(p, TILE_SIZE);
				p.translate(TILE_SIZE, 0);
			}
			p.translate(-x * TILE_SIZE, TILE_SIZE);
		}
		p.popMatrix();
	}
}
