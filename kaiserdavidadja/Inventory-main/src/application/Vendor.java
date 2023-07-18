package application;

import java.util.Vector;

public class Vendor {

	private String ID;
	private String Name;
	private Vector<Goods> ProductsOffered;

	public Vendor(String ID, String Name) {
		this.ID = ID;
		this.Name = Name;
		this.ProductsOffered = new Vector<Goods>();
	}

	public Vector<Goods> getProductsOffered() {
		return ProductsOffered;
	}

	public void setProductsOffered(Vector<Goods> productsOffered) {
		ProductsOffered = productsOffered;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
