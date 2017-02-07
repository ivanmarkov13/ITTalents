package treaders;

import java.text.DecimalFormat;
import java.util.Random;

import dealers.Dealer;
import products.Product;
import tradingObjects.ShopChainOwnable;


public class ShopChain extends Trader {
	private Dealer[] dealers;
	private int dealersSize;
	private ShopChainOwnable[] shops;
	private int shopsSize;
	
	public ShopChain(String name, String address, double money) {
		super(name, address, money);
		this.dealers = new Dealer[15];
		this.dealersSize = 0;
		this.shops = new ShopChainOwnable[10];
		this.shopsSize = 0;
	}
	
	public void addDealer(Dealer d){
		if(d != null){
			this.dealers[this.dealersSize++] = d;
		}
	}
	
	public void addShop(ShopChainOwnable s){
		if(s != null){
			this.shops[this.shopsSize++] = s;
		}
	}
	
	boolean isThisMyDealer(Dealer d){
		for(int i = 0; i < this.dealers.length; i++){
			if(this.dealers[i] == null){
				break;
			}
			
			if(this.dealers[i] == d){
				return true;
			}
		}
		return false;
	}
	
	boolean isThisShopMine(ShopChainOwnable s){
		for(int i = 0; i < this.shops.length; i++){
			if(this.shops[i] == null){
				break;
			}
			
			if(this.shops[i] == s){
				return true;
			}
		}
		return false;
	}
	
	
	public void makeOrder(double money, Dealer d, ShopChainOwnable s){
		if(money > this.money / 2 || money <= 0){
			System.out.println("Invalid money! Money must be a positive number and not more than half the money of the trader!");
			return;
		}
		
		if(!isThisMyDealer(d)){
			System.out.println("This dealer doesn't work with " + this.name + "!");
			return;
		}
		
		if(!isThisShopMine(s)){
			System.out.println("This shop doesn't belong to " + this.name + "!");
			return;
		}
		
		
		
		double cartPrice = 0;
		while(cartPrice <= money){
			double productPrice = new Random().nextInt(15 - 5 + 1) + 5;
			
			if(cartPrice + productPrice <= money){
				cartPrice += productPrice;
				s.addProduct(new Product(allProducts[allProductsIdx++], productPrice));
				if(allProductsIdx == allProducts.length){
					allProductsIdx = 0;
				}
			}
			else{
				double discount = cartPrice * d.makeDiscount();
				cartPrice -= discount;
				this.money -= cartPrice;
				System.out.println(this.name + " orders from " + d.getName() + " for shop " + s.getAddress() + " for " + cartPrice + " lv.");
				s.bubbleSortProducts();
				return;
			}
		}
		
		
		
	}

	@Override
	public void takeProfit(){
		for(int i = 0; i < this.shopsSize; i++){
			
			
			
			int soldProducts = new Random().nextInt(this.shops[i].getSizeOfProducts()+1);
			
			for(int j = 0; j < soldProducts; j++){
				int idx = new Random().nextInt(this.shops[i].getSizeOfProducts());
				this.profit += ((double)this.shops[i].getProduct(idx).getPrice() * 1.3);
				this.money += ((double)this.shops[i].getProduct(idx).getPrice() * 1.3);
				
				this.shops[i].removeProduct(idx);
			}
			
			DecimalFormat df = new DecimalFormat("0.00");
			System.out.println(this.name + " sells " + soldProducts +  " products for " + df.format(this.profit) + " at " + this.shops[i].getAddress());
			System.out.println("Money earned: " + df.format((this.profit - ((double)this.profit / 1.3))));
			this.profit = 0;
			
		}
	}

	@Override
	public void payTaxes() {
		for(int i = 0; i < this.shops.length; i++){
			this.money -= this.shops[i].getTaxes();
			
			if(this.money < 0){
				System.out.println(this.name + " doesn't have money to pay the taxes!" + this.name + " has just bancrupted.");
				return;
			}
		}
	}

	public int getDealersSize() {
		return this.dealersSize;
	}

	public int getShopsSize() {
		return shopsSize;
	}
	
	
	
	public Dealer[] getDealers() {
		return dealers;
	}

	
	
	public ShopChainOwnable[] getShops() {
		return shops;
	}

	@Override
	public String toString() {
		super.showInfo();
		
		System.out.println("Dealers:");
		if(this.dealers[0] == null){
			System.out.println("   no dealers work with " + this.name + " at this moment.");
			return"";
		}
		
		for(int i = 0; i < this.dealersSize; i++){
			System.out.println(this.dealers[i]);;
		}
		
		System.out.println("Trading shops:");
		if(this.shops[0] == null){
			System.out.println("  " + this.name + " doesn't have any trading shops at this moment");
			return"";
		}
		for(int i = 0; i < this.shopsSize; i++){
			this.shops[i].showInfo();
		}
		
		return"";
				
	}
	
}
