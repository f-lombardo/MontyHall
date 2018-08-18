package net.fl.montyhall;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Insert number of tests:");
		int n = new Scanner(System.in).nextInt();
		compute(n, new StatisticCalculator());
	}

	public static void compute(int n, StatisticCalculator calculator) {
		for (int i = 0; i < 100000; i++) {
			Game game = new Game();
			game.play();
			calculator.addResult(game.playerWins());			
		}
		
		System.out.println("Win Rate: " + calculator.winRate());
		System.out.println("Wins: " + calculator.getWinTotal());
		System.out.println("Looses: " + calculator.getLooseTotal());
	}

}
