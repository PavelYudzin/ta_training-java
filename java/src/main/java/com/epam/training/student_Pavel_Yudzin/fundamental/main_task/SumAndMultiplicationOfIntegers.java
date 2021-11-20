package com.epam.training.student_Pavel_Yudzin.fundamental.main_task;

/*
    Ввести целые числа как аргументы командной строки, подсчитать их сумму и вывести результат на консоль.
 */

public class SumAndMultiplicationOfIntegers {
    public static void main(String[] args) {
        int sum;
        int multiplication;

        sum = getSum(args);
        multiplication = getMultiplication(args);

        System.out.print("Numbers: ");
        for(String element : args) {
            System.out.print(element + " ");
        }
        System.out.println("\nSum: " + sum);
        System.out.println("Multiplication: " + multiplication);
    }

    public static int getSum(String[] numbers) {
        int sum = 0;
        for(String element : numbers) {
            sum += Integer.parseInt(element);
        }
        return sum;
    }

    public static int getMultiplication(String[] numbers){
        int multiplication = 1;
        for(String element : numbers) {
            multiplication *= Integer.parseInt(element);
        }
        return multiplication;
    }
}