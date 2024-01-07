package com.bankAccount;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class BankAccount {
    Scanner in=new Scanner(System.in);
    CsvHandling obj=new CsvHandling();
    void createAccount(){
//        System.out.println("Enter the account number: ");
//        long acctNo=in.nextLong();
//        in.nextLine();

        Random random = new Random();
        long acctNo = (long) (random.nextDouble() * 9_000_000_000_000L) + 1_000_000_000_000L;
        System.out.println("Your account number is : "+acctNo);
        System.out.println("Enter your name: ");
        String name=in.nextLine();
        System.out.println("Enter the balance: ");
        double bal=in.nextDouble();
        obj.writeToCsv(acctNo,name,bal);

    }
    void getDetails(){
        System.out.println("Enter the account number: ");
        long acctNo=in.nextLong();
        try{
            validateAccountNumber(acctNo);

        }
        catch (Exception e){
            System.out.println( e.getMessage());

        }


//        try {
//            obj.readFromCsv(acctNo);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }
    void validateAccountNumber(long acctNo) throws Exception {
        String acctNoStr=Long.toString(acctNo);
        if(acctNoStr==null||acctNoStr.length()!=12|| !acctNoStr.matches("\\d+")){
            throw new Exception("Invalid input. Please enter a 12-digit number.");
        }
        obj.readFromCsv(acctNo);

    }

}
