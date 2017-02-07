package tradingObjects;

import products.Product;

public class Sergiq extends TO implements ETOwnable{
	public Sergiq(String address, String time, int area) {
		super(address, time, area);
		
		this.taxes = 50;
		
		this.products = new Product[10];
		this.productsSize = 0;
	}

	
	@Override
	protected void validateArea(int area) {
		if(area >= 2 && area <= 10){
			this.area = area;
		}
		else{
			System.out.println("Invalid area!");
		}
		
		
	}

	
	
	
	
}
