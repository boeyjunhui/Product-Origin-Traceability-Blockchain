/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package block_chain;

import cryptography.Cryptography;
import cryptography.KeyAccess;
import digital_signature.MySignature;
import util.SearchRecord;
import util.SignificantRecord;

/**
 *
 * @author liewjy
 */
public class TestBlockChain {

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Chain chain = new Chain();
        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();

        //use for test only
        SignificantRecord data = new SignificantRecord(
                "code001",
                "harvest date",
                "farm loc",
                "prod date",
                "prod loc",
                "storege date",
                "loc",
                null,
                null
        );

        //create new public and private key pair
        cryptography.CreateKeyPair(data.productUniqueCode());
        //make digital signature
        String signature = sig.sign(
                data,
                KeyAccess.getPrivateKey(data.productUniqueCode())
        );

        //add
        // if(chain.add(data, signature)){
        //     System.out.println("added transaction");
        // } else {
        //     System.out.println("fail to add transaction");
        // }
        
        
        //search transaction
        //use for test only
        String searchID = "code001";

        //create search key pair
        cryptography.CreateKeyPair("id"+searchID);
        //make search digital signature
        String searchSignature = sig.signID(searchID, KeyAccess.getPrivateKey("id"+searchID));



        //search 
        SearchRecord searchResult  = chain.search(searchID, searchSignature);
        if(searchResult.isExist()) {
            System.out.println("found transaction");
            System.out.println(searchResult.significantRecord());
        } else {
            System.out.println("fail to find transaction");
        }
    }
}
