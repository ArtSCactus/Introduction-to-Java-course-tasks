package com.completedtasks.maintaskthree;

import java.util.*;

/**
 * Task condition:
 * Разработать наиболее эффективные алгоритмы и написать код для решения следующих задач:
 * - найти наибольшую цифру натурального числа;
 * - проверить, является ли заданное натуральное число палиндромом;
 * - определить является ли заданное натуральное число простым;
 * - найти все простые делители заданного натурального числа;
 * - найти НОД и НОК двух натуральных чисел a и b.
 * - найти количество различных цифр у заданного натурального числа.
 *
 * @author ArtSCactus
 * @version 1.0
 */
public class ComplexSolver {
    /** maximal possible numeral in a number*/
    private final int MAXIMAL_NUMERAL=9;
    /**
     * Asks user to input the number and validates is it natural. If it is natural, returns this number.
     * Other wise asking to input again.
     *
     * @return int naturalNumber
     */
    public int readNaturalNumber() {
        Scanner input = new Scanner(System.in);
        int naturalNumber = input.nextInt();
        while (naturalNumber <= 0) {
            System.out.println("This number is not natural. Please, try again: ");
            naturalNumber = input.nextInt();
        }
        return naturalNumber;
    }

    /**
     * Return the biggest numeral in the given number.
     *
     * @see ComplexSolver#toNumerals(int) - used to split number on numerals
     * @param number
     * @return biggestNumeral
     */
    private int findBiggestNumeral(int number) {
        List<Integer> numerals = toNumerals(number);
        int biggestNumeral = numerals.get(0);

        for (int index = 0; index < numerals.size(); index++) {
            if (numerals.get(index) == MAXIMAL_NUMERAL) {
                return MAXIMAL_NUMERAL;
            }
            if (biggestNumeral < numerals.get(index)) {
                biggestNumeral = numerals.get(index);
            }
        }
        return biggestNumeral;
    }

    /**
     * Returns true if given number is palindrome. False other wise.
     *
     * @param number
     * @return true if given number is palindrome. False otherwise.
     */
    public boolean isPalindrome(int number) {
        List<Integer> numerals = toNumerals(number);

        for (int start = 0, end = numerals.size() - 1; start<=end; start++, end--) {
            if (numerals.get(start) != numerals.get(end)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validates is given number are prime or not.
     *
     * @param number
     * @return true if given number is prime. False otherwise.
     */
    private boolean isPrime(int number) {
        if (number < 2) return false;

        for (int currentNumber = 2; currentNumber * currentNumber <= number; currentNumber++)
            if (number % currentNumber == 0) { //is currentNumber divider of number?
                return false;
            }
        return true;
    }

    /**
     * Returns GCD of 2 numbers;
     *
     * @param numberA
     * @param numberB
     * @return int GCD
     */
    private int gcd(int numberA, int numberB) {

        while (numberB != 0) {
            int temp = numberA % numberB;
            numberA = numberB;
            numberB = temp;
        }
        return numberA;
    }

    /**
     * Returns LCM of 2 numbers.
     *
     * @param numberA
     * @param numberB
     * @return int LCM
     */
    private int lcm(int numberA, int numberB) {
        return numberA / gcd(numberA, numberB) * numberB;
    }

    /**
     * Returns List<Integer> with prime dividers of given number.
     *
     * @param number
     * @return List<Integer> with prime dividers
     */
    private List<Integer> findPrimeDividers(int number) {
        List<Integer> primeDividers = new ArrayList<>();

        for (int divider = 1; divider <= number; divider++) {
            if (isPrime(divider) & number % divider == 0) { //is current divider prime and divider of number?
                primeDividers.add(divider);
            }
        }
        return primeDividers;
    }

    /**
     * Splits the number on numerals and returns list with this numerals.
     * Numerals are writing in the ArrayList collection type.
     *
     * @param number - number to split
     * @return list with numerals in reversed order (List<Integer> numerals)
     */
    private List<Integer> toNumerals(int number) {
        List<Integer> numerals = new ArrayList<>();

        for (int currentNumber = number; currentNumber > 0; currentNumber /= 10) {
            numerals.add(currentNumber % 10);
        }
        return numerals;
    }

    /**
     * Counts each numeral in the given number and return results as Map<Integer, Integer>.
     *
     * @see ComplexSolver#toNumerals(int) - used to split number on numerals
     * @param number
     * @return Map<Integer,Integer>, where Map<Numeral, Amount>
     */
    private Map<Integer, Integer> countNumerals(int number) {
        List<Integer> numerals = toNumerals(number);
        Map<Integer, Integer> countedNumerals = new HashMap<>();

        for (int numeral : numerals) {
            if (countedNumerals.containsKey(numeral)) {
                countedNumerals.replace(numeral, countedNumerals.get(numeral), countedNumerals.get(numeral) + 1);
            } else countedNumerals.put(numeral, 1);
        }
        return countedNumerals;
    }

    /**Reads from console operation id and validates it.
     * Reads from console operation id and starts the cycle, that will validating received operation id. If it wrong,
     * asks to input it again.
     * @return int operation id
     */
    private int readOperationID(){
        Scanner input = new Scanner(System.in);
        int operationID=input.nextInt();

    //validation operation id input
    while (operationID < 0 & operationID > 6) {
        System.out.println("Number of tosses cannot be less than 1. Try again: ");
        operationID = input.nextInt();
    }
    return operationID;
}
    /**Runs the program and asks user which operation to choose.
     * Depends on user's choice calls different operations:
     * -find the biggest numeral
     * -palindrome validation
     * -prime number validation
     * -find prime dividers
     * -find GCD and LCM
     * -amount of unique numerals
     *
     * @see ComplexSolver#findBiggestNumeral(int)
     * @see ComplexSolver#isPalindrome(int)
     * @see ComplexSolver#isPrime(int)
     * @see ComplexSolver#findPrimeDividers(int)
     * @see ComplexSolver#gcd(int, int)
     * @see ComplexSolver#lcm(int, int)
     * @see ComplexSolver#countNumerals(int)
     */
    public void run() {
        System.out.println("Please, choose the operation from list below:" +
                "\n1) Find the biggest numeral." +
                "\n2) Palindrome validation." +
                "\n3) Prime number validation " +
                "\n4) Find prime dividers" +
                "\n5) Find GCD and LCM" +
                "\n6) Amount of unique numerals" +
                "\n0) Exit");
        int operationID = readOperationID();
        int numberA;
        int numberB;
        switch (operationID) {
            // find the biggest numeral
            case (1):
                System.out.print("Please, enter a natural number: ");
                numberA = readNaturalNumber();
                System.out.println("Biggest numeral is: " + findBiggestNumeral(numberA));
                break;
            // is palindrome
            case (2):
                System.out.print("Please, enter a natural number: ");
                numberA = readNaturalNumber();
                System.out.println("This number is palindrome: " + isPalindrome(numberA));
                break;
            // is prime number
            case (3):
                System.out.print("Please, enter a natural number: ");
                numberA = readNaturalNumber();
                System.out.println("This number is prime: " + isPrime(numberA));
                break;
            // find prime dividers
            case (4):
                System.out.print("Please, enter a natural number: ");
                numberA = readNaturalNumber();
                System.out.println("Prime dividers: " + findPrimeDividers(numberA).toString());
                break;
            // find GCD and LCM
            case (5):
                System.out.print("Please, enter the first natural number: ");
                numberA = readNaturalNumber();
                System.out.print("Please, enter the second natural number: ");
                numberB = readNaturalNumber();
                System.out.println("GCD: " + gcd(numberA, numberB) + "\nLCM: " + lcm(numberA, numberB));
                break;
            // amount of unique numerals
            case (6):
                System.out.print("Please, enter a natural number: ");
                numberA = readNaturalNumber();
                Map<Integer, Integer> numerals = countNumerals(numberA);
                for (int key : numerals.keySet()) {
                    System.out.println("Numeral: " + key + " amount: " + numerals.get(key));
                }
                break;
            default:
                System.exit(0);
        }
    }
}
