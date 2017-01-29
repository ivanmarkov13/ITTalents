package bookStore;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad{
	private String password = "Defaultpass1234";
	private final String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
	
	public SecuredNotepad(int numPages, String format, String password){
		super(numPages, format);
		
		changePassword(password);
	}

	public String getPassword() {
		if(this.password != null){
			return password;
		}
		else{
			return "This notepad doesn't have a password yet.";
		}
	
	}
	
	public void changePassword(String newPassword){
		if(newPassword.matches(this.passRegex)){
			if(this.password.equals("Defaultpass1234")){
				this.password = newPassword;
				System.out.println("Password is changed.");
				return;
			}
			Scanner sc = new Scanner(System.in);
			
			String str;
			
			System.out.println("Enter the old password:");
			str = sc.next();
			
			if(str.equals(this.password)){
				this.password = newPassword;
				System.out.println("Password changed!");
			}
			else{
				System.out.println("Incorrect password!");
			}
			
		}
		else{
			System.out.println("Each secured notepad password must contain at least one uppercase letter,");
			System.out.println("one lowercase letter, one digit at at least 5 symbols!");
		}
	}

	
	private boolean validatePass(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password:");
		String str = sc.next();
		
		return str.equals(this.password);
	}
	
	
	
	@Override
	public int getNumPages(){
		if(validatePass()){
			return super.getNumPages();
		}
		else{
			System.out.print("Invalid password! Error: ");
			return -1;
		}
	}
	
	
	

	@Override
	public String getFormat() {
		if(validatePass()){
			return super.getFormat();
		}
		else{
			return "Incorrect password!";
		}
	}
	
	
	

	@Override
	public void addText(int numPage, String newText) {
		if(validatePass()){
			super.addText(numPage, newText);
		}
		else{
			System.out.println("Incorrect password!");
		}
	}
	
	
	

	@Override
	public void deleteAndInsertText(int numPage, String newText) {
		if(validatePass()){
			super.deleteAndInsertText(numPage, newText);
		}
		else{
			System.out.println("Incorrect password!");
		}
	}
	
	
	

	@Override
	public void deleteText(int numPage) {
		if(validatePass()){
			super.deleteText(numPage);
		}
		else{
			System.out.println("Incorrect password");
		}
	}
	
	
	

	@Override
	public void addHeader(int pageNum, String header) {
		if(validatePass()){
			super.addHeader(pageNum, header);
		}
		else{
			System.out.println("Incorrect password!");
		}
	}
	
	
	

	@Override
	public void deleteHeader(int pageNum) {
		if(validatePass()){
			super.deleteHeader(pageNum);
		}
		else{
			System.out.println("Incorrect password!");
		}
	}
	
	
	

	@Override
	public void printNotepad() {
		if(validatePass()){
			super.printNotepad();
		}
		else{
			System.out.println("Incorrect password!");
		}
	}

	@Override
	public boolean searchWord(String word) {
		
		if(validatePass()){
			return super.searchWord(word);
		}
		else{
			System.out.println("Incorrect password!");
			return false;
		}
	}

	@Override
	public void printAllPagesWithDigits() {
		if(validatePass()){
			super.printAllPagesWithDigits();
		}
		else{
			System.out.println("Incorrect password!");
		}
	}

	
	
	
	
	
	
	
	
	
	
}
