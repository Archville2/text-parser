package by.kurlovich.textparser.calculator;

import by.kurlovich.textparser.interpreter.Client;
import by.kurlovich.textparser.parser.SpaceInjector;
import by.kurlovich.textparser.polska.PolishAlgoritm;

public class CalculateLexeme {
	SpaceInjector injector = new SpaceInjector();

	public String calculate(String lexeme) {
		lexeme = injector.inject(lexeme);
		lexeme = (new PolishAlgoritm().convertInfixToRPN(lexeme.split("\\s")));
		Client interpreter = new Client(lexeme);
		return interpreter.calculate().toString();
	}
}
