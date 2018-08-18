package net.fl.montyhall;

public class MontyHall implements Owner {

	public void chooseGoat(Doors doors) {
		doors.chooseGoatFor(this);
	}

	public String getName() {
		return "Monty Hall";
	}

}
