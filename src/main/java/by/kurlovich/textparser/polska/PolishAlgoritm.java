package by.kurlovich.textparser.polska;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class PolishAlgoritm {
	private Map<String, Integer> priority = new HashMap<>();

	{
		priority.put("/", 5);
		priority.put("*", 5);
		priority.put("+", 4);
		priority.put("-", 4);
		priority.put("(", 0);
	}

	public String convertInfixToRPN(String[] infixNotation) {
		StringBuilder result = new StringBuilder();

		Deque<String> stack = new ArrayDeque<>();

		for (String token : infixNotation) {
			if ("(".equals(token)) {
				stack.push(token);
				continue;
			}

			if (")".equals(token)) {
				while (!"(".equals(stack.peek())) {
					result.append(stack.pop()).append(" ");
				}
				stack.pop();
				continue;
			}
			if (priority.containsKey(token)) {
				while (!stack.isEmpty() && priority.get(token) <= priority.get(stack.peek())) {
					result.append(stack.pop()).append(" ");
				}
				stack.push(token);
				continue;
			}

			if (isNumber(token)) {
				result.append(token).append(" ");
				continue;
			}

			throw new IllegalArgumentException("Invalid input");
		}

		while (!stack.isEmpty()) {
			result.append(stack.pop()).append(" ");
		}

		return result.toString();
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
