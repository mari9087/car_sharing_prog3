package uni.parthenope.carsharing.utility;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordHashing {
    private static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int HASH_ITERATIONS = 1000;
    private static final int HASH_KEY_SIZE = 256;

    public static String hashPassword(String password, String salt) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), HASH_ITERATIONS, HASH_KEY_SIZE);
            SecretKeyFactory f = SecretKeyFactory.getInstance(HASH_ALGORITHM);
            byte[] hash = f.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyPassword(String password, String salt, String storedHash) {
        String hashedPassword = hashPassword(password, salt);
        return hashedPassword.equals(storedHash);
    }
}
