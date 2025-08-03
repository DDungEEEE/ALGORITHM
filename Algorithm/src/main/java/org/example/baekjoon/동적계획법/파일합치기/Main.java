package org.example.baekjoon.동적계획법.파일합치기;


import java.util.Scanner;

public class Main {
    static int[] files;
    static int[] sum;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 테스트 케이스 수

        while (N > 0) {
            int K = sc.nextInt();  // 파일 개수
            files = new int[K + 1];  // 1-based indexing
            sum = new int[K + 1];
            dp = new int[K + 1][K + 1];


            for (int i = 1; i <= K; i++) {
                files[i] = sc.nextInt();
                sum[i] = sum[i - 1] + files[i];
            }

            // 구간 길이 2부터 K까지
            for (int len = 1; len < K; len++) {
                for (int i = 1; i + len <= K; i++) {
                    int j = i + len;
                    dp[i][j] = INF;

                    // i~j 범위를 k로 나눠서 최소 비용 계산
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }

            System.out.println(dp[1][K]);  // 전체 파일을 합치는 최소 비용 출력
            N--;
        }
    }
}