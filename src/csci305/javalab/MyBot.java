package csci305.javalab;

public class MyBot extends Player{
	public MyBot(String name) {
		super(name);
	}
	
	public Element play() {
		Element returnElement = new Rock(name);
		return returnElement;
	}
}
