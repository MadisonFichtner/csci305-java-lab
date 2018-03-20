package csci305.javalab;

public class Spock extends Element{
	public Outcome out;
	
	public Spock(String name) {
		super(name);
	}
	
	public String compareTo(Element element) {
		//lizard poisons spock
		//spock smashes scissors
		//paper disproves spock
		//spock vaporizes rock
		
		
		String elementName = element.getName();
		if(elementName.equals("Lizard")) 
			out = new Outcome("Lizard poisons Spock", "Lose");
		else if(elementName.equals("Scissors"))
			out = new Outcome("Spock smashes scissors", "Win");
		else if(elementName.equals("Paper"))
			out = new Outcome("Paper disproves Spock", "Lose");
		else if(elementName.equals("Rock"))
			out = new Outcome("Spock vaporizes rock", "Win");
		else if(elementName.equals("Spock"))
			out = new Outcome("Spock equals Spock", "Tie");
		else
			return "Invalid";
		
		String output = out.getRule() + " -- " + out.getResult();
		return output;
	}
}
