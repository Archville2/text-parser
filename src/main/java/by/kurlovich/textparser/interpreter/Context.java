package by.kurlovich.textparser.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
	private Deque<Double> contextValues = new ArrayDeque<>();

	public Double popValue() {
		return contextValues.pop();
	}

	public void pushValue(Double value) {
		this.contextValues.push(value);
	}
}
