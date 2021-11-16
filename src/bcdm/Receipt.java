package bcdm;

import java.util.List;

public class Receipt {

	private int id;
	private float totalPrice;
	private List<FoodItem> items;
	
	public Receipt(int id, float totalPrice, List<FoodItem> items) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public void setItems(List<FoodItem> items) {
		this.items = items;
	}
	
	public void createReceipt(ShoppingCart cart) {
		// return receipt
	}
}
