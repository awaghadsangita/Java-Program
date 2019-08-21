package com.bridgelab.designPattern.structural.adapter;

public class SocketClassAdapeterImpl extends Socket implements ISocketAdapter{

	@Override
	public Volt get120Volts() {
		return getVolt();
	}

	@Override
	public Volt get12Volts() {
		Volt v=getVolt();
		return convert(v,10);
	}

	@Override
	public Volt get3Volts() {
		Volt v=getVolt();
		return convert(v,40);
	}
	public Volt convert(Volt v,int i)
	{
		return new Volt(v.getVolts()/i);
	}

}
