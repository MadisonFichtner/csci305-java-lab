package csci305.javalab;

import java.util.Scanner;

public abstract class Player {
	public String name;
	public int count = 0;
	public Element last = null;
	public final Element[] moves = {new Rock("Rock"), new Paper("Paper"), new Scissors("Scissors"),
			new Spock("Spock"), new Lizard("Lizard")};
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract Element play();
}
	
	
class IterativeBot extends Player {
	public IterativeBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = new Rock(name);

		if(count == 0) {
			returnElement = moves[0];
		}
		else if(count == 1) {
			returnElement = moves[1];
		}
		else if(count == 2) {
			returnElement = moves[2];
		}
		else if(count == 3) {
			returnElement = moves[3];
		}
		else if(count == 4) {
			returnElement = moves[4];
		}
		else {
			count = 0;
			returnElement = moves[0];
		}
		count++;
		return returnElement;
	}
}
	
class RandomBot extends Player{
	public RandomBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = new Rock(name);
		int random = (int)(Math.random()*5);
		returnElement = moves[random];
		return returnElement;
	}
}
	
class StupidBot extends Player {
	public StupidBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = moves[0];
		return returnElement;
	}
}
	
class LastPlayBot extends Player{
	public LastPlayBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = moves[0];
		if(last == null) {
			return returnElement;
		}
		return last;
	}
}
	
class MyBot extends Player{	//TODO
	public MyBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = moves[0];
		return returnElement;
	}
}

class Human extends Player{
	public String name;
	
	public Human(String name) {
		super(name);
	}
	
	public Element play() {
		String output = "";
		Element returnElement = moves[0];
		Scanner in = new Scanner(System.in);
		
		System.out.println("(1) : Rock");
		System.out.println("(2) : Paper");
		System.out.println("(3) : Scissors");
		System.out.println("(4) : Spock");
		System.out.println("(5) : Lizard");
		
		boolean validIn = false;
		while(validIn == false) {
			System.out.println("Enter your move: ");
			int input = in.nextInt();
			if(input == 1) {
				output = "Rock";
				returnElement = moves[0];
				validIn = true;
			}
			else if(input == 2) {
				output = "Paper";
				returnElement = moves[1];
				validIn = true;
			}
			else if(input == 3) {
				output = "Scissors";
				returnElement = moves[2];
				validIn = true;
			}
			else if(input == 4) {
				output = "Lizard";
				returnElement = moves[3];
				validIn = true;
			}
			else if(input == 5) {
				output = "Spock";
				returnElement = moves[4];
				validIn = true;
			}
			else {
				output = "Invalid move. Please try again.";
				validIn = false;
			}
		}
		validIn = false;
		return returnElement;
	}
}
