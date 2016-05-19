package org.lazicats.ecos.internal.payment.common.Allunion.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * utility for marshalling and unmarshalling between object and xml.
 * 
 * Note:object must be configured before using this class.
 * @author Jay 
 * @date 2015-05-07
 */
public class JAXB {
    private static boolean enableFormatOutput;
	private static boolean enableFragment;
	private static boolean enableXmlDeclaration = true;
	private static String encodeMethod = "UTF-8";
    
    public static void enableFormatOutput() {
    	 enableFormatOutput = true;
    }
    
    public static void enableFragment() {
    	enableFragment = true;
    }
    
    public static void enableXmlDeclaration() {
    	enableXmlDeclaration = true;
    }
    
    
    public static void disableFormatOutput() {
    	 enableFormatOutput = false;
    }
    
    public static void disableFragment() {
    	enableFragment = false;
    }
    
    public static void disableXmlDeclaration() {
    	enableXmlDeclaration = false;
    }
    
    /**
     * convert object to xml string
     * @param object 
     * @return xml string correspond to the specifid object
     * @throws JAXBException 
     */
	public static <T> String ox(T object) throws JAXBException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JAXBContext jc = JAXBContext.newInstance(object.getClass());
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,enableFormatOutput);
		m.setProperty(Marshaller.JAXB_FRAGMENT,enableFragment);
		m.marshal(object,bos);
		
		return bos.toString();
	}
	
	/**
	 * convert xml to object
	 * @param clazz corresponding classs for the xml 
	 * @param xml representing the class
	 * @return the object of the targeted classs
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T>  T xo(Class<T> clazz, String xml) throws JAXBException {
		ByteArrayInputStream bai = new ByteArrayInputStream(xml.getBytes());
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller un = context.createUnmarshaller();
		return (T) un.unmarshal(bai);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(Class<T> clazz, InputStream is) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller un = context.createUnmarshaller();
		return (T) un.unmarshal(is);
	}
	
	public static <T> T unmarshal(Class<T> clazz, File file) throws JAXBException, FileNotFoundException {
		return unmarshal(clazz,new FileInputStream(file));
	}
	
	public static <T> void marshal(T element,OutputStream os) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(element.getClass());
		Marshaller m = jc.createMarshaller();
		m.marshal(element, os);
	}
	
	public static <T> void marshal(T element, File output) throws FileNotFoundException, JAXBException{
		marshal(element,new FileOutputStream(output));
	}
}

