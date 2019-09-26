package com.completedtasks.unit1.part2;

import java.util.Scanner;

/**Task condition:
 * В молодом возрасте дракон каждый год отращивает по три головы, но после того, как ему исполнится 200 лет – только
 * по две, а после 300 лет – лишь по одной. Предполагается, что дракон появляется на свет сразу с тремя головами.
 * Разработайте программу, которая высчитывала бы, сколько голов и глаз у дракона, которому N лет?
 */
public class DragonHeads {
    private static int countHeads(int age){
        int heads=3;
      for (int year=0; year<age; year++){
            if (year<200) heads+=3;
            else heads+= year<300? 2:1;
        }
        return heads;
    }
    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app(){
        Scanner input = new Scanner (System.in);
        System.out.print("Please, enter dragon's age: ");
        int age=input.nextInt();
        //By task condition number has to be 7-digit
        while (age<=0) {
            System.out.println("Invalid data. Age must be bigger than 0. Try again:");
            age=input.nextInt();
        }
        int heads=countHeads(age);
        System.out.println("Result: \nAmount of heads: "+heads+"\nAmount of eyes: "+heads*2);
    }
}
