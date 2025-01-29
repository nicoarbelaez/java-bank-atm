package org.example.account;

public interface AccountAuthentication {
    
    boolean authenticate(String name, String password);
    
    boolean isAuthenticated();
    
    void changePassword(String newPassword);

    void logout();
}
