package com.bankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount obj=new BankAccount();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter 1 to create bank account and 2 to get details: ");
        int choice=in.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("Create a new bank account");
                obj.createAccount();
                break;
            }
            case 2: {
                System.out.println("Get the bank details by account number");
                obj.getDetails();
                break;
            }
        }

    }
}
