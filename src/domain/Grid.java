package domain;

import static org.junit.Assert.assertTrue;

public class Grid {
	private int[][] grid = null;
	private static final int GRID_SIZE = 9;
	private static final int UNASSIGNED = 0;

	public Grid(int[][] grid) throws BadGridSizeExeption {
		if (grid.length != GRID_SIZE)
			throw new BadGridSizeExeption("The Grib must be 9x9 size!");
		
		this.grid = grid;
	}
	
	public int length () {
		return grid.length;
	}

	public void set(int row, int col, int num) {
		grid[row][col] = num;
	}

	public void invalidate(int row, int col) {
		grid[row][col] = UNASSIGNED;
	}

	public boolean isAssigned(int i, int j) {
		if (grid[i][j] != UNASSIGNED) {
			return true;
		}
		return false;
	}

	public boolean cellHasThisValue(int row, int col, int num) {
		if (grid[row][col] == num)
			return true;
		return false;
	}

	public int[][] getGrid() {
		return grid;
	}

	public boolean equals(Grid expected) {
		if (this.length() != expected.length())
			return false;
		
		int[][] toCompareWith = expected.getGrid();
		for (int i = 0; i < this.length(); i++)
			for (int j = 0; j < this.length(); j++)
				if (grid[i][j] != toCompareWith[i][j])
					return false;
		return true;
	}
}
