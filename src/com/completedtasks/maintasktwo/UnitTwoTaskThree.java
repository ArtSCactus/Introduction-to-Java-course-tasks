package com.completedtasks.maintasktwo;

import java.util.Scanner;

/**
 * Task condition:
 * Напишите программу, которая бы определяла, является ли введённая буква (символ)
 * гласной (постарайтесь сделать минимум четырьмя способами, разрешается и больше).
 */
public class UnitTwoTaskThree {
    //Vowel letters in english language
    public static char[] vowelEn = {'a', 'e', 'i', 'o', 'u'};
    //Vowel letters in russian language
    public static char[] vowelRu = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я'};

    /**
     * Checks is char array contains given char symbol.
     *
     * @param array  where will the verification be carried out
     * @param symbol that will be searched
     * @return true if array contains symbol. False otherwise.
     */
    private static boolean contains(char[] array, char symbol) {
        for (char arraySymbol : array)
            if (arraySymbol == symbol) return true;
        return false;
    }

    /**
     * Checks is char array contains symbol by it's unicode number.
     *
     * @param array      where will the verification be carried out
     * @param codeNumber code number of char element
     * @return true if array contains such symbol. False otherwise.
     */
    private static boolean contains(char[] array, int codeNumber) {
        for (char arraySymbol : array)
            if ((int) arraySymbol == codeNumber) return true;
        return false;
    }

    /**
     * Checks is char array contains symbol, that given as String.
     *
     * @param array  where will the verification be carried out
     * @param letter letter in String row.
     * @return true if array contains such symbol. False otherwise.
     */
    private static boolean contains(char[] array, String letter) {
        for (char arraySymbol : array)
            if (Character.toString(arraySymbol).equals(letter)) return true;
        return false;
    }

    /**
     * Checks is char array contains symbol by it's hash code.
     *
     * @param array    where will the verification be carried out
     * @param hashCode hash code of symbol, that will be searched in array
     * @return true if array contains such symbol. False otherwise.
     */
    private static boolean containsByhashcode(char[] array, int hashCode) {
        for (char arraySymbol : array)
            if (Character.hashCode(arraySymbol) == (hashCode)) return true;
        return false;
    }

    /**
     * Checks is given letter is a vowel (in russian and english languages).
     *
     * @param letter that will be checked
     * @return true if given letter is a vowel. False otherwise.
     */
    public static boolean isVowel(char letter) {
        if (contains(vowelEn, letter) || contains(vowelRu, letter)) return true;
        else return false;
    }

    /**
     * Checks is given letter is a vowel (in russian and english languages) by symbol's unicode number.
     *
     * @param letter that will be checked
     * @return true if given letter is a vowel. False otherwise.
     */
    public static boolean isVowelByCodeNumber(char letter) {
        if (contains(vowelEn, (int) letter) || contains(vowelRu, (int) letter)) return true;
        else return false;
    }

    /**
     * Checks is given in String letter is a vowel (in russian and english languages).
     *
     * @param letter that will be checked
     * @return true if given letter is a vowel. False otherwise.
     */
    public static boolean isVowelByString(String letter) {
        if (contains(vowelEn, letter) || contains(vowelRu, letter)) return true;
        else return false;
    }

    /**
     * Checks is given letter is a vowel (in russian and english languages) by symbol's hash code.
     *
     * @param hashCode that will be checked
     * @returntrue if given letter is a vowel. False otherwise.
     */
    public static boolean isVowelByHashCode(int hashCode) {
        if (containsByhashcode(vowelEn, hashCode) || containsByhashcode(vowelRu, hashCode)) return true;
        else return false;
    }

    /**
     * Launches application. Contains console interface.
     */
    public static void launch_app() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter the letter(you can enter row, but than will be taken only the first symbol): ");
        char letter = input.next().toLowerCase().charAt(0);
        //Validation is given data are correct (a letter)
        while (!Character.isLetter(letter)) {
            System.out.println("Wrong data. Symbol must be a letter. Try again: ");
            letter = input.next().toLowerCase().charAt(0);
        }
        //Result output
        System.out.println("Result (by char comparision): " + isVowel(letter));
        System.out.println("Result (by code number comparision): " + isVowelByCodeNumber(letter));
        System.out.println("Result (by converting to string): " + isVowelByString(Character.toString(letter)));
        System.out.println("Result (by hashcode): " + isVowelByHashCode(Character.hashCode(letter)));
    }
}
