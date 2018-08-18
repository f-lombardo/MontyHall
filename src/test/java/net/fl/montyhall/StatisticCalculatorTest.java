package net.fl.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatisticCalculatorTest {

	@Test
	public void canComputeWinRate() {
		StatisticCalculator calculator = new StatisticCalculator();
		boolean win = true;
		calculator.addResult(win);
		calculator.addResult(!win);
		calculator.addResult(win);
		calculator.addResult(!win);
		assertTrue(Math.abs(0.5 - calculator.winRate()) < 0.001);
	}

}
