package csci305.javalab;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author madis
 *
 *	Parent player class that all other players are extended from
 *
 *	@param
 *		String name
 *		int count
 *		boolean last
 *		Element lastElement
 */
public abstract class Player {
	public String name;
	public int count = 0;
	public Element last = null;
	public boolean won;
	public Element lastElement;
	public final HashMap moves = new HashMap();
	
	public final Element[] movesA = {new Rock("Rock"), new Paper("Paper"), new Scissors("Scissors"),
			new Spock("Spock"), new Lizard("Lizard")};
	
	//Constructor for player class that all subclasses will call with super
	public Player(String name) {
		this.name = name;
		moves.put("Rock", new Rock("Rock"));
		moves.put("Paper", new Paper("Paper"));
		moves.put("Scissors", new Scissors("Scissors"));
		moves.put("Spock", new Spock("Spock"));
		moves.put("Lizard", new Lizard("Lizard"));
	}
	
	//Returns name of player
	public String getName() {
		return name;
	}
	
	//Abstract method for playing that subclasses wills override
	abstract Element play();
}

/*
 * IterativeBot that cycles through all 5 plays
 */
class IterativeBot extends Player {
	//Constructor
	public IterativeBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = new Rock(name);

		//Cases for the count,
		if(count == 0) {
			returnElement = (Element) moves.get("Rock");
		}
		else if(count == 1) {
			returnElement = (Element) moves.get("Paper");
		}
		else if(count == 2) {
			returnElement = (Element) moves.get("Scissors");
		}
		else if(count == 3) {
			returnElement = (Element) moves.get("Spock");
		}
		else if(count == 4) {
			returnElement = (Element) moves.get("Lizard");
		}
		else {	//Reset count if it exceeds 5
			count = 0;
			returnElement = (Element) moves.get("Rock");
		}
		
		//Increment count each run through
		count++;
		return returnElement;
	}
}
	
/*
 * RandomBot that randomly selects a play
 */
class RandomBot extends Player{
	public RandomBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = new Rock(name);
		int random = (int)(Math.random()*5);
		returnElement = movesA[random];
		return returnElement;
	}
}
	
/*
 * StupidBot that always plays rock like an idiot
 */
class StupidBot extends Player {
	public StupidBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = (Element) moves.get("Rock");
		return returnElement;
	}
}
	
/*
 * LastPlayBot that always plays the opponents previous play
 */
class LastPlayBot extends Player{
	public LastPlayBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		Element returnElement = (Element) moves.get("Rock");
		if(last == null) {
			return returnElement;
		}
		return last;
	}
}
	
/*
 * MyBot that begins every game by randomly selecting a play, and continues to use said play until they lose. If they lose,
 * MyBot randomly selects another play and repeats the process of playing the same hand until it loses again.
 */
class MyBot extends Player{	//play til you win, swap randomly when you lose
	public MyBot(String name) {
		super(name);
	}
	
	@Override
	public Element play() {
		//Set returnElement to the last rounds hand played
		Element returnElement = lastElement;
		
		//If the bot won lost, randomly select a new hand
		if(won == false) {
			int random = (int)(Math.random()*5);
			returnElement = movesA[random];
			return returnElement;
		}
		//If the bot won, retain the hand.
		if(won == true) {
			return returnElement;
		}
		return returnElement;
	}
}

/*
 * Human player that gives the user an option of choosing a hand each round
 */
class Human extends Player{
	public String name;
	
	public Human(String name) {
		super(name);
	}
	
	public Element play() {
		String output = "";
		Element returnElement = (Element) moves.get("Rock");	//Initialize hand to rock, can be changed
		Scanner in = new Scanner(System.in);
		
		//Output for human player each round
		System.out.println("(1) : Rock");
		System.out.println("(2) : Paper");
		System.out.println("(3) : Scissors");
		System.out.println("(4) : Spock");
		System.out.println("(5) : Lizard");
		
		//Set valid input to false, will return if the input entered is not valid
		boolean validIn = false;
		
		//Choices for a hand
		while(validIn == false) {
			System.out.println("Enter your move: ");
			int input = in.nextInt();
			if(input == 1) {
				output = "Rock";
				returnElement = (Element) moves.get("Rock");
				validIn = true;
			}
			else if(input == 2) {
				output = "Paper";
				returnElement = (Element) moves.get("Paper");
				validIn = true;
			}
			else if(input == 3) {
				output = "Scissors";
				returnElement = (Element) moves.get("Scissors");
				validIn = true;
			}
			else if(input == 4) {
				output = "Lizard";
				returnElement = (Element) moves.get("Lizard");
				validIn = true;
			}
			else if(input == 5) {
				output = "Spock";
				returnElement = (Element) moves.get("Spock");
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
