package cryptography;

import util.Path;

public class Cryptography {

    Asymmetric asymmetric = new Asymmetric();

    public void CreateKeyPair(String path) {
        // create and store key pair
        KeyPair.create();
        byte[] publicKey = KeyPair.getPublicKey().getEncoded();
        byte[] privateKey = KeyPair.getPrivateKey().getEncoded();

        KeyPair.put(publicKey, Path.publicKeyPath(path));
        KeyPair.put(privateKey, Path.privateKeyPath(path));

        //return new KeyPairRecord(publicKey, privateKey);
    }

    public String Encrypt(String path, String data) throws Exception {
        CreateKeyPair(path);
        String encrypted = asymmetric.encrypt(data, KeyAccess.getPublicKey(path));
        return encrypted;
    }

    public String Decrypt(String path, String data) throws Exception {
        return asymmetric.decrypt(data, KeyAccess.getPrivateKey(path));
    }

}
