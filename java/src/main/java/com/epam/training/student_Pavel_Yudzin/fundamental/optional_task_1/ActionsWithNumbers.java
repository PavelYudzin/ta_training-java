package com.epam.training.student_Pavel_Yudzin.fundamental.optional_task_1;

/*
    Ввести n чисел с консоли.
    1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    2. Вывести числа в порядке возрастания (убывания) значений их длины.
    3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
    4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
    5. Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
    6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ActionsWithNumbers {
    public static void main(String[] args) {
        int amountOfNumbers;
//        int[] arrayOfIntegerNumbers;
//
//        amountOfNumbers = getAmountOfNumbers();
//        arrayOfIntegerNumbers = getArrayOfIntegerNumbers(amountOfNumbers);
        int[] arrayOfIntegerNumbers = {-383, 44, -4, 5645, 49, 384};

        System.out.println(Arrays.toString(arrayOfIntegerNumbers) + "\n");
        printTheShortestNumber(arrayOfIntegerNumbers);
        printTheLongestNumber(arrayOfIntegerNumbers);
        printNumbersSortedByIncreasingLength(arrayOfIntegerNumbers);
        printNumbersWithLengthLessThanAverage(arrayOfIntegerNumbers);
        printNumbersWithLengthMoreThanAverage(arrayOfIntegerNumbers);
    }

    public static int getAmountOfNumbers() {
        String message = "Enter amount of numbers: >> ";
        int amountOfNumbers = 0;

        do {
            if (amountOfNumbers < 0) {
                System.out.println("Wrong entry!!! Try again");
            }
            amountOfNumbers = inputIntegerNumber(message);
        } while (amountOfNumbers < 0);

        return amountOfNumbers;
    }

    public static int inputIntegerNumber(String message) {
        int number;
        Scanner input = new Scanner(System.in);

        System.out.print(message);
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Wrong entry!!! Try again");
            System.out.print(message);
        }
        number = input.nextInt();

        return number;
    }

    public static int[] getArrayOfIntegerNumbers(int amountOfNumbers) {
        int[] arrayOfIntegerNumbers = new int[amountOfNumbers];
        String message = "Enter integer number: >> ";

        for (int i = 0; i < arrayOfIntegerNumbers.length; i++) {
            arrayOfIntegerNumbers[i] = inputIntegerNumber(message);
            amountOfNumbers--;
            if (amountOfNumbers > 0) {
                System.out.println(amountOfNumbers + " more left");
            }
        }
        return arrayOfIntegerNumbers;
    }

    public static void printTheShortestNumber(int[] arrayOfInts) {
        String[] arrayOfNumbersAsStrings = getArrayOfNumbersAsStrings(arrayOfInts);
        int minLengthAmongNumbers = getMinLengthAmongNumbers(arrayOfNumbersAsStrings);

        System.out.println("Min length among numbers: " + minLengthAmongNumbers);
        System.out.print("Number(s) with min length: ");
        for (String number : arrayOfNumbersAsStrings) {
            if (number.length() == minLengthAmongNumbers) {
                System.out.print(number + " ");
            }
        }
        System.out.println("\n");
    }

    public static void printTheLongestNumber(int[] arrayOfInts) {
        String[] arrayOfNumbersAsStrings = getArrayOfNumbersAsStrings(arrayOfInts);
        int maxLengthAmongNumbers = getMaxLengthAmongNumbers(arrayOfNumbersAsStrings);

        System.out.println("Max length among numbers: " + maxLengthAmongNumbers);
        System.out.print("Number(s) with max length: ");
        for (String number : arrayOfNumbersAsStrings) {
            if (number.length() == maxLengthAmongNumbers) {
                System.out.print(number + " ");
            }
        }
        System.out.println("\n");
    }

    public static String[] getArrayOfNumbersAsStrings(int[] arrayOfInts) {
        String[] arrayOfStrings = new String[arrayOfInts.length];
        for (int i = 0; i < arrayOfStrings.length; i++) {
            arrayOfStrings[i] = Integer.toString(arrayOfInts[i]);
        }
        return arrayOfStrings;
    }

    public static int getMinLengthAmongNumbers(String[] arrayOfStrings) {
        int minLength;

        if (arrayOfStrings.length == 0) {
            minLength = 0;
        } else if (arrayOfStrings.length == 1) {
            minLength = arrayOfStrings[0].length();
        } else {
            minLength = arrayOfStrings[0].length();
            for (int i = 1; i < arrayOfStrings.length; i++) {
                if (arrayOfStrings[i].length() < minLength) {
                    minLength = arrayOfStrings[i].length();
                }
            }
        }
        return minLength;
    }

    public static int getMaxLengthAmongNumbers(String[] arrayOfStrings) {
        int maxLength;

        if (arrayOfStrings.length == 0) {
            maxLength = 0;
        } else if (arrayOfStrings.length == 1) {
            maxLength = 1;
        } else {
            maxLength = arrayOfStrings[0].length();
            for (int i = 1; i < arrayOfStrings.length; i++) {
                if (arrayOfStrings[i].length() > maxLength) {
                    maxLength = arrayOfStrings[i].length();
                }
            }
        }
        return maxLength;
    }

    public static void printNumbersSortedByIncreasingLength(int[] arrayOfInts) {
        String[] arrayOfStringsSortedByIncreasingLength = getArrayOfNumbersAsStrings(arrayOfInts);
        sortArrayOfStringsByIncreasingLength(arrayOfStringsSortedByIncreasingLength);
        System.out.println("Numbers sorted by increasing length: ");
        System.out.println(Arrays.toString(arrayOfStringsSortedByIncreasingLength));
        System.out.println("");
    }

    public static void sortArrayOfStringsByIncreasingLength(String[] arrayOfStrings) {
        for (int i = 0; i < arrayOfStrings.length - 1; i++) {
            int minLengthIndex = i;
            for (int j = i + 1; j < arrayOfStrings.length; j++) {
                if (arrayOfStrings[j].length() < arrayOfStrings[minLengthIndex].length()) {
                    minLengthIndex = j;
                }
                String temp = arrayOfStrings[i];
                arrayOfStrings[i] = arrayOfStrings[minLengthIndex];
                arrayOfStrings[minLengthIndex] = temp;
            }
        }
    }

    public static void printNumbersWithLengthLessThanAverage(int[] arrayOfInts) {
        String[] arrayOfStrings = getArrayOfNumbersAsStrings(arrayOfInts);
        double averageLength = getAverageLength(arrayOfStrings);

        System.out.printf("Average length of numbers: %.2f\n", averageLength);
        System.out.println("Numbers with length less than average:");
        for (String element : arrayOfStrings) {
            if (element.length() < averageLength) {
                System.out.print(element + " (length: " + element.length() + ") ");
            }
        }
        System.out.println("\n");
    }

    public static void printNumbersWithLengthMoreThanAverage(int[] arrayOfInts) {
        String[] arrayOfStrings = getArrayOfNumbersAsStrings(arrayOfInts);
        double averageLength = getAverageLength(arrayOfStrings);

        System.out.printf("Average length of numbers: %.2f\n", averageLength);
        System.out.println("Numbers with length more than average:");
        for (String element : arrayOfStrings) {
            if (element.length() > averageLength) {
                System.out.print(element + " (length: " + element.length()+ ") ");
            }
        }
        System.out.println("\n");
    }

    public static double getAverageLength(String[] arrayOfStrings) {
        double totalLength = 0;
        int amountOfElements = arrayOfStrings.length;

        for (String element : arrayOfStrings) {
            totalLength += element.length();
        }

        if (amountOfElements == 0) {
            return 0;
        } else {
            return totalLength / amountOfElements;
        }
    }
}
