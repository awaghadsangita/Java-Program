/*******************************************************************************************************
 * @purpose	:contains setters and getters for various instance variable
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ********************************************************************************************************/
package com.bridgelab.addressBook;

import java.util.ArrayList;

public class Person {
	private int persionId;
	private String firstName;
	private String lastName;
	private String address;
	private Cities city;
	private ArrayList<String> mobileNumber;

	public int getPersionId() {
		return persionId;
	}

	public void setPersionId(int persionId) {
		this.persionId = persionId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cities getCity() {
		return city;
	}

	public void setCity(Cities city) {
		this.city = city;
	}

	public ArrayList<String> getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(ArrayList<String> mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
