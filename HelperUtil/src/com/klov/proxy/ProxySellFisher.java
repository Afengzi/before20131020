package com.klov.proxy;

public class ProxySellFisher implements SellFisher{

	private SellFisher sell ;
	
	
	public ProxySellFisher(SellFisher sell) {
		this.sell = sell;
	}


	@Override
	public int sell() {
		System.out.println(getClass().getName()+"sell...");
		
		return sell.sell()+2;
	}


	@Override
	public void buy() {
		System.out.println(getClass().getName());
	}

}
