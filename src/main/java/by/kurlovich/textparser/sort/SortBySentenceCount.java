package by.kurlovich.textparser.sort;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortBySentenceCount implements Comparator<String> {
	private final static String SENTENCE_PARSE_REGEX = "[^\\.\\!\\?]*[\\.\\!\\?]";

	@Override
	public int compare(String s1, String s2) {
		Pattern pattern = Pattern.compile(SENTENCE_PARSE_REGEX);
		Matcher matcher1 = pattern.matcher(s1);
		Matcher matcher2 = pattern.matcher(s2);

		int count1 = 0;
		int count2 = 0;

		while (matcher1.find()) {
			count1++;
		}

		while (matcher2.find()) {
			count2++;
		}

		if (count1 < count2) {
			return 1;
		} else if (count1 > count2) {
			return -1;
		} else {
			return 0;
		}
	}
}
