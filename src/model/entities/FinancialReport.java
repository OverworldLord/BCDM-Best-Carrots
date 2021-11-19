package model.entities;

import java.util.Date;
import java.util.List;

public class FinancialReport {
	
	private int id;
	private Date startDate;
	private Date endDate;
	private List<Order> orders;
	
	public FinancialReport(int id, Date startDate, Date endDate, List<Order> orders) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public String generateReport(Date startDate, Date endDate) {
		//return report
		return " ";
	}
	
}
