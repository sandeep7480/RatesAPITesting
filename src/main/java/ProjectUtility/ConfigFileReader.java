/*
 Author:Sandeep Dhote
 */
package ProjectUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigFileReader {
	public void getReportConfigPath() throws Throwable{
				
		
		FileInputStream fis = new FileInputStream("Configuration.properties");
		   Properties properties = new Properties();
				properties.load(fis);
	
	}
}
