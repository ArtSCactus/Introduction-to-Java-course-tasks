package com.completedtasks.maintaskone;

import java.util.Scanner;

/**Task condition:
 * на плоскости даны два круга с общим центром и радиусом R1 и R2 (R1 > R2).
 * Разработайте программу нахождения площади кольца, внешний радиус которого равен R1, а внутренний радиус равен R2.
 *
 */
public class UnitOneTaskThree {

    /**Calculates square of ring, that which make up by 2 circles with common center, with given interior and external radius.
     *
     * @param interiorRadius
     * @param externalRadius
     * @return
     */
    private static double findSquare(double interiorRadius, double externalRadius){
        if (interiorRadius==externalRadius) return 0;
        else return Math.PI*Math.pow(externalRadius,2)-Math.PI*Math.pow(interiorRadius,2);
    }

    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter interior radius and external radius:\nExternal radius: ");
        double externalRadius=input.nextDouble();
        System.out.println("Interior radius: ");
        double interiorRadius=input.nextDouble();
        //User input validation. Interior radius must be less or equals than external.
        while (interiorRadius > externalRadius) {
            interiorRadius = input.nextDouble();
            externalRadius = input.nextDouble();
            if (interiorRadius>externalRadius) System.out.println("Invalid data. Interior radius MUST be less or equals external.");
        }

        System.out.println("The ring square is " + UnitOneTaskThree.findSquare(interiorRadius, externalRadius));
    }
}
