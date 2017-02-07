package dealers;

public class BigDealer extends Dealer{

	public BigDealer(String name, String address, String time) {
		super(name, address, time);
	}

	@Override
	public double makeDiscount() {
		
		return 0.15;
	}

	
}
