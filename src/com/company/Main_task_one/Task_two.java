package com.company.Main_task_one;

import java.util.Scanner;

/** Масса динозавра задаётся в килограммах.
 * Разработайте программу, которая вычисляет, сколько это миллиграмм, грамм и тонн.
 *
 */
public class Task_two {

    /**Converts mass, that given in kilograms into the milligrams.
     *
     * @param mass in kilograms
     * @return mass in milligrams
     */
    private static double toMilligrams (double mass){
        return mass*1000000;
    }

    /**Converts mass, that given in kilograms into the grams.
     *
     * @param mass in kilograms
     * @return mass in grams
     */
    private static double toGrams (double mass){
        return mass*1000;
    }

    /**Converts mass, that given in kilograms into the tons.
     *
     * @param mass in kilograms
     * @return mass in tons
     */
    private static double toTons(double mass){
        return mass/1000;
    }

    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please input dinosaur mass in kilograms: ");
        double massInKG=input.nextDouble();
        //User input validation. Dinosaur mass cannot be less than 0.
        while (massInKG<0) {
            System.out.print("Invalid data. Dinosaur mass cannot be less than 0. Try again: ");
            massInKG = input.nextDouble();
        }
        System.out.println("Answer:\nIn tons "+toTons(massInKG)+"\nIn grams: "+toGrams(massInKG)+
                "\nIn milligrams: "+toMilligrams(massInKG));
    }
}
