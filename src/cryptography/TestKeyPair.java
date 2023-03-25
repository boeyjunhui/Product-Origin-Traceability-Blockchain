package cryptography;

public class TestKeyPair {

    public static void main(String[] args) {
        Cryptography cryptography = new Cryptography();

        //use for test only
        String encryptedData = null;
        String decryptedData;

        try {
            encryptedData
                    = cryptography.Encrypt("test1", "this is a message to encrypt");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail to encrypt");
        }

        try {
            decryptedData
                    = cryptography.Decrypt("test1", encryptedData);
                        System.out.println("Decrypted: " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail to decrypt");

        }
    }
}
