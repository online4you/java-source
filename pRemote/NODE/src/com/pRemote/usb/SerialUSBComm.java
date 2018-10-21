package com.pRemote.usb;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.CommPortOwnershipListener;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialUSBComm {
	private SerialPort serialPort;
	
	
	public SerialUSBComm(String portName,int boudrate) throws Exception{
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if ( portIdentifier.isCurrentlyOwned()){
            throw new Exception("Error: Port is currently in use");
        }else{
            CommPort commPort = portIdentifier.open("SerialUSBWriter",2000);
            if ( commPort instanceof SerialPort ){
                serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(boudrate,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                Thread.sleep(2000);
            }
        }
	}
	
	
	public String sendDataToDevice ( String data ) throws Exception{
		String ret="";
            if ( serialPort!=null ){
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();
                byte[] byteArray = data.getBytes("UTF-8");
                out.write(byteArray);

                byte[] buffer = new byte[1024];
                int len = -1;
                try{
                    while ((len = in.read(buffer)) > -1 ) {
                    	if(len!=0){
                    		ret+=new String(buffer,0,len);
                    		if(ret.indexOf("\n")!=-1){
                    			return ret;
                    			}
                    	}
                    }
                }catch ( IOException e ){
                    e.printStackTrace();
                }       
            }
            else{
                ret="Error: something has been bad!!";
            }
		return ret;     
    }
}
