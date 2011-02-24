package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginManager {

	public static final String salt = "AdJn32k";

	private File loginFile;

	public LoginManager(String path) {

		loginFile = new File(path);
	}

	public User login(String username, String password)
			throws NoSuchAlgorithmException, NumberFormatException,
			IOException, UserNotFoundException, PasswordInvalidException {
		BufferedReader rd = new BufferedReader(new FileReader(loginFile));

		String hashedPassword = HashCrypt.SHA1(salt + password);

		
		String line;
		while ((line = rd.readLine()) != null) {
			String[] splitData = line.split(";");
			if (splitData[1].equals(username)) {

				if (splitData[2].equals(hashedPassword)) {
					/* Login successfully; Create new User */
					UserInformation userInfo = new UserInformation();
					User newUser = new User(Integer.parseInt(splitData[0]), Integer.parseInt(splitData[3]),Integer.parseInt(splitData[4]), userInfo);

					return newUser;
				}
			}

		}
		
		throw new UserNotFoundException();
	}

}
