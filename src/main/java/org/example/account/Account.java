package org.example.account;

import java.sql.Date;
import java.util.ArrayList;

import org.example.enums.AccountType;
import org.example.enums.TypeTransaction;
import org.example.exception.InsufficientFundsException;
import org.example.transaction.Transaction;
import org.example.transaction.TransactionHandler;

public abstract class Account implements AccountAuthentication, TransactionHandler {
    private String accountNumber;
    private double balance;
    private AccountType accountType;
    private Date dateCreated;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(double balance, AccountType accountType) {
        this.accountNumber = "A" + System.currentTimeMillis();
        this.balance = balance;
        this.accountType = accountType;
        this.dateCreated = new Date(System.currentTimeMillis());
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(amount, TypeTransaction.DEPOSIT));
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds to withdraw " + amount);
        }
        balance -= amount;
        transactions.add(new Transaction(amount, TypeTransaction.WITHDRAWAL));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
