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
    String readFromCsv(long accountNum) throws IOException{
        String line="false";
      //  boolean accountExists=false;
       // Scanner sc=new Scanner("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv");
        try{
            BufferedReader br = new BufferedReader(new FileReader("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv"));
            while ((line = br.readLine()) != null){
                String[] customer=line.split(",");
                if(Long.parseLong(customer[0])==accountNum){
//                    System.out.println("Account Number: "+customer[0]+" Name: "+customer[1]+" Balance: "+customer[2]);
                //accountExists=true;
                  //  break;
                    return line;
                }
            }
//            if(!accountExists){
//                System.out.println("Account does not exist");
//            }

        }catch (IOException e){
            e.printStackTrace();

        }

        return line;
    }
//    void updateCsv(Long accountNum,String name,double balance){
//        String line="false";
//        //  boolean accountExists=false;
//        // Scanner sc=new Scanner("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv");
//        try{
//            BufferedReader br = new BufferedReader(new FileReader("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv"));
////            BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv",true));
//            while ((line = br.readLine()) != null){
//                String[] customer=line.split(",");
//                if(Long.parseLong(customer[0])==accountNum){
//                    BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv",true));
//                    String str=String.format("%d,%s,%.2f\n",accountNum,name,balance);
//                    bw.write(str);
//                    bw.close();
//                    br.close();
//                    break;
////                    System.out.println("Account Number: "+customer[0]+" Name: "+customer[1]+" Balance: "+customer[2]);
//                    //accountExists=true;
//                    //  break;
//                 //   return line;
//                }
//            }
////            if(!accountExists){
////                System.out.println("Account does not exist");
////            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//
//        }
//
//       // return line;
//
//    }
void updateCsv(Long accountNum, String name, double balance) {
    try {
        File inputFile = new File("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/CustomerData.csv");
        File tempFile = new File("/Users/MAHI/IdeaProjects/Bank Operations/src/com/bankAccount/temp.csv");

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, true));

        String line;
        boolean accountUpdated = false;

        while ((line = br.readLine()) != null) {
            String[] customer = line.split(",");
            if (Long.parseLong(customer[0]) == accountNum) {
                String str = String.format("%d,%s,%.2f", accountNum, name, balance);
                bw.write(str + "\n");
                accountUpdated = true;
            } else {
                bw.write(line + "\n");
            }
        }

        br.close();
        bw.close();

        // Rename the temporary file to the original file
        if (accountUpdated) {
            if (!inputFile.delete()) {
                throw new IOException("Could not delete the original file");
            }
            if (!tempFile.renameTo(inputFile)) {
                throw new IOException("Could not rename the temporary file");
            }
        } else {
            tempFile.delete();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
