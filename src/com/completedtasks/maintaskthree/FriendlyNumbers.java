package com.completedtasks.maintaskthree;

import java.util.*;

/**
 * Task condition:
 *Дру́жественные чи́сла — два различных натуральных числа, для которых сумма всех собственных делителей первого числа
 * равна второму числу и наоборот, сумма всех собственных делителей второго числа равна первому числу. Дружественные
 * числа были открыты последователями Пифагора, которые, однако, знали только одну пару дружественных чисел – 220 и 284.
 * Найдите все дружественные числа в заданном диапазоне.
 *
 * @author ArtSCactus
 * @version 1.0
 */
public class FriendlyNumbers {
    /**
     * Returns list of dividers for current number.
     * <p>
     * Type of returning value is {@code List<Integer>} realized by {@code ArrayList<Integer>() }.
     * This method does not includes given number as divider.
     *
     * @param number for which will be searched dividers
     * @return List<Integer> dividers if at least 1 divider found. Null otherwise.
     * @see List more information about List
     * @since 1.0
     */
    private List<Integer> findDividers(int number) {
        List<Integer> dividers = new ArrayList<>();

        for (int potentialDivider = 1; potentialDivider < number; potentialDivider++) {
            if (number % potentialDivider == 0) {
                dividers.add(potentialDivider);
            }
        }
        return dividers;
    }

    /**
     * Returns sum of dividers for given number.
     * <p>
     * At first calls method {@code findDividers()} and saves founded dividers as {@code List<Integer>}.
     * Then by foreach cycle finds sum of all dividers.
     *
     * @param number for which will be searched dividers and founded sum of them.
     * @return (int) sum of dividers
     * @see FriendlyNumbers#findDividers(int) more information about findDividers(int) method
     * @since 1.0
     */
    private int findDividersSum(int number) {
        int sum = 0;
        List<Integer> dividers = findDividers(number);
        for (int divider : dividers) {
            sum += divider;
        }
        return sum;
    }

    /**Returns true if given numbers are friendly.
     *
     * Compares sums of dividers for each number.
     * To get dividers sum using method {@code findDividersSum(int)} for each number.
     *
     * @param numberA int type number
     * @param numberB int type number
     * @return true if given numbers are friendly. False otherwise.
     * @see FriendlyNumbers more information about FriendlyNumbers class.
     * @see FriendlyNumbers#findDividersSum(int) more infromation about method findDividerSum(int).
     */
    private boolean isFriendlyNumbers(int numberA, int numberB) {
        if (findDividersSum(numberA) == numberB & findDividersSum(numberB) == numberA) {
            return true;
        } else {
            return false;
        }
    }

    /**Return Map with pairs of friendly numbers.
     *
     * Method contains algorithm, that iterates through each pair of numbers in a given range and does not repeats already
     * passed pair. Given range does include numbers, that equals start and end. In process of work calls method isFriendlyNumbers().
     *
     * @param start - begin of range of numbers, where will be searched friendly numbers
     * @param end - end of range of numbers, where will be searched friendly numbers
     * @throws IllegalArgumentException if given start is less than end.
     * @return map type {@code Map<Integer, Integer>} of friendly numbers
     * @see FriendlyNumbers more information about FriendlyNumbers class
     * @see FriendlyNumbers#isFriendlyNumbers(int, int) more information about isFriendlyNumbers(int, int)
     * @see Map more information about Map class
     * @since 1.0
     */
    private Map<Integer, Integer> friendlyNumbersInRange(int start, int end){
        if (start>end) throw new IllegalArgumentException("Start of numbers line cannot be bigger than end");
        Map<Integer, Integer> friendlyNumbers= new HashMap<>();

        for (int primaryNumber=start; primaryNumber<=end; primaryNumber++){
            // by starting iteration from primaryNumber+1 we are escaping repeats to save time
            for (int secondaryNumber=primaryNumber+1; secondaryNumber<=end; secondaryNumber++)
            {
                if (isFriendlyNumbers(primaryNumber, secondaryNumber)) {
                    friendlyNumbers.put(primaryNumber, secondaryNumber);
                }
            }
        }
        if (friendlyNumbers.size()==0) return null;
        return friendlyNumbers;
    }

    /**Reads from console numbers.
     *
     * Stops current thread until user will enter the number.
     * Does not printing anything to console.
     * To get number from console is using class {@code Scanner}.
     *
     * @return int number from console
     * @see Scanner for more information about Scanner class
     */
    private int readNumber(){
        Scanner input = new Scanner(System.in);
        int number=input.nextInt();
        return number;
    }

    /**Prints Map to console.
     *
     * Accepts only maps type {@code Map<Integer, Integer>} and prints each pair from new row.
     * Template of row: {@code pair.getKey()+" and "+pair.getValue()}
     * If given map are null, will be printed a message, that no match found.
     *
     * @param mapToPrint - map, that will be printed to console.
     * @see Map more information about Map.
     * @since 1.0
     */
    private void printMap(Map<Integer, Integer> mapToPrint){
        if (mapToPrint==null){
            System.out.println("No match found.");
            return;
        }
       for (Map.Entry<Integer, Integer> entry : mapToPrint.entrySet()){
           System.out.println(entry.getKey()+" and "+entry.getValue());
       }
    }
    /**Launches application.
     *
     * Asks user to input range of numbers (start and end) and searches there pairs of friendly numbers.
     * If will be entered values, that start>end, will be called {@code return;} and program will finish it's work.
     * In process calls methods {@code readNumber()} and {@code printMap()}
     *
     * @see FriendlyNumbers more information about Friendly numbers
     * @see FriendlyNumbers#readNumber() more information about readNumber() method
     * @see FriendlyNumbers#printMap(Map) more information about printmap() method
     * @since 1.0
     */
    public void run(){
        int start;
        int end;
        System.out.print("Please, input start and end for range of numbers:\nStart: ");
        start=readNumber();
        System.out.print("End: ");
        end= readNumber();
        //Data validation
        if (end<start) {
            System.out.println("Invalid data. End cannot be less than start.");
            return;
        }
            System.out.println("Founded pairs:");
            printMap(friendlyNumbersInRange(start, end));
        }
}
