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
        // String uuid = UUID.randomUUID().toString();
        // SignificantRecord data = new SignificantRecord(
        //         uuid,
        //         "31-1-2023",
        //         "Malaysia",
        //         null,
        //         null,
        //         null,
        //         null,
        //         null,
        //         null
        // );

        //for add on after 1st entry (after farm) - need to give uuid
        String uuid = "80ea4502-a067-4147-816a-45497c7ed1c0";
        SignificantRecord data = new SignificantRecord(
                uuid,
                null,
                null,
                "11-1-2023",
                "Selangor",
                null,
                null,
                null,
                null
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
