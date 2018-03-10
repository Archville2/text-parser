package by.kurlovich.textparser.store;

import java.util.ArrayList;
import java.util.List;

public class SearchResultList {
	private List<String> stringList = new ArrayList<>();
	private List<Element> elementList = new ArrayList<>();

	public void addString(String text) {
		stringList.add(text);
	}

	public List<String> getStringList() {
		return stringList;
	}

	public void addElement(Element el) {
		elementList.add(el);
	}

	public List<Element> getElementList() {
		return elementList;
	}
}
