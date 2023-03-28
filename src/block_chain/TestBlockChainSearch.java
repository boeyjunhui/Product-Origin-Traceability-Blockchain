package block_chain;

import cryptography.Cryptography;
import cryptography.KeyAccess;
import digital_signature.MySignature;
import util.SearchResultRecord;

public class TestBlockChainSearch {

    public static void main(String[] args) throws Exception {
        Chain chain = new Chain();
        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();

        //search transaction
        //use for test only
        String searchID = "98284b8a-65d8-4e61-be7a-434a3a4bc4a9";

        //create search key pair
        cryptography.CreateKeyPair("id" + searchID);
        //make search digital signature
        String searchSignature = sig.signString(searchID, KeyAccess.getPrivateKey("id" + searchID));

        //search 
        SearchResultRecord searchResult = chain.search(searchID, searchSignature);

        boolean isValid = sig.verifySearch(searchResult.searchRecord(), searchResult.returnSignature(), KeyAccess.getPublicKey("sid" + searchID));
        //check if data is untempered
        if (isValid) {
            if (searchResult.searchRecord().isExist()) {
                System.out.println("data is found");
                System.out.println(searchResult.searchRecord().significantRecord());
            } else {
                System.out.println("data not found");
            }
        } else {
            System.out.println("data is tampered");
        }
    }
}
