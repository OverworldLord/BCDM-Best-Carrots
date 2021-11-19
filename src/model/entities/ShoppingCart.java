package model.entities;

import java.util.List;

public class ShoppingCart {

	private int id;
	private List<FoodItem> items;
	
	public ShoppingCart(int id, List<FoodItem> items) {
		this.id = id;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public void setItems(List<FoodItem> items) {
		this.items = items;
	}
	
	public void addToCart(FoodItem item) {
		items.add(item);
	}
	
	public void removeFromCart(FoodItem item) {
		items.remove(items.indexOf(item));
	}
	
}
