package com.pRemote.test;

import com.pRemote.usb.SerialUSBComm;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 * 37.152.91.12
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SerialUSBComm serial = new SerialUSBComm("COM3",9600);
		System.out.println(serial.sendDataToDevice("1"));
		
		System.out.println(serial.sendDataToDevice("0"));
		System.out.println(serial.sendDataToDevice("2"));
		System.out.println("Done!!!");
	}

}
