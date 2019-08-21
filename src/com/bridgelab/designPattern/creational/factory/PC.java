package com.bridgelab.designPattern.creational.factory;

public class PC extends Computer{

	private String hdd;
	private String cpu;
	private String ram;
	public PC(String ram,String cpu,String hdd)
	{
		this.hdd=hdd;
		this.cpu=cpu;
		this.ram=ram;		
	}
	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
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
