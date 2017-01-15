package casino_royale;

import casino_stuff.CardDeck;
import casino_stuff.Player;

public class CasinoRoyaleDemo {

	public static void main(String[] args) {
		Player player1 = new Player("Jack");
		Player player2 = new Player("Daniel");
		
		
		CardDeck deck = new CardDeck(52, true);
		deck.shuffleDeck();
		player1.razdai(deck, player2);
		
		player1.challenge(player2);
		
		System.out.println();
		
		if(player1.getAccept() && player2.getAccept()){
			int num1 = player1.getPoints();
			int num2 = player2.getPoints();
			
			System.out.println(player1.getName() + " points: " + player1.getPoints());
			System.out.println(player2.getName() + " points: " + player2.getPoints());
			if(num1 > num2){
				System.out.println(player1.getName() + " wins!");
			}
			else
			if(num2 > num1){
				System.out.println(player2.getName() + " wins!");
			}
			else{
				System.out.println("Draw game!");
			}
			
			System.out.println(player1.getName() + " taken cards:");
			player1.printTakenCards();
			System.out.println(player2.getName() + " taken cards:");
			player2.printTakenCards();
			
		}		
	}

}
