package frameworks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties {
	
	String result = "";
	InputStream input;

	public String getPropertyValues() throws IOException{
		try {
			Properties prop = new Properties();
			String configFile = "config.properties";
			
			input = getClass().getClassLoader().getResourceAsStream(configFile);
			
			if(input != null)
			{
				prop.load(input);
			}
			else
			{
				throw new FileNotFoundException("File not in classpath");
			}
			String browserType = prop.getProperty("BrowserType");
			result = browserType;
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			input.close();
		}
		return result;
	}
}
