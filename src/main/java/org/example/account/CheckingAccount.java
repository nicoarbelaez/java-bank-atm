package org.example.account;

import java.util.Scanner;

import org.example.enums.AccountType;

public class CheckingAccount extends Account {

    public CheckingAccount(double balance) {
        super(balance, AccountType.CHECKING);
    }

    @Override
    public void menuAuthentication(Scanner scanner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menuAuthentication'");
    }

    @Override
    public boolean authenticate(String name, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }

    @Override
    public boolean isAuthenticated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAuthenticated'");
    }

    @Override
    public void changePassword(String newPassword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePassword'");
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

}
