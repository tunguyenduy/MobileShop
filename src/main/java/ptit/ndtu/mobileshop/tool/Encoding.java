package ptit.ndtu.mobileshop.tool;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encoding {
	public static String sha512Encoding(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(message.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);            
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            return null;
        }
    }
}
