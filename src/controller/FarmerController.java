package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    
}
