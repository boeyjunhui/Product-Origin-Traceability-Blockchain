package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

import block_chain.Chain;
import cryptography.Cryptography;
import cryptography.KeyAccess;
import digital_signature.MySignature;
import model.AuthRecord;
import model.ProductionWorkerRecord;
import util.AddResultRecord;
import util.SignificantRecord;

public class ProductionWorkerController {

    // login account
    public AuthRecord login(String username, String password) throws FileNotFoundException {
        BufferedReader productionWorker = new BufferedReader(new FileReader("ProductionWorker.txt"));

        Optional<ProductionWorkerRecord> productionWorkerLogin = productionWorker.lines()
                .map(line -> line.split("//"))
                .filter(data -> data[1].equals(username) && data[2].equals(password))
                .map(data -> new ProductionWorkerRecord(Integer.parseInt(data[0]), data[1], data[2]))
                .findFirst();

        return productionWorkerLogin.map(productionWorkerRecord -> new AuthRecord(productionWorkerRecord.productionWorkerID(), true))
                .orElse(new AuthRecord(0, false));
    }

    //add new data
    public boolean addProductionData(String uuid, String productionDate, String productionLocation,String ExpiryDate, String ProductID) throws Exception {
        Chain chain = new Chain();
        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();

        boolean isSuccess = false;

        // add data and combine with prev transaction data into new transaction
        SignificantRecord data = new SignificantRecord(
                uuid,
                null,
                null,
                productionDate,
                productionLocation,
                null,
                null,
                ExpiryDate,
                ProductID
        );

        //create new public and private key pair
        cryptography.CreateKeyPair(uuid);
        //make digital signature
        String signature = sig.sign(data, KeyAccess.getPrivateKey(uuid));

        AddResultRecord addResult = chain.add(data, signature);
        boolean isValid = sig.verifyString(String.valueOf(addResult.isSuccess()), addResult.returnSignature(), KeyAccess.getPublicKey("aid" + uuid));

        //check if data is untempered
        if (isValid) {
            if (addResult.isSuccess()) {
                System.out.println("added transaction");
                isSuccess = true;
            } else {
                isSuccess = false;
                System.out.println("fail to add transaction");
            }
        } else {
            isSuccess = false;
            System.out.println("data is tampered");
        }
        return isSuccess;
    }

}
