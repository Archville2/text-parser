package by.kurlovich.textparser.sort;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortByLexemeLength implements Comparator<String> {
	private final static String LEXEME_PARSE_REGEX = "\\s*[^\\s]+\\b(.)";

	@Override
	public int compare(String s1, String s2) {
		Pattern pattern = Pattern.compile(LEXEME_PARSE_REGEX);
		Matcher matcher1 = pattern.matcher(s1);
		Matcher matcher2 = pattern.matcher(s2);

		int count1 = 0;
		int totalLength1 = 0;
		double averageLexemeLength1;

		int count2 = 0;
		int totalLength2 = 0;
		double averageLexemeLength2;

		while (matcher1.find()) {
			totalLength1 += matcher1.group().length();
			count1++;
		}

		averageLexemeLength1 = totalLength1 / count1;

		while (matcher2.find()) {
			count2++;
			totalLength2 += matcher2.group().length();
		}

		averageLexemeLength2 = totalLength2 / count2;
		
		if (averageLexemeLength1 < averageLexemeLength2) {
			return 1;
		} else if (averageLexemeLength1 > averageLexemeLength2) {
			return -1;
		} else {
			return 0;
		}
	}

}
