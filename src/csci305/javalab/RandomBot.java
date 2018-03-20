package csci305.javalab;

import java.util.Random;

public class RandomBot extends Player{
	public String name;
	
	public RandomBot(String name) {
		super(name);
	}
	
	public Element play() {
		Element returnElement = new Rock(name);
		int random = (int)(Math.random()*5);
		String output = ""; 
		
		if(random == 0) {
			output = "Rock";
			returnElement = new Rock(output);
		}
		else if(random == 1) {
			output = "Paper";
			returnElement = new Paper(output);
		}
		else if(random == 2) {
			output = "Scissors";
			returnElement = new Scissors(output);
		}
		else if(random == 3) {
			output = "Spock";
			returnElement = new Spock(output);
		}
		else if(random == 4) {
			output = "Lizard";
			returnElement = new Lizard(output);
		}
		
		return returnElement;
	}
}
