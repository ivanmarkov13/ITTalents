package treaders;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

import dealers.SmallDealer;
import products.Product;
import tradingObjects.ETOwnable;

public class ET extends Trader {
	private SmallDealer[] dealers;
	private int dealersSize;
	ETOwnable shop;
	
	public ET(String name, String address, double money) {
		super(name, address, money);
		this.dealers = new SmallDealer[5];
		this.dealersSize = 0;
	}
	
	public void addDealer(SmallDealer d){
		if(d != null){
			this.dealers[this.dealersSize++] = d;
		}
	}
	
	public void setShop(ETOwnable s){
		if(s != null){
			this.shop = s;
		}
	}
	
	boolean isThisMyDealer(SmallDealer d){
		for(int i = 0; i < this.dealersSize; i++){
			
			if(this.dealers[i] == d){
				return true;
			}
		}
		return false;
	}
	
	public void makeOrder(double money, SmallDealer d){
		if(money > this.money / 2 || money <= 0){
			System.out.println("Invalid money! Money must be a positive number and not more than half the money of the trader!");
			return;
		}
		
		if(!(d instanceof SmallDealer) || !isThisMyDealer(d)){
			System.out.println("This dealer doesn't work with " + this.name +  "!");
			return;
		}
		
		
		
		double cartPrice = 0;
		while(cartPrice <= money){
			double productPrice = new Random().nextInt(15 - 5 + 1) + 5;
			
			if(cartPrice + productPrice <= money){
				cartPrice += productPrice;
				this.shop.addProduct(new Product(allProducts[allProductsIdx++], productPrice));
				if(allProductsIdx == allProducts.length){
					allProductsIdx = 0;
				}
			}
			else{
				double discount = cartPrice * d.makeDiscount();
				cartPrice -= discount;
				this.money -= cartPrice;
				System.out.println(this.name + " orders from " + d.getName() + " for shop at " + this.shop.getAddress() + " for " + cartPrice + " lv.");
				this.shop.bubbleSortProducts();
				return;
			}
			
		}
		
		
	}
	
	@Override
	public void takeProfit(){
		int soldProducts = new Random().nextInt(this.shop.getSizeOfProducts()+1) ;
		
		for(int i = 0; i < soldProducts; i++){
			int idx = new Random().nextInt(this.shop.getSizeOfProducts());
			this.profit += ((double)this.shop.getProduct(idx).getPrice() * 1.3);
			this.money += ((double)this.shop.getProduct(idx).getPrice() * 1.3);
			
			this.shop.removeProduct(idx);
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(this.name + " sells " + soldProducts +  " products for " + df.format(this.profit));
		System.out.println("Money earned: " + df.format((this.profit - ((double)this.profit / 1.3))));
		this.profit = 0;
 
	}

	@Override
	public void payTaxes() {
		this.money -= this.shop.getTaxes();
		
		if(this.money < 0){
			System.out.println(this.name + " doesn't have money to pay the taxes! " + this.name + " has just bancrupted");
			
		}
	}
	public int getDealersSize() {
		return this.dealersSize;
	}

	

	public SmallDealer[] getDealers() {
		return dealers;
	}
	
	
	@Override
	public String toString() {
		super.showInfo();
		
		System.out.println("Dealers:");
		if(this.dealers[0] == null){
			System.out.println("   no dealers work with " + this.name + " at this time");
			return "";
		}
		
		for(int i = 0; i < this.dealersSize; i++){
			System.out.println(this.dealers[i]);;
		}
		
		System.out.println("Trading Shop:");
		this.shop.showInfo();
		
		return "";
	}
	
}
