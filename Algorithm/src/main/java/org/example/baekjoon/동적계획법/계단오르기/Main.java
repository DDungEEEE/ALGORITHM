package org.example.baekjoon.동적계획법.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(num[1]);
            return;
        }

        dp[1] = num[1];
        dp[2] = Math.max(num[2], num[1] + num[2]);

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + num[i],
                    dp[i - 3] + num[i - 1] + num[i]
            );
        }

        System.out.println(dp[N]);
    }
}