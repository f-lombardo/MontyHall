package net.fl.montyhall;

import java.util.*;

public class Doors {

	private List<Door> doors;
	
	public Doors() {
		doors = new ArrayList<Doors.Door>(){{
			add(new Door(Prize.GOAT));
			add(new Door(Prize.GOAT));
			add(new Door(Prize.CAR));
		}};
		Collections.shuffle(doors);
	}
	
	public void setOwner(int i, Owner owner) {
		doors.get(i).owner = owner;
	}

	public void chooseGoatFor(Owner owner) {
		for (Door door : doors) {
			if (door.isFree() && door.prize.equals(Prize.GOAT)) {
				door.owner = owner;
				return;
			}
		}
	}

	public List<Owner> owners() {
		List<Owner> result = new ArrayList<Owner>();
		for (Door door : doors) {
			result.add(door.owner);
		}
		return result;
	}
	
	public void moveToNextFreeDoor(Owner owner) {
		int current = getCurrentDoor(owner);
		int next = getNextFreeDoor();
		doors.get(current).owner = Owner.NO_ONE;
		doors.get(next).owner = owner;
	}

	public Prize prize(Owner owner) {
		return doors.get(getCurrentDoor(owner)).prize;
	}
	
	private int getNextFreeDoor() {
		for (int i = 0; i < doors.size(); i++) {
			if (doors.get(i).isFree()) {
				return i;
			}
		}
		throw new RuntimeException("No free doors");
	}

	private int getCurrentDoor(Owner owner) {
		for (int i = 0; i < doors.size(); i++) {
			if (owner.equals(doors.get(i).owner)) {
				return i;
			}
		}
		throw new RuntimeException(owner.getName() + " doesn't own a door");
	}

	private class Door {
		public final Prize prize;
		public Owner owner = Owner.NO_ONE;
		public Door(Prize prize) {
			this.prize = prize;
		}
		
		public boolean isFree() {
			return owner.equals(Owner.NO_ONE);
		}
	}

	public boolean isWinning(Player player) {
		return prize(player).equals(Prize.CAR);
	}

}
