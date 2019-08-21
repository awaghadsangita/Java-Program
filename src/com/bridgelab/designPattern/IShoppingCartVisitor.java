package com.bridgelab.designPattern;

public interface IShoppingCartVisitor {
	int visit(Book book);
	int visit(Fruit fruit);
}
