package org.example;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - i - 1; j++){
                System.out.printf(" ");
            }
            for(int k = 0; k < i + 1; k++){
                System.out.printf("*");
            }
            System.out.println();
        }

    }
}
