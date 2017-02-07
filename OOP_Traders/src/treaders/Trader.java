package treaders;

import java.text.DecimalFormat;

public abstract class Trader {
	static String[] allProducts = {"kaisii","domati","kluchodurjatel","topka","buhalka","zapalka","guma","parfum","toaletna hartiq","chetka za zubi","telefon","magnitche","klaviatura","laptop"};
	static int allProductsIdx = 0;
	
	
	protected String name;
	protected String address;
	protected double money;
	protected double profit;
	
	public Trader(String name, String address, double money) {
		
		if(name != null && !name.isEmpty()){this.name = name;
		
		}
		else{
			System.out.println("Invalid name!");
		}
		
		if(address != null && !address.isEmpty()){
			this.address = address;
		}
		else{
			System.out.println("Invalid address!");
		}
		
		if(money > 0){
			this.money = money;
		}
		else{
			System.out.println("Invalid money!");
		}
		
		this.profit = 0;
	}
	
	public abstract void takeProfit();
	public abstract void payTaxes();
	
	
	public void showInfo(){
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("Name: " + this.name);
		System.out.println("Address: " + this.address);
		System.out.println("Money: " + df.format(this.money));
	}

	public double getProfit() {
		return profit;
	}

	public String getName() {
		return name;
	}
	
	
	
	
	
	
	
}
