package org.example.study.조약돌문제;

public class Solution {
    public static void main(String[] args) {
        int[][] stones = {
                {1, 3, 3, 2},
                {2, 1, 4, 1},
                {1, 5, 2, 3}
        };

        System.out.println(solution(stones));
    }
    static int solution(int[][] stones) {

        int[][] dp = new int[stones[0].length][4];
        dp[0][0] = stones[0][0]; // A만 둘 떄
        dp[0][1] = stones[1][0]; // B만 둘 떄
        dp[0][2] = stones[2][0]; // C만 둘 떄
        dp[0][3] = stones[0][0] + stones[2][0]; // A, C 둘다 둘 떄

        for (int i = 1; i < stones[0].length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + stones[0][i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][3]) + stones[1][i];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + stones[2][i];
            dp[i][3] = dp[i - 1][1] + stones[0][i] + stones[2][i];
        }

        return Math.max(
                Math.max(dp[stones[0].length - 1][0], dp[stones[0].length - 1][1]),
                Math.max(dp[stones[0].length - 1][2], dp[stones[0].length - 1][3])
        );

    }
}
