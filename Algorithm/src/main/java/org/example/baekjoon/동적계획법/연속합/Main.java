package org.example.baekjoon.동적계획법.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int max = Integer.MIN_VALUE;
    public static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        result = new int[N][1];

        String[] inputNum = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(inputNum[i]);
        }

        for(int i = 0; i < N - 1; i ++){
            result[i][0] = nums[i] + nums[i + 1];
            max = Math.max(result[i][0], max);

            for(int j = i + 2; j < N; j ++){
                int sum = result[i][0] + nums[j];

                result[i][0] = sum;

                max = Math.max(result[i][0], max);

            }
            System.out.println();
        }

        System.out.println(max);

    }


}
