package by.kurlovich.textparser.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.kurlovich.textparser.chain.ConeHandler;
import by.kurlovich.textparser.composite.CompositeElement;
import by.kurlovich.textparser.composite.Element;
import by.kurlovich.textparser.composite.LeafElement;
import by.kurlovich.textparser.exception.FileProblemException;
import by.kurlovich.textparser.reader.TextReader;

public class TextParser {
	private final static Logger LOGGER = Logger.getLogger(TextParser.class);
	private final static String PARAGRAPH_PARSE_REGEX = "\\t[^\\t]+";
	private final static String SENTENCE_PARSE_REGEX = "[^\\.\\!\\?]*[\\.\\!\\?]";
	private final static String WORD_PARSE_REGEX = "\\s*[^\\s]+\\b(.)";
	private final static String CHAR_PARSE_REGEX = ".{1}";
	
	private ConeHandler textList;
	private TextReader textReader = new TextReader();

	public void parseText() {
		try {
			List<String> text = textReader.readFile("./files/text.txt");

			String fullText = "";

			for (String line : text) {
				fullText += line;
			}

			textList = parse(fullText);

		} catch (FileProblemException e) {
			// stub
		}
	}

	public ConeHandler getText () {
		return textList;
	}
	
	public ConeHandler parse(String text) {
		ConeHandler allText = new CompositeElement();
		LOGGER.log(Level.DEBUG, "full text = " + text);
		allText.setEntityType("all");
		//allText.setSuccessor(allText);
		allText = parseToParagraph(allText, text);
		
		return allText;
	}

	private ConeHandler parseToParagraph(ConeHandler allText, String text) {
		
		Pattern pattern = Pattern.compile(PARAGRAPH_PARSE_REGEX);
		Matcher matcher = pattern.matcher(text);

		int count = 0;
		while (matcher.find()) {
			ConeHandler paragraphList = new CompositeElement();
			count++;
			String paragraph = matcher.group();

			//paragraphList.text=paragraph;
			//paragraphList = parseToSentence(paragraphList, paragraph);

			paragraphList.setEntityType("paragraph");
			allText.setSuccessor(paragraphList);
			allText.addElement((Element) paragraphList);
		}
		LOGGER.log(Level.DEBUG, count + " paragraphs added ");
		

		return allText;
	}
/*
	private CompositeElement parseToSentence(CompositeElement paragraphList, String paragraph) {
		CompositeElement sentenceList = new CompositeElement();
		Pattern pattern = Pattern.compile(SENTENCE_PARSE_REGEX);
		Matcher matcher = pattern.matcher(paragraph);
		String sentence = "";

		int count = 0;
		while (matcher.find()) {
			count++;
			sentence = matcher.group();

			sentenceList = parseToWord(sentenceList, sentence);
			sentenceList.setEntityType("sentence");
			sentenceList.setSuccessor(sentenceList);
		}
		LOGGER.log(Level.DEBUG, count + " sentences added ");

		paragraphList.addElement(sentenceList);
		return paragraphList;
	}

	private CompositeElement parseToWord(CompositeElement sentenceList, String sentence) {
		CompositeElement wordList = new CompositeElement();
		Pattern pattern = Pattern.compile(WORD_PARSE_REGEX);
		Matcher matcher = pattern.matcher(sentence);
		String word = "";

		int count = 0;
		while (matcher.find()) {
			count++;
			word = matcher.group();
			wordList = parseToChar(wordList, word);
			wordList.setSuccessor(wordList);
		}
		LOGGER.log(Level.DEBUG, count + " words added ");
		wordList.setEntityType("word");
		sentenceList.addElement(wordList);
		return sentenceList;
	}

	private CompositeElement parseToChar(CompositeElement wordList, String word) {

		Pattern pattern = Pattern.compile(CHAR_PARSE_REGEX);
		Matcher matcher = pattern.matcher(word);
		char character;

		int count = 0;
		while (matcher.find()) {
			count++;
			character = matcher.group().charAt(0);
			LeafElement charList = new LeafElement(character);
			wordList.addElement(charList);
		}
		LOGGER.log(Level.DEBUG, count + " chars added ");
		return wordList;
	} */
}
