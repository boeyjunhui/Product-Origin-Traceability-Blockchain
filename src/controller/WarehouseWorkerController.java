package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import model.AuthRecord;
import model.WarehouseWorkerRecord;

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
    
}
