package csci305.javalab;

public abstract class Element {
	private String name;
	
	public Element(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract String compareTo(Element element);
}
