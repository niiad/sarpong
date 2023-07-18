package application;

public class Goods {

	private String ID;
	private String Name;
	private Category Category;
	private double BuyingPrice;
	private double SellingPrice;
	private Vendor Vendor;
	private int Quantity;
	private int ShelfLife;

	public Goods() {
		this.Quantity = 1;
	}

	public Goods(String ID) {
		this.ID = ID;
		this.Quantity = 1;
	}

	public Goods(String ID, String Name, Category Category, Vendor Vendor, int Quantity) {
		this.ID = ID;
		this.Name = Name;
		this.Vendor = Vendor;
		this.Quantity = Quantity;
	}

	public Goods(String ID, String Name, Category Category, double BuyingPrice, double SellingPrice, Vendor Vendor,
			int Quantity, int ShelfLife) {
		this.ID = ID;
		this.Name = Name;
		this.Vendor = Vendor;
		this.Quantity = Quantity;
		this.Category = Category;
		this.BuyingPrice = BuyingPrice;
		this.SellingPrice = SellingPrice;
		this.ShelfLife = ShelfLife;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public double getBuyingPrice() {
		return BuyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		BuyingPrice = buyingPrice;
	}

	public double getSellingPrice() {
		return SellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		SellingPrice = sellingPrice;
	}

	public Vendor getVendor() {
		return Vendor;
	}

	public void setVendor(Vendor vendor) {
		Vendor = vendor;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getShelfLife() {
		return ShelfLife;
	}

	public void setShelfLife(int shelfLife) {
		ShelfLife = shelfLife;
	}
}