package by.kurlovich.textparser.interpreter;

public class TerminalExpressionDivide extends AbstractMathExpression {

	@Override
	public void interpret(Context c) {
		Double firstValue = c.popValue();
		Double secondValue = c.popValue();
		c.pushValue(secondValue / firstValue);
	}
}
