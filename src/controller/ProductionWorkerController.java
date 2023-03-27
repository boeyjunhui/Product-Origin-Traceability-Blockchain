package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import model.AuthRecord;
import model.ProductionWorkerRecord;

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
    
}
