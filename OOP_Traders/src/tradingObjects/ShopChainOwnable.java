package tradingObjects;

import products.Product;

public interface ShopChainOwnable {

	public int getSizeOfProducts();
	public Product getProduct(int idx);
	public double getTaxes();
	public void addProduct(Product p);
	public void removeProduct(int idx);
	public String getAddress();
	public void showInfo();
	public void bubbleSortProducts();
	
}
