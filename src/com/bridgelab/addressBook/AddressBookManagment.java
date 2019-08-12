package com.bridgelab.addressBook;

import java.io.File;
import java.io.IOException;


import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelab.utility.Utility;

public class AddressBookManagment {
	public static final String FileSystem = null;

	static File file;
	public static void createAddressBook() throws IOException
	{
		System.out.println("Enter File Name");
		String fileName=Utility.getString();
		System.out.println("Enter File Extension :");
		String fileExtension=Utility.getString();
		if(fileExtension.equals("json"))
		{
			String fileSeparator = System.getProperty("file.separator");
			String absoluteFilePath = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"Sangita"+fileSeparator+"Java_Projects"+fileSeparator+"jsonFiles"+fileSeparator+fileName.trim()+"."+fileExtension;
			file=new File(absoluteFilePath);
			System.out.println(absoluteFilePath);
			if(file.createNewFile())
			{
				System.out.println(fileName.trim()+"."+fileExtension+" name Address Book is created");
			}
			else
			{
				System.out.println(fileName.trim()+"."+fileExtension+" name Address Book is already Exists");
			}
		}
		else
		{
			System.out.println("Only Json File will be Created");
		}
		
	}
	public static AddressBook openAddressBook() throws JsonProcessingException, JsonMappingException, IOException 
	{
		String fileSeparator = System.getProperty("file.separator");
		String absoluteFilePath = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"Sangita"+fileSeparator+"Java_Projects"+fileSeparator+"jsonFiles"+fileSeparator+"AddressBook";
		File folder = new File(absoluteFilePath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		
		System.out.println("Enter the File Name");
		String fileName=Utility.getString();
		System.out.println("Enter the File Extension");
		String fileExtension=Utility.getString();
		
		
		file=new File(fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"Sangita"+fileSeparator+"Java_Projects"+fileSeparator+"jsonFiles"+fileSeparator+"AddressBook"+fileSeparator+fileName.trim()+"."+fileExtension);
		AddressBook addressbook=new AddressBook(file);
		System.out.println("*************Address Book:"+fileName.trim()+"*************"+"\nYou can Perform Following Operation");
		return addressbook;
	}
	
}
