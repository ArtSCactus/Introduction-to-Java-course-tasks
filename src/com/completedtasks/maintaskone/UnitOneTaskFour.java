package com.completedtasks.maintaskone;

import java.util.Arrays;
import java.util.Scanner;

/**Task condition: Разработайте программу, которая проверяет, что цифры четырёхзначного числа N образуют возрастающую
 * (убывающую) последовательность (к примеру, число 1357 удовлетворяет условию, т.к. его цифры соответствуют следующему
 * неравенству: 1<3<5<7, т.е. идут в порядке возрастания ).
 */
public class UnitOneTaskFour {

    /**Checks the array (in reversed order) is it placed in ascending order or not.
     *
     * @param numerals -  int array of numbers in reversed order
     * @return true if given array is placed in ascending order. False otherwise.
     */
    private static boolean isAscendingOrder(int[] numerals){

        for (int index = 0; index<=numerals.length-2; index++)
            if (numerals[index] < numerals[index+1]) return false;
            return true;
    }

    /**Checks the array (in reversed order) is it placed in descending order or not.
     *
     * @param numerals -  int array in reversed order
     * @return true if given array is placed in Descending order. False otherwise.
     */
    private static boolean isDescendingOrder(int[] numerals){

        for (int index=0; index<=numerals.length-2; index++)
            if (numerals[index]>numerals[index+1]) return false;
        return true;
    }

    /**Splits the number on numerals and returns array with this numerals.
     *
     * @param number - number to split
     * @return int array with numerals in reversed order
     */
    public static int[] toNumerals(int number){
        int[] numerals = new int[0];

        for (int currentNumber=number, index=0; currentNumber>0; currentNumber/=10, index++){
            numerals= Arrays.copyOf(numerals, numerals.length+1);
            numerals[index]=currentNumber%10;
        }
        return numerals;
}
    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please, input 4-digit number:");
        int number= input.nextInt();

        //Input validation. By task condition number has to be 4-digit
        while (number<1000 | number>9999) {
            System.out.println("Invalid data. Number must be four-digit. Try again:");
            number=input.nextInt();
        }
        int[] numerals=toNumerals(number);
        System.out.print("Answer: \nAscending order: "+isAscendingOrder(numerals)+"\nDescending order: "+ isDescendingOrder(numerals));
    }
}
