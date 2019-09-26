package com.completedtasks.unit2;

import java.util.Scanner;

/**
 * Task condition:
 * Необходимо написать программу «Heads or Tails?» («Орёл или решка?»), которая бы «подбрасывала» условно монету,
 * к примеру, 1000 раз и сообщала, сколько раз выпал орёл, а сколько – решка.
 *
 * @author ArtSCactus
 * @version 1.2
 */
public class HeadsOrTails {
    /**
     * stores amount of tossed heads
     */
    private int heads;
    /**
     * stores amount of tossed tails
     */
    private int tails;
    /**
     * stores amount of tosses
     */
    private int tosses;

    /**
     * Enum to mark side of coin. Contains 2 side of coin: head and tail.
     * Also contains method getRandom(), that return random object of enum Side;
     */
    private enum Side {
        HEAD, TAIL;

        /**
         * Returns random Side object (HEAD or tail).
         *
         * @return HEAD or tail (both Side objects)
         */
        public static Side getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    /**
     * Method requests user to input amount of tosses of coin.
     * Contains console interface.
     */
    private void readInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome! Let's play the game. How much times should i toss the coin? \nEnter here==>");
        tosses = input.nextInt();

        while (tosses < 1) {
            System.out.println("Number of tosses cannot be less than 1. Try again: ");
            tosses = input.nextInt();
        }
    }

    /**
     * Tosses coin and returns HEAD or tail (Side enum objects).
     *
     * @return Side.HEAD or Side.tail
     */
    public static Side toss() {
        return Side.getRandom();
    }

    /**
     * Starts cycle that tosses coin and counts amount of tossed heads and tails.
     * Cleans amount of heads and tails (settings on 0).
     */
    private void countTosses() {
        heads = 0;
        tails = 0;

        for (int toss = 1; toss <= tosses; toss++) {
            if (toss() == Side.HEAD) heads++;
            else tails++;
        }
    }

    /**
     * Prints amount of heads and tails to console.
     */
    private void outResults() {
        System.out.println("I have tossed coin " + tosses + " times, and got " + heads + " heads" + " and " + tails + " tails.");
    }

    /**
     * Launches application.
     * Consistently calls readInput(), countTosses() and outResults().
     *
     * @see HeadsOrTails#readInput()
     * @see HeadsOrTails#countTosses()
     * @see HeadsOrTails#outResults()
     */
    public void run() {
        readInput();
        countTosses();
        outResults();
    }
}
