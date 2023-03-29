package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

import block_chain.Chain;
import cryptography.Cryptography;
import cryptography.KeyAccess;
import digital_signature.MySignature;
import model.DisplaySearchSignificantRecord;
import model.ProductRecord;
import util.SearchResultRecord;
import util.SignificantRecord;

public class SearchController {

    //search using product unique code
    public DisplaySearchSignificantRecord search(String productUniqueCode) throws Exception {
        Chain chain = new Chain();
        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();

        boolean isSuccess = false;
        SignificantRecord significantRecord = null;

        //create search key pair
        cryptography.CreateKeyPair("id" + productUniqueCode);
        //make search digital signature
        String searchSignature = sig.signString(productUniqueCode, KeyAccess.getPrivateKey("id" + productUniqueCode));

        SearchResultRecord searchResult = chain.search(productUniqueCode, searchSignature);

        boolean isValid = sig.verifySearch(searchResult.searchRecord(), searchResult.returnSignature(), KeyAccess.getPublicKey("sid" + productUniqueCode));

        //check if data is untempered
        if (isValid) {
            if (searchResult.searchRecord().isExist()) {
                //transaction found
                significantRecord = searchResult.searchRecord().significantRecord();
                isSuccess = true;
            } else {
                //transaction not found
                isSuccess = false;
            }
        } else {
            //information tampered
            isSuccess = false;
        }
        return new DisplaySearchSignificantRecord(isSuccess, significantRecord);
    }

    public boolean searchProductTypeID(String productUniqueCode) throws FileNotFoundException {
        BufferedReader product = new BufferedReader(new FileReader("Product.txt"));
        Optional<ProductRecord> productRecord = null;

        productRecord = product.lines()
                .map(line -> line.split("//"))
                .filter(data -> data[0].equals(productUniqueCode))
                .map(data -> new ProductRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6])))
                .findFirst();

        return !productRecord.isEmpty();
    }
}
