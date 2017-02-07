import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.border.EtchedBorder;

import dealers.BigDealer;
import dealers.Dealer;
import dealers.SmallDealer;
import tradingObjects.Budka;
import tradingObjects.ETOwnable;
import tradingObjects.MallShop;
import tradingObjects.Sergiq;
import tradingObjects.ShopChainOwnable;
import tradingObjects.TO;
import treaders.Ambulant;
import treaders.ET;
import treaders.ShopChain;

public class DemoDealers {
	
	static String[] names1 = {"Petur","Georgi","Viktor","Sasho","Mitko","Vladi","Ceci", "Spas"};
	static String[] names2 = {" Georgiev"," Aleksandrov"," Petrov"," Atanasov"," Mitkov"," Stoev"," Markov"," Andreev"," Spasimirov"," Docev"};
	
	static String[] numbers = {"12","125","52","36","78","45","33","21","18","11","12","55","101","207"};
	static String[] streets = {" Cooper"," Julian"," Vincent"," Canal"," Vitoshka"," Car Samuil"," Petur Beron"," Pirotska"," Glavnata"," Colins"};
	
	
	public static void main(String[] args) {
		
		System.out.println("Hello Ubuntu");
		
		
		Dealer[] dealers = new Dealer[10];
		int dealersSize = 0;
		for(int i = 0; i < dealers.length; i++){
			String name1 = names1[new Random().nextInt(names1.length)];
			String name2 = names2[new Random().nextInt(names2.length)];
			
			String number = numbers[new Random().nextInt(numbers.length)];
			String street = streets[new Random().nextInt(streets.length)];
			
			if(new Random().nextBoolean()){
				dealers[i] = new SmallDealer(name1 + name2, number + street + " street" , "5-15");
			}
			else{
				dealers[i] = new BigDealer(name1 + name2, number + street + " street" , "5-15");
			}
			
			dealersSize++;
		}
		
		TO[] tradingObjs = new TO[20];
		int tradinfObjsSize = 0;
		for(int i = 0; i < tradingObjs.length; i++){
			String number = numbers[new Random().nextInt(numbers.length)];
			String street = streets[new Random().nextInt(streets.length)];
			
			int area = 0;
			
			switch (new Random().nextInt(3)) {
			
			case 0:
				area = new Random().nextInt(6 - 4 + 1) + 4;
				tradingObjs[i] = new Budka(number + street + " street", "8-10", area);
				break;
			case 1:
				area = new Random().nextInt(100 - 10 + 1) + 10;
				tradingObjs[i] = new MallShop(number + street + " street", "8-10", area);
				break;

			case 2:
				area = new Random().nextInt(10 - 2 + 1) + 2;
				tradingObjs[i] = new Sergiq(number + street + " street", "8-10", area);
				break;
			}
			
			tradinfObjsSize++;
		}
		
		 
		 Ambulant tomMerilin = new Ambulant("Tom Merilin", "252 Two Rivers Street", 100);
		 
		 ET mit29 = new ET("MIT 29", "56 Georgi Benkovski Street", 500);
		 
		 ShopChain jumbo = new ShopChain("Jumbo OOD", "51 Bulgaria Blvd.", 3000);
		 
		 for(int i = 0; i < dealersSize; i++){
			 if(dealers[i] instanceof SmallDealer){
				 tomMerilin.setDealer((SmallDealer) dealers[i]);
				 removeObj(dealers, i, dealersSize);
				 dealersSize--;
				 break;
			 }
		 }
		 
		 int numDealersForMit29 = 0; // slagame 3 dilura na mit29
	
		 for(int i = 0; i < dealersSize && numDealersForMit29 < 2; i++){
			 if(dealers[i] instanceof SmallDealer){
				 mit29.addDealer((SmallDealer) dealers[i]);
				 removeObj(dealers, i, dealersSize);
				 dealersSize--;
				 numDealersForMit29++;
				 i--;
			 }
		 }
	 
		 
		 int numDealersForJumbo = 0;
		 while(numDealersForJumbo < 6){ // slagame 6 dilura za jumbo
			 jumbo.addDealer(dealers[dealersSize - 1]);
			 removeObj(dealers, dealersSize-1, dealersSize);
			 dealersSize--;
			 numDealersForJumbo++;
		 }

		 
		 
		 for(int i = 0; i < tradinfObjsSize; i++){
			 if(tradingObjs[i] instanceof ETOwnable){
				 mit29.setShop((ETOwnable) tradingObjs[i]);
				 removeObj(tradingObjs, i, tradinfObjsSize);
				 tradinfObjsSize--;
			 }
		 }
		 
		 int numShopsForJumbo = 0;
		 
		 for(int i = 0; i < tradinfObjsSize && numShopsForJumbo < 10; i++){
			 if(tradingObjs[i] instanceof ShopChainOwnable){
				 jumbo.addShop((ShopChainOwnable) tradingObjs[i]);
				 removeObj(tradingObjs, i, tradinfObjsSize);
				 tradinfObjsSize--;
				 numShopsForJumbo++;
				 i--;
			 }
		 }
		 
		 //*****************************************
		 System.out.println(tomMerilin.getName() + " at the begining:");
		 System.out.println(tomMerilin);
		 
		 tomMerilin.makeOrder(50, tomMerilin.getDealer());
		 System.out.println(tomMerilin.getName() + " after the order:");
		 System.out.println(tomMerilin);
		 
		 tomMerilin.takeProfit();
		 tomMerilin.payTaxes();
		 System.out.println(tomMerilin.getName() + " after selling products and paying taxes:");
		 System.out.println(tomMerilin);
		 
		 
		 //*****************************************
		 System.out.println();
		 
		 System.out.println(mit29.getName() + " at the begining:");
		 System.out.println(mit29);
		 
		 mit29.makeOrder(210, mit29.getDealers()[new Random().nextInt(mit29.getDealersSize())]);
		 System.out.println(mit29.getName() + " after the order:");
		 System.out.println(mit29);
		 
		 mit29.takeProfit();
		 mit29.payTaxes();
		 System.out.println(mit29.getName() + " after selling products and paying taxes:");
		 System.out.println(mit29);
		 //*****************************************
		 
		 System.out.println();
		 
		 System.out.println(jumbo.getName() + " at the begining:");
		 System.out.println(jumbo);
		 
		 
		 for(int i = 0; i < numShopsForJumbo; i++){
			 int randDealerIdx = new Random().nextInt(jumbo.getDealersSize());
			 
			 jumbo.makeOrder(250, jumbo.getDealers()[randDealerIdx], jumbo.getShops()[i]);
		 }
		 System.out.println(jumbo.getName() + " after the order:");
		 System.out.println(jumbo);
		 
		 jumbo.takeProfit();
		 jumbo.payTaxes();
		 System.out.println(jumbo + " after selling products and paying taxes:");
		 System.out.println(jumbo);
		//*****************************************
		 
		 
		 
	}
	
	public static void removeObj(Object[] objs, int idx, int ibjsSize){
		if(idx == ibjsSize - 1){
			objs[idx] = null;
			return;
		}
		
		for(int i = idx; i < ibjsSize - 1; i++){
			objs[i] = objs[i+1];
		}
		
		objs[ibjsSize - 1] = null;
	}
}
