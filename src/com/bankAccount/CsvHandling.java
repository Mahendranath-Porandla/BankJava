package com.bankAccount;

import java.io.*;

public class CsvHandling {
    void writeToCsv(Long accountNum,String name,double balance){

        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv",true));
            String str=String.format("%d,%s,%.2f\n",accountNum,name,balance);
            bw.write(str);
            bw.close();


        }catch (IOException e){
            e.printStackTrace();
        }



    }
    void readFromCsv(long accountNum) throws IOException{
        String line;
        boolean accountExists=false;
       // Scanner sc=new Scanner("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv");
        try{
            BufferedReader br = new BufferedReader(new FileReader("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv"));
            while ((line = br.readLine()) != null){
                String[] customer=line.split(",");
                if(Long.parseLong(customer[0])==accountNum){
                    System.out.println("Account Number: "+customer[0]+" Name: "+customer[1]+" Balance: "+customer[2]);
                    accountExists=true;
                    break;

                }
            }
            if(!accountExists){
                System.out.println("Account does not exist");
            }




        }catch (IOException e){
            e.printStackTrace();

        }

    }
}
