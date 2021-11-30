package model.entities;

public class FoodItem {

	private String name;
	private HistoricalPrice[] historicalPrice;
	private int id;
	private float currentPrice;
	
	public FoodItem(int id, String name, HistoricalPrice[] historicalPrice) {
		this.id = id;
		this.name = name;
		this.historicalPrice = historicalPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HistoricalPrice[] getHistoricalPrice() {
		return historicalPrice;
	}

	public void setHistoricalPrice(HistoricalPrice[] historicalPrice) {
		this.historicalPrice = historicalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(float price) {
		
		this.currentPrice = price;
		
	}
	
}
