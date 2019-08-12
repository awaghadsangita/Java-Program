/*******************************************************************************************************
 * @purpose	:creating setters getters for instance variable
 * @author	:sangita awaghad
 * @since	:12-09-2019
 *******************************************************************************************************/
package com.bridgelab.addressBook;

public class Cities {
	private String cityName;
	private String stateName;
	private String pincode;
	private String zip;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
