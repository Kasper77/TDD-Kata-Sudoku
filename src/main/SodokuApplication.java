package main;

import domain.Sudoku;

public class SodokuApplication {

	private Sudoku game;
	private User user;

	public SodokuApplication() {
		this.game = new Sudoku();
		this.user = new User();
	}

	public void run() {
		welcome();
		do {
			boolean solved = this.game.solve(user.getPuzzleToSolve());
			if (solved)
				showResult();
			else 
				notifyAnswer();
		} while (user.wantToPlay());

		goodBye();
	}

	private void notifyAnswer() {
		System.out.println("Unfortunately this sudoku does not have a solution!");
	}

	private void showResult() {
		System.out.println("=====> Solution: ");
		user.show(this.game.getGrid());
	}

	private void goodBye() {
		System.out.println("GAME ENDED :: ");
	}

	private void welcome() {
		System.out.println("GAME STARTING :: ");
	}
}
