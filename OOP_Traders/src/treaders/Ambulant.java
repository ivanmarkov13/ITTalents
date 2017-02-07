package treaders;

import java.text.DecimalFormat;
import java.util.Random;

import dealers.SmallDealer;
import products.Product;


public class Ambulant extends Trader {
	private SmallDealer dealer;
	private Product[] products;
	private int productsSize;
	
	
	public Ambulant(String name, String address, double money) {
		super(name, address, money);
		
		this.products = new Product[10];
		this.productsSize = 0;
	}

	public void setDealer(SmallDealer dealer){
		if(dealer != null){
			this.dealer = dealer;
		}
	}
	
	
	public void addProduct(Product p) {
		if(p == null){
			return;
		}
		
		this.products[this.productsSize++] = p;
		
		if((double)this.productsSize / this.products.length >= 0.75){
			Product[] products2 = new Product[this.products.length + this.products.length / 2 + 1];
			
			for(int i = 0; i < this.products.length; i++){
				products2[i] = this.products[i];
			}
			
			this.products = products2;
		}
		
	}

	public void removeProduct(int idx){
		if(idx == this.productsSize - 1){
			this.products[idx] = null;
			this.productsSize--;
			return;
		}
		
		for(int i = idx; i < this.productsSize - 1; i++){
			
			this.products[i] = this.products[i+1];
		}
		
		this.products[this.productsSize - 1] = null;
		this.productsSize--;
	}
	
	boolean isThisMyDealer(SmallDealer d){
		return this.dealer == d;
	}
	
	public void bubbleSortProducts(){
		
		for(int j = 0; j < this.productsSize; j++){
			for(int i = 0; i < this.productsSize - 1; i++){
				if(this.products[i].getPrice() > this.products[i+1].getPrice()){
					Product temp = products[i];
					products[i] = products[i+1];
					products[i+1] = temp;
				}
			}
		}
	}
	
	public void makeOrder(double money, SmallDealer d){
		if(money > this.money / 2 || money <=0 ){
			System.out.println("Invalid money! Money must be a positive number and not more than half the money of the trader!");
			return;
		}
		
		if(!(d instanceof SmallDealer) || !isThisMyDealer(d)){
			System.out.println("This dealer doesnt't wotk with " + this.name + "!");
			return;
		}
		
		
		
		double cartPrice = 0;
		while(cartPrice <= money){
			double productPrice = new Random().nextInt(15 - 5 + 1) + 5;
			
			if(cartPrice + productPrice <= money){
				cartPrice += productPrice;
				this.addProduct(new Product(allProducts[allProductsIdx++], productPrice));
				if(allProductsIdx == allProducts.length){
					allProductsIdx = 0;
				}
				
				
			}
			else{
				double discount = cartPrice * d.makeDiscount();
				cartPrice -= discount;
				this.money -= cartPrice;
				System.out.println(this.name + " orders from " + this.dealer.getName() + " for " + cartPrice + " lv.");
				this.bubbleSortProducts();
				return;
			}
		}
		
		
	}
	
	
	public int getSizeOfProducts() {
		return this.productsSize;
	}

	@Override
	public void takeProfit() {
		int soldProducts = new Random().nextInt(this.productsSize+1);
		
		for(int i = 0; i < soldProducts; i++){
			int idx = new Random().nextInt(this.productsSize);
			this.profit += (this.products[idx].getPrice() * 1.3);
			this.money += (this.products[idx].getPrice() * 1.3);
			
			this.removeProduct(idx);
		} 
		
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(this.name + " sells " + soldProducts +  " products for " + df.format(this.profit));
		System.out.println("Money earned: " + df.format((this.profit - ((double)this.profit / 1.3))));
		this.profit = 0;
	}

	@Override
	public void payTaxes() {
		this.money -= 0;
	}

	public SmallDealer getDealer() {
		return dealer;
	}
	
	
	
	@Override
	public String toString() {
		super.showInfo();
		
		System.out.println("Dealer: ");
		if(this.dealer == null){
			System.out.println("   there is no dealer that works with " + this.name + " at this time");
			return "";
		}
		System.out.println(this.dealer);;
		
		System.out.println("Products:");
		if(this.products[0] == null){
			System.out.println("     no products at this time");
			return"";
		}
		for(int i = 0; i < this.productsSize; i++){
			System.out.println(products[i]);;
		}
		return "";
	}
	
	
}
