package tradingObjects;

import products.Product;

public abstract class TO {
	protected String address;
	protected String time;
	protected int area;
	protected double taxes;
	protected Product[] products;
	protected int productsSize;
	
	
	public TO(String address, String time, int area) {
		if(address != null && !address.isEmpty()){
			this.address = address;
		}
		else{
			System.out.println("Invalid address!");
		}
		
		if(time != null && !time.isEmpty()){
			this.time = time;
		}
		else{
			System.out.println("Invalid time!");
		}
		
		validateArea(area);
	}
	
	protected abstract void validateArea(int area);
	
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
	
	public int getSizeOfProducts() {
		return this.productsSize;
	}

	
	public Product getProduct(int idx) {
		
		return products[idx];
	}

	public double getTaxes() {
		return taxes;
	}
	
	
	public void showInfo(){
		
		System.out.println("   Address: " + this.address);
		System.out.println("   Time: " + this.time);
		System.out.println("   Area: " + this.area);
		System.out.println("   Taxes: " + this.taxes);
		
		System.out.println("   Products: ");
		if(this.products[0] == null){
			System.out.println("     there aro no product in this shop for now");
			return;
		}
		
		for(int i = 0; i < this.productsSize; i++){
			System.out.println(this.products[i]);;
			
		}
		//System.out.println();
		System.out.println("*******************");
	}

	public String getAddress() {
		return address;
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
	
}
