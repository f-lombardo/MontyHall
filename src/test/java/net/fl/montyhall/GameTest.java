package net.fl.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void winRateShoudBeTwoThird() {
		StatisticCalculator calculator = new StatisticCalculator();

		Main.compute(10000, calculator);
		
		assertTrue(Math.abs(0.666666 - calculator.winRate()) < 0.01);
	}

}
