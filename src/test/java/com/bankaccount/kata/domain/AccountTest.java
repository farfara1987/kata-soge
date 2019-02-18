package com.bankaccount.kata.domain;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
public class AccountTest  {

    Account emptyaccount;
    Account accountWithMoney;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Before
    public void initBeforeTest(){
        emptyaccount = new Account(new Amount(0));
        accountWithMoney = new Account(new Amount(2000));
    }

    //User Story 1 : makes some Deposit
    @Test
    public void depositAccountTest() throws ParseException {
        this.emptyaccount.deposit(new Transaction(new Amount(1000), simpleDateFormat.parse("01/02/2019"),  "first Deposit"));
        this.emptyaccount.deposit(new Transaction(new Amount(500), simpleDateFormat.parse("015/02/2019"),  "second Deposit"));

        Account accountExpected = new Account(new Amount(1500));

        Assert.assertEquals(accountExpected.getBalance(), this.emptyaccount.getBalance());

    }

    //User Story 2 : makes some withdrawals
    @Test
    public void withdrawalAccountTest() throws ParseException {

        this.accountWithMoney.withdrawal(new Transaction(new Amount(200), simpleDateFormat.parse("01/02/2019"),  "first withdrawal"));
        this.accountWithMoney.withdrawal(new Transaction(new Amount(300), simpleDateFormat.parse("015/02/2019"),  "second withdrawal"));

        Account accountExpected = new Account(new Amount(1500));

        Assert.assertEquals(accountExpected.getBalance(), this.accountWithMoney.getBalance());

    }

}
