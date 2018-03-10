package by.kurlovich.textparser.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private List<AbstractMathExpression> listExpression;

	public Client(String expression) {
		listExpression = new ArrayList<>();
		parse(expression);
	}

	private void parse(String expression) {
		for (String lexeme : expression.split("\\s")) {
			if (lexeme.isEmpty()) {
				continue;
			}
			switch (lexeme) {
			case "+":
				listExpression.add(new TerminalExpressionPlus());
				break;
			case "-":
				listExpression.add(new TerminalExpressionMinus());
				break;
			case "*":
				listExpression.add(new TerminalExpressionMultiply());
				break;
			case "/":
				listExpression.add(new TerminalExpressionDivide());
				break;
			default:
				listExpression.add(new NonterminalExpressionNumber(Double.parseDouble(lexeme)));
			}
		}
	}

	public Number calculate() {
		Context context = new Context();

		for (AbstractMathExpression terminal : listExpression) {
			terminal.interpret(context);
		}
		return context.popValue();
	}
}
