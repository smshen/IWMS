package org.lazicats.ecos.internal.wms.common;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Tools {
	public  static Properties getPrperProperties(String fileName) throws IOException{
		Properties prop = new Properties();
		InputStream inputStream = Tools.class.getResourceAsStream(fileName);
		prop.load(inputStream);
		return prop;
	}
}