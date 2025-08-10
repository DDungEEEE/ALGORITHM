package org.example.baekjoon.누적합.구간합구하기4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수의 개수
        int M = sc.nextInt(); // 구간 합을 구해야 하는 횟수

        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            // 첫번째 값부터 arr[i] 까지의 누적합 계산
            sum[i] = arr[i] + sum[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int result = sum[end] - sum[start - 1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
