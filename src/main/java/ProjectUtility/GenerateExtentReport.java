package ProjectUtility;

import com.cucumber.listener.Reporter;

public class GenerateExtentReport {

		public static void setupExtendReport(){
			ConfigFileReader configReader =  new ConfigFileReader();
			String path ="./Config/extentConfig.xml";
			Reporter.loadXMLConfig(path);
			
			Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		     Reporter.setSystemInfo("Machine", "Windows 10 " + " 64 Bit");
		     //Reporter.setSystemInfo("Maven", "3.5.2");
		     Reporter.setSystemInfo("Java Version", "1.8.0_202");
	}

}
