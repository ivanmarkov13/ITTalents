package bookStore;

public class SimpleNotepad implements INotepad{
	protected final int numPages;
	protected final NotepadPage[] pages;
	protected final String format;
	
	
	public SimpleNotepad(int numPages, String format){
		if((format.equalsIgnoreCase("small") || format.equalsIgnoreCase("medium") || format.equalsIgnoreCase("large")) && numPages > 0){
			this.numPages = numPages;
			
			if(format.equalsIgnoreCase("small")){
				this.format = format;
			}
			else
			if(format.equalsIgnoreCase("medium")){
				this.format = format;
			}
			else{
				this.format = format;
			}
		}
		else{
			this.numPages = 30;
			this.format = "medium";
		}
		
		this.pages = new NotepadPage[this.numPages];
		
		
		for(int i = 0; i < this.pages.length; i++){
			this.pages[i] = new NotepadPage(i + 1, this.format);
			
			
		}
		
		
	}
	
	
	
	public int getNumPages() {
		return numPages;
	}



	public String getFormat() {
		return format;
	}

	

	@Override
	public void addText(int numPage, String newText) {
		if(numPage >= 1 && numPage <= this.pages.length && newText != null && !newText.isEmpty()){
			this.pages[numPage-1].addText(newText);
		}
		else{
			System.out.println("Invalid parameters given in method addText in SimpleNotepad class!");
		}
		
	}

	@Override
	public void deleteAndInsertText(int numPage, String newText) {
		if(numPage >= 1 && numPage <= this.pages.length && newText != null && !newText.isEmpty()){
			this.pages[numPage-1].deleteText();
			this.pages[numPage-1].addText(newText);
		}
		else{
			System.out.println("Invalid parameters given in method deleteAndInsertText in SimpleNotepad class!");
		}
		
	}

	@Override
	public void deleteText(int numPage) {
		if(numPage >= 1 && numPage <= this.pages.length){
			this.pages[numPage-1].deleteText();
		}
		else{
			System.out.println("Invalid page number given in method deleteText in SimpleNotepad class!");
		}
		
	}
	
	@Override
	public void addHeader(int pageNum, String header) {
		if(header != null && header.length() < this.pages[pageNum-1].getMaxWordWidth()){
			pages[pageNum-1].addHeader(header);
		}
		else
		if(header.length() >= this.pages[pageNum-1].getMaxWordWidth()){
			System.out.println("The chosen header for page #" + pageNum + " is too big.");
		}
		
		
	}
	
	@Override
	public void deleteHeader(int pageNum) {
		this.pages[pageNum-1].deleteHeader();
	}

	@Override
	public void printNotepad() {
		for(int i = 0; i < pages.length; i++){
			this.pages[i].printPage();
		}
		
	}


	@Override
	public boolean searchWord(String word) {
		for(int i = 0; i < this.pages.length; i++){
			if(this.pages[i].searchWord(word)){
				return true;
			}
		}
		return false;
	}



	@Override
	public void printAllPagesWithDigits() {
		boolean hasPageWithDigits = false;
		
		System.out.println("All pages with digits:");
		
		for(int i = 0; i < this.pages.length; i++){
			if(this.pages[i].containsDigits()){
				this.pages[i].printPage();
				hasPageWithDigits = true;
			}
		}
		
		if(!hasPageWithDigits){
			System.out.println("There are no pages with digits in this notepad.");
		}
		
	}

	
	
	
	
}
