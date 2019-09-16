package com.company;

import com.company.Main_task_one.*;

import java.util.Scanner;

public class Launchers {
    /**Main launcher for tasks.
     *
     */
    public void main_task_one_launcher(){
        Scanner input = new Scanner(System.in);
        System.out.println("Here's available tasks:" +
                "\n1) Task №1: Разработайте программу, которая проверяет, что числа a,b и c различны (одинаковы)" +
                "\n2) Task №2: Масса динозавра задаётся в килограммах. разработайте программу, которая вычисляет, " +
                "сколько это миллиграмм, грамм и тонн." +
                "\n3) Task №3: На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2). " +
                "\n Разработайте программу нахождения площади кольца, внешний радиус которого равен R1, " +
                "а внутрненний радиус равен R2" +
                "\n4) Task №4: Разработайте программу, которая проверяет, что цифры четырёхзначного числа N " +
                "образуют возрастающую (убывающую) последовательность (к примеру, число 1357 удовлетворяет условию, " +
                "т.к. его цифры соответствуют следующему  неравенству: 1<3<5<7, т.е. идут в порядке возрастания )." +
                "Написать программу, которая находит арифметическое и геометрическое\n" +
                "среднее цифр шестизначного числа N." +
                "\n5) Task №5: Написать программу, которая находит арифметическое и геометрическое\n" +
                " среднее цифр шестизначного числа N." +
                "\n6) Task №6: Написать программу, которая переворачивает (реверсирует) семизначное число N\n" +
                " (к примеру, число 1234567 реверсируется в число 7654321)." +
                "\n7) Task №7: Разработайте небольшую программу, которая меняет метами содержимое двух целочисленных " +
                "переменных a и b, не используя для этого дополнительных переменных." +
                "\n0) Exit" +
                "\n Please, choose the task number");
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
            case(5):
                Task_five.launch_app();
                break;
            case(6):
                Task_six.launch_app();
                break;
            case(7):
                Task_seven.launch_app();
                break;
            default:
                System.exit(0);
        }
    }
}
