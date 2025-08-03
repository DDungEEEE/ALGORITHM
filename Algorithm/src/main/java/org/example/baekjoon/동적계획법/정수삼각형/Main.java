package org.example.baekjoon.동적계획법.정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] triangle;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        triangle = new int[N][];
        sum = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            triangle[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
                sum[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));;

    }

    static int dfs(int i, int j){
        if(i == triangle.length - 1){
            return triangle[i][j];
        }

        if(sum[i][j] != -1){
            return sum[i][j];
        }

        int downLeft = dfs(i + 1, j);
        int downRight = dfs(i + 1, j + 1);

        sum[i][j] = triangle[i][j] + Math.max(downLeft, downRight);

        return sum[i][j];
    }
}
