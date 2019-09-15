package com.company.Main_task_one;

import java.util.Scanner;

/**Task condition:
 * на плоскости даны два круга с общим центром и радиусом R1 и R2 (R1 > R2).
 * Разработайте программу нахождения площади кольца, внешний радиус которого равен R1, а внутренний радиус равен R2.
 *
 */
public class Task_three {

    /**Calculates square of ring, that which make up by 2 circles with common center, with given interior and external radius.
     *
     * @param interiorRadius
     * @param externalRadius
     * @return
     */
    private static double findSquare(double interiorRadius, double externalRadius){
        if (interiorRadius==externalRadius) return 0;
        else return Math.PI*Math.pow(interiorRadius,2)-Math.PI*Math.pow(externalRadius,2);
    }

    /**Launches application. Contains user console interface.
     *
     */
    public static void launch_app() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, input 3 integer numbers");
        double interiorRadius=input.nextDouble();
        double externalRadius=input.nextDouble();

        //User input validation. Innterior radius must be less or equals than external.
        while (interiorRadius > externalRadius) {
            interiorRadius = input.nextDouble();
            externalRadius = input.nextDouble();
            if (interiorRadius>externalRadius) System.out.println("Invalid data. Interior radius MUST be less or equals external.");
        }

        System.out.println("Answer: The ring square is " + Task_three.findSquare(interiorRadius, externalRadius));
    }
}
