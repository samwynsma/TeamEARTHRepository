package frameworks;

import java.io.IOException;

public class Settings {
	public String browserType;
	
	public Settings() throws IOException{
		this.browserType = Settings.get();
	}

	private static String get() {
		ConfigurationProperties properties = new ConfigurationProperties();
		try {
			return properties.getPropertyValues();
		} catch (IOException e) {
			return "Failed";
		}
	}
}
