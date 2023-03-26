package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import model.AdminAuthRecord;
import model.AdminRecord;

public class AdminController {
    
    // login account
    public AdminAuthRecord login(String username, String password) throws FileNotFoundException {
        BufferedReader admin = new BufferedReader(new FileReader("Admin.txt"));
        
        Optional<AdminRecord> adminLogin = admin.lines()
                .map(line -> line.split("//"))
                .filter(data -> data[1].equals(username) && data[2].equals(password))
                .map(data -> new AdminRecord(Integer.parseInt(data[0]), data[1], data[2]))
                .findFirst();
        
        return adminLogin.map(adminRecord -> new AdminAuthRecord(adminRecord.adminID(), true))
            .orElse(new AdminAuthRecord(0, false));
    }
    
}
