package bookStore;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IЕlectronicDevice{
	private boolean isTurnedOn;
	
	public ElectronicSecuredNotepad(int numPages, String format, String password) {
		super(numPages, format, password);
		this.isTurnedOn = false;
	}

	@Override
	public void start() {
		this.isTurnedOn = true;
	}

	@Override
	public void stop() {
		this.isTurnedOn = false;
		
	}

	@Override
	public boolean isStarted() {
		
		return this.isTurnedOn;
	}

	@Override
	public String getPassword() {
		
		if(this.isTurnedOn){
			return super.getPassword();
		}
		else{
			return "Device is not turned on.";
		}
	}

	@Override
	public void changePassword(String newPassword) {
		if(this.isTurnedOn){
			super.changePassword(newPassword);
		}
		else{
			System.out.println("Device is not turned on. Password is not changed.");
		}
	}

	@Override
	public int getNumPages() {
		if(this.isTurnedOn){
			return super.getNumPages();
		}
		else{
			System.out.println("Device is not turned on. Error: ");
			return -1;
		}
	}

	@Override
	public String getFormat() {
		if(this.isTurnedOn){
			return super.getFormat();
		}
		else{
			return "Device is not turned on.";
		}
	}

	@Override
	public void addText(int numPage, String newText) {
		if(this.isTurnedOn){
			super.addText(numPage, newText);
		}
		else{
			System.out.println("Device is not turned on");
		}
	}

	@Override
	public void deleteAndInsertText(int numPage, String newText) {
		if(this.isTurnedOn){
			super.deleteAndInsertText(numPage, newText);
		}
		else{
			System.out.println("Device is not turned on.");
		}
	}

	@Override
	public void deleteText(int numPage) {
		if(this.isTurnedOn){
			super.deleteText(numPage);
		}
		else{
			System.out.println("Device is not turned on.");
		}
	}

	@Override
	public void addHeader(int pageNum, String header) {
		if(this.isTurnedOn){
			super.addHeader(pageNum, header);
		}
		else{
			System.out.println("Device is not turned on.");
		}
	}

	@Override
	public void deleteHeader(int pageNum) {
		if(this.isTurnedOn){
			super.deleteHeader(pageNum);
		}
		else{
			System.out.println("Device is not turned on.");
		}
	}

	@Override
	public void printNotepad() {
		if(this.isTurnedOn){
			super.printNotepad();
		}
		else{
			System.out.println("Device is not turned on.");
		}
	}

	@Override
	public boolean searchWord(String word) {
		if(this.isTurnedOn){
			return super.searchWord(word);
		}
		else{
			System.out.println("Device is not turned on.");
			return false;
		}
	}

	@Override
	public void printAllPagesWithDigits() {
		if(this.isTurnedOn){
			super.printAllPagesWithDigits();
		}
		else{
			System.out.println("Device is not turned on.");
		}
	}

	
	
}
