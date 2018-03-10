package by.kurlovich.textparser.sort;

import java.util.Comparator;

public class SortByCharCount implements Comparator<String> {
	private char ch;

	public SortByCharCount(char ch) {
		this.ch = ch;
	}

	@Override
	public int compare(String s1, String s2) {
		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();

		int count1 = 0;
		int count2 = 0;

		for (char character : array1) {
			if (character == ch) {
				count1++;
			}
		}

		for (char character : array2) {
			if (character == ch) {
				count2++;
			}
		}

		if (count1 < count2) {
			return 1;
		} else if (count1 > count2) {
			return -1;
		} else {
			return s1.compareTo(s2);
		}
	}
}
