package application;

import java.util.Date;
import java.util.Vector;

public class Bill {

	private String ID;
	private Vector<Goods> ProductsPurchased;
	private Date Date;
	private Vendor Vendor;
	private int TotalCost;

	public Bill(String ID, Vector<Goods> ProductsPurchased, Date Date, Vendor Vendor, int TotalCost) {
		this.ID = ID;
		this.ProductsPurchased = ProductsPurchased;
		this.Date = Date;
		this.Vendor = Vendor;
		this.TotalCost = TotalCost;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Vector<Goods> getProductsPurchased() {
		return ProductsPurchased;
	}

	public void setProductsPurchased(Vector<Goods> productsPurchased) {
		ProductsPurchased = productsPurchased;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Vendor getVendor() {
		return Vendor;
	}

	public void setVendor(Vendor vendor) {
		Vendor = vendor;
	}

	public int getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}

}
