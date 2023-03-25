package cryptography;

public class Cryptography {

    Asymmetric asymmetric = new Asymmetric();

    private void CreateKeyPair(String path) {
        // create and store key pair
        KeyPair.create();
        byte[] publicKey = KeyPair.getPublicKey().getEncoded();
        byte[] privateKey = KeyPair.getPrivateKey().getEncoded();

        KeyPair.put(publicKey, "newPair/" + path + "/PublicKey");
        KeyPair.put(privateKey, "newPair/" + path + "/PrivateKey");
    }

    public String Encrypt(String path, String data) throws Exception {
        CreateKeyPair(path);
        String encrypted = asymmetric.encrypt(data, KeyAccess.getPublicKey("newPair/" + path + "/PublicKey"));
        return encrypted;
    }

    public String Decrypt(String path, String data) throws Exception {
        return asymmetric.decrypt(data, KeyAccess.getPrivateKey("newPair/" + path + "/PrivateKey"));
    }

}
