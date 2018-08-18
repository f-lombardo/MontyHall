package net.fl.montyhall;

public class Game {

	private Doors doors;
	private Player player;
	private MontyHall montyHall;

	public void play() {
		doors = new Doors();
		player = new Player();
		player.chooseOne(doors);
		montyHall = new MontyHall();
		montyHall.chooseGoat(doors);
		player.change(doors);
	}

	public boolean playerWins() {
		return doors.isWinning(player);
	}
}
