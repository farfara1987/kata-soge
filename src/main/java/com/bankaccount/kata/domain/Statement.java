package com.bankaccount.kata.domain;

public class Statement {

    private Transaction transaction;
    private Amount currentBalanceOfStatement;

    private static final String SIMPLE_SPACE = "   ";

    public Statement() {
    }

    public Statement(Transaction transaction, Amount currentBalanceOfStatement) {
        this.transaction = transaction;
        this.currentBalanceOfStatement = currentBalanceOfStatement;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Amount getCurrentBalanceOfStatement() {
        return currentBalanceOfStatement;
    }

    public void setCurrentBalanceOfStatement(Amount currentBalanceOfStatement) {
        this.currentBalanceOfStatement = currentBalanceOfStatement;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(transaction.toString()).append(addCurrentBalance());
        return stringBuilder.toString();

    }

    private StringBuilder addCurrentBalance(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentBalanceOfStatement.toMoneyFormat()).append(SIMPLE_SPACE +"|");
        return stringBuilder;
    }
}
