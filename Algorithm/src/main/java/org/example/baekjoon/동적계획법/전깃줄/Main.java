package org.example.baekjoon.동적계획법.전깃줄;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }

        Arrays.sort(lines, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (lines[j][1] < lines[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(N - Arrays.stream(dp).max().getAsInt());
    }
}
