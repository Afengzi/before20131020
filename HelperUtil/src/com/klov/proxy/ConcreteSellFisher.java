package com.klov.proxy;

public class ConcreteSellFisher implements SellFisher{

	@Override
	public int sell() {
		System.out.println(getClass().getName()+"sell...");
		return 10;
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		
	}

}
