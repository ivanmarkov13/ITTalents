package tradingObjects;

import products.Product;

public class MallShop extends TO implements ShopChainOwnable{
	
	
	public MallShop(String address, String time, int area) {
		super(address, time, area);
		
		this.taxes = 150;
		
		validateArea(area);
		
		this.products = new Product[100];
		this.productsSize = 0;
	}

	@Override
	protected void validateArea(int area) {
		if(area >= 10 && area <= 100){
			this.area = area;
		}
		else{
			System.out.println("Invalid area!");
		}
		
	}

	
	
}
