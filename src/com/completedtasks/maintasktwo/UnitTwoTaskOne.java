package com.completedtasks.maintasktwo;

import java.util.Scanner;

/**На прямоугольной декартовой системе координат на плоскости заданы три точки с соответствующими координатами в
 * виде пары значений (x,y). Определить, являются ли данные точки вершинами треугольника. И если да, то дополнительно
 * определить, является ли данный треугольник прямоугольным.
 *
 */
public class UnitTwoTaskOne {
    /**Returns distance between 2 points by given coordinates
     *
     * @param x1 - X coordinate of first point
     * @param y1 - Y coordinate of first point
     * @param x2 - X coordinate of second point
     * @param y2 - Y coordinate of second point
     * @return distance between this 2 points
     */
    private static double getSide(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
}

    /**Checks is Pythagorean theorem are works in this case with given sides.
     *
     * For example, we have a triangle ABC, where A=sideOne, B=sideTwo, C=sideThree. by the Pythagorean theorem,
     * a triangle is rectangular if it satisfies the following condition: A^2+B^2=C^2 or C^2+B^2=A^2 or A^2+C^2=B^2.
     * Method are calculates
     * @param sideOne - first side of current triangle
     * @param sideTwo - second side of current triangle
     * @param sideThree - third side of current triangle
     * @return true if sideOne^2+sideTwo^2=sideThree^2. False otherwise.
     */
    private static boolean isRightAngle(double sideOne, double sideTwo, double sideThree){
        if (Math.pow(sideOne,2)+Math.pow(sideTwo,2)==Math.pow(sideThree,2)) return true;
        else return false;
    }

    /**Checks whether the data makes a triangle.
     *
     * @param sideAB - first side of current triangle
     * @param sideBC - second side of current triangle
     * @param sideCA - third side of current triangle
     * @return True if it triangle. False otherwise.
     */
    private static boolean isTriangle(double sideAB, double sideBC, double sideCA){
        if (sideAB+sideBC<sideCA & sideAB+sideCA<sideBC & sideCA+sideBC<sideAB) return false;
        else return true;
    }

    /**Checking is this triangle rectangular or not.
     *
     * How it works:
     * For example, we have a triangle ABC, where A=sideOne, B=sideTwo, C=sideThree. by the Pythagorean theorem,
     * a triangle is rectangular if it satisfies the following condition: A^2+B^2=C^2 or C^2+B^2=A^2 or A^2+C^2=B^2.
     * Method are calculates each case, and if at least one is correct, returns true. False otherwise.
     * @param sideAB - first side of current triangle
     * @param sideBC - second side of current triangle
     * @param sideCA - third side of current triangle
     * @return True if triangle is rectangular. False otherwise.
     */
    private static boolean isRectangular(double sideAB, double sideBC, double sideCA){
        if (isRightAngle(sideAB, sideBC, sideCA) || isRightAngle(sideAB, sideCA, sideBC)
                || isRightAngle(sideCA, sideBC, sideAB)) return true;
        else return false;
    }

    /**Launches application. Contains console interface.
     *
     */
    public static void launch_app(){
        Scanner input = new Scanner(System.in);
        //User inputs point's coordinates
        System.out.print("Please, enter 3 points\nPoint A: \nx=");
        double x1 = input.nextDouble();
        System.out.print("y=");
        double y1 = input.nextDouble();
        System.out.print("Point B: \nx=");
        double x2 = input.nextDouble();
        System.out.print("y=");
        double y2 = input.nextDouble();
        System.out.print("Point C: \nx=");
        double x3 = input.nextDouble();
        System.out.print("y=");
        double y3 = input.nextDouble();
        //Building sides
        double sideAB=getSide(x1,y1,x2,y2);
        double sideBC=getSide(x2,y2,x3,y3);
        double sideCA=getSide(x3,y3,x1,y1);
        //Checking is it triangle or not
        boolean thisIsTriangle=isTriangle(sideAB, sideBC, sideCA);
        //If it triangle, checking is it rectangular or not
        if (thisIsTriangle) System.out.println("Triangle: "+thisIsTriangle+"\nIs rectangular: " +
                ""+isRectangular(sideAB, sideBC, sideCA));
        else System.out.println("This is not a triangle.");
    }
}
