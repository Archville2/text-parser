package by.kurlovich.textparser.chain;

import java.util.ArrayList;
import java.util.List;

import by.kurlovich.textparser.composite.Element;

public abstract class ConeHandler {
	protected List<ConeHandler> successor = new ArrayList<>();
	
	public void setSuccessor(ConeHandler successor) {
		this.successor.add(successor);
	}
	
	abstract public void setEntityType(String entity);
	
	abstract public void addElement (Element element);

	abstract public void processRequest(String request);
	
}
