package bookStore;

public class NotepadPage {
	private String header;
	private String text;
	private final int number;
	private final String format;
	
	private final int pageRows;
	private final int pageWidth;
	private final int crossLineLength;
	private final int crossLineWidth;
	private final int maxWordWidth;
	private final int maxSymbolsInPage;
	private StringBuilder[] lines;
	
	public NotepadPage(int number, String format){
		this.number = number;
		this.header = "Header #" + this.number;
		this.text = "";
		
		
		if(format.equalsIgnoreCase("small") || format.equalsIgnoreCase("medium") || format.equalsIgnoreCase("large")){
			this.format = format;
			
			if(this.format.equalsIgnoreCase("small")){
				this.pageRows = 10;
				this.pageWidth = 20;
				this.crossLineLength = 2;
				this.crossLineWidth = 4;
				
			}
			else
			if(this.format.equalsIgnoreCase("medium")){
				this.pageRows = 20;
				this.pageWidth = 30;
				this.crossLineLength = 3;
				this.crossLineWidth = 5;
				
			}
			else{
				this.pageRows = 30;
				this.pageWidth = 40;
				this.crossLineLength = 4;
				this.crossLineWidth = 6;
				
			}
		}
		else{
			this.format = "medium";
			this.pageRows = 20;
			this.pageWidth = 30;
			this.crossLineLength = 3;
			this.crossLineWidth = 5;
			
		}
		
		this.maxWordWidth = pageWidth - crossLineWidth - 1;
		this.lines = new StringBuilder[pageRows - crossLineLength - 2];
		this.maxSymbolsInPage = (this.lines.length * this.maxWordWidth);
	}
	
	
	
	public String getHeader() {
		return header;
	}



	public int getNumber() {
		return number;
	}



	public String getFormat() {
		return format;
	}

	


	public int getMaxWordWidth() {
		return this.maxWordWidth;
	}



	public void deleteHeader(){
		this.header = "";
	}
	
	
	
	public void addHeader(String header){
		if(header != null){
			this.header = header;
		}
	}
	
	
	
	public void addText(String text){
		if(text != null){
			this.text = this.text.concat(text);
			if(this.text.length() > this.maxSymbolsInPage){
				this.text = this.text.substring(0, this.maxSymbolsInPage);
			}
		}
	}
	
	
	
	public void deleteText(){
		this.text = "";
	}
	
	public boolean searchWord(String word){
		StringBuilder tempStrBuilder = new StringBuilder(this.maxSymbolsInPage);
		
		for(int i = 0; i < this.text.length(); i++){
			char c = this.text.charAt(i);
			
			if(isLetter(c)){
				tempStrBuilder.append(c);
			}
			else{
				tempStrBuilder.append(" ");
			}
		}
		
		String tempString = new String(tempStrBuilder);
		String[] pureWords = tempString.split(" ");
		
		
		for(int i = 0; i < pureWords.length; i++){
			if(word.equalsIgnoreCase(pureWords[i])){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isLetter(char c){ 
		return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');
	}
	
	public boolean containsDigits(){
		for(int i = 0; i < this.text.length(); i++){
			char c = this.text.charAt(i);
			if(c >= '0' && c <= '9'){
				return true;
			}
		}
		return false;
	}
	
	private void makeNotepadable(){
		
		for(int i = 0; i < this.lines.length; i++){
			if(this.text.length() < this.maxWordWidth){
				StringBuilder strBuilder = new StringBuilder(this.text);
				this.lines[i] = strBuilder;
				break;
			}
			
			StringBuilder strBuilder = new StringBuilder(this.text.substring(0, this.maxWordWidth));
			
			char c = strBuilder.charAt(strBuilder.length()-1);
			
			if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ){
				for(int j = this.maxWordWidth-2; j >= 0; j--){
					if(strBuilder.charAt(j) == ' '){
						strBuilder = new StringBuilder(text.substring(0, j));
						this.text = this.text.substring(j+1, text.length());
						break;
					}
				}
				
				
			}
			else{
				this.text = this.text.substring(this.maxWordWidth, this.text.length());
			}
			this.lines[i] = strBuilder;
		}
	}
	
	
	
	public void printPage(){
		this.makeNotepadable();
		int idxToPrint = 0;
		
		for(int i = 0; i < this.lines.length; i++){
			if(this.lines[i] == null){
				break;
			}

			for(int j = this.lines[i].length(); j < this.pageWidth - this.crossLineWidth - 1; j++){
				this.lines[i].append(" ");
			}
		}
		
		

		for(int i = 0; i < this.pageRows; i++){			
			
			if(i == 0 || i == this.pageRows-1){
				if(i == 0){
					System.out.print("┌");
				}
				else{
					System.out.print("└");
				}
				
				
				for(int j = 0; j < this.pageWidth; j++){
					if(j == this.crossLineWidth && i == 0){
						System.out.print("╥");
					}
					else
					if(j == this.crossLineWidth && i == this.pageRows-1){
						System.out.print("╨");
					}
					else{
						System.out.print("─");
					}
				}
				
				
				if(i == 0){
					System.out.print("┐");
				}
				else{
					System.out.print("┘");
				}
			}
			
			else 
			if(i == this.crossLineLength){
				System.out.print("╞");
				
				for(int j = 0; j < this.pageWidth; j++){
					if(j == this.crossLineWidth){
						System.out.print("╬");
					}
					else{
						System.out.print('\u2550');
					}
				}
				
				System.out.print("╡");
			}
				
			
				
			else
			if(i < this.crossLineLength){
				System.out.print("│");
				
				for(int j = 0; j < this.pageWidth; j++){
					if(i == this.crossLineLength - 1 && j == this.crossLineWidth / (getNumDigits(this.number)) / 2){
						System.out.print(this.number);
						j += (getNumDigits(this.number) - 1);
					}
					else
					if(i == this.crossLineLength - 1 && j == (this.pageWidth + this.crossLineWidth + 1) / 2 - this.header.length() / 2 - 1){
						System.out.print(this.header);
						j += (this.header.length() - 1);
					}
					else
					if(j == this.crossLineWidth){
						System.out.print("║");
					}
					else{
						System.out.print(" ");
					}
				}
				
				System.out.print("│");
			}
				
			else{
				System.out.print("│");
				
				for(int j = 0; j < this.crossLineWidth; j++){
					System.out.print(" ");
				}
				
				System.out.print("║");
				
				if(this.lines[idxToPrint] != null && idxToPrint < this.lines.length){
					System.out.print(this.lines[idxToPrint++]);
				}
				else{
					for(int j = 0; j < this.pageWidth - this.crossLineWidth - 1; j++){
						System.out.print(" ");
					}
				}
				
				System.out.print("│");
			}
			
			System.out.println();
		}
	}

	private int getNumDigits(int number){
		int result = 0;
		while(number > 0){
			result++;
			number /= 10;
		}
		
		return result;
	}




	
}


