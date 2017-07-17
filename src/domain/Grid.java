package domain;

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

	public void set(Cell cell, int num) {
		grid[cell.getRow()][cell.getCol()] = num;
	}

	public void invalidate(Cell cell) {
		grid[cell.getRow()][cell.getCol()] = UNASSIGNED;
	}

	public Cell findUnassignedCell() {
		Cell cell = null;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid.length; ++j) {
				if (!isAssigned(i, j)) {
					cell = new Cell(i, j, UNASSIGNED);
					return cell;					
				}
			}			
		}
		return cell;
	}

	public boolean cellHasThisValue(int row, int col, int num) {
		if (grid[row][col] == num)
			return true;
		return false;
	}

	public int[][] getGrid() {
		return grid;
	}

	@Override
	public boolean equals(Object o) {
		Grid expected = (Grid) o;
		if (this.length() != expected.length())
			return false;

		int[][] toCompareWith = expected.getGrid();
		for (int i = 0; i < this.length(); i++)
			for (int j = 0; j < this.length(); j++)
				if (grid[i][j] != toCompareWith[i][j])
					return false;
		return true;
	}

	private boolean isAssigned(int i, int j) {
		if (grid[i][j] != UNASSIGNED) {
			return true;
		}
		return false;
	}
}
