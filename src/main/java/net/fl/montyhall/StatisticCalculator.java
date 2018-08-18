package net.fl.montyhall;

public class StatisticCalculator {
	
	private int winTotal = 0;
	private int looseTotal = 0;
	
	public void addResult(boolean win) {
		if (win) {
			winTotal++;
		} else {
			looseTotal++;
		}
	}

	public double winRate() {
		return (double) winTotal / ((double) (winTotal + looseTotal));
	}

	public int getWinTotal() {
		return winTotal;
	}

	public int getLooseTotal() {
		return looseTotal;
	}

}
