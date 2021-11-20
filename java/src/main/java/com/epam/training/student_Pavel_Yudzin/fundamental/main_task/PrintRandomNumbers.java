package com.epam.training.student_Pavel_Yudzin.fundamental.main_task;

/*
    Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 */

import java.util.Random;
import java.util.Scanner;

public class PrintRandomNumbers {
    public static void main(String[] args) {
        int amountOfNumbers;
        int[] arrayOfRandomNumbers;

        amountOfNumbers = getAmountOfNumbers();
        arrayOfRandomNumbers = getArrayOfRandomNumbers(amountOfNumbers);

        System.out.println("Amount of numbers: " + amountOfNumbers);
        printNumbersInLine(arrayOfRandomNumbers);
        printNumbersInRow(arrayOfRandomNumbers);

    }

    public static int getAmountOfNumbers() {
        int amountOfNumbers;
        do {
            amountOfNumbers = inputIntegerNumber();
        } while (amountOfNumbers < 0);
        return amountOfNumbers;
    }

    public static int inputIntegerNumber() {
        Scanner input = new Scanner(System.in);
        int number;
        String message = "Enter amount of numbers: >> ";

        System.out.print(message);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print(message);
        }

        number = input.nextInt();
        return number;
    }

    public static int[] getArrayOfRandomNumbers(int amountOfNumbers) {
        Random random = new Random();
        int[] arrayOfRandomNumbers = new int[amountOfNumbers];

        for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
            arrayOfRandomNumbers[i] = random.nextInt();
        }
        return arrayOfRandomNumbers;
    }

    public static void printNumbersInLine(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("\n");
    }

    public static void printNumbersInRow(int[] array) {
        for (int element : array) {
            System.out.println(element);
        }
    }
}