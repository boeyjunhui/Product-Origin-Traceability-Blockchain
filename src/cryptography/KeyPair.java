package cryptography;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;


public class KeyPair {
    //generate key pair using RSA for asymmetric encryption
    private static final String ALGORITHM = "RSA";

    private KeyPairGenerator keygen;
    private java.security.KeyPair keyPair;
    private static PublicKey publicKey;
    private static PrivateKey privateKey;

    // getter method for publicKey and privateKey
    public static PublicKey getPublicKey() {
        return publicKey;
    }

    public static PrivateKey getPrivateKey() {
        return privateKey;
    }

    public KeyPair() {
        try {
            keygen = KeyPairGenerator.getInstance(ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void create() {
        KeyPair keyMaker = new KeyPair();
        // generate the keypair
        keyMaker.keyPair = keyMaker.keygen.generateKeyPair();
        publicKey = keyMaker.keyPair.getPublic();
        privateKey = keyMaker.keyPair.getPrivate();
    }

    // put the key pair and store into a file
    public static void put(byte[] keyBytes, String path) {
        File f = new File(path);
        f.getParentFile().mkdirs();
        try {
            Files.write(Paths.get(path), keyBytes, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
