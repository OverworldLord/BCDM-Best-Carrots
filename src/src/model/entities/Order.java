package model.entities;

import java.util.Date;
import java.util.List;

public class Order {

	private Customer user;
	private int id;
	private int status;
	private List<FoodItem> items;
	private Date date;
	
	public Order(Customer user, int id, int status, List<FoodItem> items, Date date) {
		this.id = id;
		this.status = status;
		this.items = items;
		this.user = user;
	}
	public Customer getUser() {
		return user;
	}
	
	public void setUse(Customer user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public void setItems(List<FoodItem> items) {
		this.items = items;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float calculateTotalPrice() {
		//calculate and add the item's price in list
		float totalPrice = 0.0f;

		return totalPrice;
	}
}
