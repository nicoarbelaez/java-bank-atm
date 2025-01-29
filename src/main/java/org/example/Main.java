package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import org.example.account.Account;
import org.example.account.CheckingAccount;
import org.example.account.InvestimentAccount;
import org.example.account.SavingsAccount;
import org.example.enums.AccountType;

public class Main {

    private static final ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        randomData();

        start();
    }

    public static void start() {
        showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter \"exit\" to close the application.");
        System.out.println("[1] Sign in to an account");
        System.out.println("[2] Create account");
        System.out.print(">> ");

        String option = scanner.nextLine();
        switch (option) {
            case "1":
                signIn(scanner);
                break;
            case "2":
                signUp(scanner);
                break;
            case "exit":
                System.out.println("Goodbye!");
                break;
            default:
                start();
                break;
        }
        scanner.close();
    }

    public static void signIn(Scanner scanner) {
        String accountNumber = "";
        Account account = null;
        do {
            if (accountNumber != "") {
                showWelcomeMessage();
                System.out.println("Account not found. Please try again.");
            }
            System.out.println("Enter your account number:");

            accountNumber = scanner.nextLine();

            account = Util.findAccount(accounts, accountNumber);
        } while (account == null);

        account.menuAuthentication(scanner);
    }

    public static void signUp(Scanner scanner) {
        System.out.println("Account type:");

        AccountType[] accountType = AccountType.values();
        for (int i = 0; i < accountType.length; i++) {
            System.out.println("[" + (i + 1) + "] " + Util.capitalizeFirstLetter(accountType[i].toString()));
        }
        System.out.print(">> ");

        String typeAccountOption = scanner.nextLine();

        if (typeAccountOption.equals("exit")) {
            start();
            return;
        }

        if (!Util.isNumeric(typeAccountOption)) {
            System.out.println("Invalid option. Please try again.");
            signUp(scanner);
            return;
        }

        int parseIntOption = Integer.parseInt(typeAccountOption);
        if (parseIntOption < 1 || parseIntOption > AccountType.values().length) {
            System.out.println("Invalid option. Please try again.");
            signUp(scanner);
            return;
        }

        System.out.print("Enter your name:");
        String name = scanner.nextLine();

        System.out.print("Enter your password:");
        String password = scanner.nextLine();

        System.out.print("Enter your balance:");
        double balance = scanner.nextDouble();

        createAccount(name, password, balance, AccountType.values()[parseIntOption - 1]);

        Account account = accounts.get(accounts.size() - 1);
        System.out.println("Account created successfully!");
        System.out.println("Your account number is: " + account.getAccountNumber());
    }

    public static void createAccount(String name, String password, double balance, AccountType accountType) {
        switch (accountType) {
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

            createAccount(name, password, balance, Util.getRandomAccountType());
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
