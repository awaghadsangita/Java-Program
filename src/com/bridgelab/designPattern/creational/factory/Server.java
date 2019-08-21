package com.bridgelab.designPattern.creational.factory;

public class Server extends Computer{
	private String ram;
	private String hdd;
	private String cpu;
	
	public Server(String ram,String cpu ,String hdd)
	{
		this.ram=ram;
		this.cpu=cpu;
		this.hdd=hdd;
	}
	
	
	@Override
	public String getCPU() {
		return cpu;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return hdd;
	}

	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return ram;
	}

}
