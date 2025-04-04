package json.com.validate_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
	public static boolean isValid(String email) {
		String regex = "^[a-z0-9_.-]+@[a-z0-9_.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
