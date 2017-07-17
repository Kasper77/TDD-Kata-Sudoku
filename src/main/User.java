package main;

import java.util.Scanner;

import domain.Grid;
import domain.Numeric;

public class User {

	private static final int GRID_SIZE = 9;
	private Scanner in;

	public User() {
		in = new Scanner(System.in);
	}

	public boolean wantToPlay() {
		System.out.print("Another game (y/n) ? ");
		do {
			String response = in.nextLine();
			if (answerIsYes(response))
				return true;
			else if (answerIsNo(response))
				return false;
		} while (true);
	}

	public int[][] getPuzzleToSolve() {
		System.out.println("Insert the whole 9x9 grid - just integers with a space and '0' for the empty cells: ");
		int[][] grid = new int[GRID_SIZE][GRID_SIZE];
		for (int i = 0; i < GRID_SIZE; i++)
			getLine(grid, in, i);
		return grid;
	}

	private void getLine(int[][] grid, Scanner in, int i) {
		String[] line;
		do {
			line = in.nextLine().trim().split("\\s+");
		} while (!lineIsWellFormatted(line));

		for (int k = 0; k < line.length; k++)
			grid[i][k] = Numeric.toInteger(line, k);
	}

	private boolean lineIsWellFormatted(String[] line) {
		if (line.length != GRID_SIZE)
			return false;
		for (int i = 0; i < line.length; i++) {
			if (!Numeric.isInteger(line[i])) {
				System.out.println("Just numbers, please!");
				return false;
			}
		}
		return true;
	}

	public void show(Grid grid) {
		for (int i = 0; i < grid.length(); i++) {
			for (int j = 0; j < grid.length(); j++) {
				System.out.print(grid.getGrid()[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean answerIsNo(String response) {
		return response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n");
	}

	private boolean answerIsYes(String response) {
		return response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
	}
	
	@Override
	public void finalize () {
		in.close();
	}
}
