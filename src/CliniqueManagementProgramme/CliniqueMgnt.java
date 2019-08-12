/****************************************************************************************************
 * @purpose	:acts similar to GUI for clinique management system
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ****************************************************************************************************/
package CliniqueManagementProgramme;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelab.utility.Utility;

public class CliniqueMgnt {

	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException {

		Operation operation = new Operation();
		int mainDoWhileChoice;
		int innerChoice;
		int wantToSearch = 0;
		do {
			System.out.println(
					"\n1.Search Doctor\n2.Search Patient\n3.To Take Appointment\n4.Report\n5.Exit\nEnter Your Choice");
			mainDoWhileChoice = Utility.getInteger();

			switch (mainDoWhileChoice) {
			case 1:
				do {

					System.out.println(
							"\n1.Search by name\n2.Search by Id\n3.Search by Specialization\n4.Search by Availability\nEnter your chioce:");
					innerChoice = Utility.getInteger();
					operation.searchDoctor(innerChoice);
					System.out.println("Do you want more information if yes press 1 otherwise 0");
					wantToSearch = Utility.getInteger();
				} while (wantToSearch == 1);
				break;
			case 2:
				do {

					System.out.println(
							"\n1.Search by name\n2.Search by Id\n3.Search by Mobile Number\nEnter your chioce:");
					innerChoice = Utility.getInteger();
					operation.searchPatient(innerChoice);
					System.out.println("Do you want more information if yes press 1 otherwise 0");
					wantToSearch = Utility.getInteger();
				} while (wantToSearch == 1);
				break;
			case 3:
				operation.searchDoctor(1);
				break;
			case 4:
				operation.printReport();
			}// outer switch end

		} while (mainDoWhileChoice != 5);
	}
}
