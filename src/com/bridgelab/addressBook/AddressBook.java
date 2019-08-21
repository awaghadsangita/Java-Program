/*
 * @purpose	: contain all methods require to perform various operation
 * @author	: sangita awaghad
 * @since	: 12-09-2019
 * @version	: 1.0	
 */
package com.bridgelab.addressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelab.utility.FileIO;
import com.bridgelab.utility.Utility;

public class AddressBook implements IPerson {

	File personFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/person.json");
	List<Person> personList;
	ObjectMapper objectmapper = new ObjectMapper();

	/*
	 * constructor
	 * 
	 * @param :name of file initialized personlist with list of json nodes if file
	 * not empty else insert empty node first then initialized
	 */
	AddressBook(File personFileName) throws JsonParseException, JsonMappingException, IOException {
		this.personFileName = personFileName;
		FileReader fr = new FileReader(personFileName);
		BufferedReader br = new BufferedReader(fr);
		String line;
		if ((line = br.readLine()) == null) {
			Person person = new Person();
			person.setPersionId(1);
			;
			person.setFirstName("");
			person.setLastName("");
			person.setAddress("");
			ArrayList mobilenumber = new ArrayList();
			person.setMobileNumber(mobilenumber);
			Cities city = new Cities();
			person.setCity(city);
			FileIO.writeToJsonFile(personFileName, objectmapper.writeValueAsString(person));
		}
		personList = objectmapper.readValue(personFileName, new TypeReference<List<Person>>() {
		});

	}
	/*
	 * add new Person in address book
	 */

	public void addPerson() throws JsonGenerationException, JsonMappingException, IOException {
		Person person = new Person();
		person.setPersionId(personList.get(personList.size() - 1).getPersionId() + 1);
		boolean matcherResult;
		do {
			System.out.print("Enter First Name :");
			person.setFirstName(Utility.getString());

			matcherResult = Utility.isOnlyAlphabets(person.getFirstName());
			if (!matcherResult) {
				System.out.println("Enter first name in alphabets only containing 3 to 20 charcaters");
			}
		} while (matcherResult == false);
		do {
			System.out.print("Enter Last Name :");
			person.setLastName(Utility.getString());

			matcherResult = Utility.isOnlyAlphabets(person.getLastName());
			if (!matcherResult) {
				System.out.println("Enter Last name in alphabets only containing 3 to 20 charcaters");
			}
		} while (matcherResult == false);
		do {
			System.out.print("Enter Addres :");
			person.setAddress(Utility.getNextLine());

			matcherResult = Utility.isValidAddress(person.getAddress());
			if (!matcherResult) {
				System.out.println("address only include  alphabets ,hyphen and commononly ");
			}
		} while (matcherResult == false);
		String cityname;
		String state;
		String zip;
		String pincode;
		do {
			System.out.print("Enter City Name :");
			cityname = Utility.getString();

			matcherResult = Utility.isOnlyAlphabets(cityname);
			if (!matcherResult) {
				System.out.println("city must include  alphabets 2 to 50 characters ");
			}
		} while (matcherResult == false);

		do {
			System.out.print("Enter State :");
			state = Utility.getString();

			matcherResult = Utility.isOnlyAlphabets(state);
			if (!matcherResult) {
				System.out.println("State must contain only alphabets and space is allowed ");
			}
		} while (matcherResult == false);

		do {
			System.out.print("Enter Zip :");
			zip = Utility.getString();

			matcherResult = Utility.isValidZip(zip);
			if (!matcherResult) {
				System.out.println("Zip must contain 6 digits ");
			}
		} while (matcherResult == false);
		do {
			System.out.print("Enter Pin Code :");
			pincode = Utility.getString();

			matcherResult = Utility.isValidPincode(pincode);
			if (!matcherResult) {
				System.out.println("Pincode must contain 7 digit ");
			}
		} while (matcherResult == false);
		Cities cityObj = new Cities();

		cityObj.setCityName(cityname);
		cityObj.setStateName(state);
		cityObj.setZip(zip);
		cityObj.setPincode(pincode);
		person.setCity(cityObj);
		ArrayList<String> mobilenumber = new ArrayList<String>();
		int choice = 0;
		do {

			System.out.print("Enter Mobile Number :");
			String phonenumber = Utility.getString();
			choice = 0;
			matcherResult = Utility.isValidMobileNumber(phonenumber);
			if (!matcherResult) {
				System.out.println("mobile number must start with 7,8 and 9  must be 10 digit long ");
			} else {
				mobilenumber.add(phonenumber);
				System.out.println("Do You want to one More Mobile Number press 1 otherwise 0");
				choice = Utility.getInteger();
			}
		} while (matcherResult == false || choice == 1);
		person.setMobileNumber(mobilenumber);
		personList.add(person);

		System.out.println("Are you want to save changes if yes press 1 otherwise 0");
		int confirmation = Utility.getInteger();
		if (confirmation == 1) {
			System.out.println(
					person.getFirstName() + " Successfully added in Address Book.Your ID is " + person.getPersionId());
			saveFile(personFileName, personList);
		} else {
			System.out.println("Registration operation is aborted");
		}

	}

	/*
	 * Edit person edit first name,last name,address,city,mobile number
	 */
	public void editPerson() throws JsonGenerationException, JsonMappingException, IOException {
		int mainDoWhileChoice;
		int wantToContinue = 0;
		System.out.println("\nEnter Id");
		int personId = Utility.getInteger();
		int index = 0;
		boolean matcherResult;
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getPersionId() == personId) {
				index = i;
				break;
			}
		}
		do {
			wantToContinue = 0;
			System.out.println(
					"\n1.Edit First Name\n2.Edit Last Name\n3.Edit City Name\n4.Edit Mobile Number \n5.Exit\nEnter Your chioce");
			mainDoWhileChoice = Utility.getInteger();

			try {
				switch (mainDoWhileChoice) {
				case 1:
					do {
						System.out.println("\nEnter Your New First Name :");
						personList.get(index).setFirstName(Utility.getString());

						matcherResult = Utility.isOnlyAlphabets(personList.get(index).getFirstName());

						if (!matcherResult) {
							System.out.println("Enter first name in alphabets containing only 3 to 20 charcaters");
						}
					} while (matcherResult == false);
					break;
				case 2:
					do {
						System.out.println("\nEnter Your New Last Name :");
						personList.get(index).setLastName(Utility.getString());

						matcherResult = Utility.isOnlyAlphabets(personList.get(index).getLastName());

						if (!matcherResult) {
							System.out.println("Enter last name in alphabets containing only 3 to 20 charcaters");
						}
					} while (matcherResult == false);
					break;
				case 3:
					String cityname;
					String state;
					String zip;
					String pincode;
					do {
						System.out.print("Enter City Name :");
						cityname = Utility.getString();

						matcherResult = Utility.isOnlyAlphabets(cityname);

						if (!matcherResult) {
							System.out.println("city must include  alphabets 3 to 50 characters ");
						}
					} while (matcherResult == false);

					do {
						System.out.print("Enter State :");
						state = Utility.getString();

						matcherResult = Utility.isOnlyAlphabets(state);
						if (!matcherResult) {
							System.out.println("State must contain only alphabets and space is allowed ");
						}
					} while (matcherResult == false);

					do {
						System.out.print("Enter Zip :");
						zip = Utility.getString();

						matcherResult = Utility.isValidZip(zip);
						if (!matcherResult) {
							System.out.println("Zip must contain 6 digits ");
						}
					} while (matcherResult == false);
					do {
						System.out.print("Enter Pin Code :");
						pincode = Utility.getString();

						matcherResult = Utility.isValidPincode(pincode);
						if (!matcherResult) {
							System.out.println("Pincode must contain 7 digit ");
						}
					} while (matcherResult == false);
					Cities cityObj = new Cities();

					cityObj.setCityName(cityname);
					cityObj.setStateName(state);
					cityObj.setZip(zip);
					cityObj.setPincode(pincode);
					personList.get(index).setCity(cityObj);
					break;
				case 4:
					ArrayList<String> mobilenumber = new ArrayList<String>();
					int choice = 0;
					do {

						System.out.print("Enter Mobile Number :");
						String phonenumber = Utility.getString();
						choice = 0;
						matcherResult = Utility.isValidMobileNumber(phonenumber);
						if (!matcherResult) {
							System.out.println("mobile number must start with 7,8 and 9  must be 10 digit long ");
						} else {
							mobilenumber.add(phonenumber);
							System.out.println("Do You want to one More Mobile Number press 1 otherwise 0");
							choice = Utility.getInteger();
						}
					} while (matcherResult == false || choice == 1);
					personList.get(index).setMobileNumber(mobilenumber);
					break;
				case 5:
					System.exit(0);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
			System.out.println("Are you want to save changes if yes press 1 otherwise 0");
			int confirmation = Utility.getInteger();
			if (confirmation == 1) {
				saveFile(personFileName, personList);
			} else {
				System.out.println("Update operation is aborted");
			}

			System.out.println("Do you want to update one more feilds if yes press 1 else press zero");
			wantToContinue = Utility.getInteger();
		} while (mainDoWhileChoice == 5 || wantToContinue == 1);
	}

	/*
	 * delete person delete record from address book
	 */
	public void deletePerson() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Enter the Registration Id");
		int personId = Utility.getInteger();
		int index = 0;
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getPersionId() == personId) {
				index = i;
				break;
			}
		}
		System.out.println(
				"Are you sure to Delete " + personList.get(index).getFirstName() + "if yes press 1 otherwise 0");
		int confirmation = Utility.getInteger();
		if (confirmation == 1) {
			personList.remove(personList.get(index));
			saveFile(personFileName, personList);
		} else {
			System.out.println("Delete operation is aborted");
		}

	}

	/*
	 * sort address book by last name
	 */
	public void sortByLastName() {
		Object[] tempPerson = personList.toArray();
		Person[] temporyList = new Person[personList.size()];
		for (int i = 0; i < personList.size(); i++) {
			temporyList[i] = (Person) tempPerson[i];
		}
		int j;
		Person key;
		for (int i = 1; i < temporyList.length; i++) {
			j = i - 1;
			key = temporyList[i];
			while (j >= 0 && temporyList[j].getLastName().compareTo(key.getLastName()) > 0) {
				temporyList[j + 1] = temporyList[j];

				j--;
			}
			temporyList[j + 1] = key;
		}
		System.out.println("Pincode \t\tCity \t\tId \t\tFirst Name \t\tLast Name \t\t\tMobile Number");
		for (Person tempObj : temporyList) {
			System.out.printf("%-20s %-20s %-20s %-15s %-25s %-20s\n", tempObj.getCity().getZip(),
					tempObj.getCity().getCityName(), tempObj.getPersionId(), tempObj.getFirstName(),
					tempObj.getLastName(), tempObj.getMobileNumber());
		}

	}

	/*
	 * sort address book zip code
	 */
	public void sortByZip() {
		Object[] tempPerson = personList.toArray();
		Person[] temporyList = new Person[personList.size()];
		for (int i = 0; i < personList.size(); i++) {
			temporyList[i] = (Person) tempPerson[i];
		}
		int j;
		Person key;
		for (int i = 1; i < temporyList.length; i++) {
			j = i - 1;
			key = temporyList[i];
			while (j >= 0 && temporyList[j].getCity().getZip().compareTo(key.getCity().getZip()) > 0) {
				temporyList[j + 1] = temporyList[j];

				j--;
			}
			temporyList[j + 1] = key;
		}
		System.out.println("Zipcode \t\tCity \t\tId \t\tFirst Name \t\tLast Name \t\t\tMobile Number");
		for (Person tempObj : temporyList) {
			System.out.printf("%-20s %-20s %-20s %-15s %-25s %-20s\n", tempObj.getCity().getZip(),
					tempObj.getCity().getCityName(), tempObj.getPersionId(), tempObj.getFirstName(),
					tempObj.getLastName(), tempObj.getMobileNumber());
		}
	}
	/*
	 * print address book
	 */
	public void printReport() {
		System.out.println("Pincode \t\tCity \t\tId \t\tFirst Name \t\tLast Name \t\t\tMobile Number");
		for (Person tempObj : personList) {
			System.out.printf("%-20s %-20s %-20s %-15s %-25s %-20s\n", tempObj.getCity().getZip(),
					tempObj.getCity().getCityName(), tempObj.getPersionId(), tempObj.getFirstName(),
					tempObj.getLastName(), tempObj.getMobileNumber());
		}
	}
	/*
	 * used for person list in a file 
	 */
	public void saveFile(File personFileName, List<Person> personList)
			throws JsonGenerationException, JsonMappingException, IOException {
		objectmapper.writeValue(personFileName, personList);
	}
	/*
	 * 
	 */
	public void saveAsFile(File file)throws JsonGenerationException, JsonMappingException, IOException
	{
		objectmapper.writeValue(file,personList);
	}
}
