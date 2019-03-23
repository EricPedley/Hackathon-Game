package rishab;

public class room { 
	
	private int[][] tileType;
	private int x = 10 , y =10;
	
	public room() {
		tileType = new int [x][y];
	}
	public room(int rows, int cols) {
		
	}
	
	public void assignTiles() {
		
		for(int rows = 0; rows < x;rows++) {
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

}
