package main;

import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

import domain.BadGridSizeExeption;
import domain.Grid;
import mockit.Expectations;
import mockit.Mocked;

public class UserSpec {

	@Test
	public void wantToPlay_whenYesIsTheAnswer(@Mocked Scanner mockedScanner) {
		User unit = new User();
		new Expectations() {{mockedScanner.nextLine(); result = "Yes"; times = 1;}};

		assertTrue(unit.wantToPlay());
	}

	@Test
	public void wantToPlay_whenYIsTheAnswer(@Mocked Scanner mockedScanner) {
		User unit = new User();
		new Expectations() {{mockedScanner.nextLine(); result = "Y"; times = 1;}};

		assertTrue(unit.wantToPlay());
	}

	@Test
	public void wantToPlay_whenNoIsTheAnswer(@Mocked Scanner mockedScanner) {
		User unit = new User();
		new Expectations() {{mockedScanner.nextLine(); result = "No"; times = 1;}};

		assertTrue(unit.wantToPlay() == false);
	}

	@Test
	public void wantToPlay_whenNIsTheAnswer(@Mocked Scanner mockedScanner) {
		User unit = new User();
		new Expectations() {{mockedScanner.nextLine(); result = "N"; times = 1;}};

		assertTrue(unit.wantToPlay() == false);
	}

	@Test
	public void getlPuzzle_whenAValid9x9GridWithNumbersIsPassed(@Mocked Scanner mockedScanner) throws BadGridSizeExeption {
		Grid expectedGrid = new Grid(makeGrid());
		User unit = new User();
		new Expectations() {{
				mockedScanner.nextLine();
				returns("0 4 0 0 0 0 0 1 0", 
						"9 5 0 0 0 1 0 3 6", 
						"0 7 2 0 8 0 0 0 0",
						"0 1 0 7 2 0 5 0 0", 
						"0 0 3 0 0 0 0 0 9", 
						"0 0 0 3 0 0 7 0 0",
						"0 0 4 0 0 0 1 0 0", 
						"0 0 0 0 0 0 9 0 8", 
						"0 0 1 2 5 8 0 0 0");}};
		assertTrue(expectedGrid.equals(new Grid(unit.getPuzzleToSolve())));
	}

	@Test
	public void getlPuzzle_whenAValid9x9GridWithNumbersAndLettersIsPassed(@Mocked Scanner mockedScanner) throws BadGridSizeExeption {
		Grid expectedGrid = new Grid(makeGrid());
		User unit = new User();
		new Expectations() {{
				mockedScanner.nextLine();     // nextLine called 10 times due to the error on the first line!
				returns("0 B 0 t 0 0 A 1 0",
						"0 4 0 0 0 0 0 1 0",
						"9 5 0 0 0 1 0 3 6", 
						"0 7 2 0 8 0 0 0 0",
						"0 1 0 7 2 0 5 0 0", 
						"0 0 3 0 0 0 0 0 9", 
						"0 0 0 3 0 0 7 0 0",
						"0 0 4 0 0 0 1 0 0", 
						"0 0 0 0 0 0 9 0 8", 
						"0 0 1 2 5 8 0 0 0");}};
		assertTrue(expectedGrid.equals(new Grid(unit.getPuzzleToSolve())));
	}

	private int[][] makeGrid() {
		int[][] grid = new int[][] {
				{ 0, 4, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 9, 5, 0, 0, 0, 1, 0, 3, 6 },
				{ 0, 7, 2, 0, 8, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 7, 2, 0, 5, 0, 0 }, 
				{ 0, 0, 3, 0, 0, 0, 0, 0, 9 },
				{ 0, 0, 0, 3, 0, 0, 7, 0, 0 }, 
				{ 0, 0, 4, 0, 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 9, 0, 8 },
				{ 0, 0, 1, 2, 5, 8, 0, 0, 0 } };
		return grid;
	}
}
