package models;

public class Replace {
	private String oldText;
	private String newText;

	public Replace() {
	}

	public Replace(String oldText, String newText) {
		this.oldText = oldText;
		this.newText = newText;
	}

	public String getOldText() {
		return oldText;
	}

	public void setOldText(String oldText) {
		this.oldText = oldText;
	}

	public String getNewText() {
		return newText;
	}

	public void setNewText(String newText) {
		this.newText = newText;
	}
}
