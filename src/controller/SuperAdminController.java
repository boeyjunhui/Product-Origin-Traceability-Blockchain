package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import model.AuthRecord;
import model.SuperAdminRecord;

public class SuperAdminController {
    
    // login account
    public AuthRecord login(String username, String password) throws FileNotFoundException {
        BufferedReader superAdmin = new BufferedReader(new FileReader("SuperAdmin.txt"));
        
        Optional<SuperAdminRecord> superAdminLogin = superAdmin.lines()
                .map(line -> line.split("//"))
                .filter(data -> data[1].equals(username) && data[2].equals(password))
                .map(data -> new SuperAdminRecord(Integer.parseInt(data[0]), data[1], data[2]))
                .findFirst();
        
        return superAdminLogin.map(superAdminRecord -> new AuthRecord(superAdminRecord.superAdminID(), true))
            .orElse(new AuthRecord(0, false));
    }
    
}
