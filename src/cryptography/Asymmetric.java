package cryptography;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

public class Asymmetric {

    /* Cipher object*/
    private Cipher cipher;

    /* constructor */
    public Asymmetric(String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception ex) {
            Logger.getLogger(Asymmetric.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Asymmetric() {
        /*creates asymetric key using RSA algo*/
        this("RSA"); // calls the constructor by matching the input-args list
    }

    public String encrypt(String data, PublicKey key) throws Exception {
        String cipherText = null;
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // encrypt into byte[]
        byte[] cipherBytes = cipher.doFinal(data.getBytes());
        // convert byte array to String
        cipherText = Base64.getEncoder().encodeToString(cipherBytes);
        return cipherText;
    }

    public String decrypt(String cipherText, PrivateKey publicKey) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        // convert to byte[]
        byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
        // decrypt the byte array
        byte[] dataBytes = cipher.doFinal(cipherBytes);
        return new String(dataBytes);
    }
}
