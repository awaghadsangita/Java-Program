/*******************************************************************************************************
 * @purpose	:act similar to GUI for address book
 * @authod	:sangita awaghad
 * @version	:1.0
 * @since	:11-09-2019
 *******************************************************************************************************/
package com.bridgelab.addressBook;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelab.utility.Utility;

public class AddressBookManager {

	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException
	{
		int mainDoWhileChoice;
		do {
			System.out.println("1.Add New Address Book)");
			System.out.println("2.Open existing address Book");
			System.out.println("3.Save existing address book with new name");
			System.out.println("Enter your Choice");
			mainDoWhileChoice=Utility.getInteger();
			switch(mainDoWhileChoice)
			{
			case 1:AddressBookManagment.createAddressBook();
					break;
			case 2:AddressBook addressbook=AddressBookManagment.openAddressBook();
			int innerdowhileChoice;
			    do {
					System.out.println("1.Add Person");
					System.out.println("2.Edit Person");
					System.out.println("3.Delete Person");
					System.out.println("4.Sort by Last Name");
					System.out.println("5.Sort by Zip");
					System.out.println("6.Print ");
					System.out.print("Enter your Choice:");
					int innerChoice=Utility.getInteger();
					switch(innerChoice)
					{
						case 1:addressbook.addPerson();
						break;
						case 2:addressbook.editPerson();
						break;
						case 3:addressbook.deletePerson();
						break;
						case 4:addressbook.sortByLastName();
						break;
						case 5:addressbook.sortByZip();
						break;
						case 6:addressbook.printReport();
						break;
						
						default:System.out.println("invalid choice");
					}
					System.out.println("Do you want to perform other operation press 1 otherwise 0");
					innerdowhileChoice=Utility.getInteger();
			    }while(innerdowhileChoice==1);
					break;
			case 3:
				AddressBookManagment.saveAsFile();
				break;
			default:System.out.println("Enter the valid choice");
			}
		}while(mainDoWhileChoice!=7);
	
		}
}
