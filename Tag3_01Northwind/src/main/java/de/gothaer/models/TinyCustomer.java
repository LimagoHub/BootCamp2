package de.gothaer.models;

public class TinyCustomer {
	
	private final String customerID;
	private final String companyName;
	private final String city;
	private final String phone;
	
	public TinyCustomer(final String customerID,final  String companyName,final  String city,final  String phone) {
		super();
		this.customerID = customerID;
		this.companyName = companyName;
		this.city = city;
		this.phone = phone;
	}
	public String getCustomerID() {
		return customerID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getCity() {
		return city;
	}
	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "TinyCustomer [customerID=" + customerID + ", companyName=" + companyName + ", city=" + city + ", phone="
				+ phone + "]";
	}

	
}
