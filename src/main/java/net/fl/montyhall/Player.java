package net.fl.montyhall;

import java.util.Random;

public class Player implements Owner {

	public void chooseOne(Doors doors) {
		doors.setOwner(new Random().nextInt(2), this);
	}

	public void change(Doors doors) {
		doors.moveToNextFreeDoor(this);
	}

	public String getName() {
		return "Player";
	}

}
