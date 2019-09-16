package com.completedtasks;

import com.completedtasks.maintaskone.*;
import com.completedtasks.maintasktwo.*;

import java.util.Scanner;

public class Launchers {
    /**Main launcher for tasks.
     *
     */
    public void mainTaskOneLauncher(){
        Scanner input = new Scanner(System.in);
        System.out.println("Here's available tasks:" +
                "\n1) Task №1: Разработайте программу, которая проверяет, что числа a,b и c различны (одинаковы)\n" +
                "\n2) Task №2: Масса динозавра задаётся в килограммах. разработайте программу, которая вычисляет,\n" +
                "сколько это миллиграмм, грамм и тонн." +
                "\n3) Task №3: На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2).\n" +
                "\n Разработайте программу нахождения площади кольца, внешний радиус которого равен R1,\n" +
                "а внутрненний радиус равен R2\n" +
                "\n4) Task №4: Разработайте программу, которая проверяет, что цифры четырёхзначного числа N \n" +
                "образуют возрастающую (убывающую) последовательность (к примеру, число 1357 удовлетворяет условию, \n" +
                "т.к. его цифры соответствуют следующему  неравенству: 1<3<5<7, т.е. идут в порядке возрастания ).\n" +
                "Написать программу, которая находит арифметическое и геометрическое\n" +
                "среднее цифр шестизначного числа N.\n" +
                "\n5) Task №5: Написать программу, которая находит арифметическое и геометрическое\n" +
                " среднее цифр шестизначного числа N.\n" +
                "\n6) Task №6: Написать программу, которая переворачивает (реверсирует) семизначное число N\n" +
                " (к примеру, число 1234567 реверсируется в число 7654321).\n" +
                "\n7) Task №7: Разработайте небольшую программу, которая меняет метами содержимое двух целочисленных \n" +
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
       UnitOneTaskOne.launch_app();
                break;
            case(2):
                UnitOneTaskTwo.launch_app();
                break;
            case(3):
                UnitOneTaskThree.launch_app();
                break;
            case(4):
                UnitOneTaskFour.launch_app();
                break;
            case(5):
                UnitOneTaskFive.launch_app();
                break;
            case(6):
                UnitOneTaskSix.launch_app();
                break;
            case(7):
                UnitOneTaskSeven.launch_app();
                break;
            default:
                System.exit(0);
        }
    }

    public static void mainTaskTwoLauncher(){
        Scanner input = new Scanner(System.in);
        System.out.println("Here's available tasks:" +
                "\n1) Task №1:  На прямоугольной декартовой системе координат на плоскости заданы три точки с \n" +
                "соответствующими координатами в виде пары значений (x,y). Определить, являются ли данные точки \n" +
                "вершинами треугольника. И если да, то дополнительно определить, является ли данный треугольник \n" +
                "прямоугольным." +
                "\n2) Task №2: В молодом возрасте дракон каждый год отращивает по три головы, но после того, \n" +
                "как ему исполнится 200 лет – только по две, а после 300 лет – лишь по одной. Предполагается, что \n" +
                "дракон появляется на свет сразу с тремя головами. Разработайте программу, которая высчитывала бы, \n" +
                "сколько голов и глаз у дракона, которому N лет?" +
                "\n3) Task №3: Напишите программу, которая бы определяла, является ли введённая буква (символ)\n" +
                " гласной (постарайтесь сделать минимум четырьмя способами, разрешается и больше)." +
                "\n4) Task №4: Заданы три целых числа, которые задают некоторую дату по Грегорианскому календарю\n" +
                " (https://ru.wikipedia.org/wiki/Григорианский_календарь).Определить дату следующего дня. Запрещается использовать типы\n" +
                " стандартной библиотеки языка для работы с датой и временем. Также необходимо учесть то, что по григорианскому календарю\n" +
                " (используется в настоящий момент) високосный год определяется следующим образом:\n" +
                " годы, кратные 4 – високосные (например, 2008, 2012, 2016);\n" +
                " годы, кратные 4 и 100 – невисокосные (например, 1700, 1800, 1900);\n" +
                " годы, кратные 4, 100 и 400 – високосные (например, 1600, 2000, 2400)."+
                "\n0) Exit" +
                "\n Please, choose the task number");
        int choice;
        //Validation is entered task number correct
        while (true) {
            choice = input.nextInt();
            if (choice<0 | choice> 4) System.out.println("No such unit number. Please, try again.");
            else break;
        }
        switch (choice){
            case(1):
                UnitTwoTaskOne.launch_app();
                break;
            case(2):
                UnitTwoTaskTwo.launch_app();
                break;
            case(3):
                UnitTwoTaskThree.launch_app();
                break;
            case (4):
                UnitTwoTaskFour.launch_app();
                break;
            default:
                System.exit(0);
        }
    }
}