package org.example.account;

import java.util.Scanner;

public interface AccountAuthentication {
    
    void menuAuthentication(Scanner scanner);

    boolean authenticate(String name, String password);
    
    boolean isAuthenticated();
    
    void changePassword(String newPassword);

    void logout();
}
