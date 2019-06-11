import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class Loader {
	
	 static Properties prop = new Properties();

	 @BeforeTest
		public void getData() throws IOException
		{	
			FileInputStream fs = new FileInputStream("/Users/arshdeepkaur/eclipse-workspace/Test/src/MensioAPIs/src/files/env.properties");
			prop.load(fs);
		}	
	 
	 public static String getURL() {
		return prop.getProperty("arshdeep");
	 }
}
