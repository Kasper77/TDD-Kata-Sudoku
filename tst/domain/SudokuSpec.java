package domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SudokuSpec {
	private static final int TIPICAL_GRID = 9;

	@Test
	public void ctor_whenCtorWithCorrectGridSize() throws Exception {
		int expectedGridSize = TIPICAL_GRID;
		Sudoku unit = new Sudoku(makeGrid());

		assertTrue (expectedGridSize == unit.getGrid().length());
	}

	@Test(expected = BadGridSizeExeption.class)
	public void ctor_whenCtorHasBadSize() throws Exception {
		Sudoku unit = new Sudoku(makeBadGridSize());

		unit.solve();
	}

	@Test
	public void solve_whenSimplePuzzlePassed() throws Exception {
		Sudoku unit = new Sudoku(makeGrid());

		assertTrue(unit.solve() == true);
		assertTrue(unit.getGrid().equals(new Grid(expectedGrid())));
	}

	private int[][] expectedGrid() {
		int[][] grid = new int[][] 
				{{3, 4, 6, 5, 9, 2, 8, 1, 7, },
			     {9, 5, 8, 4, 7, 1, 2, 3, 6, },
				 {1, 7, 2, 6, 8, 3, 4, 9, 5, },
				 {4, 1, 9, 7, 2, 6, 5, 8, 3, },
				 {7, 2, 3, 8, 1, 5, 6, 4, 9, },
				 {8, 6, 5, 3, 4, 9, 7, 2, 1, },
				 {5, 8, 4, 9, 3, 7, 1, 6, 2, },
				 {2, 3, 7, 1, 6, 4, 9, 5, 8, },
				 {6, 9, 1, 2, 5, 8, 3, 7, 4, }};
				 return grid;
	}

	private int[][] makeGrid() {
		int[][] grid = new int[][] {
			{0, 4, 0, 0, 0, 0, 0, 1, 0},
            {9, 5, 0, 0, 0, 1, 0, 3, 6},
            {0, 7, 2, 0, 8, 0, 0, 0, 0},
            {0, 1, 0, 7, 2, 0, 5, 0, 0},
            {0, 0, 3, 0, 0, 0, 0, 0, 9},
            {0, 0, 0, 3, 0, 0, 7, 0, 0},
            {0, 0, 4, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 9, 0, 8},
            {0, 0, 1, 2, 5, 8, 0, 0, 0}};
            return grid;
	}

	private int[][] makeBadGridSize() {
		int[][] grid = new int[][] {{0, 4, 0},{9, 5, 0},{0, 7, 2}};
            return grid;
	}

//	@Test
//	public void algorothm_whenSolve() {
//		Sudoku unit = new Sudoku(SMALL_GRID);
//
//		boolean solved = unit.solve();
//		if (solved) {
//			int[][] sudoku = unit.getSudoku();
//			for (int i = 0; i < sudoku.length; i++) {
//				for (int j = 0; j < sudoku.length; j++) {
//					System.out.print(Integer.toString(sudoku[i][j]) + " ");
//				}
//				System.out.println();
//			}
//
//		}
//		assertTrue(solved == true);
//	}

//	@Test
//	public void ctor_whenTipical() {
//		Sudoku unit = new Sudoku(TIPICAL_GRID);
//
//		assertTrue(unit.getBoard().length == 9);
//	}
//
//	@Test
//	public void ctor_whenBoardTooBig() {
//		Sudoku unit = new Sudoku(TOO_BIG_GRID);
//
//		assertTrue(unit.getBoard().length > 9);
//	}
//
//	@Test
//	public void ctor_whenBoardIsNull() {
//		Sudoku unit = new Sudoku(0);
//
//		assertTrue(unit.getBoard().length == 0);
//	}
//
//	@Test
//	public void solve_whenTipical() {
//		Sudoku unit = new Sudoku(TIPICAL_GRID);
//
////		Cell [][] grid = {{0, 0, 0}, {0, 0, 0}};
//
////		, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
////						   {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
////		unit.fillWith();
//
////		unit.solve();
////		assertBoardIsFilled(unit.getBoard(), (TIPICAL_GRID*4));
//	}
//
//	private void assertBoardIsFilled(int[][] board, int expectedNumber) {
//		int actualNumber = 0;
//		for (int i = 0; i < board.length; i++)
//			for (int j = 0; j < board[0].length; j++)
//				actualNumber += 1;
//
//		assertTrue(actualNumber == expectedNumber);
//	}
}
