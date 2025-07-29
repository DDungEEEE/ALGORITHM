package org.example.baekjoon.동적계획법.쉬운계단수;

import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //[][] --> [] -> 숫자열의 길이, [] -> 마지막으로 끝난 숫자
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                // 점화식 : dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
                // 오버플로우 방지
                if(j < 9) dp[i][j] += dp[i-1][j+1];
                if(j > 0) dp[i][j] += dp[i-1][j-1];
                dp[i][j] %= MOD;
            }
        }

        long result = 0;

        for (int j = 0; j <= 9; j++) {
            result += dp[N][j];
        }

        System.out.println(result % MOD);
    }
}