package csci305.javalab;

public class Lizard extends Element {
	public Outcome out;
	
	public Lizard(String name) {
		super(name);
	}
	
	public String compareTo(Element element) {
		//rock crushes lizard
		//lizard poisons spock
		//scissors decapitate lizard
		//lizard eats paper
		
		String elementName = element.getName();
		if(elementName.equals("Rock"))
			out = new Outcome("Rock crushes Lizard", "Lose");
		else if(elementName.equals("Spock"))
			out = new Outcome("Lizard poisons Spock", "Win");
		else if(elementName.equals("Scissors"))
			out = new Outcome("Scissors decapitates lizard", "Lose");
		else if(elementName.equals("Paper"))
			out = new Outcome("Lizard eats Paper", "Win");
		else if(elementName.equals("Lizard"))
			out = new Outcome("Lizard equals Lizard", "Tie");
		else
			return "Invalid";
		
		String output = out.getRule() + " -- " + out.getResult();
		return output;
	}
}
