package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import org.example.account.Account;
import org.example.account.CheckingAccount;
import org.example.account.InvestimentAccount;
import org.example.account.SavingsAccount;

public class Main {

    private static final ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        randomData();
        showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter \"exit\" to close the application.");

        String accountNumber = "";
        Account account = null;
        do {
            if (accountNumber != "") {
                System.out.println("Account not found. Please try again.");
            }
            System.out.println("Enter your account number:");

            accountNumber = scanner.nextLine();

            if (accountNumber.equals("exit")) {
                break;
            }

            account = Util.findAccount(accounts, accountNumber);
        } while (account == null);

        scanner.close();
    }

    public static void randomData() {
        double initialBalanceFirstAccount = Util.generateRandomDouble(500, 10000);
        accounts.add(new SavingsAccount("Juan P", "123", initialBalanceFirstAccount));
        accounts.get(0).setAccountNumber("A123");
        ;
        accounts.get(0).deposit(500);

        int amountAccount = Util.generateRandomInt(10, 50);
        for (int i = 0; i < amountAccount; i++) {
            double balance = Util.generateRandomDouble(10, 100);
            String name = "Account " + (i + 1);
            String password = "123" + (char) Util.generateRandomInt(65, 122);

            switch (Util.getRandomAccountType()) {
                case SAVINGS:
                    accounts.add(new SavingsAccount(name, password, balance));
                    break;
                case CHECKING:
                    accounts.add(new CheckingAccount(balance));
                    break;
                case INVESTMENT:
                    accounts.add(new InvestimentAccount(balance));
                    break;
            }
        }
    }

    /**
     * Muestra el mensaje de bienvenida y el logo del banco.
     */
    public static void showWelcomeMessage() {
        printBankLogo();
        printLoginMessage();
    }

    /**
     * Imprime el logo del banco con arte ASCII.
     */
    private static void printBankLogo() {
        Util.clearConsole();
        System.out.println("         _                  ____              _    ");
        System.out.println("        | | __ ___   ____ _| __ )  __ _ _ __ | | __");
        System.out.println("     _  | |/ _` \\ \\ / / _` |  _ \\ / _` | '_ \\| |/ /");
        System.out.println("    | |_| | (_| |\\ V / (_| | |_) | (_| | | | |   < ");
        System.out.println("     \\___/ \\__,_| \\_/ \\__,_|____/ \\__,_|_| |_|_|\\_\\");
        System.out.println("        _  _____ __  __                            ");
        System.out.println("       / \\|_   _|  \\/  |                           ");
        System.out.println("      / _ \\ | | | |\\/| |                           ");
        System.out.println("     / ___ \\| | | |  | |                           ");
        System.out.println("    /_/   \\_\\_| |_|  |_|                           \n");
        System.out.println("\t\t\t\t\t\t" + accounts.size() + " Accounts");
    }

    /**
     * Imprime el mensaje que invita a iniciar sesión.
     */
    private static void printLoginMessage() {
        System.out.println("Welcome to Java Bank!");
        System.out.println("Please, log in to access your account.");
        System.out.println("=====================================");
    }
}
