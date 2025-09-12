package org.example.baekjoon.동적계획법.바이토닉수열;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] plus = new int[N];
        int[] minus = new int[N];

        for(int i = 0; i < N; i++){
            plus[i] = 1;


            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    plus[i] = Math.max(plus[i], plus[j] + 1);
                }
            }
        }

        for(int i = N - 1; i >= 0; i--){
            minus[i] = 1;

            for(int j = N - 1; j > i; j--){
                if(arr[i] > arr[j]){
                    minus[i] = Math.max(minus[i], minus[j] + 1);
                }
            }
        }
        int result = 0;

        for(int i = 0; i < N; i++){
            result = Math.max(result, plus[i] + minus[i] - 1);
        }

        System.out.println(result);
    }
}
