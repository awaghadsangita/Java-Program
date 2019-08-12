/***************************************************************************************************
 * @purpose	:acts similar to GUI for commercial data processing
 * @author 	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019
 ***************************************************************************************************/
package com.bridgelab.objectoriented;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.bridgelab.utility.FileIO;
import com.bridgelab.utility.Utility;

public class CommercialDataProcessing {

	public static void main(String[] args) throws JsonParseException, JsonProcessingException, IOException {
		File companyInfoFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/stockDetails.json");
		File customerDetailsFileName = new File("/home/user/Sangita/Java_Projects/jsonFiles/customerDetails.json");

		ObjectMapper objectmapper = new ObjectMapper();

		List<CompanyInfo> companyList = objectmapper.readValue(companyInfoFileName,
				new TypeReference<List<CompanyInfo>>() {
				});
		System.out.println("*********Stock Details****************");
		for (CompanyInfo companyDetails : companyList) {
			System.out.println("Company Name     :" + companyDetails.getStockName());
			System.out.println("Symbol           :" + companyDetails.getSymbol());
			System.out.println("Number of Shares :" + companyDetails.getNumberOfShares());
			System.out.println("Price per Share  :" + companyDetails.getPriceOfStock());
			System.out.println("----------------");
		}

		List<CustomerDetails> customerList = objectmapper.readValue(customerDetailsFileName,
				new TypeReference<List<CustomerDetails>>() {
				});
		System.out.println("*********Customer Details****************");
		for (CustomerDetails customerDetails : customerList) {
			System.out.println("Customer Id       :" + customerDetails.getId());
			System.out.println("Customer Name     :" + customerDetails.getName());
			System.out.println("Address           :" + customerDetails.getAddress() + "," + customerDetails.getCity()
					+ "," + customerDetails.getCountry());
			System.out.println("Email             :" + customerDetails.getEmail());
			System.out.println("Mobile Number     :" + customerDetails.getMobileNumber());
			System.out.println("Balance           :" + customerDetails.getBalance());
			System.out.println("Shares Details");
			ArrayList<CompanyInfo> sharesDetails = customerDetails.getShares();
			for (int i = 0; i < sharesDetails.size(); i++) {
				System.out.println("\t" + (i + 1) + " Company Name   :" + sharesDetails.get(i).getStockName());
				System.out.println("\t" + "Company Symbol        :" + sharesDetails.get(i).getSymbol());
				System.out.println("\tNumber of Shares Bought  :" + sharesDetails.get(i).getNumberOfShares());
				System.out.println("\tPrice Per Shares         :" + sharesDetails.get(i).getPriceOfStock());
				System.out.println("\tTotal Price              :"
						+ sharesDetails.get(i).getNumberOfShares() * sharesDetails.get(i).getPriceOfStock());
				System.out.println("\t\t======");
			}
			System.out.println("----------------");
		}
		System.out.println("***************************************************************************");
		int choice;
		do {// outer do while start
			System.out.println("\n1.Stock\n2.Add Customer\n3.Sell or Buy Shares\n4.Report\n5.Exit\nEnter Your Choice");
			choice = Utility.getInteger();
			switch (choice) {
			case 1:
				System.out.println("\n1.Add Shares\n2.Add Company\n3.Exit\nEnter Your Choice");
				int companyChoice = Utility.getInteger();
				switch (companyChoice) {
				case 1:
					System.out.println("Enter the Compnay symbol");
					String companySymbol = Utility.getString();
					System.out.println("How many Shares you want to add ");
					int noOfShares = Utility.getInteger();
					for (int i = 0; i < companyList.size(); i++) {
						if (companyList.get(i).getSymbol().compareTo(companySymbol) == 0) {
							companyList.get(i).setNumberOfShares(companyList.get(i).getNumberOfShares() + noOfShares);
						}
					}
					String jsonString = objectmapper.writeValueAsString(companyList);
					FileIO.writeToJsonFile(companyInfoFileName, jsonString);
					break;
				case 2:
					CompanyInfo company = new CompanyInfo();
					System.out.println("Enter the Company Name :");
					company.setStockName(Utility.getString());
					System.out.println("Enter the Company Symbol :");
					company.setSymbol(Utility.getString());
					System.out.println("Enter the Number of Shares");
					company.setNumberOfShares(Utility.getInteger());
					System.out.println("Enter the Price");
					company.setPriceOfStock(Utility.getDouble());
					companyList.add(company);
					String jsonCompanyInfo = objectmapper.writeValueAsString(companyList);
					FileIO.writeToJsonFile(companyInfoFileName, jsonCompanyInfo);
					break;
				case 3:
					System.exit(0);
				}
			case 2:
				System.out.println("Enter the Following Customer Details");
				CustomerDetails customer = new CustomerDetails();
				System.out.println("Enter the Id");
				customer.setId(Utility.getInteger());
				System.out.println("Enter the Name");
				customer.setName(Utility.getString());
				System.out.println("Enter the Email");
				customer.setEmail(Utility.getString());
				System.out.println("Enter the Address");
				customer.setAddress(Utility.getString());
				System.out.println("Enter the City");
				customer.setCity(Utility.getString());
				System.out.println("Enter the Country");
				customer.setCountry(Utility.getString());
				System.out.println("Enter the Mobild Number");
				customer.setMobileNumber(Utility.getString());
				System.out.println("Enter the Balance");
				customer.setBalance(Utility.getDouble());
				customerList.add(customer);
				System.out.println(customer.getName() + " Successfully Register");
				objectmapper.writeValue(customerDetailsFileName, customerList);
				break;

			case 3:
				System.out.println("\n1.Buy Shares\n2.Sell Shares\nEnter your chice");
				int operationChoice = Utility.getInteger();
				switch (operationChoice) {
				case 1:
					System.out.println("Enter the Customer Id:");
					int custId = Utility.getInteger();
					System.out.println("Enter the Company Symbol:");
					String CSymbol = Utility.getString();
					int operationdecision = 0;
					do {
						System.out.println("Enter the Number of Shares:");
						int noOfshare = Utility.getInteger();
						operationdecision = 0;

						CompanyInfo companyObj = new CompanyInfo();
						for (int i = 0; i < companyList.size(); i++) {
							if (companyList.get(i).getSymbol().equals(CSymbol)) {
								companyObj = companyList.get(i);
							}
						}

						CustomerDetails customerObj = new CustomerDetails();
						for (int i = 0; i < customerList.size(); i++) {
							if (customerList.get(i).getId() == custId) {
								customerObj = customerList.get(i);
							}
						}
						if (customerObj.getBalance() < (companyObj.getPriceOfStock() * noOfshare)
								|| companyObj.getNumberOfShares() < noOfshare) {
							System.out.println("Check Your Available Balance And company has only "
									+ companyObj.getNumberOfShares()
									+ " Shares.\nEnter Less number of Shares are you continue press 1 otherwise 0");
							operationdecision = 1;
						} else {
							StockAccount.buy(companyObj, customerObj, noOfshare);
						}
					} while (operationdecision == 1);
					break;
				case 2:
					System.out.println("Enter the Customer Id:");
					int customertId = Utility.getInteger();
					System.out.println("Which Company Shares you want to Sell Enter the Company Symbol :");
					String companySymbol = Utility.getString();
					System.out.println("Enter the Number of Shares you want to sell:");
					int noOfshare = Utility.getInteger();
					CompanyInfo companyObj = new CompanyInfo();
					for (int i = 0; i < companyList.size(); i++) {
						if (companyList.get(i).getSymbol().equals(companySymbol)) {
							companyObj = companyList.get(i);
						}
					}

					CustomerDetails customerObj = new CustomerDetails();
					for (int i = 0; i < customerList.size(); i++) {
						if (customerList.get(i).getId() == customertId) {
							customerObj = customerList.get(i);
							for (CompanyInfo stock : customerObj.getShares()) {
								if (stock.getNumberOfShares() < noOfshare) {
									System.out.println(
											"number of shares you have are less than number shares  you want to sell");
									break;
								} else {
									StockAccount.sell(companyObj, customerObj, noOfshare);
									break;
								}
							}
							break;
						}
					}

				}
				break;
			case 4:
				StockReports.report();
				break;
			}

		} while (choice != 5);
	}
}
