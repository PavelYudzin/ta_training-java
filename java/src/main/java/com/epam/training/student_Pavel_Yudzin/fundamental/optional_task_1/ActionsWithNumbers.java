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
import java.util.regex.Pattern;

public class ActionsWithNumbers {
    public static void main(String[] args) {
        int amountOfNumbers;
//        int[] arrayOfInts;
//
//        amountOfNumbers = getAmountOfNumbers();
//        arrayOfInts = getArrayOfIntegerNumbers(amountOfNumbers);
        int[] arrayOfInts = {-3848, 24, -4, 5645, 49, 684, 8};

        System.out.println(Arrays.toString(arrayOfInts) + "\n");
        printTheShortestNumber(arrayOfInts);
        printTheLongestNumber(arrayOfInts);
        printNumbersSortedByIncreasingLength(arrayOfInts);
        printNumbersWithLengthLessThanAverage(arrayOfInts);
        printNumbersWithLengthMoreThanAverage(arrayOfInts);

        int numberWithMinAmountOfDifferentDigits;
        numberWithMinAmountOfDifferentDigits = getNumberWithMinAmountOfDifferentDigits(arrayOfInts);
        System.out.println("Number with minimum amount of different digits: " + numberWithMinAmountOfDifferentDigits + "\n");

        int amountOfNumbersWithOnlyEvenDigits = getAmountOfNumbersWithOnlyEvenDigits(arrayOfInts);
        System.out.println("Amount of numbers with only even digits: " + amountOfNumbersWithOnlyEvenDigits);

        int amountOfNumbersWithWithEqualAmountOfEvenAndOddDigits = getAmountOfNumbersWithWithEqualAmountOfEvenAndOddDigits(arrayOfInts);
        System.out.println("Amount of numbers with equal amount of even and odd digits: " + amountOfNumbersWithWithEqualAmountOfEvenAndOddDigits + "\n");

        int numberWithIncreasingDigits = getNumberWithIncreasingDigits(arrayOfInts);
        System.out.println("Number with increasing digits: " + numberWithIncreasingDigits + "\n");

        int numberThatContainsOnlyDifferentDigits = getNumberThatContainsOnlyDifferentDigits(arrayOfInts);
        System.out.println("Number that contains only different digits: " + numberThatContainsOnlyDifferentDigits);
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
                System.out.print(element + " (length: " + element.length() + ") ");
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

    public static int getNumberWithMinAmountOfDifferentDigits(int[] arrayOfInts) {
        int numberWithMinAmountOfDifferentDigits;
        if (arrayOfInts.length == 0) {
            numberWithMinAmountOfDifferentDigits = 0;
        } else if (arrayOfInts.length == 1) {
            numberWithMinAmountOfDifferentDigits = arrayOfInts[0];
        } else {
            int minAmountOfDifferentDigits = 10;
            int indexOfNumberWithMinAmountOfDifferentDigits = 0;
            for (int i = 0; i < arrayOfInts.length; i++) {
                int amountOfDifferentDigits = getAmountOfDifferentDigits(arrayOfInts[i]);
                if (amountOfDifferentDigits < minAmountOfDifferentDigits) {
                    minAmountOfDifferentDigits = amountOfDifferentDigits;
                    indexOfNumberWithMinAmountOfDifferentDigits = i;
                }
            }
            numberWithMinAmountOfDifferentDigits = arrayOfInts[indexOfNumberWithMinAmountOfDifferentDigits];
        }
        return numberWithMinAmountOfDifferentDigits;
    }

    public static int getAmountOfDifferentDigits(int number) {
        int amountOfDifferentDigits = 0;
        String numberAsString = Integer.toString(Math.abs(number));
        boolean hasDigit;

        for (int i = 0; i < 10; i++) {
            String pattern = "[" + i + "]";
            hasDigit = Pattern.compile(pattern).matcher(numberAsString).find();
            if (hasDigit) {
                amountOfDifferentDigits++;
            }
        }

        return amountOfDifferentDigits;
    }

    public static int getAmountOfNumbersWithOnlyEvenDigits(int[] arrayOfInts) {
        int amountOfNumbersWithOnlyEvenDigits = 0;
        for (int number : arrayOfInts) {
            boolean isAbsolutelyEven = hasOnlyEvenDigits(number);
            if (isAbsolutelyEven) {
                amountOfNumbersWithOnlyEvenDigits++;
            }
        }

        return amountOfNumbersWithOnlyEvenDigits;
    }

    public static boolean hasOnlyEvenDigits(int number) {
        boolean hasOddDigits;
        String numberAsString = Integer.toString(number);
        hasOddDigits = Pattern.compile("[13579]").matcher(numberAsString).find();
        return !hasOddDigits;
    }

    public static int getAmountOfNumbersWithWithEqualAmountOfEvenAndOddDigits(int[] arrayOfInts) {
        int amountOfNumbersWithWithEqualAmountOfEvenAndOddDigits = 0;
        int amountOfEvenDigits;
        int amountOfOddDigits;

        for (int number : arrayOfInts) {
            amountOfEvenDigits = getAmountOfEvenDigits(number);
            amountOfOddDigits = getAmountOfOddDigits(number);
            if (amountOfEvenDigits == amountOfOddDigits) {
                amountOfNumbersWithWithEqualAmountOfEvenAndOddDigits++;
            }
        }
        return amountOfNumbersWithWithEqualAmountOfEvenAndOddDigits;
    }

    public static int getAmountOfEvenDigits(int number) {
        int amountOfEvenDigits = 0;
        String[] arrayOfDigits = Integer.toString(Math.abs(number)).split("");

        for (String element : arrayOfDigits) {
            if (Pattern.compile("[02468]").matcher(element).find()) {
                amountOfEvenDigits++;
            }
        }

        return amountOfEvenDigits;
    }

    public static int getAmountOfOddDigits(int number) {
        int amountOfOddDigits = 0;
        String[] stringArrayOfDigits = Integer.toString(Math.abs(number)).split("");

        for (String element : stringArrayOfDigits) {
            if (Pattern.compile("[13579]").matcher(element).find()) {
                amountOfOddDigits++;
            }
        }

        return amountOfOddDigits;
    }

    public static int getNumberWithIncreasingDigits(int[] arrayOfInts) {
        int numberWithIncreasingDigits = 0;

        for (int element : arrayOfInts) {
            if (hasIncreasingSequence(element)) {
                numberWithIncreasingDigits = element;
                break;
            }
        }
        return numberWithIncreasingDigits;
    }

    public static boolean hasIncreasingSequence(int number) {
        boolean isIncreasingSequence = true;
        number = Math.abs(number);

        while (number != 0) {
            int nextDigit;
            int previousDigit;

            nextDigit = number - (number / 10) * 10;
            number /= 10;
            previousDigit = number - (number / 10) * 10;
            if (previousDigit > nextDigit) {
                isIncreasingSequence = false;
                break;
            }
        }

        return isIncreasingSequence;
    }

    public static int getNumberThatContainsOnlyDifferentDigits(int[] arrayOfInts) {
        int numberThatContainsOnlyDifferentDigits = 0;

        for (int element : arrayOfInts) {
            if (hasOnlyDifferentDigits(element)) {
                numberThatContainsOnlyDifferentDigits = element;
                break;
            }
        }
        return numberThatContainsOnlyDifferentDigits;
    }

    public static boolean hasOnlyDifferentDigits(int number) {
        boolean hasOnlyDifferentDigits = true;
        String[] stringArrayOfDigits = Integer.toString(Math.abs(number)).split("");
        StringBuilder digits = new StringBuilder("");

        for (String element : stringArrayOfDigits) {
            String pattern = "[" + element + "]";
            if (!Pattern.compile(pattern).matcher(digits).find()) {
                digits.append(element);
            } else {
                hasOnlyDifferentDigits = false;
                break;
            }
        }

        return hasOnlyDifferentDigits;
    }
}