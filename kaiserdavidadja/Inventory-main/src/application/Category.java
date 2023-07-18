package application;

public class Category {

	private String ID;
	private String Name;

	public Category(String ID, String Name) {
		this.ID = ID;
		this.Name = Name;
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

}
