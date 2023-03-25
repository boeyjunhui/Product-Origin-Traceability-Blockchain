package hasher;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;


public class Hasher {

    public static String sha256(String input) throws Exception {
        return hash(input, "SHA256");
    }

    private static String hash(String input, String algorithm) throws Exception {
        
        var md = MessageDigest.getInstance(algorithm);
        // fetch the input byte[] into MessageDigest instance
        md.update(input.getBytes());
        // digest the input byte[]
        byte[] hashBytes = md.digest();
        // convert hashBytes into hex
        var hashCode = Hex.encodeHexString(hashBytes);

        return hashCode;
    }

}
