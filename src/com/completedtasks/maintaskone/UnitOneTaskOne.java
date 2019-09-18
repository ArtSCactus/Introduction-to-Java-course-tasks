package com.completedtasks.maintaskone;

import java.util.Scanner;

/** Task condition:
 * Разработайте программу, которая проверяет, что числа a, b и c различны (одинаковы).
 */
public class UnitOneTaskOne {
    /** Checks three numbers are they equals or not.
     *
     * @param numberA
     * @param numberB
     * @param numberC
     * @return true if all three numbers are equals. False otherwise.
     */
    private static boolean isDifferent (long numberA, long numberB, long numberC){
        return numberA!=numberB & numberB!=numberC? true:false;
    }

    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, input 3 integer numbers");
        System.out.print("Enter number A: ");
        long numberA = input.nextLong();
        System.out.print("Enter number B: ");
        long numberB = input.nextLong();
        System.out.print("Enter number C: ");
        long numberC = input.nextLong();
        System.out.println("Answer: " + UnitOneTaskOne.isDifferent(numberA, numberB, numberC));
    }

}
