import by.kurlovich.textparser.chain.ConeHandler;
import by.kurlovich.textparser.composite.CompositeElement;
import by.kurlovich.textparser.parser.TextParser;

public class Starter {
	public static void main(String[] args) {
		TextParser textParser = new TextParser();
		textParser.parseText();
		CompositeElement element = (CompositeElement) textParser.getText();
		element.processRequest("paragraph");
	}
}
