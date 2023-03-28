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
import model.ProductRecord;

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
    public Optional<ProductRecord> viewOneProduct(String productUniqueCode) throws IOException {
        BufferedReader product = new BufferedReader(new FileReader("Product.txt"));
        
        Optional<ProductRecord> productRecord = product.lines()
                .map(line -> line.split("//"))
                .filter(data -> data[0].equals(productUniqueCode))
                .map(data -> new ProductRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6])))
                .findFirst();

        return productRecord;
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
    
}
