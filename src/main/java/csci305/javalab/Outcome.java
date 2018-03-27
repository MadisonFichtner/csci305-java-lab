package main.java.csci305.javalab;

/**
 * 
 * @author madis
 *
 *	Outcome class that keeps track of the result of each round
 *	
 *	@param
 *		String rule
 *		String result
 */
public class Outcome {
	public String rule;
	public String result;
	
	//Constructor
	public Outcome(String rule, String result) {
		this.rule = rule;
		this.result = result;
	}
	
	//returns rule
	public String getRule() {
		return rule;
	}
	
	//returns result
	public String getResult() {
		return result;
	}
}
