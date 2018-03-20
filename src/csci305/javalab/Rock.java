package csci305.javalab;

public class Rock extends Element{
	public Outcome out;
	
	public Rock(String name) {
		super(name);
	}
	
	public String compareTo(Element element) {
		//paper covers rock
		//rock crushes lizard
		//spock vaporizes rock
		//rock crushes scissors
		
		String elementName = element.getName();
		if(elementName.equals("Paper"))
			out = new Outcome("Paper covers Rock", "Lose");
		else if(elementName.equals("Lizard"))
			out = new Outcome("Rock crushes Lizard", "Win");
		else if(elementName.equals("Spock"))
			out = new Outcome("Spock vaporizes Rock", "Lose");
		else if(elementName.equals("Scissors"))
			out = new Outcome("Rock crushes Scissors", "Win");
		else if(elementName.equals("Rock"))
			out = new Outcome("Rock equals Rock", "Tie");
		else
			return "Invalid";
		
		String output = out.getRule() + " -- " + out.getResult();
		return output;
	}
}