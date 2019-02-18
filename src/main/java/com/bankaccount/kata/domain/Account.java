package com.bankaccount.kata.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private Amount balance;

    private List<Statement> listOfStatement;

    public Account() {
    }

    public Account(Amount balance) {
        this.balance = balance;
        this.listOfStatement = new ArrayList<>();
    }

    public Amount getBalance() {
        return balance;
    }


    public void withdrawal(Transaction transaction) {

        Transaction negativeTransaction = new Transaction(new Amount(transaction.getAmount().getNegativeValue()),
                transaction.getDate(), transaction.getOperation());

        addNewTransaction(negativeTransaction);
    }

    public void deposit(Transaction transaction) {

        addNewTransaction(transaction);
    }


    private void addNewTransaction(Transaction newTransaction) {
        balance= newTransaction.getBalanceAfterTransaction(balance);
        listOfStatement.add(new Statement(newTransaction, balance));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Statement statementLine : listOfStatement) {
            stringBuilder.append(statementLine.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
