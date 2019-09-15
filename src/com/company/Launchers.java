package com.company;

import com.company.Main_task_one.Task_four;
import com.company.Main_task_one.Task_one;
import com.company.Main_task_one.Task_three;
import com.company.Main_task_one.Task_two;

import java.util.Scanner;

public class Launchers {
    /**Main launcher for tasks.
     *
     */
    public void main_task_one_launcher(){
        Scanner input = new Scanner(System.in);
        System.out.println("Here's available tasks:" +
                "\n1) Task №1: Разработайте программу, которая проверяет, что числа a,b и c различны (одинаковы)" +
                "\n2) Task №2: Масса динозавра задаётся в килограммах. разработайте программу, которая вычисляет, сколько это миллиграмм, грамм и тонн." +
                "\n3) Task №3: На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2). " +
                "\n Разработайте программу нахождения площади кольца, внешний радиус которого равен R1, а внутрненний радиус равен R2" +
                "\n Please, choose the task number" +
                "\n4) Task №4: Разработайте программу, которая проверяет, что цифры четырёхзначного числа N образуют возрастающую\n" +
                " (убывающую) последовательность (к примеру, число 1357 удовлетворяет условию, т.к. его цифры соответствуют следующему\n" +
                " неравенству: 1<3<5<7, т.е. идут в порядке возрастания ).");
        int choice;
        while (true) {
            choice = input.nextInt();
            if (choice<0 | choice> 7) System.out.println("No such unit number. Please, try again.");
            else break;
        }
        switch (choice){
            case(1):
       Task_one.launch_app();
                break;
            case(2):
                Task_two.launch_app();
                break;
            case(3):
                Task_three.launch_app();
                break;
            case(4):
                Task_four.launch_app();
                break;
            default:
                System.exit(0);
        }
    }
}
