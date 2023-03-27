package digital_signature;


import cryptography.Cryptography;
import cryptography.KeyAccess;
import util.SignificantRecord;

public class TestSignature {

    public static void main(String[] args) throws Exception {

        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();

        //use for test only
        String path = "test2";
        //String data = "Simple digital signature demo";

        SignificantRecord data = new SignificantRecord("code1", "harvest date", "farm loc", null, null, null, null, null, null);

        //create new public and private key pair
        cryptography.CreateKeyPair(path);

        //make digital signature
        String signature = sig.sign(data, KeyAccess.getPrivateKey(path));
        //check signature
        boolean isValid = sig.verify(data, signature, KeyAccess.getPublicKey(path));
        System.out.println((isValid) ? ">> Correct!" : ">> Incorrect!");

    }

}
