package domain;

public class Cell {
	private int val;
	private int row;
	private int col;
	
	Cell (int row, int col, int val) {
		this.val = val;
		this.row = row;
		this.col = col;
	}

	public void set(int row, int col) {		
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.row;
	}
}
