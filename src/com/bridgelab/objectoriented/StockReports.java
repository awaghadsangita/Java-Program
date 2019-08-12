/****************************************************************************************************
 * @purpose	:print report showing customer name ,transaction type buy or sell,number of share and 
 * 			company name ,date and time.
 * @auther	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ****************************************************************************************************/
package com.bridgelab.objectoriented;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class StockReports {

	public static void report() throws JsonParseException, JsonProcessingException, IOException {
		File companyInfoFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/stockDetails.json");
		File customerFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/customerDetails.json");
		File transactionFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/transaction.json");
		ObjectMapper objectmapper = new ObjectMapper();
		List<CompanyInfo> companyList = objectmapper.readValue(companyInfoFileName,
				new TypeReference<List<CompanyInfo>>() {
				});
		List<CustomerDetails> customerList = objectmapper.readValue(customerFileName,
				new TypeReference<List<CustomerDetails>>() {
				});
		List<Transaction> transactionList = objectmapper.readValue(transactionFileName,
				new TypeReference<List<Transaction>>() {
				});
		objectmapper.writeValue(transactionFileName, transactionList);
		for (int i = 0; i < transactionList.size(); i++) {
			for (CustomerDetails customer : customerList) {
				
				if (transactionList.get(i).getId() == customer.getId()) {
					for (CompanyInfo company : companyList) {
						if (transactionList.get(i).getSymbol().equals(company.getSymbol())) {
							System.out.println("Customer Name: " + customer.getName());
							String temp;
							temp = transactionList.get(i).getOperation().equals("BUY") ? "From" : "To";
							System.out.println(transactionList.get(i).getOperation() + " "
									+ transactionList.get(i).getNumberOfShares() + " shares " + temp + " "
									+ company.getStockName());
							System.out.println("on " + transactionList.get(i).getDate() + " at "
									+ transactionList.get(i).getTime());
							System.out.println("\n===============");
							break;
						}
					}
					break;
				}
			}

		}
	}
}
