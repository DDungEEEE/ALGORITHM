package org.example.baekjoon.동적계획법.피보나치수1;

import java.util.Scanner;

public class Main{
    static int[] arr;
    static int fibonacci1 = 0;
    static int fibonacci2 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        arr = new int[num + 1];
        fibonacci1(num);
        fibonacci(num);

        StringBuilder sb = new StringBuilder();
        sb.append(fibonacci1).append(" ").append(fibonacci2);
        System.out.println(sb);
    }
    public static int fibonacci1(int n){
        if(n == 1 || n == 2){
            fibonacci1++;
            return 1;
        }else{
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }
    }

    public static int fibonacci(int n){
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3; i <= n; i++){
            fibonacci2++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
