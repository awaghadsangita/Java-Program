/****************************************************************************************************
 * @purpose	:contains setters and getters for various private variables
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ****************************************************************************************************/
package CliniqueManagementProgramme;

public class Patients {
	private int patientId;
	private String patientName;
	private String mobileNumber;
	private int age;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
