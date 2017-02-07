package tradingObjects;

import products.Product;

public class Budka extends TO implements ETOwnable, ShopChainOwnable{
	
	public Budka(String address, String time, int area) {
		super(address, time, area);
		
		this.taxes = 50;
		
		this.products = new Product[25];
		this.productsSize = 0;
	}

	@Override
	protected void validateArea(int area) {
		if(area >= 4 && area <= 6){
			this.area = area;
		}
		else{
			System.out.println("Invalid area!");
		}
		
	}

	

	
	
}
