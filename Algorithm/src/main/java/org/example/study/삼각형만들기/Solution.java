package org.example.study.삼각형만들기;

public class Solution {
    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        System.out.println(solution(triangle));
    }
    static int solution(int[][] triangle){
        int[][] dp = new int[triangle.length][];

        for(int i = 0; i < triangle.length; i++){
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        int result = 0;

        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    result = Math.max(dp[i][j], result);
                }else if(j == (triangle[i].length - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    result = Math.max(dp[i][j], result);
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                    result = Math.max(dp[i][j], result);
                }
            }
        }

        return result;
    }
}
