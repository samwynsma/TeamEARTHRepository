package foundations;

public class LoginModule {
	
	private final static String email = "maker@gmail.com";
	private final static String pass = "h2twJh!MbbV.hd.";
	private final static String[] credentials = {email, pass};
	
	public static String getEmail() {
		return getCred(0);
	}
	
	public static String getPass() {
		return getCred(1);
	}
	
	public static String getCred(int index) {
		return credentials[index];
	}
}
