package bookStore;

public interface INotepad {
	
	public void addText(int numPage, String newText);
	public void deleteAndInsertText(int numPage, String newText);
	public void addHeader(int pageNum, String header);
	public void deleteHeader(int pageNum);
	public void deleteText(int numPage);
	public void printNotepad();
	public boolean searchWord(String word);
	public void printAllPagesWithDigits();
	
}
