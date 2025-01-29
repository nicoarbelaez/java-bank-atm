package org.example.transaction;

import java.sql.Date;

import org.example.enums.TypeTransaction;

public class Transaction {
    private String id;
    private double amount;
    private TypeTransaction description;
    private Date transactionDate;

    public Transaction(double amount, TypeTransaction description) {
        this.id = "T" + System.currentTimeMillis();
        this.amount = amount;
        this.description = description;
        this.transactionDate = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return id + "\t" + transactionDate + "\t" + amount + "\t" + description;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public TypeTransaction getDescription() {
        return description;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}
