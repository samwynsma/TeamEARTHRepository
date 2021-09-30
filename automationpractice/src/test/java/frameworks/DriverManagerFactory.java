package frameworks;

public class DriverManagerFactory {

	public static DriverManager getManager(String driverType) {
		if(driverType.equals("chrome"))
		{
			return new ChromeDriverManager();
		}
		if(driverType.equals("edge"))
		{
			return new EdgeDriverManager();
		}
		
		throw new RuntimeException("Driver not supported");
	}
}
