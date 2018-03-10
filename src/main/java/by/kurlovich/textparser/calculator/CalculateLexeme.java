package by.kurlovich.textparser.calculator;

import by.kurlovich.textparser.interpreter.Client;
import by.kurlovich.textparser.parser.SpaceInsertor;
import by.kurlovich.textparser.polska.PolishAlgoritm;

public class CalculateLexeme {
	SpaceInsertor injector = new SpaceInsertor();

	public String calculate(String lexeme) {
		lexeme = injector.insert(lexeme);
		lexeme = (new PolishAlgoritm().convertInfixToRPN(lexeme.split("\\s")));
		
		Client interpreter = new Client(lexeme);
		Integer result = interpreter.calculate().intValue();
		
		return result.toString();
	}
}
