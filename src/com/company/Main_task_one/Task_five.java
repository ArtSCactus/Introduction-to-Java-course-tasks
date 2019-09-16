package com.company.Main_task_one;

import java.util.Scanner;

/**Task condition: Написать программу, которая находит арифметическое и геометрическое
 * среднее цифр шестизначного числа N.
 */
public class Task_five {
    /**Calculates arithmetic average from given number (numerals)
     *
     * @param numerals (numbers) array
     * @return arithmetic average (double)
     */
    private static double arithmeticAverage(int[] numerals){
        int sum=0;
        for (int index=0; index<numerals.length; index++)
            sum+=numerals[index];
        return sum/numerals.length;
    }

    /**Calculates geometric average from given numbers (numerals)
     *
     * @param numerals
     * @return geometric average (double)
     */
    private static double geometricAverage(int[] numerals){
        double average=1;
        for (int index=0; index<numerals.length; index++)
            average*=numerals[index];
        return Math.pow(average,1.0/numerals.length);
    }

    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app(){
        Scanner input = new Scanner (System.in);
        System.out.print("Please, enter 6-digit number: ");
        int number=input.nextInt();
        //By task condition number has to be 6-digit
        while (number<100000 | number>999999) {
            System.out.println("Invalid data. Number must be 6-digit. Try again:");
            number=input.nextInt();
        }
        int[] numerals=Task_four.toNumerals(number);
        System.out.println("Results: " +
                "\nArithmetic average: "+arithmeticAverage(numerals)+
                "\nGeometric average "+geometricAverage(numerals));
    }
}
