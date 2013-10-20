package com.klov.tcp_ip.base;

public abstract class ServiceServer extends Serviceable{

	private String name ;
	private boolean initalized ;
	
	
	public ServiceServer(String name) {
		this.name = name;
		initalized = true ;
	}

	@Override
	public boolean init() {
		if(!initalized){
			doInit() ;
			return true ;
		}
		return false ;
	}

	@Override
	public boolean start() {
		if(initalized){
			doStart() ;
			return true ;
		}else{
			doInit() ;
			initalized = true ;
			doStart() ;
			return true ;
		}
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}

	protected abstract boolean doInit() ;
	protected abstract boolean doStart() ;
	protected abstract boolean doStop() ;
	

}
