/******************************************************************************************************************************
 * @purpose	:class containing three fields name of stock,number of stack,price per stock and getters and setters of each fields
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:08-08-2019
 ******************************************************************************************************************************/
package com.bridgelab.objectoriented;

public class Stock {
	String stockName;
	int numberOfShares;
	double priceOfStock;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
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
