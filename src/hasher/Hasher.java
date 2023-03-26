package hasher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Hex;

public class Hasher {

    public static String sha256(String input) {
        return hash(input, "SHA256");
    }

    private static String hash(String input, String algorithm) {
        var hashCode = "";

        try {
            var md = MessageDigest.getInstance(algorithm);
            // fetch the input byte[] into MessageDigest instance
            md.update(input.getBytes());
            // digest the input byte[]
            byte[] hashBytes = md.digest();
            // convert hashBytes into hex
            hashCode = Hex.encodeHexString(hashBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashCode;

    }

}
