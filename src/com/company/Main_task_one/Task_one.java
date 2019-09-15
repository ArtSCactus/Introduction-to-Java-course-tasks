package com.company.Main_task_one;

import java.util.Scanner;

/** Task condition:
 * Разработайте программу, которая проверяет, что числа a, b и c различны (одинаковы).
 */
public class Task_one {
    /** Checks three numbers are they equals or not.
     *
     * @param numberA
     * @param numberB
     * @param numberC
     * @return true if all three numbers are equals. False otherwise.
     */
    private static boolean is_different (long numberA, long numberB, long numberC){
        return numberA==numberB & numberB==numberC? true:false;
    }

    /** Launches application. Contains user console interface.
     *
     */
    public static void launch_app(){
        Scanner input = new Scanner (System.in);
        System.out.println("Please, input 3 integer numbers");
        long numberA=input.nextInt();
        long numberB=input.nextInt();
        long numberC=input.nextInt();
        System.out.println("Answer: "+Task_one.is_different(numberA, numberB, numberC));
    }
}
