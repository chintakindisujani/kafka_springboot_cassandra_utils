package com.mmtechpocs.sparkcassandra.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to read property file
 * 
 * @author anjaiahspr
 *
 */
public class PropertyFileReader {
	//private static final Logger logger = Logger.getLogger(PropertyFileReader.class);
	private static Properties prop = new Properties();
	public static Properties readPropertyFile() throws Exception {
		if (prop.isEmpty()) {
			InputStream input = PropertyFileReader.class.getClassLoader().getResourceAsStream("iot-spark.properties");
			try {
				prop.load(input);
			} catch (IOException ex) {
				//logger.error(ex);
				throw ex;
			} finally {
				if (input != null) {
					input.close();
				}
			}
		}
		return prop;
	}
	
		
	public static void main(String[] args) {
		
		try {
			System.out.println(readPropertyFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
