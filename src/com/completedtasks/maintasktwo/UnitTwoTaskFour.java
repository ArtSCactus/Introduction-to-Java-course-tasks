package com.completedtasks.maintasktwo;

import java.util.Scanner;

/**
 * Task condition:
 * Заданы три целых числа, которые задают некоторую дату по Грегорианскому календарю
 * (https://ru.wikipedia.org/wiki/Григорианский_календарь).Определить дату следующего дня. Запрещается использовать типы
 * стандартной библиотеки языка для работы с датой и временем. Также необходимо учесть то, что по григорианскому календарю
 * (используется в настоящий момент) високосный год определяется следующим образом:
 *  годы, кратные 4 – високосные (например, 2008, 2012, 2016);
 *  годы, кратные 4 и 100 – невисокосные (например, 1700, 1800, 1900);
 *  годы, кратные 4, 100 и 400 – високосные (например, 1600, 2000, 2400).
 */
public class UnitTwoTaskFour {
    /**Checks is given year a leap or not.
     *
     * @param year
     * @return true if current year s leap. False otherwise.
     */
    public static boolean isYearLeap(int year) {
        if (year % 4 == 0 || year % 100 == 0 || year % 400 == 0) return true;
        else return false;
    }

    /**Finds next date from give.
     *
     * @param day
     * @param month
     * @param year
     * @return next date as String row (for example, "17.9.2019")
     */
    public static String findNextDate(int day, int month, int year) {
        if (day > 31 || month > 12 || year < 0 || day < 1 || month < 1) return "Error. Impossible date: "+day+"."+month+"."+year;
        boolean isLeapYear = isYearLeap(year);
        switch (month) {
            case (2):
                if (isLeapYear) {
                    if (day == 29) {
                        if (month + 1 > 12) return "" + 1 + "." + 1 + "." + (year + 1);
                        else return "" + 1 + "." + (month + 1) + "." + year;
                    }
                } else if (day == 28) {
                     return "" + 1 + "." + (month + 1) + "." + year;
                } else if (day > 28) return "This year is leap and in this month no more than 28 days";
                else {
                    return "" + (day + 1) + "." + month + "." + year;
                }
                break;
            case (4):
                if (day == 30) {
                    return "" + 1 + "." + (month + 1) + "." + year;
                } else return "" + (day + 1) + "." + month + "." + year;
            case (6):
                if (day == 30) {
                    return "" + 1 + "." + (month + 1) + "." + year;
                } else return "" + (day + 1) + "." + month + "." + year;
            case (9):
                if (day == 30) {
                    if (month + 1 > 12) return "" + 1 + "." + 1 + "." + (year + 1);
                    else return "" + 1 + "." + (month + 1) + "." + year;
                } else return "" + (day + 1) + "." + month + "." + year;
            case (11):
                if (day == 30) {
                    return "" + 1 + "." + (month + 1) + "." + year;
                } else return "" + (day + 1) + "." + month + "." + year;
            case (12):
                if (day == 31) {
                    return "" + 1 + "." + 1 + "." + (year + 1);
                } else return "" + (day + 1) + "." + month + "." + year;
            default:
               if (day == 31) {
                    return "" + 1 + "." + (month + 1) + "." + year;
                } else return "" + (day + 1) + "." + month + "." + year;
        }
        return null;
    }
    public static void launch_app() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter the day, month and year: \nDay: ");
        int day = input.nextInt();
        System.out.print("Month: ");
        int month = input.nextInt();
        System.out.println("Year: ");
        int year = input.nextInt();
        //Validation is given data are correct (a letter)
       System.out.println("Next date: "+findNextDate(day,month,year));
    }
}

