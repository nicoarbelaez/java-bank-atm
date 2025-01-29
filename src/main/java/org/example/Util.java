package org.example;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.example.account.Account;
import org.example.enums.AccountType;

public class Util {

    /**
     * Generates a random integer within a specific range (minimum and maximum).
     * 
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random integer between the minimum and maximum values.
     * @throws IllegalArgumentException If the minimum value is greater than the
     *                                  maximum value.
     */
    public static int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The minimum value cannot be greater than the maximum value.");
        }

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Generates a random double within a specific range (minimum and maximum) with
     * two decimal places.
     * 
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random double between the minimum and maximum values with two
     *         decimal places.
     * @throws IllegalArgumentException If the minimum value is greater than the
     *                                  maximum value.
     */
    public static double generateRandomDouble(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("The minimum value cannot be greater than the maximum value.");
        }

        double randomValue = ThreadLocalRandom.current().nextDouble(min, max);
        return Math.round(randomValue * 100.0) / 100.0; // Round to 2 decimal places
    }

    /**
     * Finds an account with a specific account number in a list of accounts.
     * 
     * @param accounts      The list of accounts to search.
     * @param accountNumber The account number to search for.
     * @return The account with the specified account number, or null if no account
     */
    public static Account findAccount(ArrayList<Account> accounts, String accountNumber) {
        return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst()
                .orElse(null);
    }

    /**
     * Clears the console screen.
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a random account type.
     * 
     * @return A random account type.
     */
    public static AccountType getRandomAccountType() {
        AccountType[] accountTypes = AccountType.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(accountTypes.length);
        return accountTypes[randomIndex];
    }
}
