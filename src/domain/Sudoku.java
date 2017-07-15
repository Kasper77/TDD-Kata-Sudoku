package domain;

public class Sudoku {
	private Grid grid = null;

	public Sudoku(int[][] grid) throws BadGridSizeExeption {
		this.grid = new Grid (grid);
	}

	public Grid getGrid() {
		return grid;
	}

	boolean solve() {
		Cell cell = grid.findUnassignedCell();
		if (cell == null)
			return true; // success! all cells are assigned

		for (int num = 1; num <= grid.length(); num++) {
			if (isSafe(cell, num)) {
				grid.set(cell, num);

				if (solve())
					return true;	

				grid.invalidate(cell);
			}
		}
		return false;
	}

	private boolean isSafe(Cell cell, int num) {
		return !UsedInRow(cell.getRow(), num) && 
			   !UsedInCol(cell.getCol(), num) && 
			   !UsedInBox(cell.getRow() - cell.getRow() % 3, cell.getCol() - cell.getCol() % 3, num);
	}

	private boolean UsedInRow(int row, int num) {
		for (int col = 0; col < grid.length(); col++)
			if (grid.cellHasThisValue(row, col, num))
				return true;
		return false;
	}

	private boolean UsedInCol(int col, int num) {
		for (int row = 0; row < grid.length(); row++)
			if (grid.cellHasThisValue(row, col, num))
				return true;
		return false;
	}

	private boolean UsedInBox(int boxStartRow, int boxStartCol, int num) {
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (grid.cellHasThisValue(row + boxStartRow, col + boxStartCol, num))
					return true;
		return false;
	}
}
