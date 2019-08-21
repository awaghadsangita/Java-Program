/******************************************************************************************************************************
 * @purpose	:to create inventory object from JSON and call each Inventory Object in its list to calculate the Inventory Price
 * 			 and then call the Inventory Object to return the JSON String
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:08-08-2019
 ******************************************************************************************************************************/
package com.bridgelab.objectoriented;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


public class InventoryManager {
	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException
	{
		File stockDetailsFilePath=new File("/home/user/Sangita/Java_Projects/jsonFiles/stockDetails1.json");
		ObjectMapper objectmapper=new ObjectMapper();
		
		List<Stock> stockList=objectmapper.readValue(stockDetailsFilePath, new TypeReference<List<Stock>>(){});
		double total=0;
		for(Stock node:stockList)
		{
			total=(double)total+node.getNumberOfShares()*node.getPriceOfStock();
			System.out.println("Stock Name :"+node.getStockName());
			System.out.println("Number of Shares :"+node.getNumberOfShares());
			System.out.println("Price :"+node.getPriceOfStock());
			System.out.println("Total Price of Stock :"+node.getNumberOfShares()*node.getPriceOfStock());
			System.out.println("*****************************");
		}
		System.out.println("Total Price of total Stock :"+total);	
	}

}
