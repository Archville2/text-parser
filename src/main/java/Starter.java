import java.util.List;

import by.kurlovich.textparser.calculator.CalculateIJ;
import by.kurlovich.textparser.exception.FileProblemException;
import by.kurlovich.textparser.interpreter.Client;
import by.kurlovich.textparser.parser.ChainParser;
import by.kurlovich.textparser.parser.EntityParser;
import by.kurlovich.textparser.parser.LexemeParser;
import by.kurlovich.textparser.parser.ParagraphParser;
import by.kurlovich.textparser.parser.SentenceParser;
import by.kurlovich.textparser.polska.PolishAlgoritm;
import by.kurlovich.textparser.reader.TextReader;
import by.kurlovich.textparser.sort.SortByCharCount;
import by.kurlovich.textparser.sort.SortBySentenceCount;
import by.kurlovich.textparser.sort.SortByLexemeLength;
import by.kurlovich.textparser.store.CompositeElement;
import by.kurlovich.textparser.store.Element;
import by.kurlovich.textparser.store.SearchResultList;
import by.kurlovich.textparser.store.TextElements;

public class Starter {
	public static void main(String[] args) throws FileProblemException {
		TextReader reader = new TextReader();
		Element element = new CompositeElement(TextElements.TEXT);
		String text = reader.readFile("files/textus.txt");

		System.out.println(text);
		
		CalculateIJ  calculate = new CalculateIJ();
		text = calculate.calculate(text, 5, 8);
		
		System.out.println(text);
		
		ChainParser entityParser = new EntityParser(null);
		ChainParser lexemeParser = new LexemeParser(entityParser);
		ChainParser sentenceParser = new SentenceParser(lexemeParser);
		ChainParser paragraphParser = new ParagraphParser(sentenceParser);
		
		paragraphParser.parse(element, text);
		
		SearchResultList paragraphResult = new SearchResultList();
		element.formElementList(paragraphResult, "PARAGRAPH");
		
		List<String> paragraphList = paragraphResult.getStringList();
		
		SortBySentenceCount sentenceSort = new SortBySentenceCount();
		SortByLexemeLength wordsSort = new SortByLexemeLength();
		SortByCharCount charSort = new SortByCharCount('a');
		
		paragraphList.sort(sentenceSort);
		for (String line :paragraphList) {
			System.out.println(line);
		}
		
		SearchResultList sentenceResult = new SearchResultList();
		element.formElementList(sentenceResult, "SENTENCE");
		
		List<String> sentenceList = sentenceResult.getStringList();
		
		sentenceList.sort(wordsSort);
		for (String line :sentenceList) {
			System.out.println(line);
		}
		
		SearchResultList lexemeResult = new SearchResultList();
		element.formElementList(lexemeResult, "LEXEME");
		
		List<String> lexemeList = lexemeResult.getStringList();
		
		lexemeList.sort(charSort);
		for (String line :lexemeList) {
			System.out.println(line);
		}
	}
}
