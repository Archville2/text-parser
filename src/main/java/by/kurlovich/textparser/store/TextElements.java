package by.kurlovich.textparser.store;

public enum TextElements {
	TEXT ("text"), PARAGRAPH("paragraph"), SENTENCE("sentence"), LEXEME("lexeme");

	private String entity;

	private TextElements(String entity) {
		this.entity = entity;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
	

}
