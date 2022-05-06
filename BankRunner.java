package com.company;


import java.util.Scanner;

public class BankRunner {

    public static void main(String[] args) {


            Bank SBIbank = new Bank();
            System.out.println("Welcome to SBIbank");
            int option;

            do {
                System.out.println("Choose the option");
                System.out.println("1. Create an account");
                System.out.println("2. Transfer Money to account");
                System.out.println("3. Add Money to Account");
                System.out.println("4. Check Balance");
                System.out.println("8. Exit");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                int id,recieverID,senderID;
                boolean login;
                double amount;

                String password;

                switch (option) {
                    case 1:
                        System.out.println("Enter your new User id");
                        id = sc.nextInt();
                        System.out.println("Enter new password");
                        password = sc.next();

                        SBIbank.addUser(id, password);
                        break;
                    case 2:
                        System.out.println("Enter your User id");
                        senderID = sc.nextInt();
                        System.out.println("Enter password");
                        password = sc.next();
                        login=SBIbank.VerifyCredentials(senderID,password);
                        if(login){
                            System.out.println("Enter reciever id :");
                            recieverID=sc.nextInt();
                            System.out.println("Enter the amount to transfer: ");
                            amount=sc.nextDouble();
                            SBIbank.sendMoney(senderID,password,recieverID,amount);
                        }else{
                            System.out.println("No user found");
                        }
                        break;

                    case 3:
                        System.out.println("Enter your User id");
                        id = sc.nextInt();
                        System.out.println("Enter password");
                        password = sc.next();
                        login=SBIbank.VerifyCredentials(id,password);
                        if(login){
                            System.out.println("Enter the amount to add: ");
                            amount =sc.nextDouble();
                            SBIbank.addMoney(id,amount);
                        }else{
                            System.out.println("User Not found");
                        }
                    case 4:
                        System.out.println("Enter your User id");
                        id = sc.nextInt();
                        System.out.println("Enter password");
                        password = sc.next();
                        login=SBIbank.VerifyCredentials(id,password);
                        if(login){
                            SBIbank.checkBalance(id);
                        }

                    case 8:
                        break;

                    default:
                        break;

                }
            } while (option != 8);

        }
    }


