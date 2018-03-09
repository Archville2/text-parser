package by.kurlovich.textparser.store;

import java.util.List;

public class LeafElement implements Element {
	private LeafElements leafElement;
	private char entity;

	public LeafElement(LeafElements leafElement, char entity) {
		this.leafElement = leafElement;
		this.entity = entity;
	}

	@Override
	public void addElement(Element element) {

	}
	
	@Override
	public List<Element> getElementList() {
		return null;
	}
	
	@Override
	public String getTextElement () {
		return leafElement.name();
	}	

	@Override
	public void printSequence(String param) {
		if (leafElement.equals(param.toUpperCase())) {
			System.out.println(param + " found");
		}
	}

	@Override
	public String toString() {
		return String.valueOf(entity);
	}
}
