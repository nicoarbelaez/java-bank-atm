package org.example.account;

import org.example.enums.AccountType;

public class SavingsAccount extends Account implements AccountAuthentication {
    private String name;
    private String password;
    private boolean authenticated;

    public SavingsAccount(String name, String password, double balance) {
        super(balance, AccountType.SAVINGS);
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean authenticate(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void changePassword(String newPassword) {
        password = newPassword;
    }

    @Override
    public void logout() {
        authenticated = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
