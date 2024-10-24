package org.example;

public class Example {
    public static int number = 0;

    public static void addNumber(){
        number++;
        System.out.println("Add number result = " + number);
    }

    static{
        number = 10;
        System.out.println("number = " + number);
    }
}
