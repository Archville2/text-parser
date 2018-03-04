import by.kurlovich.textparser.exception.FileProblemException;
import by.kurlovich.textparser.parser.ChainParser;
import by.kurlovich.textparser.parser.EntityParser;
import by.kurlovich.textparser.parser.LexemeParser;
import by.kurlovich.textparser.parser.ParagraphParser;
import by.kurlovich.textparser.parser.SentenceParser;
import by.kurlovich.textparser.reader.TextReader;
import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.TextElements;

public class Starter {
	public static void main(String[] args) throws FileProblemException {
		TextReader reader = new TextReader();
		Element element = new CompositeElement(TextElements.TEXT);
		String text = reader.readFile("files/text.txt");
		
		ChainParser entityParser = new EntityParser(null);
		ChainParser lexemeParser = new LexemeParser(entityParser);
		ChainParser sentenceParser = new SentenceParser(lexemeParser);
		ChainParser paragraphParser = new ParagraphParser(sentenceParser);
		
		paragraphParser.parse(element, text);
	}
}
