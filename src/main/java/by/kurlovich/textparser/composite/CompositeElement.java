package by.kurlovich.textparser.composite;

import java.util.ArrayList;
import java.util.List;

import by.kurlovich.textparser.chain.ConeHandler;

public class CompositeElement extends ConeHandler implements Element {
	private List<Element> elementList = new ArrayList<>();
	private String entityType;
	public String text;

	public CompositeElement() {
	}

	public void processRequest(String param) {
		
		for (ConeHandler coneHandler : successor) {
			System.out.println(param + " " + entityType);
			if (param.equals(entityType)) {
				System.out.println("param found");
				// printSequence();
			} 
			if (coneHandler != null) {
				coneHandler.processRequest(param);
			}
		}
	}

	@Override
	public void printSequence() {
		for (Element element : elementList) {
			element.printSequence();
		}
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public void addElement(Element element) {
		elementList.add(element);
	}

	public void removeElement(Element element) {
		elementList.remove(element);
	}

	public Element getElement(int index) {
		return elementList.get(index);
	}
}
