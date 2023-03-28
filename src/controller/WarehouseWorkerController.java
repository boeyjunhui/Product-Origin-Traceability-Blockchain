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
import model.WarehouseWorkerRecord;
import util.AddResultRecord;
import util.SignificantRecord;

public class WarehouseWorkerController {
    
    // login account
    public AuthRecord login(String username, String password) throws FileNotFoundException {
        BufferedReader warehouseWorker = new BufferedReader(new FileReader("WarehouseWorker.txt"));
        
        Optional<WarehouseWorkerRecord> warehouseWorkerLogin = warehouseWorker.lines()
                .map(line -> line.split("//"))
                .filter(data -> data[1].equals(username) && data[2].equals(password))
                .map(data -> new WarehouseWorkerRecord(Integer.parseInt(data[0]), data[1], data[2]))
                .findFirst();
        
        return warehouseWorkerLogin.map(warehouseWorkerRecord -> new AuthRecord(warehouseWorkerRecord.warehouseWorkerID(), true))
            .orElse(new AuthRecord(0, false));
    }


    //add new data
    public boolean addWarehouseData(String uuid, String storageDate, String storageLocation) throws Exception {
        Chain chain = new Chain();
        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();

        boolean isSuccess = false;

        // add data and combine with prev transaction data into new transaction
        SignificantRecord data = new SignificantRecord(
                uuid,
                null,
                null,
                null,
                null,
                storageDate,
                storageLocation,
                null,
                null
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
