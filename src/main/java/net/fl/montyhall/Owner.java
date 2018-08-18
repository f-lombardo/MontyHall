package net.fl.montyhall;

public interface Owner {
	public Owner NO_ONE = new Owner() {
		public String getName() {
			return "No one";
		}
	};

	public String getName();
}
