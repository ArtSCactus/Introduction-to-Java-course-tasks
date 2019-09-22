package com.completedtasks.maintaskthree;

import java.util.Random;
import java.util.Scanner;

/**Task condition:
 * Необходимо написать программу «Heads or Tails?» («Орёл или решка?»), которая бы «подбрасывала» условно монету,
 * к примеру, 1000 раз и сообщала, сколько раз выпал орёл, а сколько – решка.
 *
 * @author ArtSCactus
 * @version 1.0
 */
public class HeadsOrTrails {
    /** stores amount of tossed heads*/
   private int heads;
   /** stores amount of tossed tails */
   private int trails;
   /** stores amount of tosses */
   private int tosses;

    /**Enum to mark side of coin. Contains 2 side of coin: head and trail.
     * Also contains method getRandom(), that return random object of enum Side;
     */
    private enum Side{
        HEAD, TRAIL;
        public static Side getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    /**Method requests user to input amount of tosses of coin.
     * Contains console interface.
      */
    private void readInput(){
        Scanner input = new Scanner (System.in);
        System.out.print("Welcome! Let's play the game. How much times i should toss the coin? \nEnter here==>");
        tosses=input.nextInt();
        while (tosses<1){
            System.out.println("Number of tosses cannot be less than 1. Try again: ");
            tosses=input.nextInt();
        }
    }

    /**Tosses coin and returns HEAD or TRAIL (Side enum objects).
     *
     * @return Side.HEAD or Side.TRAIL
     */
    public static Side toss(){
        return Side.getRandom();
    }

    /**Starts cycle that tosses coin and counts amount of tossed heads and trails.
     * Cleans amount of heads and trails (settings on 0).
     */
    private void countTosses(){
        heads=0;
        trails=0;
        for (int toss=1; toss<=tosses; toss++)
        {
            if (toss()==Side.HEAD) heads++;
            else trails++;
        }
    }

    /** Prints amount of heads and trails to console.
     *
     */
    private void outResults(){
        System.out.println("I have tossed coin "+tosses+" times, and got "+heads+" heads"+" and "+trails+" trails.");
    }

    /**Launches application.
     * Consistently calls readInput(), countTosses() and outResults().
     *
     * @see HeadsOrTrails#readInput()
     * @see HeadsOrTrails#countTosses()
     * @see HeadsOrTrails#outResults()
     */
   public void launchApp(){
        readInput();
        countTosses();
        outResults();
   }
}
