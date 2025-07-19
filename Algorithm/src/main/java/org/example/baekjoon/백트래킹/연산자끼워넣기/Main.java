package org.example.baekjoon.백트래킹.연산자끼워넣기;


import java.util.Scanner;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++)
            numbers[i] = sc.nextInt();

        for (int i = 0; i < 4; i++)
            operators[i] = sc.nextInt(); // 연산자 개수 +, -, *, /

        backTracking(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }


    static void backTracking(int depth, int total) {
        if (depth == N) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int next = switch (i) {
                    case 0 -> total + numbers[depth];
                    case 1 -> total - numbers[depth];
                    case 2 -> total * numbers[depth];
                    case 3 -> total / numbers[depth];
                    default -> total;
                };

                backTracking(depth + 1, next);

                operators[i]++; // 백트래킹
            }
        }
    }
}