package net.fl.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class MontyHallTest {

	@Test
	public void playerChoosesADoor() {
		Doors doors = new Doors();
		Player player = new Player();
		player.chooseOne(doors);
		assertOnePortOwnedBy(doors, player);
	}

	private void assertOnePortOwnedBy(Doors doors, Owner owner) {
		int ownedPorts = 0;
		for (Owner doorOwner : doors.owners()) {
			if (owner.equals(doorOwner)){
				ownedPorts++;
			}
		}
		assertEquals(owner.getName() + " should own exactly one port", 1, ownedPorts);
	}
	
	@Test
	public void montyHallChoosesAGoatDoor() {
		Doors doors = new Doors();
		Player player = new Player();
		player.chooseOne(doors);
		MontyHall montyHall = new MontyHall();
		montyHall.chooseGoat(doors);
		assertOnePortOwnedBy(doors, player);
		assertOnePortOwnedBy(doors, montyHall);
	}
	
	@Test
	public void playerChangesHisDoor() {
		Doors doors = new Doors();
		Player player = new Player();
		player.chooseOne(doors);
		MontyHall montyHall = new MontyHall();
		montyHall.chooseGoat(doors);
		player.change(doors);
		assertOnePortOwnedBy(doors, player);
		assertOnePortOwnedBy(doors, montyHall);
		if (doors.isWinning(player)) {
			System.out.println("Winning");
		} else {
			System.out.println("Loosing");
		}
	}
}
