package com.company;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer, user> users;

    Bank(){
        users = new HashMap<Integer, user>();
    }

    public void addUser(int id, String password){
        if(users.containsKey(id)){
            System.out.println("User id already exists");
        }else{
            user newUser = new user(id,password);
            users.put(id, newUser);
            System.out.println("Account successfully created");
        }
    }
    public void sendMoney(int id,String password,int destID,double amount){
        user sender = users.get(id);

            if (sender.getBalance() >= amount) {
                System.out.println("Transfering money");
                user reciever = users.get(destID);
                if(reciever==null){
                    System.out.println("Id not found");
                    return;
                }
                sender.setBalance(sender.getBalance() - amount);
                reciever.setBalance(reciever.getBalance() + amount);
                System.out.println("Transfering successfull");
                System.out.println("Your new balance is"+sender.getBalance());

            }else{
                System.out.println("Not sufficient balance");
            }


    }
    public boolean VerifyCredentials(int id,String password){
        user user= users.get(id);
        if(user == null){
            return false;
        }
        return user.verifyPassword(password);
    }
    public void addMoney(int id,double amount){
        user user=users.get(id);
        user.addBalance(amount);
        System.out.println("Sucessfully added money. \n your new balance is:  "+user.getBalance());

    }
    public void checkBalance(int id){
        user user=users.get(id);
        System.out.println("Your balance is: "+user.getBalance());
    }
}
