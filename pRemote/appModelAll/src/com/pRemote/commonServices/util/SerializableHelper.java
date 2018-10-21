package com.pRemote.commonServices.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;


public class SerializableHelper {
	public static Object unserialize(String serilizedObj) throws IOException, ClassNotFoundException {
		byte[] buf;
		Base64 codec=new Base64();
		ByteArrayOutputStream baos;
		Object obj=null;
		
			if (serilizedObj!=null){
				buf = codec.decode(serilizedObj);
				if (buf != null) {
					baos = new ByteArrayOutputStream();
					ByteArrayInputStream bin = new ByteArrayInputStream(buf);
					ObjectInputStream objectIn = new ObjectInputStream(bin);
					obj = objectIn.readObject();
				}
			}
		return obj;			
	}
 	public static String serialize(Object obj) throws IOException, ClassNotFoundException {
		String serilizedObj;
		byte[] buf;
		Base64 codec=new Base64();
		ByteArrayOutputStream baos;
		baos = new ByteArrayOutputStream();
		ObjectOutputStream oout = new ObjectOutputStream(baos);
		oout.writeObject(obj);
		oout.close();
		buf = baos.toByteArray();
		serilizedObj = codec.encodeAsString(baos.toByteArray());

		return serilizedObj;			
 	}
    public static Object clone(Serializable obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        write(obj, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Object result = read(in);
        return result;
    }
    private static void write(Serializable obj, OutputStream out) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(obj);
        oos.flush();
    }
    
    private static Object read(InputStream in) throws IOException {
        ObjectInputStream is = new ObjectInputStream(in);
        Object result = null;
        try {
            result = is.readObject();
        }
        catch (ClassNotFoundException e) {
            throw (IllegalArgumentException) 
                new IllegalArgumentException("Fallo al deserializar").initCause(e);
        }
        return result;
    }


}