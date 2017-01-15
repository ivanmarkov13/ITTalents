package casino_stuff;

import java.util.ArrayList;
import java.util.Random;

public class CardDeck {
	private int numCards;
	private int maxNumCards;
	private boolean isPlayingDeck;
	char[] cards;
	int nextCard;
	
	public CardDeck(int maxNumCards, boolean isPlayingDeck){
		this.maxNumCards = maxNumCards;
		this.isPlayingDeck = isPlayingDeck;
		this.nextCard = this.maxNumCards - 1;
		
		if(isPlayingDeck && maxNumCards == 52){
			char c;
			cards = new char[52];
			for(int i = 2; i <= 9; i++){
				c = (char)(i + 48);
				for(int j = 1; j <= 4; j++){
					cards[numCards] = c;
					numCards++;
				}
			}
			
			for(int i = 1; i <= 20; i++){
				if(i >= 1 && i <= 4){
					c = 'T';
				}
				else if(i >= 5 && i <= 8){
					c = 'J';
				}
				else if(i >= 9 && i <= 12){
					c = 'Q';
				}
				else if(i >= 13 && i <= 16){
					c = 'K';
				}
				else{
					c = 'A';
				}
				
				cards[numCards] = c;
				numCards++;
			}
		}
		else
		if(maxNumCards > 0){
			this.numCards = 0;
			this.maxNumCards = maxNumCards;
			this.isPlayingDeck = isPlayingDeck;
			this.nextCard = this.maxNumCards - 1;
			cards = new char[maxNumCards];                
		}
	}
	
	public int getNumCards(){
		return numCards;
	}
	
	public int getMaxNumCards(){
		return maxNumCards;
	}
	
	public boolean getIsPlayingDeck(){
		return isPlayingDeck;
	}
	
	
	
	void putCard(char c){
		if(numCards < maxNumCards){
			cards[numCards] = c;
			numCards++;
		}
	}
	
	char playCard(){
		if(nextCard >= 0){
			return cards[nextCard--];
		}
		return 'e';
				
	}
	
	public void shuffleDeck(){
		Random rand = new Random();
		
		for(int i = 0; i < 200; i++){
			int tempIndex1 = rand.nextInt(this.maxNumCards-1);
			int tempIndex2 = rand.nextInt(this.maxNumCards-1);
			
			char temp = cards[tempIndex1];
			cards[tempIndex1] = cards[tempIndex2];
			cards[tempIndex2] = temp;
		}
	}
	
	public void printCards(){
		for(int i = 0; i < this.numCards; i++){
			System.out.print(cards[i]);
			if(i < this.numCards - 1){
				System.out.print(", ");
			}
		}
		System.out.println();
	}


}
