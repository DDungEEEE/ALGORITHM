package org.example.baekjoon.six;

import java.util.Arrays;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for(int i=0; i<n; i++){
            printDiamondLine(n, i);
        }

        for(int k=n-2; k>=0; k--){
           printDiamondLine(n, k);
        }
    }

    public static void printDiamondLine(int n, int lineIndex) {
        // 공백 출력
        for (int space = 0; space < n - lineIndex - 1; space++) {
            System.out.print(" ");
        }
        // 별 출력
        for (int star = 0; star < lineIndex * 2 + 1; star++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
