package com.bankaccount.kata.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private Amount amount;
    private Date date;
    private String operation;

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private static final String SIMPLE_SPACE = "   ";

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);


    public Transaction(Amount amount, Date date, String operation) {
        this.amount = amount;
        this.date = date;
        this.operation = operation;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(addOpperation()).append(addDate()).append(addAmount());
        return stringBuilder.toString();
    }

    private StringBuilder addOpperation(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(operation).append(SIMPLE_SPACE +"|");

        return stringBuilder;
    }

    private StringBuilder addDate(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(simpleDateFormat.format(date)).append(SIMPLE_SPACE +"|");

        return stringBuilder;
    }

    private StringBuilder addAmount(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(amount.toMoneyFormat()).append(SIMPLE_SPACE +"|");

        return stringBuilder;
    }

    public Amount getBalanceAfterTransaction(Amount currentBalance) {
        return currentBalance.addValue(amount.getValue());
    }


}
