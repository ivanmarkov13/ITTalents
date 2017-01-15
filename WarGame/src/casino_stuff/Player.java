package casino_stuff;

import java.util.Random;
import java.util.Scanner;

public class Player {
	private String name;
	private CardDeck playerDeck;
	private CardDeck takenCards;
	private int points;
	boolean accept;
	
 	public Player(String name){
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		this.playerDeck = new CardDeck(26, false);
 		this.takenCards = new CardDeck(52, false);
 		this.points = 0;
	}
 	
 	public void setName(String name){
 		if(name != null && !name.isEmpty()){
 			this.name = name;
 		}
 	}
	
	public String getName(){
		return name;
	}
	
	public int getPoints(){
		return points;
	}
	
	public boolean getAccept(){
		return this.accept;
	}
	
	public void printPlayerDeck(){
		this.playerDeck.printCards();
	}
	
	public void printTakenCards(){
		this.takenCards.printCards();
	}
	
 	public void razdai(CardDeck deck, Player player2){
		if(player2 != null){
			for(int i = 0; i < deck.cards.length; i++){
				if(i % 2 == 0){
					this.playerDeck.putCard(deck.cards[i]);
				}
				else{
					player2.playerDeck.putCard(deck.cards[i]);
				}
			}
		}
	}
	
	
	int compare(char c1, char c2){
		if(c1 >= '2' && c1 <= '9' && c2 >= '2' && c2 <= '9'){
			if(c1 > c2){
				return 1;
			}
			return -1;
		}
		if(c1 > '9' && c2 <= '9'){
			return 1;
		}
		if(c1 <= '9' && c2 > '9'){
			return -1;
		}
		if(c1 == 'J'){
			c1 = 'S';
		}
		if(c2 == 'J'){
			c2 = 'S';
		}
		if(c1 < c2){
			return 1;
		}
		return -1;
	}
	
	private Scanner sc = new Scanner(System.in);
	
	public void challenge(Player player2){
		this.accept = true;
		System.out.println(player2.name +  ", do you want to play?");
		String answer = sc.next();
		player2.accept = answer.equalsIgnoreCase("yes");
		
		if(player2.accept){
			for(int i = 0; i < this.playerDeck.cards.length; i++){
				char c1 = this.playerDeck.playCard();
				char c2 = player2.playerDeck.playCard();
				if(c1 == 'e'){
					break;
				}
				System.out.print(c1 + " - " + c2);
				
				if(c1 != c2){
					if(compare(c1, c2) == 1){
						System.out.println("  " + this.name);
						this.takenCards.putCard(c1);
						this.takenCards.putCard(c2);
					
						this.points++;
					}
					else{
						System.out.println("  " + player2.name);
						player2.takenCards.putCard(c1);
						player2.takenCards.putCard(c2);
					
						player2.points++;
					}
				}
				else{
					int tempPoints = 1;
					char[] tempTakenCards = new char[52];
					int idx = 0;
					tempTakenCards[idx] = c1;
					idx++;
					tempTakenCards[idx] = c2;
					idx++;
					
					System.out.println();
					System.out.println("War!");
					for(int j = 0; j < 2; j++){
						c1 = this.playerDeck.playCard();
						c2 = player2.playerDeck.playCard();	
						if(c1 != 'e'){
							System.out.println(c1 + " - " + c2);
						
							tempPoints++;
							tempTakenCards[idx] = c1;
							idx++;
							tempTakenCards[idx] = c2;
							idx++;
						}
						
					}
					do{
						c1 = this.playerDeck.playCard();
						c2 = player2.playerDeck.playCard();
						if(c1 != 'e'){
							System.out.println(c1 + " - " + c2);
						
							tempPoints++;
							tempTakenCards[idx] = c1;
							idx++;
							tempTakenCards[idx] = c2;
							idx++;
						}
					}while(c1 == c2 && c1 != 'e');
					
					if(c1 == 'e'){
						return;
					}
					
					if(compare(c1, c2) == 1){
						System.out.println(this.name + " wins this war");
						
						for(int j = 0; j < idx; j++){
							this.takenCards.putCard(tempTakenCards[j]);
						}

						this.points += tempPoints;
					}
					else{
						System.out.println(player2.name + " wins this war");
						
						for(int j = 0; j < idx; j++){
							player2.takenCards.putCard(tempTakenCards[j]);
						}
						
						player2.points += tempPoints;
					}
				}
			}
		}
		else{
			System.out.println("Not at the moment, " + this.name + ", some other time...");
		}
	}
}
