package hr.fer.opp.project.util;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * A utility class containing methods for performing various
 * security functions, such as hashing user passwords.
 */
public class Util {

	/**
	 * Returns the SHA-512 hash of the given password.
	 *
	 * @param password the password to hash
	 * @return the SHA-512 hash of the given password
	 */
	public static String getPasswordHash(String password) {
		return DigestUtils.sha512Hex(password);
	}

	/**
	 * Returns the currently logged in user.
	 *
	 * @return currently logged in user
	 */
	public static String getCurrentUserEmail() {
		return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
