package com.completedtasks;

import com.completedtasks.airline.view.Viewer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Launchers launcher = new Launchers();
        System.out.println("Welcome stranger. Here's available units:" +
                "\n1) Main task one" +
                "\n2) Main task two" +
                "\n3) Main task three" +
                "\n4) Main task four"+
                "\n0) Exit" +
                "\nPlease, choose the unit number");
        int choice;
        while (true) {
            choice = input.nextInt();
            if (choice > 4 | choice < 0) System.out.println("No such unit number. Please, try again.");
            else break;
        }
        switch (choice) {
            case (1):
                launcher.mainTaskOneLauncher();
                break;
            case (2):
                launcher.mainTaskTwoLauncher();
                break;
            case (3):
                launcher.mainTaskThreeLauncher();
                break;
            case(4):
                Viewer runner = new Viewer();
                runner.run();
                break;
            default:
                System.exit(0);
        }
    }
}
