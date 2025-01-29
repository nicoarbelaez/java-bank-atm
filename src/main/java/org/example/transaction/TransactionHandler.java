package org.example.transaction;

import org.example.exception.InsufficientFundsException;

public interface TransactionHandler {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
}
