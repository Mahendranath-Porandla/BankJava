package com.bankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount obj=new BankAccount();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter 1 to create bank account and 2 to get details: \n 3 for deposit");
        int choice=in.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("Create a new bank account");
                obj.createAccount();
                break;
            }
            case 2: {
                System.out.println("Get the bank details by account number");
                System.out.println("Enter the bank account number");
                long acctNo=in.nextLong();
                obj.getDetails(acctNo);
                break;
            }
            case 3: {
                System.out.println("Enter the bank account number");
                long acctNo=in.nextLong();
                System.out.println("Enter the deposit amount: ");
                double depositAmount=in.nextDouble();
                obj.deposit(acctNo,depositAmount);
                break;
            }
        }

    }
}
