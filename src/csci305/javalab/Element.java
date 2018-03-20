package csci305.javalab;

public abstract class Element {
	public String name;
	public Outcome out;
	public final String[] fin = {"Win", "Lose", "Tie"};
	
	public Element(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract Outcome compareTo(Element element);
}

class Rock extends Element{
	public Rock(String name) {
		super(name);
	}
	
	public Outcome compareTo(Element element) {
		//paper covers rock
		//rock crushes lizard
		//spock vaporizes rock
		//rock crushes scissors
		
		String elementName = element.getName();
		if(elementName.equals("Paper"))
			out = new Outcome("Paper covers Rock", fin[1]);
		else if(elementName.equals("Lizard"))
			out = new Outcome("Rock crushes Lizard", fin[0]);
		else if(elementName.equals("Spock"))
			out = new Outcome("Spock vaporizes Rock", fin[1]);
		else if(elementName.equals("Scissors"))
			out = new Outcome("Rock crushes Scissors", fin[0]);
		else if(elementName.equals("Rock"))
			out = new Outcome("Rock equals Rock", fin[2]);
		
		String output = out.getRule() + " -- " + out.getResult();
		return out;
	}
}

class Paper extends Element{
	public Outcome out;
	
	public Paper(String name) {
		super(name);
	}
	
	public Outcome compareTo(Element element) {
		//scissors cut paper
		//paper covers rock
		//lizard eats paper
		//paper disproves spock
		
		String elementName = element.getName();
		if(elementName.equals("Scissors"))
			out = new Outcome("Scissors cut Paper", fin[1]);
		else if(elementName.equals("Rock"))
			out = new Outcome("Paper covers Rock", fin[0]);
		else if(elementName.equals("Lizard"))
			out = new Outcome("Lizard eats Paper", fin[1]);
		else if(elementName.equals("Spock"))
			out = new Outcome("Paper disproves Spock", fin[0]);
		else if(elementName.equals("Paper"))
			out = new Outcome("Paper equals Paper", fin[2]);
		
		String output = out.getRule() + " -- " + out.getResult();
		return out;
	}
}

class Scissors extends Element{
	public Outcome out;
	
	public Scissors(String name) {
		super(name);
	}
	
	public Outcome compareTo(Element element) {
		//scissors cut paper
		//spock smashes scissors
		//scissors decapitate lizard
		//rock crushes scissors
		
		String elementName = element.getName();
		if(elementName.equals("Paper"))
			out = new Outcome("Scissors cut Paper", fin[0]);
		else if(elementName.equals("Spock"))
			out = new Outcome("Spock smashes Scissors", fin[1]);
		else if(elementName.equals("Lizard"))
			out = new Outcome("Scissors decapitate lizard", fin[0]);
		else if(elementName.equals("Rock"))
			out = new Outcome("Rock crushes Scissors", fin[1]);
		else if(elementName.equals("Scissors"))
			out = new Outcome("Scissors equals Scissors", fin[2]);
		
		String output = out.getRule() + " -- " + out.getResult();
		return out;
	}
}

class Lizard extends Element {
	public Outcome out;
	
	public Lizard(String name) {
		super(name);
	}
	
	public Outcome compareTo(Element element) {
		//rock crushes lizard
		//lizard poisons spock
		//scissors decapitate lizard
		//lizard eats paper
		
		String elementName = element.getName();
		if(elementName.equals("Rock"))
			out = new Outcome("Rock crushes Lizard", fin[1]);
		else if(elementName.equals("Spock"))
			out = new Outcome("Lizard poisons Spock", fin[0]);
		else if(elementName.equals("Scissors"))
			out = new Outcome("Scissors decapitates lizard", fin[1]);
		else if(elementName.equals("Paper"))
			out = new Outcome("Lizard eats Paper", fin[0]);
		else if(elementName.equals("Lizard"))
			out = new Outcome("Lizard equals Lizard", fin[2]);
		
		String output = out.getRule() + " -- " + out.getResult();
		return out;
	}
}

class Spock extends Element{
	public Outcome out;
	
	public Spock(String name) {
		super(name);
	}
	
	public Outcome compareTo(Element element) {
		//lizard poisons spock
		//spock smashes scissors
		//paper disproves spock
		//spock vaporizes rock
		
		String result = "";
		String elementName = element.getName();
		if(elementName.equals("Lizard")) 
			out = new Outcome("Lizard poisons Spock", result = fin[1]);
		else if(elementName.equals("Scissors"))
			out = new Outcome("Spock smashes scissors", result = fin[0]);
		else if(elementName.equals("Paper"))
			out = new Outcome("Paper disproves Spock", result = fin[1]);
		else if(elementName.equals("Rock"))
			out = new Outcome("Spock vaporizes rock", result = fin[0]);
		else if(elementName.equals("Spock"))
			out = new Outcome("Spock equals Spock", result = fin[2]);
		
		//String output = out.getRule() + " -- " + out.getResult();
		return out;
	}
}
