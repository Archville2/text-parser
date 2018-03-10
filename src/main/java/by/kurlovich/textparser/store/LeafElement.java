package by.kurlovich.textparser.store;

import java.util.List;

public class LeafElement implements Element {
	private TextElements textElement;
	private String entity;

	public LeafElement(TextElements textElement, String entity) {
		this.textElement = textElement;
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
		return textElement.name();
	}	

	@Override
	public void formElementList(SearchResultList result, String param) {
		if (textElement.equals(param.toUpperCase())) {
			System.out.println(param + " found");
		}
	}

	@Override
	public String toString() {
		return String.valueOf(entity);
	}
}
