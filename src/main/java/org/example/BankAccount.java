package org.example;

import java.util.logging.*;
import java.util.*;

class BankAccount
{
    public static void main (String[]arg)
    {
        Scanner s = new Scanner (System.in);
        Logger l=Logger.getLogger("My Logger");

        l.log(Level.INFO, () ->"Enter the Holder Name:");
        String hname = s.nextLine ();

        l.log(Level.INFO, () ->"Enter the Account Number:");
        int ano = s.nextInt ();

        double balance = 0.0;
        double damt;
        double wamt;

        Payment p = new Payment (hname, ano);

        while(true)
        {
            l.log(Level.INFO, () ->"select your payment method \n1. Deposit \n2. Withdraw \n3. Balance \n0.Exit");
            int ch = s.nextInt ();
            switch (ch) {
                case 1 -> {
                    l.info("Your Deposit Amount :");
                    damt = s.nextDouble();
                    balance = p.deposit(damt, balance);
                    l.log(Level.INFO, () ->"Your Balance :" + balance);
                }
                case 2 -> {
                    l.info("Your Withdraw Amount :");
                    wamt = s.nextDouble();
                    if (balance < wamt) {
                        l.log(Level.INFO, () ->"Your Amount balance : " + balance + ". so, didn't withdraw Amount.");
                    } else {
                        balance = p.withdraw(wamt, balance);
                        l.log(Level.INFO, () ->"Your Current Amount :" + balance);
                    }
                }
                case 3 -> p.amount(balance);
                default -> System.exit(0);
            }
        }
    }

}
