package com.epam.training.student_Pavel_Yudzin.fundamental.main_task;

/*
    Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
 */

import java.util.Scanner;

public class MonthNameByNumber {
    public static void main(String[] args) {
        int monthNumber;
        String monthName;
        monthNumber = getMonthNumber();
        monthName = getMonthNameByNumber(monthNumber);
        System.out.println(monthNumber + " - " + monthName);
    }

    public static int getMonthNumber() {
        int monthNumber;
        do {
            monthNumber = inputMonthNumber();
        } while (monthNumber < 1 || monthNumber > 12);
        return monthNumber;
    }

    public static int inputMonthNumber() {
        int monthNumber;
        String message = "Enter month number: >> ";
        Scanner input = new Scanner(System.in);

        System.out.print(message);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print(message);
        }
        monthNumber = input.nextInt();
        return monthNumber;
    }

    public static String getMonthNameByNumber(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Month doesn't exist";
        }
    }
}
