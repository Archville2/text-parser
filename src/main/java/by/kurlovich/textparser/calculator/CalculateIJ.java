package by.kurlovich.textparser.calculator;

public class CalculateIJ {
	public String calculate(String text, int i, int j) {

		text = text.replace("i++", String.valueOf(i));
		text = text.replace("++i", String.valueOf(i));
		text = text.replace("i--", String.valueOf(i));
		text = text.replace(" --j", String.valueOf(j));

		return text;
	}
}
