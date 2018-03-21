package csci305.javalab;

/**
 * 
 * @author madis
 *
 * Element class that contains all subclasses of each hand/element
 * 
 * 	@param
 * 		String name
 * 		Outcome out
 * 		String[] fin (finishes)
 */
public abstract class Element {
	public String name;
	public Outcome out;
	public final String[] fin = {"Win", "Lose", "Tie"};
	
	//Constructor
	public Element(String name) {
		this.name = name;
	}
	
	//Returns name of element
	public String getName() {
		return name;
	}
	
	//Abstract call for compareTo that all other classes will override
	abstract Outcome compareTo(Element element);
}

/*
 * Rock class that holds information for winning and losing for when a player uses rock
 */
class Rock extends Element{
	//Constructor
	public Rock(String name) {
		super(name);
	}
	
	//Overridden function for compareTo
	@Override
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

/*
 * Paper class that holds information for winning and losing for when a player uses paper
 */
class Paper extends Element{
	//Constructor
	public Paper(String name) {
		super(name);
	}
	
	//Overridden compareto function
	@Override
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

/*
 * Scissors class that holds information for winning and losing for when a player uses scissors
 */
class Scissors extends Element{
	//Constructor
	public Scissors(String name) {
		super(name);
	}
	
	//Overridden compareto function
	@Override
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

/*
 * Lizard class that holds information for winning and losing for when a player uses Lizard
 */
class Lizard extends Element {
	//Constructor
	public Lizard(String name) {
		super(name);
	}
	
	//Overridden compareto function
	@Override
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

/*
 * Spock class that holds information for winning and losing for when a player uses spock
 */
class Spock extends Element{
	//Constructor
	public Spock(String name) {
		super(name);
	}
	
	//Overridden compareto function
	@Override
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
