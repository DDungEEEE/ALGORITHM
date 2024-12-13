package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        int origin = num;



        while (true){
            num = func(num);
            count++;
            if(num == origin){
                break;
            }
        }

        System.out.println(count);
    }

    public static int func(int a){
        if(a <10){
            int r = a;
            return r * 10 + r;
        }else{
            int r = a % 10; // 십의자리
            int t = a/10 + r; // 일의자리
            return r * 10 + t%10;
        }

    }
}