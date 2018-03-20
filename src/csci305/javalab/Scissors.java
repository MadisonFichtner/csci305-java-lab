package csci305.javalab;

public class Scissors extends Element{
	public Outcome out;
	
	public Scissors(String name) {
		super(name);
	}
	
	public String compareTo(Element element) {
		//scissors cut paper
		//spock smashes scissors
		//scissors decapitate lizard
		//rock crushes scissors
		
		String elementName = element.getName();
		if(elementName.equals("Paper"))
			out = new Outcome("Scissors cut Paper", "Win");
		else if(elementName.equals("Spock"))
			out = new Outcome("Spock smashes Scissors", "Lose");
		else if(elementName.equals("Lizard"))
			out = new Outcome("Scissors decapitate lizard", "Win");
		else if(elementName.equals("Rock"))
			out = new Outcome("Rock crushes Scissors", "Lose");
		else if(elementName.equals("Scissors"))
			out = new Outcome("Scissors equals Scissors", "Tie");
		else
			return "Invalid";
		
		String output = out.getRule() + " -- " + out.getResult();
		return output;
	}
}
