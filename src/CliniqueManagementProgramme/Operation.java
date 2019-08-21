/****************************************************************************************************
 * @purpose	:contains methods for various operation require for clinique managments
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ****************************************************************************************************/
package CliniqueManagementProgramme;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelab.utility.Utility;

public class Operation {

	File doctorsFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/doctors.json");
	File patientsFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/patients.json");
	File appointmentFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/appointment.json");
	List<Doctors> doctorList;
	List<Patients> patientsList;
	List<Appointments> appointmentList;
	ObjectMapper objectmapper = new ObjectMapper();

	/*
	 * Constructor initialized doctor list,patients list and appointment list
	 */
	Operation() throws JsonParseException, JsonMappingException, IOException {
		doctorList = objectmapper.readValue(doctorsFileName, new TypeReference<List<Doctors>>() {
		});
		patientsList = objectmapper.readValue(patientsFileName, new TypeReference<List<Patients>>() {
		});
		appointmentList = objectmapper.readValue(appointmentFileName, new TypeReference<List<Appointments>>() {
		});
	}

	/*
	 * function search doctor by name ,id,specialization and availability
	 */
	public void searchDoctor(int searchBy) throws JsonGenerationException, JsonMappingException, IOException {

		String ldate = LocalDate.now().toString();
		switch (searchBy) {
		case 1:
			System.out.print("\nEnter the Doctor Name:");
			String name = Utility.getString();
			for (Doctors doctor : doctorList) {
				if (doctor.getDoctorName().equalsIgnoreCase(name)) {
					System.out.println("*******\ndoctor Id :" + doctor.getDoctorId());
					System.out.println("doctor Name :" + doctor.getDoctorName());
					System.out.println("Shift :" + doctor.getAvailability());

					int chioce;
					System.out.println("\nWant appointment press 1 otherwise 0");
					chioce = Utility.getInteger();
					if (chioce == 1) {
						ldate = showAppointment(doctor);
						System.out.println("Are you want to appoint on " + ldate + " if yes press 1 otherwise 0");
						int result = Utility.getInteger();
						if (result == 1) {
							makeAppointment(doctor);
						} else
							System.out.println("Thank you");
					} else {
						System.out.println("Thank You");
					}
				}
			}
			break;
		case 2:
			System.out.print("\nEnter the Doctor Id:");
			int doctorId = Utility.getInteger();
			for (Doctors doctor : doctorList) {
				if (doctor.getDoctorId() == doctorId) {
					System.out.println("*******\ndoctor Id :" + doctor.getDoctorId());
					System.out.println("Doctor Name :" + doctor.getDoctorName());
					System.out.println("Specialization :" + doctor.getSpecialization());
					System.out.println("Shift :" + doctor.getAvailability());

					int chioce;
					System.out.println("\nWant appointment press 1 otherwise 0");
					chioce = Utility.getInteger();
					if (chioce == 1) {
						ldate = showAppointment(doctor);
						System.out.println("Are you want to appoint on " + ldate + " if yes press 1 otherwise 0");
						int result = Utility.getInteger();
						if (result == 1) {
							makeAppointment(doctor);
						} else
							System.out.println("Thank you");
					} else {
						System.out.println("Thank You");
					}

				}
			}
			break;
		case 3:
			System.out.println("\n1.MBBS,MD Surgen\n2.MBBS,MD Pedratics\n3.MBBS,MD gynecology");
			System.out.print("\nEnter the Doctor Specialization:");
			int chioceSpec = Utility.getInteger();
			String specialization;
			ArrayList<Doctors> doct = new ArrayList<Doctors>();
			if (chioceSpec == 1)
				specialization = "MBBS,MD Surgen";
			else if (chioceSpec == 2)
				specialization = "MBBS,MD Pedratics";
			else
				specialization = "MBBS,MD gynecology";

			for (Doctors doctor : doctorList) {
				if (doctor.getSpecialization().equals(specialization)) {
					System.out.println("*******\ndoctor Id :" + doctor.getDoctorId());
					System.out.println("doctor Name :" + doctor.getDoctorName());
					System.out.println("Shift :" + doctor.getAvailability());
					doct.add(doctor);
				}
			}
			System.out.println("\nWant appointment press 1 otherwise 0");
			chioceSpec = Utility.getInteger();
			if (chioceSpec == 1) {
				searchDoctor(1);
			} else {
				System.out.println("Thank You");
			}
			break;
		case 4:
			System.out.print("\nEnter the Doctor availability\n1.AM\n2.PM\n3.BOTH:");
			int availability = Utility.getInteger();
			String choice;
			if (availability == 1)
				choice = "AM";
			else if (availability == 2)
				choice = "PM";
			else
				choice = "BOTH";
			showAppointment(choice);
			System.out.println("\nWant appointment press 1 otherwise 0");
			chioceSpec = Utility.getInteger();
			if (chioceSpec == 1) {
				searchDoctor(1);
			} else {
				System.out.println("Thank You");
			}

			break;
		}// end switch

	}

	/*
	 * return last appointment date and shows all appointment from current date
	 */
	public String showAppointment(Doctors doctorObj) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ldate = format.format(LocalDate.now());
		for (Appointments appointment : appointmentList) {
			if (appointment.getAppintmentDate().compareTo(ldate) >= 0
					&& appointment.getDoctorId() == doctorObj.getDoctorId()) {
				System.out.println("Appoint Date :" + appointment.getAppintmentDate());
				System.out.println("Patient Name :" + getPatientName(appointment.getPatientId()));
				ldate = appointment.getAppintmentDate();
			}
		}
		if(ldate.compareTo(format.format(LocalDate.now()))<0)
		{
			ldate=format.format(LocalDate.now());
		}
		return ldate;
	}

	/*
	 * @param :take shift of doctor as parameter return last appointment date and
	 * shows all appointment from current date
	 */
	public String showAppointment(String availability) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ldate = format.format(LocalDate.now()).toString();

		for (Doctors doctor : doctorList) {
			if (doctor.getAvailability().equals(availability) || doctor.getAvailability().equals("BOTH")) {

				for (Appointments appointment : appointmentList) {
					if (appointment.getAppintmentDate().compareTo(ldate) >= 0
							&& appointment.getDoctorId() == doctor.getDoctorId()) {
						System.out.println("Appoint Date :" + appointment.getAppintmentDate());
						System.out.println("Patient Name :" + getPatientName(appointment.getPatientId()));
						ldate = appointment.getAppintmentDate();
					}
				}
				System.out.println("*****\nDoctor ID: " + doctor.getDoctorId());
				System.out.println("Doctor Name: " + doctor.getDoctorName() + " (" + doctor.getSpecialization() + ") "
						+ "is Available on " + ldate);

			}
		}
		return ldate;
	}
	/*
	 * @param :take patient ID as argument
	 * 
	 * @return :patient name
	 */

	public String getPatientName(int patientId) {
		String patientName = "";
		for (Patients patient : patientsList) {
			if (patient.getPatientId() == patientId) {
				patientName = patient.getPatientName();
			}
		}
		return patientName;
	}

	/*
	 * @param :take doctor object as argument add new new record containing doctor
	 * and patient information to appointment file
	 */
	public void makeAppointment(Doctors doctorObj) throws JsonGenerationException, JsonMappingException, IOException {
		int count = 0;
		String lastDate = LocalDate.now().toString();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int i = 0;
		for (Appointments appointment : appointmentList) {
			if (appointment.getAppintmentDate().compareTo(LocalDate.now().toString()) >= 0
					&& appointment.getDoctorId() == doctorObj.getDoctorId()) {
				count++;
				if (count == 5) {
					lastDate = (format.format(LocalDate.now().plusDays(++i))).toString();
					count = 0;
				}
			}
			
			
			
		}
		Patients patientObj = new Patients();
		System.out.println("New Patient Press 1 otherwise 0");
		int newPatientChoice = Utility.getInteger();
		if (newPatientChoice == 1) {
			boolean matcherResult;
			patientObj.setPatientId(patientsList.size() + 1);
			do {
				System.out.print("Enter the Patient Name :");
				patientObj.setPatientName(Utility.getString());

				matcherResult = Utility.isOnlyAlphabets(patientObj.getPatientName());
				if (!matcherResult) {
					System.out.println("Enter first name in alphabets only containing 3 to 20 charcaters");
				}
			} while (matcherResult == false);
			System.out.print("Enter the Patient Name :");
			patientObj.setPatientName(Utility.getString());
			do {
				System.out.print("Enter the Patient Mobile Number :");
				patientObj.setMobileNumber(Utility.getString());

				matcherResult = Utility.isValidMobileNumber(patientObj.getMobileNumber());
				if (!matcherResult) {
					System.out.println("Enter Mobile Number must be 10 digit numberic value");
				}
			} while (matcherResult == false);

			System.out.print("Enter the Age of Patient :");
			patientObj.setAge(Utility.getInteger());
			patientsList.add(patientObj);
		} else {
			System.out.println("Enter Patient Id :");
			int patientId = Utility.getInteger();
			for (Patients patient : patientsList) {
				if (patient.getPatientId() == patientId) {
					showPatientDetails(patient.getPatientId());
					patientObj = patient;
					break;
				}
			}

		}
		Appointments appointment = new Appointments();
		appointment.setAppointmentId(appointmentList.get(appointmentList.size()-1).getAppointmentId() + 1);
		appointment.setDoctorId(doctorObj.getDoctorId());
		appointment.setPatientId(patientObj.getPatientId());
		appointment.setAppintmentDate(lastDate);
		appointmentList.add(appointment);

		System.out.println("are you sure to confirm the appointment press 1 otherswise press 0 ");
		int choice = Utility.getInteger();
		if (choice == 1) {
			objectmapper.writeValue(patientsFileName, patientsList);
			objectmapper.writeValue(appointmentFileName, appointmentList);
			System.out.println(patientObj.getPatientName()+" your Appointment is Scheduled on "+appointment.getAppintmentDate());
		} else {
			System.out.println("Your Appointment Cancel");
		}
	}
	/*
	 * Search patient by name ,id or mobile number
	 */

	public void searchPatient(int searchChoice) {
		switch (searchChoice) {
		case 1:
			System.out.print("Enter Patient Name :");
			String patientName = Utility.getString();
			for (Patients patient : patientsList) {
				if (patient.getPatientName().equalsIgnoreCase(patientName)) {
					showPatientDetails(patient.getPatientId());
					break;
				}
			}
			break;
		case 2:
			System.out.print("Enter Patient Id :");
			int patientId = Utility.getInteger();
			for (Patients patient : patientsList) {
				if (patient.getPatientId() == patientId) {
					showPatientDetails(patient.getPatientId());
					break;
				}
			}
			break;
		case 3:
			System.out.print("Enter Patient Mobile Number :");
			String mobileNumber = Utility.getString();

			for (Patients patient : patientsList) {
				if (patient.getMobileNumber().equals(mobileNumber)) {
					showPatientDetails(patient.getPatientId());
					break;
				}
			}
			break;
		default:
			System.out.println("Enter Valid Choice");
		}
	}

	/*
	 * show patient details by patient id
	 */
	public void showPatientDetails(int patientId) {
		for (Patients patient : patientsList) {
			if (patient.getPatientId() == patientId) {
				System.out.println("********Patient Details********\nPatient Id: " + patient.getPatientId());
				System.out.println("Patient Name: " + patient.getPatientName());
				System.out.println("Mobile Number: " + patient.getMobileNumber());
				System.out.println("Age :" + patient.getAge());
				break;
			}
		}
	}

	/*
	 * show doctor doctor details
	 */
	public void showDoctorDetails(Doctors doctor) {

		System.out.println("********Doctor Details********\nDoctor Id: " + doctor.getDoctorId());
		System.out.println("Doctor Name: " + doctor.getDoctorName());
		System.out.println("Specialization: " + doctor.getSpecialization());
		System.out.println("Shift :" + doctor.getAvailability());
	}

	/*
	 * print report doctor wise and also date wise
	 */
	public void printReport() {
		String ldate = "";
		for (Doctors doctor : doctorList) {
			showDoctorDetails(doctor);
			System.out.println("Appointments\n");
			for (Appointments appointment : appointmentList) {

				if (appointment.getDoctorId() == doctor.getDoctorId()) {
					if (!ldate.equals(appointment.getAppintmentDate())) {
						System.out.println("\n\nAppointment Date :" + appointment.getAppintmentDate());
					}
					ldate = appointment.getAppintmentDate();

					showPatientDetails(appointment.getPatientId());
				}
			}
			System.out.println("-------------------------------------------");
		}
	}
}
