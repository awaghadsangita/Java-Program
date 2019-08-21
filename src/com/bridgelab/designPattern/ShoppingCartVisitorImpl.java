package com.bridgelab.designPattern;

public class ShoppingCartVisitorImpl implements IShoppingCartVisitor {

	@Override
	public int visit(Book book) {
		int cost=0;
		if(book.getPrice()>50)
		{
			cost=book.getPrice()-5;
		}
		else
			cost=book.getPrice();
		System.out.println("Book ISBN Number :"+book.getIsbnNumber()+"Book Cost :"+cost);
		return cost;
	}

	@Override
	public int visit(Fruit fruit) {
		int cost=fruit.getPricePerKg()*fruit.getWeight();
		System.out.println("Fruit Name :"+fruit.getName()+"Cost :"+cost);
		
		return cost;
	}

}
