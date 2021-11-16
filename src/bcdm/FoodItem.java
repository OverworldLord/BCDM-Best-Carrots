package bcdm;

public class FoodItem {

	private String name;
	private HistoricalPrice[] historicalPrice;
	private int id;
	
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
		float currentPrice = 0.0f;
		return currentPrice;
	}
	
}
