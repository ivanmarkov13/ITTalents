package demo;

import bookStore.ElectronicSecuredNotepad;
import bookStore.SecuredNotepad;
import bookStore.SimpleNotepad;

public class DemoBookStore {
	public static void main(String[] args) {
		ElectronicSecuredNotepad notepad = new ElectronicSecuredNotepad(20, "medium", "Password1234");
		notepad.start();
		notepad.changePassword("Password1234");
		
		notepad.addHeader(5, "Kartofi na furna");
		notepad.addText(5, "5-Narejete kartofite. Izmiite gi. Postavete kartofite v tava. Slojete podpravki spored vkusa vi, dobavete maslo. Pechete na silnozagrqta furna");
	
		System.out.println(notepad.searchWord("kartofite"));
		notepad.printAllPagesWithDigits();
		
		System.out.println("The notepad look like this:");
		notepad.printNotepad();
	}
}
