package model.entities;

import java.util.Date;

public class HistoricalPrice {

	private float price;
	private Date date;

	public HistoricalPrice(float price, Date date) {
		this.price = price;
		this.date = date;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
