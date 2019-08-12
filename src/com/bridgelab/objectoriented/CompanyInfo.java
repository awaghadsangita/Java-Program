/****************************************************************************************************
 * @purpose	:contains setters and getters for company information class variables
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-9-2019
 ****************************************************************************************************/
package com.bridgelab.objectoriented;

public class CompanyInfo {
	private String stockName;
	private String symbol;
	private int numberOfShares;
	private double priceOfStock;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
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

	public double getPriceOfStock() {
		return priceOfStock;
	}

	public void setPriceOfStock(double priceOfStock) {
		this.priceOfStock = priceOfStock;
	}

}
