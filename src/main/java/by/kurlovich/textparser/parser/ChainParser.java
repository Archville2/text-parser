package by.kurlovich.textparser.parser;

import by.kurlovich.textparser.store.Element;

public abstract class ChainParser {
	private ChainParser successor;

	public abstract Element parse(Element element, String text);

	protected ChainParser getSuccessor() {
		return successor;
	}

	protected void setSuccessor(ChainParser successor) {
		this.successor = successor;
	}
}
