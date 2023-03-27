package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import model.AuthRecord;
import model.FarmerRecord;

public class FarmerController {
    
    // login account
    public AuthRecord login(String username, String password) throws FileNotFoundException {
        BufferedReader farmer = new BufferedReader(new FileReader("Farmer.txt"));
        
        Optional<FarmerRecord> farmerLogin = farmer.lines()
                .map(line -> line.split("//"))
                .filter(data -> data[1].equals(username) && data[2].equals(password))
                .map(data -> new FarmerRecord(Integer.parseInt(data[0]), data[1], data[2]))
                .findFirst();
        
        return farmerLogin.map(farmerRecord -> new AuthRecord(farmerRecord.farmerID(), true))
            .orElse(new AuthRecord(0, false));
    }
    
    // update product unique code
    public boolean updateProductUniqueCode(int productID) throws IOException {
        String line;
        String[] lineArray;
        String productName, productDescription, ingredient, nutrition, weight, price;
        String productUniqueCode = "ad7699bc-9209-4ebd-84a7-d9e86fc7fc32";
        ArrayList<String> tempData = new ArrayList<>();
        
        BufferedReader product = new BufferedReader(new FileReader("Product.txt"));
        
        while ((line = product.readLine()) != null) {
            lineArray = line.split("//");
            
            if (lineArray[0].equals(Integer.toString(productID))) {
                productName = lineArray[1];
                productDescription = lineArray[2];
                ingredient = lineArray[3];
                nutrition = lineArray[4];
                weight = lineArray[5];
                price = lineArray[6];
                
                tempData.add(productID + "//" + productName + "//" + productDescription + "//" + ingredient + "//" + nutrition + "//" + weight + "//" + price + "//" + productUniqueCode + "//");
            } else {
                tempData.add(line);
            }
        }
        
        product.close();
        
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Product.txt")))) {
            for (String newData : tempData) {
                printWriter.println(newData);
            }
            
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return true;
    }
    
}
