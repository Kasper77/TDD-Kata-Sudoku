package domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Sudoku {
	private Grid grid = null;

	public Sudoku(int[][] grid) throws BadGridSizeExeption {
		this.grid = new Grid (grid);
	}

	public Grid getGrid() {
		return grid;
	}

	boolean solve() {
		AtomicInteger row = new AtomicInteger(0);
		AtomicInteger col = new AtomicInteger(0);
//		Cell cell = new Cell (0, 0, 0);
		if (!FindUnassignedLocation(row, col))
			return true; // success!

		for (int num = 1; num <= grid.length(); num++) {
			if (isSafe(row.get(), col.get(), num)) {
				grid.set(row.get(), col.get(), num);

				if (solve())
					return true;	

				grid.invalidate(row.get(), col.get());
			}
		}
		return false; // backtracking
	}

	private boolean FindUnassignedLocation(AtomicInteger row, AtomicInteger col) {
		for (int i = 0; i < grid.length(); ++i) {
			for (int j = 0; j < grid.length(); ++j) {
				if (!grid.isAssigned(i, j)) {
					row.set(i);
					col.set(j);
					return true;					
				}				
			}			
		}
		return false;
	}

	private boolean isSafe(int row, int col, int num) {
		return !UsedInRow(row, num) && 
			   !UsedInCol(col, num) && 
			   !UsedInBox(row - row % 3, col - col % 3, num);
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
