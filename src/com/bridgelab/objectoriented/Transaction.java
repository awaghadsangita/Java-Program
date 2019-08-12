/****************************************************************************************************
 * @purpose	:contains setters and getters for transaction class variables
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-9-2019
 ****************************************************************************************************/
package com.bridgelab.objectoriented;

public class Transaction {
	int id;
	String operation;
	String symbol;
	int numberOfShares;
	String date;
	String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
