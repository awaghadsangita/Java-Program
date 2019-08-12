/****************************************************************************************************
 * @purpose	:contains setters and getters for various private variables
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ****************************************************************************************************/
package CliniqueManagementProgramme;

public class Doctors {
	private int doctorId;
	private String doctorName;
	private String specialization;
	private String availability;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
