package inventory.models;

public class Customer {
	
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerPhone;
	
	// default constructor
	public Customer() {
		
	}
	
	/**
	 * constructor with attributes
	 */
	public Customer(int customerId, String customerFirstName, String customerLastName, String customerPhone) {
		try {
			if (customerId >= 0) {
				this.customerId = customerId;
				this.customerFirstName = customerFirstName;
				this.customerLastName = customerLastName;
				this.customerPhone = customerPhone;
			}
			else {
				throw new ArithmeticException("Failed to create new instance of Customer. customerId is a negative value.");
			}
		}catch (ArithmeticException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * constructor with no customerId
	 */
	public Customer(String customerFirstName, String customerLastName, String customerPhone) {
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerPhone = customerPhone;
	}
	
	public int GetCustomerId() {
		return this.customerId;
	}
	
	public String GetCustomerFirstName() {
		return this.customerFirstName;
	}
	
	public String GetCustomerLastName() {
		return this.customerLastName;
	}

	public String GetCustomerFullName() {
		return this.customerFirstName + " " + this.customerLastName;
	}
	
	public String GetCustomerPhone() {
		return this.customerPhone;
	}
	
	
	public void SetCustomerId(int newId) {
		this.customerId = newId;
	}
	
	public void SetCustomerFirstName(String newFirstName) {
		this.customerFirstName = newFirstName;
	}
	
	public void SetCustomerLastName(String newLastName) {
		this.customerLastName = newLastName;
	}
	
	public void SetCustomerPhone(String newPhone) {
		this.customerPhone = newPhone;
	}
	
	
	@Override
	/**
	 * Get String representation
	 */
	public String toString() {
		return String.format("%-30s %-30s %-30s %-30s", customerId, customerFirstName, customerLastName, customerPhone);
	}
}
