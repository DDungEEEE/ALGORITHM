package org.example.baekjoon.bruteforce;

import java.util.Scanner;

public class Movie {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        int num = 0;
        int count = 0;
        while (true){
            if(String.valueOf(num).contains("666")){
                count++;
            }
            if(count == N){
                break;
            }
            num++;
        }
        System.out.println(num);
    }
}
