package dealers;

public abstract class Dealer {

	protected String name;
	protected String address;
	protected String time;
	
	
	
	public Dealer(String name, String address, String time) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		
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
		
		
		if(time != null && !time.isEmpty()){
			this.time = time;
		}
		else{
			System.out.println("Invalid time!");
		}
	}

	

	public String getName() {
		return name;
	}



	public String getAddress() {
		return address;
	}
	

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		System.out.println("   Name: " + this.getName());
		System.out.println("   Address: " + this.getAddress());
		System.out.println("   Time: " + this.getTime());
		System.out.println("*******************");
		return"";
	}
	
	

	public abstract double makeDiscount();
}
