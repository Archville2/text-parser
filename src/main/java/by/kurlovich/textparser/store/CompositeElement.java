package by.kurlovich.textparser.store;

import java.util.ArrayList;
import java.util.List;


public class CompositeElement implements Element {
	private List<Element> elementList = new ArrayList<>();
	private TextElements textElement;

	public CompositeElement(TextElements textElement) {
		this.textElement = textElement;
	}

	public void processRequest(String param) {
	}

	@Override
	public void printSequence() {
		for (Element element : elementList) {
			element.printSequence();
		}
	}

	public void addElement(Element element) {
		elementList.add(element);
	}
}
