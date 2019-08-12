/******************************************************************************************************************************
 * @purpose	:calculate the value of each stock and the total value
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:08-08-2019
 ******************************************************************************************************************************/
package com.bridgelab.objectoriented;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockReport {

	public static void main(String[] args) throws IOException {
		File stockFileName=new File("/home/user/Sangita/Java_Projects/jsonFiles/stockDetails.txt");
		FileReader filereader=new FileReader(stockFileName);
		BufferedReader bufferedreader=new BufferedReader(filereader);
		String line;
		
		List<Stock> stockList=new ArrayList<Stock>();
		while((line=bufferedreader.readLine())!=null)//iterating line by line
		{
			String array[]=line.split(" ");
			Stock obj=new Stock();
			obj.setStockName(array[0]);
			obj.setNumberOfShares(Integer.parseInt(array[1]));
			obj.setPriceOfStock(Double.parseDouble(array[2]));
			stockList.add(obj);
		}
		double total=0;
		for(int i=0;i<stockList.size();i++)//printing each stock details
		{
			total=total+stockList.get(i).numberOfShares*stockList.get(i).getPriceOfStock();
			System.out.println("Stock Name :"+stockList.get(i).getStockName()+
					"\nNumber of Shares :"+stockList.get(i).numberOfShares+
					"\nPrice of Stock :"+stockList.get(i).getPriceOfStock()+"\nValue of Stock :"+
					stockList.get(i).numberOfShares*stockList.get(i).getPriceOfStock());
			System.out.println("************************");
		}
		System.out.println("\n\nTotal value of Stock :"+total);
		bufferedreader.close();

	}

}
