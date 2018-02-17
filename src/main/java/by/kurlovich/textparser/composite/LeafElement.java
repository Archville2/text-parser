package by.kurlovich.textparser.composite;

public class LeafElement implements Element {
	char character;

	public LeafElement(char character) {
		this.character = character;
	}
	
	@Override
    public void printSequence() {
        System.out.print(character);
    }
	
	@Override
	public String toString (){
		return String.valueOf(character);
	}
}
