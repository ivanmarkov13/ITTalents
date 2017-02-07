package products;

public class Product {

	private String name;
	private double price;
	
	
	public Product(String name, double price) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		else{
			System.out.println("Invalid name!");
		}
		
		if(price >=5 && price <= 15){
			this.price = price;
		}
		else{
			System.out.println("Invalid price!");
		}
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}
	
	
	
	@Override
	public String toString() {
		System.out.println("     name: " + this.name + "," + " price(dealer price): " + this.price + " lv.");
		return "";
	}
	
}
