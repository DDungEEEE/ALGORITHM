package org.example.baekjoon.동적계획법.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        result = new int[N][1];

        String[] input = br.readLine().split(" ");

        int[] sum = new int[N];
        sum[0] = Integer.parseInt(input[0]);

        int currSum = sum[0];
        int maxSum  = sum[0];

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(input[i]);

            sum[i] = Math.max(num, sum[i - 1] + num);
            currSum = sum[i];
            // 전체 최댓값 갱신
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println(maxSum);

    }
}
