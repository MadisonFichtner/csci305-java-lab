package csci305.javalab;

public class Paper extends Element{
	public Outcome out;
	
	public Paper(String name) {
		super(name);
	}
	
	public String compareTo(Element element) {
		//scissors cut paper
		//paper covers rock
		//lizard eats paper
		//paper disproves spock
		
		String elementName = element.getName();
		if(elementName.equals("Scissors"))
			out = new Outcome("Scissors cut Paper", "Lose");
		else if(elementName.equals("Rock"))
			out = new Outcome("Paper covers Rock", "Win");
		else if(elementName.equals("Lizard"))
			out = new Outcome("Lizard eats Paper", "Lose");
		else if(elementName.equals("Spock"))
			out = new Outcome("Paper disproves Spock", "Win");
		else if(elementName.equals("Paper"))
			out = new Outcome("Paper equals Paper", "Tie");
		else
			return "Invalid";
		
		String output = out.getRule() + " -- " + out.getResult();
		return output;
	}
}
