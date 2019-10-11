package com.completedtasks.airline.view;

import com.completedtasks.airline.util.Controller;

import java.util.Scanner;

public class Viewer {
    private Controller controller;

    private int inputInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    private String inputLine(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
//not finished yet
    public void mainMenu(){
        System.out.println("Hello, welcome to our airline company." +
                "\nPlease, select command:"+
                "\n1-Create company."+
                "\n2-Load company from txt file");
        int choice=inputInt();
        switch(choice){
            case(1):
                createCompany();
                break;
            default:
                System.out.println("No such command");
        }
    }

    private void createCompany(){
        System.out.print("Please, choose the company name: ");
        String companyName = inputLine();
        System.out.println("Company "+companyName+" has been successfully created.");
        controller.createCompany(companyName);
    }
//not finished yet
    private void inCompanyMenu(){
        System.out.println("You are owner of company "+controller.getCompanyName()+"."+
                "\nWhat do you want to do?"+
                "\n1-Take a look at planes list"+
                "\n2-Add new plane"+
                "\n3-Change company name"+
                "\n4-Find plane");
        int choice = inputInt();
        switch(choice){
            case (1):

        }
    }
}
