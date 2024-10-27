package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SmartPhone smartPhone= new SmartPhone("손원익");

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();


    }
}