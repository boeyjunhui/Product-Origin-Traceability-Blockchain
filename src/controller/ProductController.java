package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import block_chain.Chain;
import cryptography.Cryptography;
import cryptography.KeyAccess;
import digital_signature.MySignature;
import model.DisplaySearchRecord;
import model.ProductRecord;
import util.SearchResultRecord;
import util.SignificantRecord;

public class ProductController {

    // calculate product id
    public int calculateProductTypeID() throws FileNotFoundException {
        BufferedReader product = new BufferedReader(new FileReader("Product.txt"));

        int productTypeID = product.lines()
                .map(line -> line.split("//"))
                .map(data -> new ProductRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6])))
                .reduce((first, second) -> second)
                .get()
                .productTypeID();

        return productTypeID + 1;
    }

    // add product
    public boolean addProductType(ProductRecord productRecord) throws FileNotFoundException, IOException {
        boolean dataExist;

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Product.txt", true)));
        BufferedReader product = new BufferedReader(new FileReader("Product.txt"));

        dataExist = product.lines()
                .map(line -> line.split("//"))
                .map(data -> new ProductRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6])))
                .anyMatch(productData -> productData.productTypeID() == productRecord.productTypeID());

        if (dataExist) {
            return false;
        } else {
            printWriter.printf("%s//%s//%s//%s//%s//%s//%s//\n", productRecord.productTypeID(), productRecord.productName(), productRecord.productDescription(), productRecord.ingredient(), productRecord.nutrition(), productRecord.weight(), productRecord.price());
            printWriter.close();
            return true;
        }
    }

    // view a single product
    public DisplaySearchRecord viewOneProduct(String productUniqueCode) throws Exception {

        Chain chain = new Chain();
        Cryptography cryptography = new Cryptography();
        MySignature sig = new MySignature();
        Optional<ProductRecord> productRecord = null;
        SignificantRecord significantRecord = null;
        boolean isExist = false;

        //create search key pair
        cryptography.CreateKeyPair("id" + productUniqueCode);
        //make search digital signature
        String searchSignature = sig.signString(productUniqueCode, KeyAccess.getPrivateKey("id" + productUniqueCode));

        //search 
        SearchResultRecord searchResult = chain.search(productUniqueCode, searchSignature);

        boolean isValid = sig.verifySearch(searchResult.searchRecord(), searchResult.returnSignature(), KeyAccess.getPublicKey("sid" + productUniqueCode));

        //check if data is untempered
        if (isValid) {
            if (searchResult.searchRecord().isExist()) {
                System.out.println("data is found");

                significantRecord = searchResult.searchRecord().significantRecord();
                //get insignificant data
                BufferedReader product = new BufferedReader(new FileReader("Product.txt"));

                productRecord = product.lines()
                        .map(line -> line.split("//"))
                        .filter(data -> data[0].equals(searchResult.searchRecord().significantRecord().productTypeID()))
                        .map(data -> new ProductRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6])))
                        .findFirst();

                isExist = !productRecord.isEmpty();
            } else {
                System.out.println("data not found");
                isExist = false;
            }
        } else {
            System.out.println("data is tampered");
            isExist = false;
        }
        return new DisplaySearchRecord(isExist, productRecord, significantRecord);
    }

    // view all products
    public List<ProductRecord> viewAllProducts() throws IOException {
        BufferedReader product = new BufferedReader(new FileReader("Product.txt"));

        List<ProductRecord> productRecord = product.lines()
                .map(line -> line.split("//"))
                .map(data -> new ProductRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6])))
                .collect(Collectors.toList());

        return productRecord;
    }

    //view all record from blockchain
    public List<SignificantRecord> viewAllUniqueProductCode() throws Exception {
        Chain chain = new Chain();
        return chain.viewAllTransaction(); 
    }

}
