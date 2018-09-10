package ptit.ndtu.mobileshop.tool;

import java.util.regex.Pattern;

public class Validation {
	public boolean checkUsername(String username) {
		try {
			char c = username.charAt(0);
			if(username.length()<5 || username.length()>20) {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean checkPassword(String password) {
		try {
			char c = password.charAt(0);
			if(password.length()<5) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean checkString(String str) {
		try {
			char c = str.charAt(0);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	public boolean checkPhoneNumber(String s) {
		try {
			char c = s.charAt(0);
			for(int i = 0 ; i < s.length() ; i ++) {
				if(s.charAt(i)<48 || s.charAt(i)>57) {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean checkEmail(String s) {
		try {
			char c = s.charAt(0);
			final Pattern pattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		    if (!pattern.matcher(s).matches()) {
		    	
		        return false;
		    }
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
