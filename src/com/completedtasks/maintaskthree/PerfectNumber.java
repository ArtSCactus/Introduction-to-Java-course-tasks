package com.completedtasks.maintaskthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Task condition:
 * Натуральное число называют совершенным, если оно равно сумме всех своих делителей, не считая только его самого
 * (например, 28=1+2+3+7+14 – совершенное число). Напишите программу, которая проверяет, является ли введённое
 * натуральное число совершенным. Для проверки работоспособности программы приводится список некоторых совершенных
 * чисел: 6, 28, 496, 8128.
 *
 * @author ArtSCactus
 * @version 1.0
 */
public class PerfectNumber {
    /**
     * Returns list of dividers for current number.
     * <p>
     * Warning: returns all dividers without given number as divider (1<=divider<number).
     * Type of returning value is {@code List<Integer>} realized by {@codeArrayList<Integer>() }.
     * If no dividers for this number found, returns null;
     *
     * @param number for which will be searched dividers
     * @return List<Integer> dividers if at least 1 divider found. Null otherwise.
     * @since 1.0
     */
    private List<Integer> findDividers(int number) {
        List<Integer> dividers = new ArrayList<>();

        for (int potentialDivider = 1; potentialDivider < number; potentialDivider++) {
            if (number % potentialDivider == 0) {
                dividers.add(potentialDivider);
            }
        }
        if (dividers.size() == 0) return null;
        return dividers;
    }

    /**
     * Validates is given number perfect or not.
     * <p>
     * By calling method {@code findDividers()} getting dividers for given number.
     * Then summing them and checks is the sum equals to the number.
     *
     * @param number that will be validates
     * @return true if given number is perfect. False otherwise.
     * @see PerfectNumber#findDividers(int) more information about findDividers(int) method
     * @since 1.0
     */
    public boolean isPerfect(int number) {
        List<Integer> dividers = findDividers(number);
        int sum = 0;

        // summing all dividers
        for (int divider : dividers) {
            sum += divider;
        }
        if (sum == number) return true;
        else return false;
    }

    /**
     * Reads number from console.
     * <p>
     * Asking user to input number from console, then reads entered number through Scanner class.
     * Contains validation: "is given number bigger than 1". If entered number is invalid, asks to enter again.
     *
     * @return int number
     * @see Scanner more information about Scanner class
     * @since 1.0
     */
    private int readNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter the number:\n==> ");
        int number = input.nextInt();

        while (number < 1) {
            System.out.println("Wrong data. Entered number is less than 1. There's no negative perfect number.\nTry again: ");
            number = input.nextInt();
        }
        return number;
    }

    /**
     * Runs application.
     * Call at first method {@code readNumber()}. After that prints to console result of method {@code isPerfect()}.
     *
     * @see PerfectNumber#readNumber() more information about readNumber() method
     * @see PerfectNumber#isPerfect(int) more information about isPerfect() method
     * @since 1.0
     */
    public void run() {
        int number = readNumber();
        System.out.println("This is perfect number: " + isPerfect(number));
    }
}
