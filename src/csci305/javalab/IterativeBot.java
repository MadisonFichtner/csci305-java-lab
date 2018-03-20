package csci305.javalab;

public class IterativeBot extends Player {
	public int count = 0;
	
	public IterativeBot(String name) {
		super(name);
	}
	
	public Element play() {
		Element returnElement = new Rock(name);
		String output = "";
		if(count == 0) {
			output = "Rock";
			returnElement = new Rock(output);
		}
		else if(count == 1) {
			output = "Paper";
			returnElement = new Paper(output);
		}
		else if(count == 2) {
			output = "Scissors";
			returnElement = new Scissors(output);
		}
		else if(count == 3) {
			output = "Spock";
			returnElement = new Spock(output);
		}
		else if(count == 4) {
			output = "Lizard";
			returnElement = new Lizard(output);
		}
		
		count++;
		return returnElement;
	}

}
