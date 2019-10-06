package com.completedtasks.unit1.part1;

import java.util.Scanner;

/**Task condition: Написать программу, которая переворачивает (реверсирует) семизначное число N
 * (к примеру, число 1234567 реверсируется в число 7654321)
 *
 */
public class UnitOneTaskSix {
    /**Reverses numerals of given number. For example, number 123 will be reversed to 321.
     *
     * @param number that will be reversed
     * @return reversed number (int)
     */
    public static int reverse(int number){
        int[] numerals= UnitOneTaskFour.toNumerals(number);
        String reversedNumber="";

        for (int index=0; index<numerals.length; index++)
        reversedNumber += numerals[index];
        return Integer.parseInt(reversedNumber);
    }
    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app(){
        Scanner input = new Scanner (System.in);
        System.out.print("Please, enter 7-digit number: ");
        int number=input.nextInt();

        //By task condition number has to be 7-digit
        while (number<1000000 | number>9999999) {
            System.out.println("Invalid entity. Number must be 7-digit. Try again:");
            number=input.nextInt();
        }
        System.out.println("Result: "+reverse(number));
    }
}
