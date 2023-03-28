package block_chain;

import cryptography.Cryptography;
import cryptography.KeyAccess;
import digital_signature.MySignature;
import java.util.UUID;
import util.AddResultRecord;
import util.SignificantRecord;

public class TestBlockChainAdd {

    public static void main(String[] args) throws Exception {
        Chain chain = new Chain();
        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();

        //use for test only
        //for first add
        //  String uuid = UUID.randomUUID().toString();
        //  SignificantRecord data = new SignificantRecord(
        //          uuid,
        //          "12-2-2023",
        //          "Indonesia",
        //          null,
        //          null,
        //          null,
        //          null,
        //          null,
        //          null
        //  );

        //for add on after 1st entry (after farm) - need to give uuid
       String uuid = "98284b8a-65d8-4e61-be7a-434a3a4bc4a9";
       SignificantRecord data = new SignificantRecord(
               uuid,
               null,
               "test",
               "11-1-2023",
               "Selangor",
               "12-1-2023",
               "warehouse",
               "20-12-2023",
               "1"
       );

        //create new public and private key pair
        cryptography.CreateKeyPair(uuid);
        //make digital signature
        String signature = sig.sign(
                data,
                KeyAccess.getPrivateKey(uuid)
        );

        AddResultRecord addResult = chain.add(data, signature);
        boolean isValid = sig.verifyString(String.valueOf(addResult.isSuccess()), addResult.returnSignature(), KeyAccess.getPublicKey("aid" + uuid));
        //check if data is untempered
        if (isValid) {
            if (addResult.isSuccess()) {
                System.out.println("added transaction");
            } else {
                System.out.println("fail to add transaction");
            }
        } else {
            System.out.println("data is tampered");
        }
    }

}
