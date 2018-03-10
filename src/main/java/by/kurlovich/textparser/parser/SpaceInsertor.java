package by.kurlovich.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpaceInsertor {
	private final static String MATH_EXPRESSION_REGEX = "((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*\\/\\(\\)]))";

	public String insert(String text) {
		String result = "";
		String previous = "";
		String current;

		Pattern pattern = Pattern.compile(MATH_EXPRESSION_REGEX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			current = matcher.group();

			if (current.equals("-") && !isNumber(previous) && !previous.equals(")")) {
				result += current;
			} else {
				result += current + " ";
			}
			previous = current;
		}

		return result;
	}

	private boolean isNumber(String str) {
		try {
			Double.valueOf(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
