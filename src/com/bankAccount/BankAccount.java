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
    void getDetails(long acctNo){
//        System.out.println("Enter the account number: ");
//        long acctNo=in.nextLong();
        try{
            boolean flag = validateAccountNumber(acctNo);
            if(flag){
                String str = obj.readFromCsv(acctNo);
        if(str.equals("false")){
            System.out.println("account does not exist");
        }
        String[] customer=str.split(",");
        System.out.println("Account Number: "+customer[0]+" Name: "+customer[1]+" Balance: "+customer[2]);
            }

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
    void deposit(long acctNo,double depositAmount){
        try{
            boolean flag = validateAccountNumber(acctNo);
            if(flag){
                String str = obj.readFromCsv(acctNo);
                if(str.equals("false")){
                    System.out.println("account does not exist");
                }
                String[] customer=str.split(",");
               // System.out.println("Account Number: "+customer[0]+" Name: "+customer[1]+" Balance: "+customer[2]);
                obj.updateCsv(acctNo,customer[1],(Double.parseDouble(customer[2])+depositAmount));
                getDetails(acctNo);
            }

        }
        catch (Exception e){
            System.out.println( e.getMessage());

        }


    }
    boolean validateAccountNumber(long acctNo) throws Exception {
        String acctNoStr=Long.toString(acctNo);
        if(acctNoStr==null||acctNoStr.length()!=13|| !acctNoStr.matches("\\d+")){
            throw new Exception("Invalid input. Please enter a 12-digit number.");

        }
        return true;
//        String str = obj.readFromCsv(acctNo);
//        if(str.equals("false")){
//            System.out.println("account does not exist");
//        }
//        String[] customer=str.split(",");
//        System.out.println("Account Number: "+customer[0]+" Name: "+customer[1]+" Balance: "+customer[2]);


    }

}
