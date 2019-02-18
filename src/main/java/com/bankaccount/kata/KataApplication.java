package com.bankaccount.kata;

import com.bankaccount.kata.domain.Account;
import com.bankaccount.kata.domain.Amount;
import com.bankaccount.kata.domain.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class KataApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(KataApplication.class, args);
		System.out.println("THIS IS MY KATA");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		//Init Account with 0 of balance
		Account account = new Account(new Amount(0));

		//U.S 1 : Make some Deposits
		Transaction firstDeposit = new Transaction(new Amount(5000), sdf.parse("18/02/2019"), "first deposit");
		account.deposit(firstDeposit);

		Transaction secondDeposit = new Transaction(new Amount(3000), sdf.parse("20/02/2019"), "second deposit");
		account.deposit(secondDeposit);

		// U.S 2 : Make some withdrawals
		Transaction firstWithdraw= new Transaction(new Amount(2000), sdf.parse("15/03/2019"), "first withdraw");
		account.withdrawal(firstWithdraw);

		Transaction secondeWithdraw = new Transaction(new Amount(1000), sdf.parse("15/03/2019"), "first withdraw");
		account.withdrawal(secondeWithdraw);


		// U.S 2 : check my operations
		System.out.println(account.toString());

	}

}
