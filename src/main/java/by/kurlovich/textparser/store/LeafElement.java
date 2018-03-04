package by.kurlovich.textparser.store;

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
	public void printSequence() {
		System.out.print(entity);
	}

	@Override
	public String toString() {
		return String.valueOf(entity);
	}
}
