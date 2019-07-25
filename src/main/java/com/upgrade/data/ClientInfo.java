package com.upgrade.data;



public class ClientInfo {

	private String firstname;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String dateofbirth;

	public ClientInfo(String firstName, String lastName, String street, String city, String state,
			String zipcode, String dateofbirth) {
		this.firstname = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.dateofbirth = dateofbirth;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}



		
}
