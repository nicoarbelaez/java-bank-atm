package org.example.account;

import java.util.Scanner;

import org.example.Util;
import org.example.enums.AccountType;

public class SavingsAccount extends Account {
    private String name;
    private String password;
    private boolean authenticated;

    public SavingsAccount(String name, String password, double balance) {
        super(balance, AccountType.SAVINGS);
        this.name = name;
        this.password = password;
    }

    @Override
    public void menuAuthentication(Scanner scanner) {
        showTypeAccount();
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        authenticate(name, password);
    }

    @Override
    public boolean authenticate(String name, String password) {
        authenticated = this.name.equals(name) && this.password.equals(password);
        return authenticated;
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

    private static void showTypeAccount() {
        Util.clearConsole();
        System.out.println("  _____             _                                                     _   ");
        System.out.println(" / ____|           (_)                     /\\                            | |  ");
        System.out.println("| (___   __ ___   ___ _ __   __ _ ___     /  \\   ___ ___ ___  _   _ _ __ | |_ ");
        System.out.println(" \\___ \\ / _` \\ \\ / / | '_ \\ / _` / __|   / /\\ \\ / __/ __/ _ \\| | | | '_ \\| __|");
        System.out.println(" ____) | (_| |\\ V /| | | | | (_| \\__ \\  / ____ \\ (_| (_| (_) | |_| | | | | |_ ");
        System.out.println("|_____/ \\__,_| \\_/ |_|_| |_|\\__, |___/ /_/    \\_\\___\\___\\___/ \\__,_|_| |_|\\__|");
        System.out.println("                             __/ |                                            ");
        System.out.println("                            |___/                                             ");

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
