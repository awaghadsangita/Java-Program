/* **************************************************************************************************
 * @purpose	:showing various products first and after giving product shows details of product
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ****************************************************************************************************/
package com.bridgelab.objectoriented;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelab.utility.Utility;

public class InventoryMain {
	
	public static void main(String args[]) throws JsonGenerationException,JsonMappingException,IOException
	{
		File Filename=new File("/home/user/Sangita/Java_Projects/jsonFiles/inventory.json");
		String product="";
		int choice;
		ObjectMapper objectmapper=new ObjectMapper();
		do {
			System.out.println("1.Rice\n2.Wheats\n3.Pulses\nEnter Your Product to See Inventory Details");
			choice=Utility.getInteger();
			switch(choice)
			{
			case 1:product="rice";
					break;
			case 2:product="wheats";
					break;
			case 3:product="pulses";
					break;
			default:
					System.out.println("Enter the number between 1 to 3");
			}
		JsonNode actualTree=objectmapper.readTree(Filename);
		JsonNode RequiredNode=actualTree.get(product);
		
		for(JsonNode node:RequiredNode)
		{
			InventoryProduct inventory=objectmapper.readValue(node, InventoryProduct.class);
			System.out.println("Name :"+inventory.getName());
			System.out.println("Weight :"+inventory.getWeight());
			System.out.println("Price :"+inventory.getPrice());
			System.out.println("************************************************************");
		}
				
		System.out.println("do you want to see other inventory details press 1 otherwise press 0");
		choice=Utility.getInteger();
		
		}while(choice!=0);
		
	}
}