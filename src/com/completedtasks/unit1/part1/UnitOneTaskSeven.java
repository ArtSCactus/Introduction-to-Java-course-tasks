package com.completedtasks.unit1.part1;

import java.util.Scanner;

/**Task condition: Разработайте небольшую программу, которая меняет местами содержимое двух целочисленных
 переменных a и b, не используя для этого дополнительных переменных.
 */
public class UnitOneTaskSeven {
    /**Launches application, that accepts 2 numbers form console (entered by user) and swaps them (swaps variables).
     *
     */
    public static void launch_app() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter 2 numbers\nnumberA=");
         double numberA = input.nextDouble();
         System.out.print("numberB=");
         double numberB = input.nextDouble();

        numberA+=numberB;
        numberB=numberA-numberB;
        numberA-=numberB;
        System.out.println("Result: \nnumberA=" + numberA + "\nnumberB=" + numberB);
    }
}
