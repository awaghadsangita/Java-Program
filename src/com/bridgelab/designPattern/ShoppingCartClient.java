package com.bridgelab.designPattern;

public class ShoppingCartClient {

	public static void main(String[] args) {
		ItemElement[] items=new ItemElement[] {new Book(500,"ISBN1120"),new Book(50,"ISBN4402"),
		                                    new Fruit(1,50,"banana"),new Fruit(2,100,"apple")};
		
		int total=Calculate(items);
		System.out.println("Total Cost :"+total);
	}
	public static int Calculate(ItemElement[] items)
	{
		IShoppingCartVisitor visitor=new ShoppingCartVisitorImpl();
		int sum=0;
		for(ItemElement item : items)
		{
			sum+=item.accept(visitor);
		}
		return sum;
	}

}
