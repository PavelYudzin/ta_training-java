package com.epam.training.student_Pavel_Yudzin.fundamental.main_task;

/*
    Приветствовать любого пользователя при вводе его имени через командную строку.
 */

public class HelloUser {
    public static void main(String[] args) {
        System.out.print("Hello, ");
        for (String val : args) {
            System.out.print(val + " ");
        }
    }
}