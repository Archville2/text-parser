package by.kurlovich.textparser.interpreter;

public class NonterminalExpressionNumber extends AbstractMathExpression {
	private double number;

	public NonterminalExpressionNumber(double number) {
		this.number = number;
	}

	@Override
	public void interpret(Context c) {
		c.pushValue(number);
	}
}
