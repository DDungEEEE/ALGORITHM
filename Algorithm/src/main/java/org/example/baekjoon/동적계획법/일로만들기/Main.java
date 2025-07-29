package org.example.baekjoon.동적계획법.일로만들기;

import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 해당 값을 1로 만들기 위해 필요한 연산 횟수
        dp = new int[N + 1];

        dp[1] = 0;
        for(int i = 2; i <= N; i++){

            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }

}
