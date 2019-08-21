package com.bridgelab.designPattern.structural.adapter;

public class AdapterPatternTest {
	public static void main(String args[])
	{
		testObjectAdapter();
		testClassAdapter();
	}
	public static void testObjectAdapter()
	{
		ISocketAdapter socketAdapter=new SocketObjectAdapterImpl();
		
		Volt v3=getVolt(socketAdapter,3);
		Volt v12=getVolt(socketAdapter,12);
		Volt v120=getVolt(socketAdapter,120);
		
		System.out.println("V3 using ObjectAdapter :"+v3.getVolts());
		System.out.println("V12 using ObjectAdapter :"+v12.getVolts());
		System.out.println("V120 using ObjectAdapter :"+v120.getVolts());
		
	}
	public static void testClassAdapter() {
		ISocketAdapter socketAdapter=new SocketClassAdapeterImpl();
		Volt v3=getVolt(socketAdapter,3);
		Volt v12=getVolt(socketAdapter,12);
		Volt v120=getVolt(socketAdapter,120);
		System.out.println("V3 using ClassAdapter :"+v3.getVolts());
		System.out.println("V12 using ClassAdapter :"+v12.getVolts());
		System.out.println("V120 using ClassAdapter :"+v120.getVolts());
	}
	public static Volt getVolt(ISocketAdapter socketAdapter,int i)
	{
		switch(i)
		{
		case 3: return socketAdapter.get3Volts();
		case 12:return socketAdapter.get12Volts();
		case 120:return socketAdapter.get120Volts();
		default:return socketAdapter.get120Volts();
		}
	}
}
