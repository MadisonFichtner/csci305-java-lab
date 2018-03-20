package csci305.javalab;

public abstract class Player {
	public String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract Element play();
}
