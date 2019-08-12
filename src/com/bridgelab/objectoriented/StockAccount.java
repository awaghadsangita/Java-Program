/***************************************************************************************************
 * @purpose	:contain method like buy,sell and save require for commercial data Processing
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-08-2019
 ****************************************************************************************************/
package com.bridgelab.objectoriented;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.codehaus.jackson.type.TypeReference;

import com.bridgelab.utility.Utility;

public class StockAccount {

	/*
	 * logic for sell operation
	 */
	public static void buy(CompanyInfo companyDetails, CustomerDetails customerInfo, int noOfshares)
			throws JsonParseException, JsonMappingException, IOException {
		File companyInfoFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/stockDetails.json");
		File customerDetailsFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/customerDetails.json");
		File transactionFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/transaction.json");

		ObjectMapper objectmapper = new ObjectMapper();
		List<CompanyInfo> companyList = objectmapper.readValue(companyInfoFileName,
				new TypeReference<List<CompanyInfo>>() {
				});

		for (int i = 0; i < companyList.size(); i++) {
			if (companyList.get(i).getSymbol().equals(companyDetails.getSymbol())) {
				companyList.get(i).setNumberOfShares(companyList.get(i).getNumberOfShares() - noOfshares);
				break;
			}
		}

		List<CustomerDetails> customerList = objectmapper.readValue(customerDetailsFileName,
				new TypeReference<List<CustomerDetails>>() {
				});
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getId() == customerInfo.getId()) {
				boolean isFound = false;
				customerList.get(i)
						.setBalance(customerList.get(i).getBalance() - companyDetails.getPriceOfStock() * noOfshares);
				for (int j = 0; j < customerList.get(i).getShares().size(); j++) {
					if (customerList.get(i).getShares().get(j).getSymbol().equals(companyDetails.getSymbol())) {
						customerList.get(i).getShares().get(j).setNumberOfShares(
								customerList.get(i).getShares().get(j).getNumberOfShares() + noOfshares);
						isFound = true;
						break;
					}
				}
				if (!isFound) {
					CompanyInfo obj = companyDetails;
					obj.setNumberOfShares(noOfshares);
					customerList.get(i).getShares().add(obj);
				}
			}
		}

		List<Transaction> transaction = objectmapper.readValue(transactionFileName,
				new TypeReference<List<Transaction>>() {
				});
		Transaction transactionObj = new Transaction();
		transactionObj.setId(customerInfo.getId());
		transactionObj.setOperation("BUY");
		transactionObj.setSymbol(companyDetails.getSymbol());
		transactionObj.setNumberOfShares(noOfshares);
		System.out.println(transactionObj.getNumberOfShares() + "    " + noOfshares);
		LocalDate ldate = LocalDate.now();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		transactionObj.setDate(formater.format(ldate));

		transactionObj.setTime(java.time.LocalTime.now().toString());

		transaction.add(transactionObj);
		System.out.println("You Buy " + noOfshares + " shares of " + companyDetails.getStockName());
		save(companyList, customerList, transaction);

	}

	/*
	 * logic for buy transaction
	 */
	public static void sell(CompanyInfo companyObj, CustomerDetails customerObj, int noOfshare)
			throws JsonParseException, JsonMappingException, IOException {
		File companyInfoFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/stockDetails.json");
		File customerDetailsFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/customerDetails.json");
		File transactionFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/transaction.json");
		System.out.println(noOfshare);
		ObjectMapper objectmapper = new ObjectMapper();
		List<CompanyInfo> companyList = objectmapper.readValue(companyInfoFileName,
				new TypeReference<List<CompanyInfo>>() {
				});

		for (int i = 0; i < companyList.size(); i++) {
			if (companyList.get(i).getSymbol().equals(companyObj.getSymbol())) {
				int temp = companyList.get(i).getNumberOfShares() + noOfshare;
				companyList.get(i).setNumberOfShares(temp);
				System.out.println(companyList.get(i).getNumberOfShares());
			}
		}

		List<CustomerDetails> customerList = objectmapper.readValue(customerDetailsFileName,
				new TypeReference<List<CustomerDetails>>() {
				});
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getId() == customerObj.getId()) {
				customerList.get(i)
						.setBalance(customerList.get(i).getBalance() + (noOfshare * companyObj.getPriceOfStock()));
				for (int j = 0; j < customerList.get(i).getShares().size(); j++) {
					if (customerList.get(i).getShares().get(j).getSymbol().equals(companyObj.getSymbol())) {
						int temp = customerList.get(i).getShares().get(j).getNumberOfShares() - noOfshare;
						customerList.get(i).getShares().get(j).setNumberOfShares(temp);

					}
				}
			}
		}

		List<Transaction> transaction = objectmapper.readValue(transactionFileName,
				new TypeReference<List<Transaction>>() {
				});
		Transaction transactionObj = new Transaction();
		transactionObj.setId(customerObj.getId());
		transactionObj.setOperation("SELL");
		transactionObj.setSymbol(companyObj.getSymbol());
		transactionObj.setNumberOfShares(noOfshare);
		LocalDate ldate = LocalDate.now();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		transactionObj.setDate(formater.format(ldate));
		transactionObj.setTime(java.time.LocalTime.now().toString());

		transaction.add(transactionObj);

		System.out.println("You Sold " + noOfshare + " shares to " + companyObj.getStockName());
		save(companyList, customerList, transaction);

	}

	/*
	 * logic for save method after sell or buy transaction
	 */
	public static void save(List<CompanyInfo> companyList, List<CustomerDetails> customerList,
			List<Transaction> transactionList) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Do you save Transction press 1 otherwise press 0");
		int decision = Utility.getInteger();
		if (decision == 1) {
			File companyInfoFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/stockDetails.json");
			File customerDetailsFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/customerDetails.json");
			File transactionFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/transaction.json");

			ObjectMapper objectmapper = new ObjectMapper();
			objectmapper.writeValue(companyInfoFileName, companyList);
			objectmapper.writeValue(customerDetailsFileName, customerList);
			objectmapper.writeValue(transactionFileName, transactionList);
		} else {
			System.out.println("your Transcation is Aborted");
		}
	}

}
