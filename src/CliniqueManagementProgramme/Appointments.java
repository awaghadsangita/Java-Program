/****************************************************************************************************
 * @purpose	:contains setters and getters for various private variables
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ****************************************************************************************************/
package CliniqueManagementProgramme;

public class Appointments {
	private int appointmentId;
	private int doctorId;
	private int patientId;
	private String appintmentDate;
	
	public String getAppintmentDate() {
		return appintmentDate;
	}
	public void setAppintmentDate(String appintmentDate) {
		this.appintmentDate = appintmentDate;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	
}
