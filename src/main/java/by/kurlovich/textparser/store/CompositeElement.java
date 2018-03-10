package by.kurlovich.textparser.store;

import java.util.ArrayList;
import java.util.List;

public class CompositeElement implements Element {
	private List<Element> elementList = new ArrayList<>();
	private TextElements textElement;

	public CompositeElement(TextElements textElement) {
		this.textElement = textElement;
	}

	public void processRequest(SearchResultList result, Element el) {
		String str = "";
		for (Element element : el.getElementList()) {
			str += element.toString();
		}
		result.addString(str);
	}

	@Override
	public String getTextElement() {
		return textElement.name();
	}

	@Override
	public void formElementList(SearchResultList result, String param) {
		for (Element element : elementList) {
			if (element.getTextElement().equals(param.toUpperCase())) {
				processRequest(result, element);
			} else {
				element.formElementList(result, param);
			}
		}
	}

	@Override
	public void addElement(Element element) {
		elementList.add(element);
	}

	@Override
	public List<Element> getElementList() {
		return elementList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elementList == null) ? 0 : elementList.hashCode());
		result = prime * result + ((textElement == null) ? 0 : textElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeElement other = (CompositeElement) obj;
		if (elementList == null) {
			if (other.elementList != null)
				return false;
		} else if (!elementList.equals(other.elementList))
			return false;
		if (textElement != other.textElement)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (Element text : elementList) {
			result.append(text.toString());
		}

		return result.toString();
	}
}
