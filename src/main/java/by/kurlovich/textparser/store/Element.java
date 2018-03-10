package by.kurlovich.textparser.store;

import java.util.List;

public interface Element {
	void formElementList(SearchResultList result, String param);
	void addElement(Element element);
	String getTextElement ();
	List<Element> getElementList();
}
