package com.bridgelab.designPattern.structural.adapter;

public class SocketObjectAdapterImpl implements ISocketAdapter{

	Socket socket =new Socket();
	@Override
	public Volt get120Volts() {
		Volt v=socket.getVolt();
		return v;
	}

	@Override
	public Volt get12Volts() {
		Volt v=socket.getVolt();
		return calculate(v,10);
	}

	@Override
	public Volt get3Volts() {
		Volt v=socket.getVolt();
		return calculate(v,40);
	}
	
	public Volt calculate(Volt v,int i)
	{
		return new Volt(v.getVolts()/i);
	}

}
